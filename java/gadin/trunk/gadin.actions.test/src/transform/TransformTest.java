package transform;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.epsilon.antlr.postprocessor.model.antlrAst.AntlrAstFactory;
import org.eclipse.epsilon.antlr.postprocessor.model.antlrAst.Ast;
import org.eclipse.epsilon.antlr.postprocessor.model.antlrAst.Node;
import org.eclipse.epsilon.emc.emf.EmfUtil;
import org.eclipse.epsilon.test.util.ModelWithEolAssertions;
import org.junit.Test;

import actions.ActionsException;
import actions.ActionsPackage;
import actions.Document;
import actionsAntlrAst.ActionNode;
import actionsAntlrAst.ActionsAntlrAstFactory;
import actionsAntlrAst.CharacterParameterNode;
import actionsAntlrAst.EffectsNode;
import actionsAntlrAst.NameNode;
import actionsAntlrAst.ParametersNode;
import actionsAntlrAst.PreconditionsNode;
import actionsAntlrAst.PropositionNode;

public abstract class TransformTest {
	
	protected static ModelWithEolAssertions model;
	
	protected static Ast initialiseAst(Node... roots) {
		final Ast ast = AntlrAstFactory.eINSTANCE.createAst();
		EmfUtil.createResourceFor(ast);
		
		ast.getRoots().addAll(Arrays.asList(roots));
		
		return ast;
	}
	
	protected static ActionNode defaultActionNode(Collection<PreconditionsNode> preconditions, ParametersNode parameters, PropositionNode... extraEffects) {
		final ActionNode action = createActionNode("flirts", defaultEffectsNode(extraEffects));

		if (preconditions != null) {
			action.getChildren().addAll(0, preconditions);
		}
		
		if (parameters != null) {
			action.getChildren().add(0, parameters);
		}
		
		return action;                          
	}
	
	protected static ActionNode defaultActionNode(PreconditionsNode preconditions, ParametersNode parameters, PropositionNode... extraEffects) {
		return defaultActionNode(Collections.singleton(preconditions), parameters, extraEffects);                         
	}
	
	protected static ActionNode defaultActionNode(ParametersNode parameters, PropositionNode... extraEffects) {
		final Collection<PreconditionsNode> preconditions = Collections.emptyList();
		return defaultActionNode(preconditions, null, extraEffects);                         
	}
	
	protected static ActionNode defaultActionNode(PropositionNode... extraEffects) {
		return defaultActionNode(null, extraEffects);
	}
	
	protected static ActionNode createActionNode(String text, Node... children) {
		final ActionNode n = ActionsAntlrAstFactory.eINSTANCE.createActionNode();
		n.setText(text);
		n.getChildren().addAll(Arrays.asList(children));
		return n;
	}
	
	protected static ParametersNode createParametersNode(Node... children) {
		final ParametersNode n = ActionsAntlrAstFactory.eINSTANCE.createParametersNode();
		n.setText("PARAMETERS");
		n.getChildren().addAll(Arrays.asList(children));
		return n;
	}
	
	protected static CharacterParameterNode createCharacterParameterNode(String name) {
		final CharacterParameterNode n = ActionsAntlrAstFactory.eINSTANCE.createCharacterParameterNode();
		n.setText(name);
		return n;
	}
	
	
	protected static PreconditionsNode createPreconditionsNode(Node... children) {
		final PreconditionsNode n = ActionsAntlrAstFactory.eINSTANCE.createPreconditionsNode();
		n.setText("PRECONDITIONS");
		n.getChildren().addAll(Arrays.asList(children));
		return n;
	}
	
	
	protected static EffectsNode defaultEffectsNode(PropositionNode... extraEffects) {
		final EffectsNode effectsNode = createEffectsNode(defaultPropositionNode());
		effectsNode.getChildren().addAll(Arrays.asList(extraEffects));
		return effectsNode;
	}
	
	protected static EffectsNode createEffectsNode(Node... children) {
		final EffectsNode n = ActionsAntlrAstFactory.eINSTANCE.createEffectsNode();
		n.setText("EFFECTS");
		n.getChildren().addAll(Arrays.asList(children));
		return n;
	}
	
	protected static PropositionNode defaultPropositionNode() {
		return createPropositionNode("flirts", createNameNode("c"), createNameNode("d"));
	}
	
	protected static PropositionNode createPropositionNode(String text, Node... children) {
		final PropositionNode n = ActionsAntlrAstFactory.eINSTANCE.createPropositionNode();
		n.setText(text);
		n.getChildren().addAll(Arrays.asList(children));
		return n;
	}
	
	protected static NameNode createNameNode(String text, Node... children) {
		final NameNode n = ActionsAntlrAstFactory.eINSTANCE.createNameNode();
		n.setText(text);
		n.getChildren().addAll(Arrays.asList(children));
		return n;
	}
	
	protected static void transformTest(Node... roots) throws ActionsException {
		final Ast ast = initialiseAst(roots);
		
		final Document doc = new ActionsTransformer().createDocument(ast);
		
		model = new ModelWithEolAssertions(doc, ActionsPackage.eINSTANCE);
	}
	
	protected static void defaultTransformTest(Collection<PreconditionsNode> preconditions, ParametersNode parameters, PropositionNode... extraEffects) throws ActionsException {
		transformTest(defaultActionNode(preconditions, parameters, extraEffects));
		
		model.setVariable("doc",    "Document.all.first");
		model.setVariable("action", "doc.actions.first");
		model.setVariable("effect", "action.effects.first");
	}
	
	protected static void defaultTransformTest(PreconditionsNode precondition, ParametersNode parameters, PropositionNode... extraEffects) throws ActionsException {
		defaultTransformTest(Collections.singleton(precondition), parameters, extraEffects);
	}
	
	
	protected static void defaultTransformTest(PreconditionsNode precondition, PropositionNode... extraEffects) throws ActionsException {
		defaultTransformTest(precondition, null, extraEffects);
	}
	
	protected static void defaultTransformTest(ParametersNode parameters, PropositionNode... extraEffects) throws ActionsException {
		final Collection<PreconditionsNode> preconditions = Collections.emptyList();
		defaultTransformTest(preconditions, parameters, extraEffects);
	}
	
	protected static void defaultTransformTest(Collection<PreconditionsNode> preconditions) throws ActionsException {
		defaultTransformTest(preconditions, null);
	}
	
	protected static void defaultTransformTest(PropositionNode... extraEffects) throws ActionsException {
		final Collection<PreconditionsNode> preconditions = Collections.emptyList();
		defaultTransformTest(preconditions, null, extraEffects);
	}
	
	@Test
	public void documentHasOneAction() {
		model.assertEquals(1, "doc.actions.size()");
	}
	
	@Test
	public void actionIsNamedFlirts() {
		model.assertEquals("flirts", "action.name");
	}
	
	@Test
	public void actionHasOneEffect() {
		model.assertEquals(1, "action.effects.size()");
	}
	
	@Test
	public void effectHasTypeWithNameFlirts() {
		model.assertEquals("flirts", "effect.type.name");
	}

	@Test
	public void effectHasTwoParameters() {
		model.assertEquals(2, "effect.parameters.size()");
	}
	
	@Test
	public void firstEffectFirstParameterIsC() {
		model.assertEquals("c", "effect.parameters.first.name");
	}
	
	@Test
	public void firstEffectSeecondParameterIsD() {
		model.assertEquals("d", "effect.parameters.last.name");
	}
}
