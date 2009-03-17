/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package actions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Proposition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link actions.Proposition#getType <em>Type</em>}</li>
 *   <li>{@link actions.Proposition#isPositive <em>Positive</em>}</li>
 * </ul>
 * </p>
 *
 * @see actions.ActionsPackage#getProposition()
 * @model
 * @generated
 */
public interface Proposition extends ParameterisedElement {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(PropositionType)
	 * @see actions.ActionsPackage#getProposition_Type()
	 * @model required="true"
	 * @generated
	 */
	PropositionType getType();

	/**
	 * Sets the value of the '{@link actions.Proposition#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(PropositionType value);

	/**
	 * Returns the value of the '<em><b>Positive</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Positive</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Positive</em>' attribute.
	 * @see #setPositive(boolean)
	 * @see actions.ActionsPackage#getProposition_Positive()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isPositive();

	/**
	 * Sets the value of the '{@link actions.Proposition#isPositive <em>Positive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Positive</em>' attribute.
	 * @see #isPositive()
	 * @generated
	 */
	void setPositive(boolean value);

} // Proposition
