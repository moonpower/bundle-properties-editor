/**
 */
package net.moon.util.bundlePropertiesEditor.model.propertieseditor;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Default Properties</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.DefaultProperties#getProperty <em>Property</em>}</li>
 *   <li>{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.DefaultProperties#getMerges <em>Merges</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.PropertieseditorPackage#getDefaultProperties()
 * @model
 * @generated
 */
public interface DefaultProperties extends Properties {
	/**
	 * Returns the value of the '<em><b>Property</b></em>' containment reference list.
	 * The list contents are of type {@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.DefaultProperty}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property</em>' containment reference list.
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.PropertieseditorPackage#getDefaultProperties_Property()
	 * @model containment="true"
	 * @generated
	 */
	EList<DefaultProperty> getProperty();

	/**
	 * Returns the value of the '<em><b>Merges</b></em>' containment reference list.
	 * The list contents are of type {@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.Merge}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Merges</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Merges</em>' containment reference list.
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.PropertieseditorPackage#getDefaultProperties_Merges()
	 * @model containment="true"
	 * @generated
	 */
	EList<Merge> getMerges();

} // DefaultProperties
