/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package actionsAntlrAst.util;

import actionsAntlrAst.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.epsilon.antlr.postprocessor.model.antlrAst.Node;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see actionsAntlrAst.ActionsAntlrAstPackage
 * @generated
 */
public class ActionsAntlrAstAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ActionsAntlrAstPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionsAntlrAstAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ActionsAntlrAstPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActionsAntlrAstSwitch<Adapter> modelSwitch =
		new ActionsAntlrAstSwitch<Adapter>() {
			@Override
			public Adapter caseActionNode(ActionNode object) {
				return createActionNodeAdapter();
			}
			@Override
			public Adapter caseEffectsNode(EffectsNode object) {
				return createEffectsNodeAdapter();
			}
			@Override
			public Adapter casePropositionNode(PropositionNode object) {
				return createPropositionNodeAdapter();
			}
			@Override
			public Adapter caseNameNode(NameNode object) {
				return createNameNodeAdapter();
			}
			@Override
			public Adapter caseParametersNode(ParametersNode object) {
				return createParametersNodeAdapter();
			}
			@Override
			public Adapter caseCharacterParameterNode(CharacterParameterNode object) {
				return createCharacterParameterNodeAdapter();
			}
			@Override
			public Adapter casePreconditionsNode(PreconditionsNode object) {
				return createPreconditionsNodeAdapter();
			}
			@Override
			public Adapter caseNode(Node object) {
				return createNodeAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link actionsAntlrAst.ActionNode <em>Action Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see actionsAntlrAst.ActionNode
	 * @generated
	 */
	public Adapter createActionNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link actionsAntlrAst.EffectsNode <em>Effects Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see actionsAntlrAst.EffectsNode
	 * @generated
	 */
	public Adapter createEffectsNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link actionsAntlrAst.PropositionNode <em>Proposition Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see actionsAntlrAst.PropositionNode
	 * @generated
	 */
	public Adapter createPropositionNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link actionsAntlrAst.NameNode <em>Name Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see actionsAntlrAst.NameNode
	 * @generated
	 */
	public Adapter createNameNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link actionsAntlrAst.ParametersNode <em>Parameters Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see actionsAntlrAst.ParametersNode
	 * @generated
	 */
	public Adapter createParametersNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link actionsAntlrAst.CharacterParameterNode <em>Character Parameter Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see actionsAntlrAst.CharacterParameterNode
	 * @generated
	 */
	public Adapter createCharacterParameterNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link actionsAntlrAst.PreconditionsNode <em>Preconditions Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see actionsAntlrAst.PreconditionsNode
	 * @generated
	 */
	public Adapter createPreconditionsNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.epsilon.antlr.postprocessor.model.antlrAst.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.epsilon.antlr.postprocessor.model.antlrAst.Node
	 * @generated
	 */
	public Adapter createNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ActionsAntlrAstAdapterFactory
