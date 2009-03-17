package transform;

import org.junit.BeforeClass;
import org.junit.Test;

import actions.ActionsException;

public class SinglePrecondition extends TransformTest {
	
	@BeforeClass
	public static void setup() throws ActionsException {
		defaultTransformTest(createPreconditionsNode(createPropositionNode("at",
				createCharacterParameterNode("c"),
				createCharacterParameterNode("p"))));
                                         
		model.setVariable("preconditionSet", "action.preconditionSets.first");
		model.setVariable("precondition",    "preconditionSet.preconditions.first");
	}
	
	@Test
	public void actionHasOnePreconditionSet() {
		model.assertEquals(1, "action.preconditionSets.size()");
	}
	
	@Test
	public void preconditionSetHasOneProposition() {
		model.assertEquals(1, "preconditionSet.preconditions.size()");
	}
	
	@Test
	public void preconditionHasTypeWithNameAt() {
		model.assertEquals("at", "precondition.type.name");
	}

	@Test
	public void preconditionHasTwoParameters() {
		model.assertEquals(2, "precondition.parameters.size()");
	}
	
	@Test
	public void firstParameterIsC() {
		model.assertEquals("c", "precondition.parameters.first.name");
	}
	
	@Test
	public void secondParameterIsP() {
		model.assertEquals("p", "precondition.parameters.last.name");
	}
}
