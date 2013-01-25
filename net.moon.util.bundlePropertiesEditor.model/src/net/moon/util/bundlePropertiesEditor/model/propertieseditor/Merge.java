/**
 */
package net.moon.util.bundlePropertiesEditor.model.propertieseditor;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Merge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.Merge#getProperty <em>Property</em>}</li>
 *   <li>{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.Merge#getMergedProperty <em>Merged Property</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.PropertieseditorPackage#getMerge()
 * @model
 * @generated
 */
public interface Merge extends EObject {
	/**
	 * Returns the value of the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property</em>' reference.
	 * @see #setProperty(DefaultProperty)
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.PropertieseditorPackage#getMerge_Property()
	 * @model
	 * @generated
	 */
	DefaultProperty getProperty();

	/**
	 * Sets the value of the '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.Merge#getProperty <em>Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property</em>' reference.
	 * @see #getProperty()
	 * @generated
	 */
	void setProperty(DefaultProperty value);

	/**
	 * Returns the value of the '<em><b>Merged Property</b></em>' reference list.
	 * The list contents are of type {@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.DefaultProperty}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Merged Property</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Merged Property</em>' reference list.
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.PropertieseditorPackage#getMerge_MergedProperty()
	 * @model
	 * @generated
	 */
	EList<DefaultProperty> getMergedProperty();

} // Merge
