/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package actions.impl;

import actions.ActionsPackage;
import actions.PropositionType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Proposition Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link actions.impl.PropositionTypeImpl#isReflexive <em>Reflexive</em>}</li>
 *   <li>{@link actions.impl.PropositionTypeImpl#isExclusive <em>Exclusive</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PropositionTypeImpl extends NamedElementImpl implements PropositionType {
	/**
	 * The default value of the '{@link #isReflexive() <em>Reflexive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReflexive()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REFLEXIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isReflexive() <em>Reflexive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReflexive()
	 * @generated
	 * @ordered
	 */
	protected boolean reflexive = REFLEXIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #isExclusive() <em>Exclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExclusive()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXCLUSIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExclusive() <em>Exclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExclusive()
	 * @generated
	 * @ordered
	 */
	protected boolean exclusive = EXCLUSIVE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropositionTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActionsPackage.Literals.PROPOSITION_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReflexive() {
		return reflexive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReflexive(boolean newReflexive) {
		boolean oldReflexive = reflexive;
		reflexive = newReflexive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionsPackage.PROPOSITION_TYPE__REFLEXIVE, oldReflexive, reflexive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExclusive() {
		return exclusive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExclusive(boolean newExclusive) {
		boolean oldExclusive = exclusive;
		exclusive = newExclusive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionsPackage.PROPOSITION_TYPE__EXCLUSIVE, oldExclusive, exclusive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ActionsPackage.PROPOSITION_TYPE__REFLEXIVE:
				return isReflexive() ? Boolean.TRUE : Boolean.FALSE;
			case ActionsPackage.PROPOSITION_TYPE__EXCLUSIVE:
				return isExclusive() ? Boolean.TRUE : Boolean.FALSE;
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ActionsPackage.PROPOSITION_TYPE__REFLEXIVE:
				setReflexive(((Boolean)newValue).booleanValue());
				return;
			case ActionsPackage.PROPOSITION_TYPE__EXCLUSIVE:
				setExclusive(((Boolean)newValue).booleanValue());
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
			case ActionsPackage.PROPOSITION_TYPE__REFLEXIVE:
				setReflexive(REFLEXIVE_EDEFAULT);
				return;
			case ActionsPackage.PROPOSITION_TYPE__EXCLUSIVE:
				setExclusive(EXCLUSIVE_EDEFAULT);
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
			case ActionsPackage.PROPOSITION_TYPE__REFLEXIVE:
				return reflexive != REFLEXIVE_EDEFAULT;
			case ActionsPackage.PROPOSITION_TYPE__EXCLUSIVE:
				return exclusive != EXCLUSIVE_EDEFAULT;
		}
		return super.eIsSet(featureID);
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
		result.append(" (reflexive: ");
		result.append(reflexive);
		result.append(", exclusive: ");
		result.append(exclusive);
		result.append(')');
		return result.toString();
	}

} //PropositionTypeImpl
