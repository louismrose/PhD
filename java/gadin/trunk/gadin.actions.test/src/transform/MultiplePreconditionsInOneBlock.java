package transform;

import org.junit.BeforeClass;
import org.junit.Test;

import actions.ActionsException;

public class MultiplePreconditionsInOneBlock extends TransformTest {
	
	@BeforeClass
	public static void setup() throws ActionsException {
		defaultTransformTest(createPreconditionsNode(createPropositionNode("at",
				createCharacterParameterNode("c"),
				createCharacterParameterNode("p")), createPropositionNode("at",
				createCharacterParameterNode("d"),
				createCharacterParameterNode("q"))));
        
		model.setVariable("preconditionSet", "action.preconditionSets.first");
		model.setVariable("precondition1",   "preconditionSet.preconditions.first");
		model.setVariable("precondition2",   "preconditionSet.preconditions.last");
	}
	
	@Test
	public void actionHasOnePreconditionSet() {
		model.assertEquals(1, "action.preconditionSets.size()");
	}
	
	@Test
	public void preconditionSetHasOneProposition() {
		model.assertEquals(2, "preconditionSet.preconditions.size()");
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
	public void precondition2HasTypeWithNameAt() {
		model.assertEquals("at", "precondition2.type.name");
	}

	@Test
	public void precondition2HasTwoParameters() {
		model.assertEquals(2, "precondition2.parameters.size()");
	}
	
	@Test
	public void precondition2FirstParameterIsC() {
		model.assertEquals("d", "precondition2.parameters.first.name");
	}
	
	@Test
	public void precondition2SecondParameterIsP() {
		model.assertEquals("q", "precondition2.parameters.last.name");
	}
}
