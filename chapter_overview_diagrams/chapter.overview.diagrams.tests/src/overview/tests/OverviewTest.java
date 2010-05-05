/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package overview.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import overview.Overview;
import overview.OverviewFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Overview</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class OverviewTest extends TestCase {

	/**
	 * The fixture for this Overview test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Overview fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(OverviewTest.class);
	}

	/**
	 * Constructs a new Overview test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OverviewTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Overview test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Overview fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Overview test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Overview getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(OverviewFactory.eINSTANCE.createOverview());
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

} //OverviewTest
