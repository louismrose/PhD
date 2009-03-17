/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package actions;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link actions.Action#getPreconditionSets <em>Precondition Sets</em>}</li>
 *   <li>{@link actions.Action#getApplicabilityConditions <em>Applicability Conditions</em>}</li>
 *   <li>{@link actions.Action#getEffects <em>Effects</em>}</li>
 * </ul>
 * </p>
 *
 * @see actions.ActionsPackage#getAction()
 * @model
 * @generated
 */
public interface Action extends NamedElement, ParameterisedElement {
	/**
	 * Returns the value of the '<em><b>Precondition Sets</b></em>' containment reference list.
	 * The list contents are of type {@link actions.PreconditionSet}.
	 * It is bidirectional and its opposite is '{@link actions.PreconditionSet#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Precondition Sets</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Precondition Sets</em>' containment reference list.
	 * @see actions.ActionsPackage#getAction_PreconditionSets()
	 * @see actions.PreconditionSet#getAction
	 * @model opposite="action" containment="true" required="true"
	 * @generated
	 */
	EList<PreconditionSet> getPreconditionSets();

	/**
	 * Returns the value of the '<em><b>Applicability Conditions</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Applicability Conditions</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Applicability Conditions</em>' attribute list.
	 * @see actions.ActionsPackage#getAction_ApplicabilityConditions()
	 * @model
	 * @generated
	 */
	EList<String> getApplicabilityConditions();

	/**
	 * Returns the value of the '<em><b>Effects</b></em>' containment reference list.
	 * The list contents are of type {@link actions.Proposition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Effects</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Effects</em>' containment reference list.
	 * @see actions.ActionsPackage#getAction_Effects()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Proposition> getEffects();

} // Action
