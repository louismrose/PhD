package transform;

import org.junit.BeforeClass;
import org.junit.Test;

import actions.ActionsException;

public class ManyEffects extends TransformTest {
	
	@BeforeClass
	public static void setup() throws ActionsException {
		defaultTransformTest((createPropositionNode("flirts", createNameNode("d"), createNameNode("c"))));
		
		model.setVariable("effect2", "action.effects.last");
	}
	
	@Override
	@Test
	public void actionHasOneEffect() {
		model.assertEquals(2, "action.effects.size()");
	}
	
	@Test
	public void effectsHaveSameType() {
		model.assertTrue("effect.type = effect2.type");
	}

	@Test
	public void effect2HasTwoParameters() {
		model.assertEquals(2, "effect2.parameters.size()");
	}
	
	@Test
	public void effect2FirstParameterIsD() {
		model.assertEquals("d", "effect2.parameters.first.name");
	}
	
	@Test
	public void effect2SecondParameterIsC() {
		model.assertEquals("c", "effect2.parameters.last.name");
	}
}
