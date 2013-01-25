/**
 */
package net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl;

import java.util.Collection;

import net.moon.util.bundlePropertiesEditor.model.propertieseditor.DefaultProperties;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.DefaultProperty;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.Merge;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.PropertieseditorPackage;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.Property;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Default Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.DefaultPropertiesImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.DefaultPropertiesImpl#getMerges <em>Merges</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DefaultPropertiesImpl extends PropertiesImpl implements DefaultProperties {
	/**
	 * The cached value of the '{@link #getProperty() <em>Property</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperty()
	 * @generated
	 * @ordered
	 */
	protected EList<DefaultProperty> property;

	/**
	 * The cached value of the '{@link #getMerges() <em>Merges</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMerges()
	 * @generated
	 * @ordered
	 */
	protected EList<Merge> merges;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DefaultPropertiesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PropertieseditorPackage.Literals.DEFAULT_PROPERTIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DefaultProperty> getProperty() {
		if (property == null) {
			property = new EObjectContainmentEList<DefaultProperty>(DefaultProperty.class, this, PropertieseditorPackage.DEFAULT_PROPERTIES__PROPERTY);
		}
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Merge> getMerges() {
		if (merges == null) {
			merges = new EObjectContainmentEList<Merge>(Merge.class, this, PropertieseditorPackage.DEFAULT_PROPERTIES__MERGES);
		}
		return merges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PropertieseditorPackage.DEFAULT_PROPERTIES__PROPERTY:
				return ((InternalEList<?>)getProperty()).basicRemove(otherEnd, msgs);
			case PropertieseditorPackage.DEFAULT_PROPERTIES__MERGES:
				return ((InternalEList<?>)getMerges()).basicRemove(otherEnd, msgs);
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
			case PropertieseditorPackage.DEFAULT_PROPERTIES__PROPERTY:
				return getProperty();
			case PropertieseditorPackage.DEFAULT_PROPERTIES__MERGES:
				return getMerges();
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
			case PropertieseditorPackage.DEFAULT_PROPERTIES__PROPERTY:
				getProperty().clear();
				getProperty().addAll((Collection<? extends DefaultProperty>)newValue);
				return;
			case PropertieseditorPackage.DEFAULT_PROPERTIES__MERGES:
				getMerges().clear();
				getMerges().addAll((Collection<? extends Merge>)newValue);
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
			case PropertieseditorPackage.DEFAULT_PROPERTIES__PROPERTY:
				getProperty().clear();
				return;
			case PropertieseditorPackage.DEFAULT_PROPERTIES__MERGES:
				getMerges().clear();
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
			case PropertieseditorPackage.DEFAULT_PROPERTIES__PROPERTY:
				return property != null && !property.isEmpty();
			case PropertieseditorPackage.DEFAULT_PROPERTIES__MERGES:
				return merges != null && !merges.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DefaultPropertiesImpl
