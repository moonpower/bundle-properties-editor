/**
 */
package net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl;

import java.util.Collection;

import net.moon.util.bundlePropertiesEditor.model.propertieseditor.DefaultProperty;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.Merge;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.PropertieseditorPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Merge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.MergeImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.MergeImpl#getMergedProperty <em>Merged Property</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MergeImpl extends EObjectImpl implements Merge {
	/**
	 * The cached value of the '{@link #getProperty() <em>Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperty()
	 * @generated
	 * @ordered
	 */
	protected DefaultProperty property;

	/**
	 * The cached value of the '{@link #getMergedProperty() <em>Merged Property</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMergedProperty()
	 * @generated
	 * @ordered
	 */
	protected EList<DefaultProperty> mergedProperty;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MergeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PropertieseditorPackage.Literals.MERGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultProperty getProperty() {
		if (property != null && property.eIsProxy()) {
			InternalEObject oldProperty = (InternalEObject)property;
			property = (DefaultProperty)eResolveProxy(oldProperty);
			if (property != oldProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PropertieseditorPackage.MERGE__PROPERTY, oldProperty, property));
			}
		}
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultProperty basicGetProperty() {
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProperty(DefaultProperty newProperty) {
		DefaultProperty oldProperty = property;
		property = newProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PropertieseditorPackage.MERGE__PROPERTY, oldProperty, property));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DefaultProperty> getMergedProperty() {
		if (mergedProperty == null) {
			mergedProperty = new EObjectResolvingEList<DefaultProperty>(DefaultProperty.class, this, PropertieseditorPackage.MERGE__MERGED_PROPERTY);
		}
		return mergedProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PropertieseditorPackage.MERGE__PROPERTY:
				if (resolve) return getProperty();
				return basicGetProperty();
			case PropertieseditorPackage.MERGE__MERGED_PROPERTY:
				return getMergedProperty();
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
			case PropertieseditorPackage.MERGE__PROPERTY:
				setProperty((DefaultProperty)newValue);
				return;
			case PropertieseditorPackage.MERGE__MERGED_PROPERTY:
				getMergedProperty().clear();
				getMergedProperty().addAll((Collection<? extends DefaultProperty>)newValue);
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
			case PropertieseditorPackage.MERGE__PROPERTY:
				setProperty((DefaultProperty)null);
				return;
			case PropertieseditorPackage.MERGE__MERGED_PROPERTY:
				getMergedProperty().clear();
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
			case PropertieseditorPackage.MERGE__PROPERTY:
				return property != null;
			case PropertieseditorPackage.MERGE__MERGED_PROPERTY:
				return mergedProperty != null && !mergedProperty.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MergeImpl
