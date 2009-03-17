package actions;

import generate.ActionsGenerator;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.eclipse.epsilon.antlr.postprocessor.model.antlrAst.Ast;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.commons.parse.problem.ParseProblem;

import parser.ActionsLexer;
import parser.ActionsParser;
import postprocessor.ActionsPostprocessor;
import transform.ActionsTransformer;

public class ActionsModule {

	private final AST ast;
	private final List<ParseProblem> problems = new LinkedList<ParseProblem>();
	
	public ActionsModule(String text) {
		ast = parse(text);
	}
	
	private AST parse(String text) {
		final Lexer lexer          = new ActionsLexer(new ANTLRStringStream(text)) {
			@Override
			public void displayRecognitionError(String[] tokenNames,
			                                    RecognitionException re) {
				
				problems.add(new ParseProblem(re.line,
				                              re.charPositionInLine,
				                              getErrorMessage(re, getTokenNames())));
			}
		};
		final ActionsParser parser = new ActionsParser(new CommonTokenStream(lexer)) {
			@Override
			public void displayRecognitionError(String[] tokenNames,
			                                    RecognitionException re) {
				
				problems.add(new ParseProblem(re.line,
				                              re.charPositionInLine,
				                              getErrorMessage(re, getTokenNames())));
			}
		};
		
		try {
			return new AST((CommonTree)parser.document().getTree());
			
		} catch (RecognitionException e) {
			final ParseProblem problem = new ParseProblem();
			problem.setLine(e.line);
			problem.setColumn(e.charPositionInLine);
			problem.setReason(e.getMessage());
			getParseProblems().add(problem);			
			e.printStackTrace();
			
			return null;
		}
	}
	
	public boolean hasParseProblems() {
		return !problems.isEmpty();
	}
	
	public List<ParseProblem> getParseProblems() {
		return Collections.unmodifiableList(problems);
	}
	
	
	public String generate() throws ActionsException {
		return generateCode(generateDocument());
	}
	
	public Document generateDocument() throws ActionsException {
		return transform(postprocess(ast));
	}

	private static Ast postprocess(AST ast) {
		return new ActionsPostprocessor().process(ast);
	}
	
	private static Document transform(Ast ast) throws ActionsException {
		return new ActionsTransformer().createDocument(ast);
	}
	
	private static String generateCode(Document document) throws ActionsException {
		return new ActionsGenerator(document).generate();
	}
	
}
