package acceptance;

import org.junit.BeforeClass;
import org.junit.Test;

public class Precondition extends AcceptanceTest {

	
	@BeforeClass
	public static void setup() throws Exception {
		acceptanceTest("flirt"                + '\n' +
 		               "  involves"           + '\n' +
		               "    c - Character"    + '\n' +
		               "    d - Character"    + '\n' +
		               "  when"               + '\n' +
		               "    c at p"           + '\n' +
		               "    d at p"           + '\n' +
		               "  then "              + '\n' +
		               "    c flirts d");
                                         
		model.setVariable("doc",    "Document.all.first");
		model.setVariable("action", "doc.actions.first");
		model.setVariable("preSet", "action.preconditionSets.first");
		model.setVariable("pre1",   "preSet.preconditions.first");
		model.setVariable("pre2",   "preSet.preconditions.last");
	}
		
	// Preconditions
	
	@Test
	public void actionHasOnePreconditionSet() {
		model.assertEquals(1, "action.preconditionSets.size()");
	}
	
	@Test
	public void preconditionSetHasTwoPreconditions() {
		model.assertEquals(2, "preSet.preconditions.size()");
	}
	
	@Test
	public void pre1HasTypeWithNameAt() {
		model.assertEquals("at", "pre1.type.name");
	}
	
	@Test
	public void pre1IsPositive() {
		model.assertTrue("pre1.positive");
	}
	
	@Test
	public void pre1HasTwoParameters() {
		model.assertEquals(2, "pre1.parameters.size()");
	}
	
	@Test
	public void pre1FirstParameterHasNameC() {
		model.assertEquals("c", "pre1.parameters.first.name");
	}
	
	@Test
	public void pre1SecondParameterHasNameP() {
		model.assertEquals("p", "pre1.parameters.last.name");
	}
	
	@Test
	public void pre1AndPre2HaveSameType() {
		model.assertTrue("pre1.type = pre2.type");
	}
	
	@Test
	public void pre2IsPositive() {
		model.assertTrue("pre2.positive");
	}
	
	@Test
	public void pre2HasTwoParameters() {
		model.assertEquals(2, "pre2.parameters.size()");
	}
	
	@Test
	public void pre2FirstParameterHasNameD() {
		model.assertEquals("d", "pre2.parameters.first.name");
	}
	
	@Test
	public void pre2SecondParameterHasNameP() {
		model.assertEquals("p", "pre2.parameters.last.name");
	}
}
