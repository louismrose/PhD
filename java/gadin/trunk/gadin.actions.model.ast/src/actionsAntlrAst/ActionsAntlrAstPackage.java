/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package actionsAntlrAst;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.epsilon.antlr.postprocessor.model.antlrAst.AntlrAstPackage;

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
 * @see actionsAntlrAst.ActionsAntlrAstFactory
 * @model kind="package"
 * @generated
 */
public interface ActionsAntlrAstPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "actionsAntlrAst";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "actionsAntlrAst";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "actionsAntlrAst";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ActionsAntlrAstPackage eINSTANCE = actionsAntlrAst.impl.ActionsAntlrAstPackageImpl.init();

	/**
	 * The meta object id for the '{@link actionsAntlrAst.impl.ActionNodeImpl <em>Action Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see actionsAntlrAst.impl.ActionNodeImpl
	 * @see actionsAntlrAst.impl.ActionsAntlrAstPackageImpl#getActionNode()
	 * @generated
	 */
	int ACTION_NODE = 0;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_NODE__TEXT = AntlrAstPackage.NODE__TEXT;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_NODE__LINE = AntlrAstPackage.NODE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_NODE__COLUMN = AntlrAstPackage.NODE__COLUMN;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_NODE__PARENT = AntlrAstPackage.NODE__PARENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_NODE__CHILDREN = AntlrAstPackage.NODE__CHILDREN;

	/**
	 * The number of structural features of the '<em>Action Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_NODE_FEATURE_COUNT = AntlrAstPackage.NODE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link actionsAntlrAst.impl.EffectsNodeImpl <em>Effects Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see actionsAntlrAst.impl.EffectsNodeImpl
	 * @see actionsAntlrAst.impl.ActionsAntlrAstPackageImpl#getEffectsNode()
	 * @generated
	 */
	int EFFECTS_NODE = 1;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFFECTS_NODE__TEXT = AntlrAstPackage.NODE__TEXT;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFFECTS_NODE__LINE = AntlrAstPackage.NODE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFFECTS_NODE__COLUMN = AntlrAstPackage.NODE__COLUMN;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFFECTS_NODE__PARENT = AntlrAstPackage.NODE__PARENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFFECTS_NODE__CHILDREN = AntlrAstPackage.NODE__CHILDREN;

	/**
	 * The number of structural features of the '<em>Effects Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFFECTS_NODE_FEATURE_COUNT = AntlrAstPackage.NODE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link actionsAntlrAst.impl.PropositionNodeImpl <em>Proposition Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see actionsAntlrAst.impl.PropositionNodeImpl
	 * @see actionsAntlrAst.impl.ActionsAntlrAstPackageImpl#getPropositionNode()
	 * @generated
	 */
	int PROPOSITION_NODE = 2;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPOSITION_NODE__TEXT = AntlrAstPackage.NODE__TEXT;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPOSITION_NODE__LINE = AntlrAstPackage.NODE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPOSITION_NODE__COLUMN = AntlrAstPackage.NODE__COLUMN;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPOSITION_NODE__PARENT = AntlrAstPackage.NODE__PARENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPOSITION_NODE__CHILDREN = AntlrAstPackage.NODE__CHILDREN;

	/**
	 * The number of structural features of the '<em>Proposition Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPOSITION_NODE_FEATURE_COUNT = AntlrAstPackage.NODE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link actionsAntlrAst.impl.NameNodeImpl <em>Name Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see actionsAntlrAst.impl.NameNodeImpl
	 * @see actionsAntlrAst.impl.ActionsAntlrAstPackageImpl#getNameNode()
	 * @generated
	 */
	int NAME_NODE = 3;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_NODE__TEXT = AntlrAstPackage.NODE__TEXT;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_NODE__LINE = AntlrAstPackage.NODE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_NODE__COLUMN = AntlrAstPackage.NODE__COLUMN;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_NODE__PARENT = AntlrAstPackage.NODE__PARENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_NODE__CHILDREN = AntlrAstPackage.NODE__CHILDREN;

	/**
	 * The number of structural features of the '<em>Name Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_NODE_FEATURE_COUNT = AntlrAstPackage.NODE_FEATURE_COUNT + 0;


	/**
	 * The meta object id for the '{@link actionsAntlrAst.impl.ParametersNodeImpl <em>Parameters Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see actionsAntlrAst.impl.ParametersNodeImpl
	 * @see actionsAntlrAst.impl.ActionsAntlrAstPackageImpl#getParametersNode()
	 * @generated
	 */
	int PARAMETERS_NODE = 4;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERS_NODE__TEXT = AntlrAstPackage.NODE__TEXT;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERS_NODE__LINE = AntlrAstPackage.NODE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERS_NODE__COLUMN = AntlrAstPackage.NODE__COLUMN;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERS_NODE__PARENT = AntlrAstPackage.NODE__PARENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERS_NODE__CHILDREN = AntlrAstPackage.NODE__CHILDREN;

	/**
	 * The number of structural features of the '<em>Parameters Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERS_NODE_FEATURE_COUNT = AntlrAstPackage.NODE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link actionsAntlrAst.impl.CharacterParameterNodeImpl <em>Character Parameter Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see actionsAntlrAst.impl.CharacterParameterNodeImpl
	 * @see actionsAntlrAst.impl.ActionsAntlrAstPackageImpl#getCharacterParameterNode()
	 * @generated
	 */
	int CHARACTER_PARAMETER_NODE = 5;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTER_PARAMETER_NODE__TEXT = AntlrAstPackage.NODE__TEXT;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTER_PARAMETER_NODE__LINE = AntlrAstPackage.NODE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTER_PARAMETER_NODE__COLUMN = AntlrAstPackage.NODE__COLUMN;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTER_PARAMETER_NODE__PARENT = AntlrAstPackage.NODE__PARENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTER_PARAMETER_NODE__CHILDREN = AntlrAstPackage.NODE__CHILDREN;

	/**
	 * The number of structural features of the '<em>Character Parameter Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTER_PARAMETER_NODE_FEATURE_COUNT = AntlrAstPackage.NODE_FEATURE_COUNT + 0;


	/**
	 * The meta object id for the '{@link actionsAntlrAst.impl.PreconditionsNodeImpl <em>Preconditions Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see actionsAntlrAst.impl.PreconditionsNodeImpl
	 * @see actionsAntlrAst.impl.ActionsAntlrAstPackageImpl#getPreconditionsNode()
	 * @generated
	 */
	int PRECONDITIONS_NODE = 6;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECONDITIONS_NODE__TEXT = AntlrAstPackage.NODE__TEXT;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECONDITIONS_NODE__LINE = AntlrAstPackage.NODE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECONDITIONS_NODE__COLUMN = AntlrAstPackage.NODE__COLUMN;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECONDITIONS_NODE__PARENT = AntlrAstPackage.NODE__PARENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECONDITIONS_NODE__CHILDREN = AntlrAstPackage.NODE__CHILDREN;

	/**
	 * The number of structural features of the '<em>Preconditions Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECONDITIONS_NODE_FEATURE_COUNT = AntlrAstPackage.NODE_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link actionsAntlrAst.ActionNode <em>Action Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action Node</em>'.
	 * @see actionsAntlrAst.ActionNode
	 * @generated
	 */
	EClass getActionNode();

	/**
	 * Returns the meta object for class '{@link actionsAntlrAst.EffectsNode <em>Effects Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Effects Node</em>'.
	 * @see actionsAntlrAst.EffectsNode
	 * @generated
	 */
	EClass getEffectsNode();

	/**
	 * Returns the meta object for class '{@link actionsAntlrAst.PropositionNode <em>Proposition Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Proposition Node</em>'.
	 * @see actionsAntlrAst.PropositionNode
	 * @generated
	 */
	EClass getPropositionNode();

	/**
	 * Returns the meta object for class '{@link actionsAntlrAst.NameNode <em>Name Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Name Node</em>'.
	 * @see actionsAntlrAst.NameNode
	 * @generated
	 */
	EClass getNameNode();

	/**
	 * Returns the meta object for class '{@link actionsAntlrAst.ParametersNode <em>Parameters Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameters Node</em>'.
	 * @see actionsAntlrAst.ParametersNode
	 * @generated
	 */
	EClass getParametersNode();

	/**
	 * Returns the meta object for class '{@link actionsAntlrAst.CharacterParameterNode <em>Character Parameter Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Character Parameter Node</em>'.
	 * @see actionsAntlrAst.CharacterParameterNode
	 * @generated
	 */
	EClass getCharacterParameterNode();

	/**
	 * Returns the meta object for class '{@link actionsAntlrAst.PreconditionsNode <em>Preconditions Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Preconditions Node</em>'.
	 * @see actionsAntlrAst.PreconditionsNode
	 * @generated
	 */
	EClass getPreconditionsNode();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ActionsAntlrAstFactory getActionsAntlrAstFactory();

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
		 * The meta object literal for the '{@link actionsAntlrAst.impl.ActionNodeImpl <em>Action Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see actionsAntlrAst.impl.ActionNodeImpl
		 * @see actionsAntlrAst.impl.ActionsAntlrAstPackageImpl#getActionNode()
		 * @generated
		 */
		EClass ACTION_NODE = eINSTANCE.getActionNode();

		/**
		 * The meta object literal for the '{@link actionsAntlrAst.impl.EffectsNodeImpl <em>Effects Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see actionsAntlrAst.impl.EffectsNodeImpl
		 * @see actionsAntlrAst.impl.ActionsAntlrAstPackageImpl#getEffectsNode()
		 * @generated
		 */
		EClass EFFECTS_NODE = eINSTANCE.getEffectsNode();

		/**
		 * The meta object literal for the '{@link actionsAntlrAst.impl.PropositionNodeImpl <em>Proposition Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see actionsAntlrAst.impl.PropositionNodeImpl
		 * @see actionsAntlrAst.impl.ActionsAntlrAstPackageImpl#getPropositionNode()
		 * @generated
		 */
		EClass PROPOSITION_NODE = eINSTANCE.getPropositionNode();

		/**
		 * The meta object literal for the '{@link actionsAntlrAst.impl.NameNodeImpl <em>Name Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see actionsAntlrAst.impl.NameNodeImpl
		 * @see actionsAntlrAst.impl.ActionsAntlrAstPackageImpl#getNameNode()
		 * @generated
		 */
		EClass NAME_NODE = eINSTANCE.getNameNode();

		/**
		 * The meta object literal for the '{@link actionsAntlrAst.impl.ParametersNodeImpl <em>Parameters Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see actionsAntlrAst.impl.ParametersNodeImpl
		 * @see actionsAntlrAst.impl.ActionsAntlrAstPackageImpl#getParametersNode()
		 * @generated
		 */
		EClass PARAMETERS_NODE = eINSTANCE.getParametersNode();

		/**
		 * The meta object literal for the '{@link actionsAntlrAst.impl.CharacterParameterNodeImpl <em>Character Parameter Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see actionsAntlrAst.impl.CharacterParameterNodeImpl
		 * @see actionsAntlrAst.impl.ActionsAntlrAstPackageImpl#getCharacterParameterNode()
		 * @generated
		 */
		EClass CHARACTER_PARAMETER_NODE = eINSTANCE.getCharacterParameterNode();

		/**
		 * The meta object literal for the '{@link actionsAntlrAst.impl.PreconditionsNodeImpl <em>Preconditions Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see actionsAntlrAst.impl.PreconditionsNodeImpl
		 * @see actionsAntlrAst.impl.ActionsAntlrAstPackageImpl#getPreconditionsNode()
		 * @generated
		 */
		EClass PRECONDITIONS_NODE = eINSTANCE.getPreconditionsNode();

	}

} //ActionsAntlrAstPackage
