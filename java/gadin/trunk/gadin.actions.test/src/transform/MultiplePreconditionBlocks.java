package transform;

import java.util.LinkedList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import actions.ActionsException;
import actionsAntlrAst.PreconditionsNode;

public class MultiplePreconditionBlocks extends TransformTest {
	
	@BeforeClass
	public static void setup() throws ActionsException {
		final List<PreconditionsNode> preconditionSets = new LinkedList<PreconditionsNode>();
		
		preconditionSets.add(createPreconditionsNode(createPropositionNode("at",
				createCharacterParameterNode("c"),
				createCharacterParameterNode("p"))));
		
		preconditionSets.add(createPreconditionsNode(createPropositionNode("fancies",
				createCharacterParameterNode("c"),
				createCharacterParameterNode("d"))));
		
		defaultTransformTest(preconditionSets);
                                         
		model.setVariable("preconditionSet1", "action.preconditionSets.first");
		model.setVariable("preconditionSet2", "action.preconditionSets.last");
		
		model.setVariable("precondition1", "preconditionSet1.preconditions.first");
		model.setVariable("precondition2", "preconditionSet2.preconditions.last");
	}
	
	@Test
	public void actionHasTwoPreconditionSets() {
		model.assertEquals(2, "action.preconditionSets.size()");
	}
	
	@Test
	public void firstPreconditionSetHasOnePrecondition() {
		model.assertEquals(1, "preconditionSet1.preconditions.size()");
	}
	
	@Test
	public void secondPreconditionSetHasOnePrecondition() {
		model.assertEquals(1, "preconditionSet2.preconditions.size()");
	}
	
	@Test
	public void precondition1HasTypeWithNameAt() {
		model.assertEquals("at", "precondition1.type.name");
	}

	@Test
	public void precondition1HasTwoParameters() {
		model.assertEquals(2, "precondition1.parameters.size()");
	}
	
	@Test
	public void precondition1FirstParameterIsC() {
		model.assertEquals("c", "precondition1.parameters.first.name");
	}
	
	@Test
	public void precondition1SecondParameterIsP() {
		model.assertEquals("p", "precondition1.parameters.last.name");
	}
	
	@Test
	public void precondition2HasTypeWithNameFancies() {
		model.assertEquals("fancies", "precondition2.type.name");
	}

	@Test
	public void precondition2HasTwoParameters() {
		model.assertEquals(2, "precondition2.parameters.size()");
	}
	
	@Test
	public void precondition2FirstParameterIsC() {
		model.assertEquals("c", "precondition2.parameters.first.name");
	}
	
	@Test
	public void precondition2SecondParameterIsD() {
		model.assertEquals("d", "precondition2.parameters.last.name");
	}
}
