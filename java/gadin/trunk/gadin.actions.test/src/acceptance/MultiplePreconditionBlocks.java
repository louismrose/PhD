package acceptance;

import org.junit.BeforeClass;
import org.junit.Test;

public class MultiplePreconditionBlocks extends AcceptanceTest {

	
	@BeforeClass
	public static void setup() throws Exception {
		acceptanceTest("mutual_fancy"        + "\n" +
		               "  involves"          + "\n" +
		               "    c - Character"   + "\n" +
		               "    d - Character"   + "\n" +
		               "  when"              + "\n" +
		               "    c flirts with d" + "\n" +
		               "    d flirts with c" + "\n" +
		               "    c is at p"       + "\n" +
		               "    d is at p"       + "\n" +
		               "  or when"           + "\n" +
		               "    c is drunk"      + "\n" +
		               "    d is drunk"      + "\n" +
		               "    c is at p"       + "\n" +
		               "    d is at p"       + "\n" +
		               "  then"              + "\n" +
		               "    c fancies d"     + "\n" +
		               "    d fancies c");
                                         
		model.setVariable("doc",     "Document.all.first");
		model.setVariable("action",  "doc.actions.first");
		model.setVariable("p1",      "action.parameters.first");
		model.setVariable("p2",      "action.parameters.last");
		model.setVariable("effect1", "action.effects.first");
		model.setVariable("effect2", "action.effects.last");
	}
	
	@Test
	public void documentHasOneAction() {
		model.assertEquals(1, "doc.actions.size()");
	}
	
	@Test
	public void actionIsNamedMutualFancy() {
		model.assertEquals("mutual_fancy", "action.name");
	}
	
	// Parameters
	
	@Test
	public void actionHasTwoParameters() {
		model.assertEquals(2, "action.parameters.size()");
	}
	
	@Test
	public void firstParameterIsC() {
		model.assertEquals("c", "p1.name");
	}
	
	@Test
	public void firstParameterIsCharacter() {
		model.assertTrue("CharacterParameter.isType(p1)");
	}
	
	@Test
	public void secondParameterIsD() {
		model.assertEquals("d", "p2.name");
	}
	
	@Test
	public void secondParameterIsCharacter() {
		model.assertTrue("CharacterParameter.isType(p2)");
	}
	
	// Preconditions
	
	@Test
	public void actionHasTwoPreconditionSets() {
		model.assertEquals(2, "action.preconditionSets.size()");
	}
	
	// Effects
	
	@Test
	public void actionHasTwoEffect() {
		model.assertEquals(2, "action.effects.size()");
	}
	
	@Test
	public void firstEffectHasTypeWithNameFancies() {
		model.assertEquals("fancies", "effect1.type.name");
	}

	@Test
	public void firstEffectHasTwoParameters() {
		model.assertEquals(2, "effect1.parameters.size()");
	}
	
	@Test
	public void firstEffectFirstParameterIsC() {
		model.assertEquals("c", "effect1.parameters.first.name");
	}
	
	@Test
	public void firstEffectSecondParameterIsD() {
		model.assertEquals("d", "effect1.parameters.last.name");
	}
	
	@Test
	public void secondEffectHasTypeWithNameFancies() {
		model.assertEquals("fancies", "effect2.type.name");
	}

	@Test
	public void secondEffectHasTwoParameters() {
		model.assertEquals(2, "effect2.parameters.size()");
	}
	
	@Test
	public void secondEffectFirstParameterIsD() {
		model.assertEquals("d", "effect2.parameters.first.name");
	}
	
	@Test
	public void secondEffectSecondParameterIsC() {
		model.assertEquals("c", "effect2.parameters.last.name");
	}
}
