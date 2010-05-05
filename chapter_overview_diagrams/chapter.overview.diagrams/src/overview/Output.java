/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package overview;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Output</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link overview.Output#getChaptero <em>Chaptero</em>}</li>
 * </ul>
 * </p>
 *
 * @see overview.OverviewPackage#getOutput()
 * @model
 * @generated
 */
public interface Output extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Chaptero</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Chaptero</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Chaptero</em>' reference.
	 * @see #setChaptero(Chapter)
	 * @see overview.OverviewPackage#getOutput_Chaptero()
	 * @model required="true"
	 *        annotation="gmf.link source.decoration='arrow'"
	 * @generated
	 */
	Chapter getChaptero();

	/**
	 * Sets the value of the '{@link overview.Output#getChaptero <em>Chaptero</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Chaptero</em>' reference.
	 * @see #getChaptero()
	 * @generated
	 */
	void setChaptero(Chapter value);

} // Output
