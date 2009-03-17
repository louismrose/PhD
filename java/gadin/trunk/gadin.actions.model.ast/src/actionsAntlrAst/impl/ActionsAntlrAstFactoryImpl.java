/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package actionsAntlrAst.impl;

import actionsAntlrAst.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ActionsAntlrAstFactoryImpl extends EFactoryImpl implements ActionsAntlrAstFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ActionsAntlrAstFactory init() {
		try {
			ActionsAntlrAstFactory theActionsAntlrAstFactory = (ActionsAntlrAstFactory)EPackage.Registry.INSTANCE.getEFactory("actionsAntlrAst"); 
			if (theActionsAntlrAstFactory != null) {
				return theActionsAntlrAstFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ActionsAntlrAstFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionsAntlrAstFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ActionsAntlrAstPackage.ACTION_NODE: return createActionNode();
			case ActionsAntlrAstPackage.EFFECTS_NODE: return createEffectsNode();
			case ActionsAntlrAstPackage.PROPOSITION_NODE: return createPropositionNode();
			case ActionsAntlrAstPackage.NAME_NODE: return createNameNode();
			case ActionsAntlrAstPackage.PARAMETERS_NODE: return createParametersNode();
			case ActionsAntlrAstPackage.CHARACTER_PARAMETER_NODE: return createCharacterParameterNode();
			case ActionsAntlrAstPackage.PRECONDITIONS_NODE: return createPreconditionsNode();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionNode createActionNode() {
		ActionNodeImpl actionNode = new ActionNodeImpl();
		return actionNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EffectsNode createEffectsNode() {
		EffectsNodeImpl effectsNode = new EffectsNodeImpl();
		return effectsNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropositionNode createPropositionNode() {
		PropositionNodeImpl propositionNode = new PropositionNodeImpl();
		return propositionNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NameNode createNameNode() {
		NameNodeImpl nameNode = new NameNodeImpl();
		return nameNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParametersNode createParametersNode() {
		ParametersNodeImpl parametersNode = new ParametersNodeImpl();
		return parametersNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CharacterParameterNode createCharacterParameterNode() {
		CharacterParameterNodeImpl characterParameterNode = new CharacterParameterNodeImpl();
		return characterParameterNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PreconditionsNode createPreconditionsNode() {
		PreconditionsNodeImpl preconditionsNode = new PreconditionsNodeImpl();
		return preconditionsNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionsAntlrAstPackage getActionsAntlrAstPackage() {
		return (ActionsAntlrAstPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ActionsAntlrAstPackage getPackage() {
		return ActionsAntlrAstPackage.eINSTANCE;
	}

} //ActionsAntlrAstFactoryImpl
