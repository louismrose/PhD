package acceptance;

import static org.junit.Assert.fail;

import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.test.util.ModelWithEolAssertions;

import actions.ActionsException;
import actions.ActionsModule;
import actions.ActionsPackage;


public abstract class AcceptanceTest {
	
	private static final boolean PRINT_GENERATED_CODE = true;
	
	protected static ModelWithEolAssertions model;
	
	protected static void acceptanceTest(String text) throws ActionsException {
		final ActionsModule module = new ActionsModule(text);
		
		if (module.hasParseProblems()) {
			for (ParseProblem problem : module.getParseProblems()) {
				System.err.println(problem);
			}
			fail("Could not parse text.");
		}

		model = new ModelWithEolAssertions(module.generateDocument(), ActionsPackage.eINSTANCE);
		
		
		if (PRINT_GENERATED_CODE) {
			System.out.println("// start");
			System.out.println(module.generate());
		}
	}
}
