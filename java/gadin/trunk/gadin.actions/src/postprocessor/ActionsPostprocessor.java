package postprocessor;

import org.antlr.runtime.tree.CommonTree;
import org.eclipse.epsilon.antlr.postprocessor.AbstractAstPostProcessor;
import org.eclipse.epsilon.antlr.postprocessor.model.antlrAst.Node;

import actionsAntlrAst.ActionsAntlrAstFactory;

import parser.ActionsParser;

public class ActionsPostprocessor extends AbstractAstPostProcessor  {

	@Override
	protected Node createNodeObjectFor(CommonTree ast) {
		switch (ast.getType()) {
			case ActionsParser.NAME:
				return ActionsAntlrAstFactory.eINSTANCE.createNameNode();
				
			case ActionsParser.ACTION:
				return ActionsAntlrAstFactory.eINSTANCE.createActionNode();
				
			case ActionsParser.PARAMETERS:
				return ActionsAntlrAstFactory.eINSTANCE.createParametersNode();
			
			case ActionsParser.CHARACTER:
				return ActionsAntlrAstFactory.eINSTANCE.createCharacterParameterNode();
			
			case ActionsParser.PRECONDITIONS:
				return ActionsAntlrAstFactory.eINSTANCE.createPreconditionsNode();
			
			case ActionsParser.EFFECTS:
				return ActionsAntlrAstFactory.eINSTANCE.createEffectsNode();
				
			case ActionsParser.PROPOSITION1:
			case ActionsParser.PROPOSITION2:
				return ActionsAntlrAstFactory.eINSTANCE.createPropositionNode();
				
			default:
				throw new IllegalStateException("No model element can be created from the ANTLR AST node, " + ast.toString());
		}
	}

}
