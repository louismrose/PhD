/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package actions.impl;

import actions.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import actions.Action;
import actions.ActionsFactory;
import actions.ActionsPackage;
import actions.CharacterParameter;
import actions.Document;
import actions.LocationParameter;
import actions.PrincipleParameter;
import actions.Proposition;
import actions.PropositionType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ActionsFactoryImpl extends EFactoryImpl implements ActionsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ActionsFactory init() {
		try {
			ActionsFactory theActionsFactory = (ActionsFactory)EPackage.Registry.INSTANCE.getEFactory("actions"); 
			if (theActionsFactory != null) {
				return theActionsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ActionsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionsFactoryImpl() {
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
			case ActionsPackage.DOCUMENT: return createDocument();
			case ActionsPackage.ACTION: return createAction();
			case ActionsPackage.PRECONDITION_SET: return createPreconditionSet();
			case ActionsPackage.PROPOSITION: return createProposition();
			case ActionsPackage.PROPOSITION_TYPE: return createPropositionType();
			case ActionsPackage.CHARACTER_PARAMETER: return createCharacterParameter();
			case ActionsPackage.LOCATION_PARAMETER: return createLocationParameter();
			case ActionsPackage.PRINCIPLE_PARAMETER: return createPrincipleParameter();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Document createDocument() {
		DocumentImpl document = new DocumentImpl();
		return document;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action createAction() {
		ActionImpl action = new ActionImpl();
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PreconditionSet createPreconditionSet() {
		PreconditionSetImpl preconditionSet = new PreconditionSetImpl();
		return preconditionSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Proposition createProposition() {
		PropositionImpl proposition = new PropositionImpl();
		return proposition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropositionType createPropositionType() {
		PropositionTypeImpl propositionType = new PropositionTypeImpl();
		return propositionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CharacterParameter createCharacterParameter() {
		CharacterParameterImpl characterParameter = new CharacterParameterImpl();
		return characterParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocationParameter createLocationParameter() {
		LocationParameterImpl locationParameter = new LocationParameterImpl();
		return locationParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrincipleParameter createPrincipleParameter() {
		PrincipleParameterImpl principleParameter = new PrincipleParameterImpl();
		return principleParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionsPackage getActionsPackage() {
		return (ActionsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ActionsPackage getPackage() {
		return ActionsPackage.eINSTANCE;
	}

} //ActionsFactoryImpl
