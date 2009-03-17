/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package actions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Proposition Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link actions.PropositionType#isReflexive <em>Reflexive</em>}</li>
 *   <li>{@link actions.PropositionType#isExclusive <em>Exclusive</em>}</li>
 * </ul>
 * </p>
 *
 * @see actions.ActionsPackage#getPropositionType()
 * @model
 * @generated
 */
public interface PropositionType extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Reflexive</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reflexive</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reflexive</em>' attribute.
	 * @see #setReflexive(boolean)
	 * @see actions.ActionsPackage#getPropositionType_Reflexive()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isReflexive();

	/**
	 * Sets the value of the '{@link actions.PropositionType#isReflexive <em>Reflexive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reflexive</em>' attribute.
	 * @see #isReflexive()
	 * @generated
	 */
	void setReflexive(boolean value);

	/**
	 * Returns the value of the '<em><b>Exclusive</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exclusive</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exclusive</em>' attribute.
	 * @see #setExclusive(boolean)
	 * @see actions.ActionsPackage#getPropositionType_Exclusive()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isExclusive();

	/**
	 * Sets the value of the '{@link actions.PropositionType#isExclusive <em>Exclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exclusive</em>' attribute.
	 * @see #isExclusive()
	 * @generated
	 */
	void setExclusive(boolean value);

} // PropositionType
