/**
 */
package net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl;

import java.util.Collection;

import net.moon.util.bundlePropertiesEditor.model.propertieseditor.DefaultProperties;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.Properties;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.PropertiesEditor;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.PropertieseditorPackage;

import net.moon.util.bundlePropertiesEditor.model.propertieseditor.SubProperties;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Properties Editor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.PropertiesEditorImpl#getSubProperties <em>Sub Properties</em>}</li>
 *   <li>{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.PropertiesEditorImpl#getDefaultProperties <em>Default Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PropertiesEditorImpl extends EObjectImpl implements PropertiesEditor {
	/**
	 * The cached value of the '{@link #getSubProperties() <em>Sub Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<SubProperties> subProperties;
	/**
	 * The cached value of the '{@link #getDefaultProperties() <em>Default Properties</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultProperties()
	 * @generated
	 * @ordered
	 */
	protected DefaultProperties defaultProperties;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertiesEditorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PropertieseditorPackage.Literals.PROPERTIES_EDITOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SubProperties> getSubProperties() {
		if (subProperties == null) {
			subProperties = new EObjectContainmentEList<SubProperties>(SubProperties.class, this, PropertieseditorPackage.PROPERTIES_EDITOR__SUB_PROPERTIES);
		}
		return subProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultProperties getDefaultProperties() {
		return defaultProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefaultProperties(DefaultProperties newDefaultProperties, NotificationChain msgs) {
		DefaultProperties oldDefaultProperties = defaultProperties;
		defaultProperties = newDefaultProperties;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PropertieseditorPackage.PROPERTIES_EDITOR__DEFAULT_PROPERTIES, oldDefaultProperties, newDefaultProperties);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultProperties(DefaultProperties newDefaultProperties) {
		if (newDefaultProperties != defaultProperties) {
			NotificationChain msgs = null;
			if (defaultProperties != null)
				msgs = ((InternalEObject)defaultProperties).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PropertieseditorPackage.PROPERTIES_EDITOR__DEFAULT_PROPERTIES, null, msgs);
			if (newDefaultProperties != null)
				msgs = ((InternalEObject)newDefaultProperties).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PropertieseditorPackage.PROPERTIES_EDITOR__DEFAULT_PROPERTIES, null, msgs);
			msgs = basicSetDefaultProperties(newDefaultProperties, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PropertieseditorPackage.PROPERTIES_EDITOR__DEFAULT_PROPERTIES, newDefaultProperties, newDefaultProperties));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PropertieseditorPackage.PROPERTIES_EDITOR__SUB_PROPERTIES:
				return ((InternalEList<?>)getSubProperties()).basicRemove(otherEnd, msgs);
			case PropertieseditorPackage.PROPERTIES_EDITOR__DEFAULT_PROPERTIES:
				return basicSetDefaultProperties(null, msgs);
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
			case PropertieseditorPackage.PROPERTIES_EDITOR__SUB_PROPERTIES:
				return getSubProperties();
			case PropertieseditorPackage.PROPERTIES_EDITOR__DEFAULT_PROPERTIES:
				return getDefaultProperties();
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
			case PropertieseditorPackage.PROPERTIES_EDITOR__SUB_PROPERTIES:
				getSubProperties().clear();
				getSubProperties().addAll((Collection<? extends SubProperties>)newValue);
				return;
			case PropertieseditorPackage.PROPERTIES_EDITOR__DEFAULT_PROPERTIES:
				setDefaultProperties((DefaultProperties)newValue);
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
			case PropertieseditorPackage.PROPERTIES_EDITOR__SUB_PROPERTIES:
				getSubProperties().clear();
				return;
			case PropertieseditorPackage.PROPERTIES_EDITOR__DEFAULT_PROPERTIES:
				setDefaultProperties((DefaultProperties)null);
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
			case PropertieseditorPackage.PROPERTIES_EDITOR__SUB_PROPERTIES:
				return subProperties != null && !subProperties.isEmpty();
			case PropertieseditorPackage.PROPERTIES_EDITOR__DEFAULT_PROPERTIES:
				return defaultProperties != null;
		}
		return super.eIsSet(featureID);
	}

} //PropertiesEditorImpl
