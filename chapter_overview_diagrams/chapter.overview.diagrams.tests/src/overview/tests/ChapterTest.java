/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package overview.tests;

import junit.textui.TestRunner;

import overview.Chapter;
import overview.OverviewFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Chapter</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ChapterTest extends NamedElementTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ChapterTest.class);
	}

	/**
	 * Constructs a new Chapter test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChapterTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Chapter test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Chapter getFixture() {
		return (Chapter)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(OverviewFactory.eINSTANCE.createChapter());
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

} //ChapterTest
