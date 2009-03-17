/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package actions.impl;

import actions.Action;
import actions.ActionsPackage;
import actions.Parameter;
import actions.ParameterisedElement;
import actions.PreconditionSet;
import actions.Proposition;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link actions.impl.ActionImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link actions.impl.ActionImpl#getPreconditionSets <em>Precondition Sets</em>}</li>
 *   <li>{@link actions.impl.ActionImpl#getApplicabilityConditions <em>Applicability Conditions</em>}</li>
 *   <li>{@link actions.impl.ActionImpl#getEffects <em>Effects</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActionImpl extends NamedElementImpl implements Action {
	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<Parameter> parameters;

	/**
	 * The cached value of the '{@link #getPreconditionSets() <em>Precondition Sets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreconditionSets()
	 * @generated
	 * @ordered
	 */
	protected EList<PreconditionSet> preconditionSets;

	/**
	 * The cached value of the '{@link #getApplicabilityConditions() <em>Applicability Conditions</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplicabilityConditions()
	 * @generated
	 * @ordered
	 */
	protected EList<String> applicabilityConditions;

	/**
	 * The cached value of the '{@link #getEffects() <em>Effects</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEffects()
	 * @generated
	 * @ordered
	 */
	protected EList<Proposition> effects;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActionsPackage.Literals.ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Parameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<Parameter>(Parameter.class, this, ActionsPackage.ACTION__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PreconditionSet> getPreconditionSets() {
		if (preconditionSets == null) {
			preconditionSets = new EObjectContainmentWithInverseEList<PreconditionSet>(PreconditionSet.class, this, ActionsPackage.ACTION__PRECONDITION_SETS, ActionsPackage.PRECONDITION_SET__ACTION);
		}
		return preconditionSets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getApplicabilityConditions() {
		if (applicabilityConditions == null) {
			applicabilityConditions = new EDataTypeUniqueEList<String>(String.class, this, ActionsPackage.ACTION__APPLICABILITY_CONDITIONS);
		}
		return applicabilityConditions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Proposition> getEffects() {
		if (effects == null) {
			effects = new EObjectContainmentEList<Proposition>(Proposition.class, this, ActionsPackage.ACTION__EFFECTS);
		}
		return effects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ActionsPackage.ACTION__PRECONDITION_SETS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPreconditionSets()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ActionsPackage.ACTION__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
			case ActionsPackage.ACTION__PRECONDITION_SETS:
				return ((InternalEList<?>)getPreconditionSets()).basicRemove(otherEnd, msgs);
			case ActionsPackage.ACTION__EFFECTS:
				return ((InternalEList<?>)getEffects()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ActionsPackage.ACTION__PARAMETERS:
				return getParameters();
			case ActionsPackage.ACTION__PRECONDITION_SETS:
				return getPreconditionSets();
			case ActionsPackage.ACTION__APPLICABILITY_CONDITIONS:
				return getApplicabilityConditions();
			case ActionsPackage.ACTION__EFFECTS:
				return getEffects();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ActionsPackage.ACTION__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends Parameter>)newValue);
				return;
			case ActionsPackage.ACTION__PRECONDITION_SETS:
				getPreconditionSets().clear();
				getPreconditionSets().addAll((Collection<? extends PreconditionSet>)newValue);
				return;
			case ActionsPackage.ACTION__APPLICABILITY_CONDITIONS:
				getApplicabilityConditions().clear();
				getApplicabilityConditions().addAll((Collection<? extends String>)newValue);
				return;
			case ActionsPackage.ACTION__EFFECTS:
				getEffects().clear();
				getEffects().addAll((Collection<? extends Proposition>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ActionsPackage.ACTION__PARAMETERS:
				getParameters().clear();
				return;
			case ActionsPackage.ACTION__PRECONDITION_SETS:
				getPreconditionSets().clear();
				return;
			case ActionsPackage.ACTION__APPLICABILITY_CONDITIONS:
				getApplicabilityConditions().clear();
				return;
			case ActionsPackage.ACTION__EFFECTS:
				getEffects().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ActionsPackage.ACTION__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case ActionsPackage.ACTION__PRECONDITION_SETS:
				return preconditionSets != null && !preconditionSets.isEmpty();
			case ActionsPackage.ACTION__APPLICABILITY_CONDITIONS:
				return applicabilityConditions != null && !applicabilityConditions.isEmpty();
			case ActionsPackage.ACTION__EFFECTS:
				return effects != null && !effects.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ParameterisedElement.class) {
			switch (derivedFeatureID) {
				case ActionsPackage.ACTION__PARAMETERS: return ActionsPackage.PARAMETERISED_ELEMENT__PARAMETERS;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ParameterisedElement.class) {
			switch (baseFeatureID) {
				case ActionsPackage.PARAMETERISED_ELEMENT__PARAMETERS: return ActionsPackage.ACTION__PARAMETERS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (applicabilityConditions: ");
		result.append(applicabilityConditions);
		result.append(')');
		return result.toString();
	}

} //ActionImpl
