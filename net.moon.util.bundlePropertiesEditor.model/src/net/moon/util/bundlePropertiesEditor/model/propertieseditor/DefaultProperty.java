/**
 */
package net.moon.util.bundlePropertiesEditor.model.propertieseditor;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Default Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.DefaultProperty#getSubProperty <em>Sub Property</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.PropertieseditorPackage#getDefaultProperty()
 * @model
 * @generated
 */
public interface DefaultProperty extends Property {
	/**
	 * Returns the value of the '<em><b>Sub Property</b></em>' containment reference list.
	 * The list contents are of type {@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.Property}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Property</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Property</em>' containment reference list.
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.PropertieseditorPackage#getDefaultProperty_SubProperty()
	 * @model containment="true"
	 * @generated
	 */
	EList<Property> getSubProperty();

} // DefaultProperty
