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
import overview.Output;
import overview.OverviewPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Output</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link overview.impl.OutputImpl#getChaptero <em>Chaptero</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OutputImpl extends NamedElementImpl implements Output {
	/**
	 * The cached value of the '{@link #getChaptero() <em>Chaptero</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChaptero()
	 * @generated
	 * @ordered
	 */
	protected Chapter chaptero;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OutputImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OverviewPackage.Literals.OUTPUT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Chapter getChaptero() {
		if (chaptero != null && chaptero.eIsProxy()) {
			InternalEObject oldChaptero = (InternalEObject)chaptero;
			chaptero = (Chapter)eResolveProxy(oldChaptero);
			if (chaptero != oldChaptero) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OverviewPackage.OUTPUT__CHAPTERO, oldChaptero, chaptero));
			}
		}
		return chaptero;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Chapter basicGetChaptero() {
		return chaptero;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChaptero(Chapter newChaptero) {
		Chapter oldChaptero = chaptero;
		chaptero = newChaptero;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OverviewPackage.OUTPUT__CHAPTERO, oldChaptero, chaptero));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OverviewPackage.OUTPUT__CHAPTERO:
				if (resolve) return getChaptero();
				return basicGetChaptero();
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
			case OverviewPackage.OUTPUT__CHAPTERO:
				setChaptero((Chapter)newValue);
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
			case OverviewPackage.OUTPUT__CHAPTERO:
				setChaptero((Chapter)null);
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
			case OverviewPackage.OUTPUT__CHAPTERO:
				return chaptero != null;
		}
		return super.eIsSet(featureID);
	}

} //OutputImpl
