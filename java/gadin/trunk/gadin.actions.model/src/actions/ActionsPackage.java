/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package actions;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see actions.ActionsFactory
 * @model kind="package"
 * @generated
 */
public interface ActionsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "actions";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "actions";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "actions";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ActionsPackage eINSTANCE = actions.impl.ActionsPackageImpl.init();

	/**
	 * The meta object id for the '{@link actions.impl.DocumentImpl <em>Document</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see actions.impl.DocumentImpl
	 * @see actions.impl.ActionsPackageImpl#getDocument()
	 * @generated
	 */
	int DOCUMENT = 0;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT__ACTIONS = 0;

	/**
	 * The number of structural features of the '<em>Document</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link actions.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see actions.impl.NamedElementImpl
	 * @see actions.impl.ActionsPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link actions.impl.ParameterisedElementImpl <em>Parameterised Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see actions.impl.ParameterisedElementImpl
	 * @see actions.impl.ActionsPackageImpl#getParameterisedElement()
	 * @generated
	 */
	int PARAMETERISED_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERISED_ELEMENT__PARAMETERS = 0;

	/**
	 * The number of structural features of the '<em>Parameterised Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERISED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link actions.impl.ActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see actions.impl.ActionImpl
	 * @see actions.impl.ActionsPackageImpl#getAction()
	 * @generated
	 */
	int ACTION = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__PARAMETERS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Precondition Sets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__PRECONDITION_SETS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Applicability Conditions</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__APPLICABILITY_CONDITIONS = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Effects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__EFFECTS = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link actions.impl.PreconditionSetImpl <em>Precondition Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see actions.impl.PreconditionSetImpl
	 * @see actions.impl.ActionsPackageImpl#getPreconditionSet()
	 * @generated
	 */
	int PRECONDITION_SET = 4;

	/**
	 * The feature id for the '<em><b>Action</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECONDITION_SET__ACTION = 0;

	/**
	 * The feature id for the '<em><b>Preconditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECONDITION_SET__PRECONDITIONS = 1;

	/**
	 * The number of structural features of the '<em>Precondition Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECONDITION_SET_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link actions.impl.PropositionImpl <em>Proposition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see actions.impl.PropositionImpl
	 * @see actions.impl.ActionsPackageImpl#getProposition()
	 * @generated
	 */
	int PROPOSITION = 5;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPOSITION__PARAMETERS = PARAMETERISED_ELEMENT__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPOSITION__TYPE = PARAMETERISED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Positive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPOSITION__POSITIVE = PARAMETERISED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Proposition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPOSITION_FEATURE_COUNT = PARAMETERISED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link actions.impl.PropositionTypeImpl <em>Proposition Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see actions.impl.PropositionTypeImpl
	 * @see actions.impl.ActionsPackageImpl#getPropositionType()
	 * @generated
	 */
	int PROPOSITION_TYPE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPOSITION_TYPE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Reflexive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPOSITION_TYPE__REFLEXIVE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Exclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPOSITION_TYPE__EXCLUSIVE = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Proposition Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPOSITION_TYPE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link actions.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see actions.impl.ParameterImpl
	 * @see actions.impl.ActionsPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link actions.impl.CharacterParameterImpl <em>Character Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see actions.impl.CharacterParameterImpl
	 * @see actions.impl.ActionsPackageImpl#getCharacterParameter()
	 * @generated
	 */
	int CHARACTER_PARAMETER = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTER_PARAMETER__NAME = PARAMETER__NAME;

	/**
	 * The number of structural features of the '<em>Character Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTER_PARAMETER_FEATURE_COUNT = PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link actions.impl.LocationParameterImpl <em>Location Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see actions.impl.LocationParameterImpl
	 * @see actions.impl.ActionsPackageImpl#getLocationParameter()
	 * @generated
	 */
	int LOCATION_PARAMETER = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_PARAMETER__NAME = PARAMETER__NAME;

	/**
	 * The number of structural features of the '<em>Location Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_PARAMETER_FEATURE_COUNT = PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link actions.impl.PrincipleParameterImpl <em>Principle Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see actions.impl.PrincipleParameterImpl
	 * @see actions.impl.ActionsPackageImpl#getPrincipleParameter()
	 * @generated
	 */
	int PRINCIPLE_PARAMETER = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINCIPLE_PARAMETER__NAME = PARAMETER__NAME;

	/**
	 * The number of structural features of the '<em>Principle Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINCIPLE_PARAMETER_FEATURE_COUNT = PARAMETER_FEATURE_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link actions.Document <em>Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document</em>'.
	 * @see actions.Document
	 * @generated
	 */
	EClass getDocument();

	/**
	 * Returns the meta object for the containment reference list '{@link actions.Document#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actions</em>'.
	 * @see actions.Document#getActions()
	 * @see #getDocument()
	 * @generated
	 */
	EReference getDocument_Actions();

	/**
	 * Returns the meta object for class '{@link actions.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see actions.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link actions.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see actions.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link actions.ParameterisedElement <em>Parameterised Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameterised Element</em>'.
	 * @see actions.ParameterisedElement
	 * @generated
	 */
	EClass getParameterisedElement();

	/**
	 * Returns the meta object for the containment reference list '{@link actions.ParameterisedElement#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see actions.ParameterisedElement#getParameters()
	 * @see #getParameterisedElement()
	 * @generated
	 */
	EReference getParameterisedElement_Parameters();

	/**
	 * Returns the meta object for class '{@link actions.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see actions.Action
	 * @generated
	 */
	EClass getAction();

	/**
	 * Returns the meta object for the containment reference list '{@link actions.Action#getPreconditionSets <em>Precondition Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Precondition Sets</em>'.
	 * @see actions.Action#getPreconditionSets()
	 * @see #getAction()
	 * @generated
	 */
	EReference getAction_PreconditionSets();

	/**
	 * Returns the meta object for the attribute list '{@link actions.Action#getApplicabilityConditions <em>Applicability Conditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Applicability Conditions</em>'.
	 * @see actions.Action#getApplicabilityConditions()
	 * @see #getAction()
	 * @generated
	 */
	EAttribute getAction_ApplicabilityConditions();

	/**
	 * Returns the meta object for the containment reference list '{@link actions.Action#getEffects <em>Effects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Effects</em>'.
	 * @see actions.Action#getEffects()
	 * @see #getAction()
	 * @generated
	 */
	EReference getAction_Effects();

	/**
	 * Returns the meta object for class '{@link actions.PreconditionSet <em>Precondition Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Precondition Set</em>'.
	 * @see actions.PreconditionSet
	 * @generated
	 */
	EClass getPreconditionSet();

	/**
	 * Returns the meta object for the container reference '{@link actions.PreconditionSet#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Action</em>'.
	 * @see actions.PreconditionSet#getAction()
	 * @see #getPreconditionSet()
	 * @generated
	 */
	EReference getPreconditionSet_Action();

	/**
	 * Returns the meta object for the containment reference list '{@link actions.PreconditionSet#getPreconditions <em>Preconditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Preconditions</em>'.
	 * @see actions.PreconditionSet#getPreconditions()
	 * @see #getPreconditionSet()
	 * @generated
	 */
	EReference getPreconditionSet_Preconditions();

	/**
	 * Returns the meta object for class '{@link actions.Proposition <em>Proposition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Proposition</em>'.
	 * @see actions.Proposition
	 * @generated
	 */
	EClass getProposition();

	/**
	 * Returns the meta object for the reference '{@link actions.Proposition#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see actions.Proposition#getType()
	 * @see #getProposition()
	 * @generated
	 */
	EReference getProposition_Type();

	/**
	 * Returns the meta object for the attribute '{@link actions.Proposition#isPositive <em>Positive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Positive</em>'.
	 * @see actions.Proposition#isPositive()
	 * @see #getProposition()
	 * @generated
	 */
	EAttribute getProposition_Positive();

	/**
	 * Returns the meta object for class '{@link actions.PropositionType <em>Proposition Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Proposition Type</em>'.
	 * @see actions.PropositionType
	 * @generated
	 */
	EClass getPropositionType();

	/**
	 * Returns the meta object for the attribute '{@link actions.PropositionType#isReflexive <em>Reflexive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reflexive</em>'.
	 * @see actions.PropositionType#isReflexive()
	 * @see #getPropositionType()
	 * @generated
	 */
	EAttribute getPropositionType_Reflexive();

	/**
	 * Returns the meta object for the attribute '{@link actions.PropositionType#isExclusive <em>Exclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exclusive</em>'.
	 * @see actions.PropositionType#isExclusive()
	 * @see #getPropositionType()
	 * @generated
	 */
	EAttribute getPropositionType_Exclusive();

	/**
	 * Returns the meta object for class '{@link actions.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see actions.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for class '{@link actions.CharacterParameter <em>Character Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Character Parameter</em>'.
	 * @see actions.CharacterParameter
	 * @generated
	 */
	EClass getCharacterParameter();

	/**
	 * Returns the meta object for class '{@link actions.LocationParameter <em>Location Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Location Parameter</em>'.
	 * @see actions.LocationParameter
	 * @generated
	 */
	EClass getLocationParameter();

	/**
	 * Returns the meta object for class '{@link actions.PrincipleParameter <em>Principle Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Principle Parameter</em>'.
	 * @see actions.PrincipleParameter
	 * @generated
	 */
	EClass getPrincipleParameter();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ActionsFactory getActionsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link actions.impl.DocumentImpl <em>Document</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see actions.impl.DocumentImpl
		 * @see actions.impl.ActionsPackageImpl#getDocument()
		 * @generated
		 */
		EClass DOCUMENT = eINSTANCE.getDocument();

		/**
		 * The meta object literal for the '<em><b>Actions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT__ACTIONS = eINSTANCE.getDocument_Actions();

		/**
		 * The meta object literal for the '{@link actions.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see actions.impl.NamedElementImpl
		 * @see actions.impl.ActionsPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '{@link actions.impl.ParameterisedElementImpl <em>Parameterised Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see actions.impl.ParameterisedElementImpl
		 * @see actions.impl.ActionsPackageImpl#getParameterisedElement()
		 * @generated
		 */
		EClass PARAMETERISED_ELEMENT = eINSTANCE.getParameterisedElement();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETERISED_ELEMENT__PARAMETERS = eINSTANCE.getParameterisedElement_Parameters();

		/**
		 * The meta object literal for the '{@link actions.impl.ActionImpl <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see actions.impl.ActionImpl
		 * @see actions.impl.ActionsPackageImpl#getAction()
		 * @generated
		 */
		EClass ACTION = eINSTANCE.getAction();

		/**
		 * The meta object literal for the '<em><b>Precondition Sets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION__PRECONDITION_SETS = eINSTANCE.getAction_PreconditionSets();

		/**
		 * The meta object literal for the '<em><b>Applicability Conditions</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION__APPLICABILITY_CONDITIONS = eINSTANCE.getAction_ApplicabilityConditions();

		/**
		 * The meta object literal for the '<em><b>Effects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION__EFFECTS = eINSTANCE.getAction_Effects();

		/**
		 * The meta object literal for the '{@link actions.impl.PreconditionSetImpl <em>Precondition Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see actions.impl.PreconditionSetImpl
		 * @see actions.impl.ActionsPackageImpl#getPreconditionSet()
		 * @generated
		 */
		EClass PRECONDITION_SET = eINSTANCE.getPreconditionSet();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRECONDITION_SET__ACTION = eINSTANCE.getPreconditionSet_Action();

		/**
		 * The meta object literal for the '<em><b>Preconditions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRECONDITION_SET__PRECONDITIONS = eINSTANCE.getPreconditionSet_Preconditions();

		/**
		 * The meta object literal for the '{@link actions.impl.PropositionImpl <em>Proposition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see actions.impl.PropositionImpl
		 * @see actions.impl.ActionsPackageImpl#getProposition()
		 * @generated
		 */
		EClass PROPOSITION = eINSTANCE.getProposition();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPOSITION__TYPE = eINSTANCE.getProposition_Type();

		/**
		 * The meta object literal for the '<em><b>Positive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPOSITION__POSITIVE = eINSTANCE.getProposition_Positive();

		/**
		 * The meta object literal for the '{@link actions.impl.PropositionTypeImpl <em>Proposition Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see actions.impl.PropositionTypeImpl
		 * @see actions.impl.ActionsPackageImpl#getPropositionType()
		 * @generated
		 */
		EClass PROPOSITION_TYPE = eINSTANCE.getPropositionType();

		/**
		 * The meta object literal for the '<em><b>Reflexive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPOSITION_TYPE__REFLEXIVE = eINSTANCE.getPropositionType_Reflexive();

		/**
		 * The meta object literal for the '<em><b>Exclusive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPOSITION_TYPE__EXCLUSIVE = eINSTANCE.getPropositionType_Exclusive();

		/**
		 * The meta object literal for the '{@link actions.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see actions.impl.ParameterImpl
		 * @see actions.impl.ActionsPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '{@link actions.impl.CharacterParameterImpl <em>Character Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see actions.impl.CharacterParameterImpl
		 * @see actions.impl.ActionsPackageImpl#getCharacterParameter()
		 * @generated
		 */
		EClass CHARACTER_PARAMETER = eINSTANCE.getCharacterParameter();

		/**
		 * The meta object literal for the '{@link actions.impl.LocationParameterImpl <em>Location Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see actions.impl.LocationParameterImpl
		 * @see actions.impl.ActionsPackageImpl#getLocationParameter()
		 * @generated
		 */
		EClass LOCATION_PARAMETER = eINSTANCE.getLocationParameter();

		/**
		 * The meta object literal for the '{@link actions.impl.PrincipleParameterImpl <em>Principle Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see actions.impl.PrincipleParameterImpl
		 * @see actions.impl.ActionsPackageImpl#getPrincipleParameter()
		 * @generated
		 */
		EClass PRINCIPLE_PARAMETER = eINSTANCE.getPrincipleParameter();

	}

} //ActionsPackage
