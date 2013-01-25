/**
 */
package net.moon.util.bundlePropertiesEditor.model.propertieseditor;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Properties Editor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.PropertiesEditor#getSubProperties <em>Sub Properties</em>}</li>
 *   <li>{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.PropertiesEditor#getDefaultProperties <em>Default Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.PropertieseditorPackage#getPropertiesEditor()
 * @model
 * @generated
 */
public interface PropertiesEditor extends EObject {
	/**
	 * Returns the value of the '<em><b>Sub Properties</b></em>' containment reference list.
	 * The list contents are of type {@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.SubProperties}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Properties</em>' containment reference list.
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.PropertieseditorPackage#getPropertiesEditor_SubProperties()
	 * @model containment="true"
	 * @generated
	 */
	EList<SubProperties> getSubProperties();

	/**
	 * Returns the value of the '<em><b>Default Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Properties</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Properties</em>' containment reference.
	 * @see #setDefaultProperties(DefaultProperties)
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.PropertieseditorPackage#getPropertiesEditor_DefaultProperties()
	 * @model containment="true"
	 * @generated
	 */
	DefaultProperties getDefaultProperties();

	/**
	 * Sets the value of the '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.PropertiesEditor#getDefaultProperties <em>Default Properties</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Properties</em>' containment reference.
	 * @see #getDefaultProperties()
	 * @generated
	 */
	void setDefaultProperties(DefaultProperties value);

} // PropertiesEditor
