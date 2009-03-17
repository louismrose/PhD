/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package actionsAntlrAst;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see actionsAntlrAst.ActionsAntlrAstPackage
 * @generated
 */
public interface ActionsAntlrAstFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ActionsAntlrAstFactory eINSTANCE = actionsAntlrAst.impl.ActionsAntlrAstFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Action Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Action Node</em>'.
	 * @generated
	 */
	ActionNode createActionNode();

	/**
	 * Returns a new object of class '<em>Effects Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Effects Node</em>'.
	 * @generated
	 */
	EffectsNode createEffectsNode();

	/**
	 * Returns a new object of class '<em>Proposition Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Proposition Node</em>'.
	 * @generated
	 */
	PropositionNode createPropositionNode();

	/**
	 * Returns a new object of class '<em>Name Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Name Node</em>'.
	 * @generated
	 */
	NameNode createNameNode();

	/**
	 * Returns a new object of class '<em>Parameters Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameters Node</em>'.
	 * @generated
	 */
	ParametersNode createParametersNode();

	/**
	 * Returns a new object of class '<em>Character Parameter Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Character Parameter Node</em>'.
	 * @generated
	 */
	CharacterParameterNode createCharacterParameterNode();

	/**
	 * Returns a new object of class '<em>Preconditions Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Preconditions Node</em>'.
	 * @generated
	 */
	PreconditionsNode createPreconditionsNode();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ActionsAntlrAstPackage getActionsAntlrAstPackage();

} //ActionsAntlrAstFactory
