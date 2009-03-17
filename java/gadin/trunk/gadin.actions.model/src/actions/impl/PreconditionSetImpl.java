/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package actions.impl;

import actions.Action;
import actions.ActionsPackage;
import actions.PreconditionSet;
import actions.Proposition;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Precondition Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link actions.impl.PreconditionSetImpl#getAction <em>Action</em>}</li>
 *   <li>{@link actions.impl.PreconditionSetImpl#getPreconditions <em>Preconditions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PreconditionSetImpl extends EObjectImpl implements PreconditionSet {
	/**
	 * The cached value of the '{@link #getPreconditions() <em>Preconditions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreconditions()
	 * @generated
	 * @ordered
	 */
	protected EList<Proposition> preconditions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PreconditionSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActionsPackage.Literals.PRECONDITION_SET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action getAction() {
		if (eContainerFeatureID != ActionsPackage.PRECONDITION_SET__ACTION) return null;
		return (Action)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAction(Action newAction, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newAction, ActionsPackage.PRECONDITION_SET__ACTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAction(Action newAction) {
		if (newAction != eInternalContainer() || (eContainerFeatureID != ActionsPackage.PRECONDITION_SET__ACTION && newAction != null)) {
			if (EcoreUtil.isAncestor(this, newAction))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newAction != null)
				msgs = ((InternalEObject)newAction).eInverseAdd(this, ActionsPackage.ACTION__PRECONDITION_SETS, Action.class, msgs);
			msgs = basicSetAction(newAction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionsPackage.PRECONDITION_SET__ACTION, newAction, newAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Proposition> getPreconditions() {
		if (preconditions == null) {
			preconditions = new EObjectContainmentEList<Proposition>(Proposition.class, this, ActionsPackage.PRECONDITION_SET__PRECONDITIONS);
		}
		return preconditions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ActionsPackage.PRECONDITION_SET__ACTION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetAction((Action)otherEnd, msgs);
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
			case ActionsPackage.PRECONDITION_SET__ACTION:
				return basicSetAction(null, msgs);
			case ActionsPackage.PRECONDITION_SET__PRECONDITIONS:
				return ((InternalEList<?>)getPreconditions()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case ActionsPackage.PRECONDITION_SET__ACTION:
				return eInternalContainer().eInverseRemove(this, ActionsPackage.ACTION__PRECONDITION_SETS, Action.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ActionsPackage.PRECONDITION_SET__ACTION:
				return getAction();
			case ActionsPackage.PRECONDITION_SET__PRECONDITIONS:
				return getPreconditions();
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
			case ActionsPackage.PRECONDITION_SET__ACTION:
				setAction((Action)newValue);
				return;
			case ActionsPackage.PRECONDITION_SET__PRECONDITIONS:
				getPreconditions().clear();
				getPreconditions().addAll((Collection<? extends Proposition>)newValue);
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
			case ActionsPackage.PRECONDITION_SET__ACTION:
				setAction((Action)null);
				return;
			case ActionsPackage.PRECONDITION_SET__PRECONDITIONS:
				getPreconditions().clear();
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
			case ActionsPackage.PRECONDITION_SET__ACTION:
				return getAction() != null;
			case ActionsPackage.PRECONDITION_SET__PRECONDITIONS:
				return preconditions != null && !preconditions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PreconditionSetImpl
