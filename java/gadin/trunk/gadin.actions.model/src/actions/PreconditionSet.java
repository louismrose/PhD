/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package actions;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Precondition Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link actions.PreconditionSet#getAction <em>Action</em>}</li>
 *   <li>{@link actions.PreconditionSet#getPreconditions <em>Preconditions</em>}</li>
 * </ul>
 * </p>
 *
 * @see actions.ActionsPackage#getPreconditionSet()
 * @model
 * @generated
 */
public interface PreconditionSet extends EObject {
	/**
	 * Returns the value of the '<em><b>Action</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link actions.Action#getPreconditionSets <em>Precondition Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action</em>' container reference.
	 * @see #setAction(Action)
	 * @see actions.ActionsPackage#getPreconditionSet_Action()
	 * @see actions.Action#getPreconditionSets
	 * @model opposite="preconditionSets" required="true" transient="false"
	 * @generated
	 */
	Action getAction();

	/**
	 * Sets the value of the '{@link actions.PreconditionSet#getAction <em>Action</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action</em>' container reference.
	 * @see #getAction()
	 * @generated
	 */
	void setAction(Action value);

	/**
	 * Returns the value of the '<em><b>Preconditions</b></em>' containment reference list.
	 * The list contents are of type {@link actions.Proposition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Preconditions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Preconditions</em>' containment reference list.
	 * @see actions.ActionsPackage#getPreconditionSet_Preconditions()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Proposition> getPreconditions();

} // PreconditionSet
