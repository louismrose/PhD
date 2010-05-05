/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package overview.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import overview.Chapter;
import overview.Input;
import overview.Output;
import overview.Overview;
import overview.OverviewPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Overview</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link overview.impl.OverviewImpl#getChapterrs <em>Chapterrs</em>}</li>
 *   <li>{@link overview.impl.OverviewImpl#getInputs <em>Inputs</em>}</li>
 *   <li>{@link overview.impl.OverviewImpl#getOutputs <em>Outputs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OverviewImpl extends EObjectImpl implements Overview {
	/**
	 * The cached value of the '{@link #getChapterrs() <em>Chapterrs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChapterrs()
	 * @generated
	 * @ordered
	 */
	protected EList<Chapter> chapterrs;

	/**
	 * The cached value of the '{@link #getInputs() <em>Inputs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputs()
	 * @generated
	 * @ordered
	 */
	protected EList<Input> inputs;

	/**
	 * The cached value of the '{@link #getOutputs() <em>Outputs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputs()
	 * @generated
	 * @ordered
	 */
	protected EList<Output> outputs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OverviewImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OverviewPackage.Literals.OVERVIEW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Chapter> getChapterrs() {
		if (chapterrs == null) {
			chapterrs = new EObjectContainmentEList<Chapter>(Chapter.class, this, OverviewPackage.OVERVIEW__CHAPTERRS);
		}
		return chapterrs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Input> getInputs() {
		if (inputs == null) {
			inputs = new EObjectContainmentEList<Input>(Input.class, this, OverviewPackage.OVERVIEW__INPUTS);
		}
		return inputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Output> getOutputs() {
		if (outputs == null) {
			outputs = new EObjectContainmentEList<Output>(Output.class, this, OverviewPackage.OVERVIEW__OUTPUTS);
		}
		return outputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OverviewPackage.OVERVIEW__CHAPTERRS:
				return ((InternalEList<?>)getChapterrs()).basicRemove(otherEnd, msgs);
			case OverviewPackage.OVERVIEW__INPUTS:
				return ((InternalEList<?>)getInputs()).basicRemove(otherEnd, msgs);
			case OverviewPackage.OVERVIEW__OUTPUTS:
				return ((InternalEList<?>)getOutputs()).basicRemove(otherEnd, msgs);
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
			case OverviewPackage.OVERVIEW__CHAPTERRS:
				return getChapterrs();
			case OverviewPackage.OVERVIEW__INPUTS:
				return getInputs();
			case OverviewPackage.OVERVIEW__OUTPUTS:
				return getOutputs();
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
			case OverviewPackage.OVERVIEW__CHAPTERRS:
				getChapterrs().clear();
				getChapterrs().addAll((Collection<? extends Chapter>)newValue);
				return;
			case OverviewPackage.OVERVIEW__INPUTS:
				getInputs().clear();
				getInputs().addAll((Collection<? extends Input>)newValue);
				return;
			case OverviewPackage.OVERVIEW__OUTPUTS:
				getOutputs().clear();
				getOutputs().addAll((Collection<? extends Output>)newValue);
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
			case OverviewPackage.OVERVIEW__CHAPTERRS:
				getChapterrs().clear();
				return;
			case OverviewPackage.OVERVIEW__INPUTS:
				getInputs().clear();
				return;
			case OverviewPackage.OVERVIEW__OUTPUTS:
				getOutputs().clear();
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
			case OverviewPackage.OVERVIEW__CHAPTERRS:
				return chapterrs != null && !chapterrs.isEmpty();
			case OverviewPackage.OVERVIEW__INPUTS:
				return inputs != null && !inputs.isEmpty();
			case OverviewPackage.OVERVIEW__OUTPUTS:
				return outputs != null && !outputs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //OverviewImpl
