/**
 */
package net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl;

import java.util.Collection;

import net.moon.util.bundlePropertiesEditor.model.propertieseditor.DefaultProperty;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.PropertieseditorPackage;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.Property;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Default Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.DefaultPropertyImpl#getSubProperty <em>Sub Property</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DefaultPropertyImpl extends PropertyImpl implements DefaultProperty {
	/**
	 * The cached value of the '{@link #getSubProperty() <em>Sub Property</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubProperty()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> subProperty;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DefaultPropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PropertieseditorPackage.Literals.DEFAULT_PROPERTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Property> getSubProperty() {
		if (subProperty == null) {
			subProperty = new EObjectContainmentEList<Property>(Property.class, this, PropertieseditorPackage.DEFAULT_PROPERTY__SUB_PROPERTY);
		}
		return subProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PropertieseditorPackage.DEFAULT_PROPERTY__SUB_PROPERTY:
				return ((InternalEList<?>)getSubProperty()).basicRemove(otherEnd, msgs);
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
			case PropertieseditorPackage.DEFAULT_PROPERTY__SUB_PROPERTY:
				return getSubProperty();
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
			case PropertieseditorPackage.DEFAULT_PROPERTY__SUB_PROPERTY:
				getSubProperty().clear();
				getSubProperty().addAll((Collection<? extends Property>)newValue);
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
			case PropertieseditorPackage.DEFAULT_PROPERTY__SUB_PROPERTY:
				getSubProperty().clear();
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
			case PropertieseditorPackage.DEFAULT_PROPERTY__SUB_PROPERTY:
				return subProperty != null && !subProperty.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DefaultPropertyImpl
