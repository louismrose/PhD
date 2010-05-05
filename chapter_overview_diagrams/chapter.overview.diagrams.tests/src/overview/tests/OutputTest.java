/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package overview.tests;

import junit.textui.TestRunner;

import overview.Output;
import overview.OverviewFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Output</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class OutputTest extends NamedElementTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(OutputTest.class);
	}

	/**
	 * Constructs a new Output test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Output test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Output getFixture() {
		return (Output)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(OverviewFactory.eINSTANCE.createOutput());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //OutputTest
