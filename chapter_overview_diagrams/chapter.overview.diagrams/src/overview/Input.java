/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package overview;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link overview.Input#getChapteri <em>Chapteri</em>}</li>
 * </ul>
 * </p>
 *
 * @see overview.OverviewPackage#getInput()
 * @model
 * @generated
 */
public interface Input extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Chapteri</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Chapteri</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Chapteri</em>' reference.
	 * @see #setChapteri(Chapter)
	 * @see overview.OverviewPackage#getInput_Chapteri()
	 * @model required="true"
	 *        annotation="gmf.link target.decoration='arrow'"
	 * @generated
	 */
	Chapter getChapteri();

	/**
	 * Sets the value of the '{@link overview.Input#getChapteri <em>Chapteri</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Chapteri</em>' reference.
	 * @see #getChapteri()
	 * @generated
	 */
	void setChapteri(Chapter value);

} // Input
