package parser;

import junit.framework.TestCase;
import java.io.*;
import java.lang.reflect.*;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

public class TestActions extends TestCase {
	String stdout;
	String stderr;

	public void testAction1() throws Exception {
		// test input: "flirt involves c - Character d - Character then c flirts d"
		Object retval = execParser("action", "flirt involves c - Character d - Character then c flirts d", false);
		Object actual = examineParserExecResult(8, retval);
		Object expecting = "(flirt (PARAMETERS c d) (EFFECTS (flirts c d)))";

		assertEquals("testing rule "+"action", expecting, actual);
	}

	public void testAction2() throws Exception {
		// test input: "flirt when c at p d at p then c flirts d"
		Object retval = execParser("action", "flirt when c at p d at p then c flirts d", false);
		Object actual = examineParserExecResult(8, retval);
		Object expecting = "(flirt (PRECONDITIONS (at c p) (at d p)) (EFFECTS (flirts c d)))";

		assertEquals("testing rule "+"action", expecting, actual);
	}

	public void testAction3() throws Exception {
		// test input: "flirt when c at p d at p or when c fancies d d fancies c then c flirts d"
		Object retval = execParser("action", "flirt when c at p d at p or when c fancies d d fancies c then c flirts d", false);
		Object actual = examineParserExecResult(8, retval);
		Object expecting = "(flirt (PRECONDITIONS (at c p) (at d p)) (PRECONDITIONS (fancies c d) (fancies d c)) (EFFECTS (flirts c d)))";

		assertEquals("testing rule "+"action", expecting, actual);
	}

	public void testAction4() throws Exception {
		// test input: "flirt then c flirts d"
		Object retval = execParser("action", "flirt then c flirts d", false);
		Object actual = examineParserExecResult(8, retval);
		Object expecting = "(flirt (EFFECTS (flirts c d)))";

		assertEquals("testing rule "+"action", expecting, actual);
	}

	public void testAction5() throws Exception {
		// test input: "mutual_fancy then c flirts d"
		Object retval = execParser("action", "mutual_fancy then c flirts d", false);
		Object actual = examineParserExecResult(8, retval);
		Object expecting = "(mutual_fancy (EFFECTS (flirts c d)))";

		assertEquals("testing rule "+"action", expecting, actual);
	}

	public void testAction6() throws Exception {
		// test input: "flirt"
		Object retval = execParser("action", "flirt", false);
		Object actual = examineParserExecResult(28, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"action", expecting, actual);
	}

	public void testParameters1() throws Exception {
		// test input: "involves"
		Object retval = execParser("parameters", "involves", false);
		Object actual = examineParserExecResult(28, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"parameters", expecting, actual);
	}

	public void testParameters2() throws Exception {
		// test input: "involves c - Character"
		Object retval = execParser("parameters", "involves c - Character", false);
		Object actual = examineParserExecResult(8, retval);
		Object expecting = "(PARAMETERS c)";

		assertEquals("testing rule "+"parameters", expecting, actual);
	}

	public void testParameters3() throws Exception {
		// test input: "involves c - Character d - Character"
		Object retval = execParser("parameters", "involves c - Character d - Character", false);
		Object actual = examineParserExecResult(8, retval);
		Object expecting = "(PARAMETERS c d)";

		assertEquals("testing rule "+"parameters", expecting, actual);
	}

	public void testParameter1() throws Exception {
		// test input: "c - Character"
		Object retval = execParser("parameter", "c - Character", false);
		Object actual = examineParserExecResult(8, retval);
		Object expecting = "c";

		assertEquals("testing rule "+"parameter", expecting, actual);
	}

	public void testPreconditions1() throws Exception {
		// test input: "when"
		Object retval = execParser("preconditions", "when", false);
		Object actual = examineParserExecResult(28, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"preconditions", expecting, actual);
	}

	public void testPreconditions2() throws Exception {
		// test input: "when c at p"
		Object retval = execParser("preconditions", "when c at p", false);
		Object actual = examineParserExecResult(8, retval);
		Object expecting = "(PRECONDITIONS (at c p))";

		assertEquals("testing rule "+"preconditions", expecting, actual);
	}

	public void testPreconditions3() throws Exception {
		// test input: "when c at p d at p"
		Object retval = execParser("preconditions", "when c at p d at p", false);
		Object actual = examineParserExecResult(8, retval);
		Object expecting = "(PRECONDITIONS (at c p) (at d p))";

		assertEquals("testing rule "+"preconditions", expecting, actual);
	}

	public void testEffects1() throws Exception {
		// test input: "then"
		Object retval = execParser("effects", "then", false);
		Object actual = examineParserExecResult(28, retval);
		Object expecting = "FAIL";

		assertEquals("testing rule "+"effects", expecting, actual);
	}

	public void testEffects2() throws Exception {
		// test input: "then c flirts d"
		Object retval = execParser("effects", "then c flirts d", false);
		Object actual = examineParserExecResult(8, retval);
		Object expecting = "(EFFECTS (flirts c d))";

		assertEquals("testing rule "+"effects", expecting, actual);
	}

	public void testEffects3() throws Exception {
		// test input: "then c flirts d d flirts c"
		Object retval = execParser("effects", "then c flirts d d flirts c", false);
		Object actual = examineParserExecResult(8, retval);
		Object expecting = "(EFFECTS (flirts c d) (flirts d c))";

		assertEquals("testing rule "+"effects", expecting, actual);
	}

	public void testProposition1() throws Exception {
		// test input: "c flirts d"
		Object retval = execParser("proposition", "c flirts d", false);
		Object actual = examineParserExecResult(8, retval);
		Object expecting = "(flirts c d)";

		assertEquals("testing rule "+"proposition", expecting, actual);
	}

	public void testProposition2() throws Exception {
		// test input: "c flirts with d"
		Object retval = execParser("proposition", "c flirts with d", false);
		Object actual = examineParserExecResult(8, retval);
		Object expecting = "(flirts c d)";

		assertEquals("testing rule "+"proposition", expecting, actual);
	}

	public void testProposition3() throws Exception {
		// test input: "c is at d"
		Object retval = execParser("proposition", "c is at d", false);
		Object actual = examineParserExecResult(8, retval);
		Object expecting = "(at c d)";

		assertEquals("testing rule "+"proposition", expecting, actual);
	}

	public void testProposition4() throws Exception {
		// test input: "c doesn't fancy d"
		Object retval = execParser("proposition", "c doesn't fancy d", false);
		Object actual = examineParserExecResult(8, retval);
		Object expecting = "(!fancy c d)";

		assertEquals("testing rule "+"proposition", expecting, actual);
	}

	// Invoke target parser.rule
	public Object execParser(String testRuleName, String testInput, boolean isFile) throws Exception {
		CharStream input;
		/** Set up ANTLR input stream based on input source, file or String */
		if ( isFile==true ) {
			input = new ANTLRFileStream(testInput);
		}
		else {
			input = new ANTLRStringStream(testInput);
		}
		try {
			ActionsLexer lexer = new ActionsLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			ActionsParser parser = new ActionsParser(tokens);

//			parser.prepareForGUnit();

			/** Use Reflection to get rule method from parser */
			Method ruleName = Class.forName("parser.ActionsParser").getMethod(testRuleName);

			/** Start of I/O Redirecting */
			PipedInputStream pipedIn = new PipedInputStream();
			PipedOutputStream pipedOut = new PipedOutputStream();
			PipedInputStream pipedErrIn = new PipedInputStream();
			PipedOutputStream pipedErrOut = new PipedOutputStream();
			try {
				pipedOut.connect(pipedIn);
				pipedErrOut.connect(pipedErrIn);
			}
			catch(IOException e) {
				System.err.println("connection failed...");
				System.exit(1);
			}
			PrintStream console = System.out;
			PrintStream consoleErr = System.err;
			PrintStream ps = new PrintStream(pipedOut);
			PrintStream ps2 = new PrintStream(pipedErrOut);
			System.setOut(ps);
			System.setErr(ps2);
			/** End of redirecting */

			/** Invoke grammar rule, and store if there is a return value */
			Object ruleReturn = ruleName.invoke(parser);
			String astString = null;
			/** If rule has return value, determine if it's an AST */
			if ( ruleReturn!=null ) {
				/** If return object is instanceof AST, get the toStringTree */
				if ( ruleReturn.toString().indexOf(testRuleName+"_return")>0 ) {
					try {	// NullPointerException may happen here...
						Class _return = Class.forName("parser.ActionsParser"+"$"+testRuleName+"_return");            	
						Method[] methods = _return.getDeclaredMethods();
                		for(Method method : methods) {
			                if ( method.getName().equals("getTree") ) {
			                	Method returnName = _return.getMethod("getTree");
		                    	CommonTree tree = (CommonTree) returnName.invoke(ruleReturn);
		                    	astString = tree.toStringTree();
			                }
			            }
					}
					catch(Exception e) {
                		System.err.println(e);
                	}
				}
			}

			org.antlr.gunit.gUnitExecuter.StreamVacuum stdoutVacuum = new org.antlr.gunit.gUnitExecuter.StreamVacuum(pipedIn);
			org.antlr.gunit.gUnitExecuter.StreamVacuum stderrVacuum = new org.antlr.gunit.gUnitExecuter.StreamVacuum(pipedErrIn);
			ps.close();
			ps2.close();
			System.setOut(console);			// Reset standard output
			System.setErr(consoleErr);		// Reset standard err out
			this.stdout = null;
			this.stderr = null;
			stdoutVacuum.start();
			stderrVacuum.start();			
			stdoutVacuum.join();
			stderrVacuum.join();
			// retVal could be actual return object from rule, stderr or stdout
			if ( stderrVacuum.toString().length()>0 ) {
				this.stderr = stderrVacuum.toString();
				return this.stderr;
			}
			if ( stdoutVacuum.toString().length()>0 ) {
				this.stdout = stdoutVacuum.toString();
			}
			if ( astString!=null ) {	// Return toStringTree of AST
				return astString;
			}
			if ( ruleReturn!=null ) {
				return ruleReturn;
			}
			if ( stderrVacuum.toString().length()==0 && stdoutVacuum.toString().length()==0 ) {
				return null;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); System.exit(1);
		} catch (SecurityException e) {
			e.printStackTrace(); System.exit(1);
		} catch (NoSuchMethodException e) {
			e.printStackTrace(); System.exit(1);
		} catch (IllegalAccessException e) {
			e.printStackTrace(); System.exit(1);
		} catch (InvocationTargetException e) {
			return e.getCause().toString();
		} catch (InterruptedException e) {
			e.printStackTrace(); System.exit(1);
		} catch (Exception e) {
			e.printStackTrace(); System.exit(1);
		}
		return stdout;
	}

	// Modify the return value if the expected token type is OK or FAIL
	public Object examineParserExecResult(int tokenType, Object retVal) {	
		if ( tokenType==27 ) {	// expected Token: OK
			if ( this.stderr==null ) {
				return "OK";
			}
			else {
				return "FAIL";
			}
		}
		else if ( tokenType==28 ) {	// expected Token: FAIL
			if ( this.stderr!=null ) {
				return "FAIL";
			}
			else {
				return "OK";
			}
		}
		else {	// return the same object for the other token types
			return retVal;
		}		
	}

}
