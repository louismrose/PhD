/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package overview.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import overview.Chapter;
import overview.Input;
import overview.OverviewPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Input</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link overview.impl.InputImpl#getChapteri <em>Chapteri</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InputImpl extends NamedElementImpl implements Input {
	/**
	 * The cached value of the '{@link #getChapteri() <em>Chapteri</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChapteri()
	 * @generated
	 * @ordered
	 */
	protected Chapter chapteri;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InputImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OverviewPackage.Literals.INPUT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Chapter getChapteri() {
		if (chapteri != null && chapteri.eIsProxy()) {
			InternalEObject oldChapteri = (InternalEObject)chapteri;
			chapteri = (Chapter)eResolveProxy(oldChapteri);
			if (chapteri != oldChapteri) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OverviewPackage.INPUT__CHAPTERI, oldChapteri, chapteri));
			}
		}
		return chapteri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Chapter basicGetChapteri() {
		return chapteri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChapteri(Chapter newChapteri) {
		Chapter oldChapteri = chapteri;
		chapteri = newChapteri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OverviewPackage.INPUT__CHAPTERI, oldChapteri, chapteri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OverviewPackage.INPUT__CHAPTERI:
				if (resolve) return getChapteri();
				return basicGetChapteri();
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
			case OverviewPackage.INPUT__CHAPTERI:
				setChapteri((Chapter)newValue);
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
			case OverviewPackage.INPUT__CHAPTERI:
				setChapteri((Chapter)null);
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
			case OverviewPackage.INPUT__CHAPTERI:
				return chapteri != null;
		}
		return super.eIsSet(featureID);
	}

} //InputImpl
