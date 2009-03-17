package transform;

import org.junit.BeforeClass;
import org.junit.Test;

import actions.ActionsException;

public class SingleParameter extends TransformTest {
	
	@BeforeClass
	public static void setup() throws ActionsException {
		defaultTransformTest(createParametersNode(createCharacterParameterNode("c")));
                                         
		model.setVariable("parameter", "action.parameters.first");
	}
	
	@Test
	public void parameterIsC() {
		model.assertEquals("c", "parameter.name");
	}
	
	@Test
	public void parameterHasTypeCharacter() {
		model.assertTrue("CharacterParameter.isType(parameter)");
	}
}
