/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package actionsAntlrAst.impl;

import actionsAntlrAst.ActionNode;
import actionsAntlrAst.ActionsAntlrAstFactory;
import actionsAntlrAst.ActionsAntlrAstPackage;
import actionsAntlrAst.CharacterParameterNode;
import actionsAntlrAst.EffectsNode;
import actionsAntlrAst.NameNode;
import actionsAntlrAst.ParametersNode;
import actionsAntlrAst.PreconditionsNode;
import actionsAntlrAst.PropositionNode;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.epsilon.antlr.postprocessor.model.antlrAst.AntlrAstPackage;

import org.eclipse.epsilon.antlr.postprocessor.model.antlrAst.impl.AntlrAstPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ActionsAntlrAstPackageImpl extends EPackageImpl implements ActionsAntlrAstPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass effectsNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propositionNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nameNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parametersNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass characterParameterNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass preconditionsNodeEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see actionsAntlrAst.ActionsAntlrAstPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ActionsAntlrAstPackageImpl() {
		super(eNS_URI, ActionsAntlrAstFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ActionsAntlrAstPackage init() {
		if (isInited) return (ActionsAntlrAstPackage)EPackage.Registry.INSTANCE.getEPackage(ActionsAntlrAstPackage.eNS_URI);

		// Obtain or create and register package
		ActionsAntlrAstPackageImpl theActionsAntlrAstPackage = (ActionsAntlrAstPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof ActionsAntlrAstPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new ActionsAntlrAstPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		AntlrAstPackageImpl theAntlrAstPackage = (AntlrAstPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AntlrAstPackage.eNS_URI) instanceof AntlrAstPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AntlrAstPackage.eNS_URI) : AntlrAstPackage.eINSTANCE);

		// Create package meta-data objects
		theActionsAntlrAstPackage.createPackageContents();
		theAntlrAstPackage.createPackageContents();

		// Initialize created meta-data
		theActionsAntlrAstPackage.initializePackageContents();
		theAntlrAstPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theActionsAntlrAstPackage.freeze();

		return theActionsAntlrAstPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActionNode() {
		return actionNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEffectsNode() {
		return effectsNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropositionNode() {
		return propositionNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNameNode() {
		return nameNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParametersNode() {
		return parametersNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCharacterParameterNode() {
		return characterParameterNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPreconditionsNode() {
		return preconditionsNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionsAntlrAstFactory getActionsAntlrAstFactory() {
		return (ActionsAntlrAstFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		actionNodeEClass = createEClass(ACTION_NODE);

		effectsNodeEClass = createEClass(EFFECTS_NODE);

		propositionNodeEClass = createEClass(PROPOSITION_NODE);

		nameNodeEClass = createEClass(NAME_NODE);

		parametersNodeEClass = createEClass(PARAMETERS_NODE);

		characterParameterNodeEClass = createEClass(CHARACTER_PARAMETER_NODE);

		preconditionsNodeEClass = createEClass(PRECONDITIONS_NODE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		AntlrAstPackage theAntlrAstPackage = (AntlrAstPackage)EPackage.Registry.INSTANCE.getEPackage(AntlrAstPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		actionNodeEClass.getESuperTypes().add(theAntlrAstPackage.getNode());
		effectsNodeEClass.getESuperTypes().add(theAntlrAstPackage.getNode());
		propositionNodeEClass.getESuperTypes().add(theAntlrAstPackage.getNode());
		nameNodeEClass.getESuperTypes().add(theAntlrAstPackage.getNode());
		parametersNodeEClass.getESuperTypes().add(theAntlrAstPackage.getNode());
		characterParameterNodeEClass.getESuperTypes().add(theAntlrAstPackage.getNode());
		preconditionsNodeEClass.getESuperTypes().add(theAntlrAstPackage.getNode());

		// Initialize classes and features; add operations and parameters
		initEClass(actionNodeEClass, ActionNode.class, "ActionNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(effectsNodeEClass, EffectsNode.class, "EffectsNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(propositionNodeEClass, PropositionNode.class, "PropositionNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(nameNodeEClass, NameNode.class, "NameNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(parametersNodeEClass, ParametersNode.class, "ParametersNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(characterParameterNodeEClass, CharacterParameterNode.class, "CharacterParameterNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(preconditionsNodeEClass, PreconditionsNode.class, "PreconditionsNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //ActionsAntlrAstPackageImpl
