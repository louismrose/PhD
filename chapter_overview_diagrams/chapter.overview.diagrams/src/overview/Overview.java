/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package overview;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Overview</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link overview.Overview#getChapterrs <em>Chapterrs</em>}</li>
 *   <li>{@link overview.Overview#getInputs <em>Inputs</em>}</li>
 *   <li>{@link overview.Overview#getOutputs <em>Outputs</em>}</li>
 * </ul>
 * </p>
 *
 * @see overview.OverviewPackage#getOverview()
 * @model annotation="gmf.diagram foo='bar'"
 * @generated
 */
public interface Overview extends EObject {
	/**
	 * Returns the value of the '<em><b>Chapterrs</b></em>' containment reference list.
	 * The list contents are of type {@link overview.Chapter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Chapterrs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Chapterrs</em>' containment reference list.
	 * @see overview.OverviewPackage#getOverview_Chapterrs()
	 * @model containment="true"
	 * @generated
	 */
	EList<Chapter> getChapterrs();

	/**
	 * Returns the value of the '<em><b>Inputs</b></em>' containment reference list.
	 * The list contents are of type {@link overview.Input}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inputs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inputs</em>' containment reference list.
	 * @see overview.OverviewPackage#getOverview_Inputs()
	 * @model containment="true"
	 * @generated
	 */
	EList<Input> getInputs();

	/**
	 * Returns the value of the '<em><b>Outputs</b></em>' containment reference list.
	 * The list contents are of type {@link overview.Output}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outputs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outputs</em>' containment reference list.
	 * @see overview.OverviewPackage#getOverview_Outputs()
	 * @model containment="true"
	 * @generated
	 */
	EList<Output> getOutputs();

} // Overview
