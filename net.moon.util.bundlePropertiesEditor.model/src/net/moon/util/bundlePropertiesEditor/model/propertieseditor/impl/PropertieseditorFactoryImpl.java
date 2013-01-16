/**
 */
package net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl;

import net.moon.util.bundlePropertiesEditor.model.propertieseditor.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PropertieseditorFactoryImpl extends EFactoryImpl implements PropertieseditorFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PropertieseditorFactory init() {
		try {
			PropertieseditorFactory thePropertieseditorFactory = (PropertieseditorFactory)EPackage.Registry.INSTANCE.getEFactory("com.bundle.util"); 
			if (thePropertieseditorFactory != null) {
				return thePropertieseditorFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PropertieseditorFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertieseditorFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case PropertieseditorPackage.PROPERTIES: return createProperties();
			case PropertieseditorPackage.PROPERTY: return createProperty();
			case PropertieseditorPackage.ANNOTATION: return createAnnotation();
			case PropertieseditorPackage.PROPERTIES_EDITOR: return createPropertiesEditor();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Properties createProperties() {
		PropertiesImpl properties = new PropertiesImpl();
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property createProperty() {
		PropertyImpl property = new PropertyImpl();
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Annotation createAnnotation() {
		AnnotationImpl annotation = new AnnotationImpl();
		return annotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertiesEditor createPropertiesEditor() {
		PropertiesEditorImpl propertiesEditor = new PropertiesEditorImpl();
		return propertiesEditor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertieseditorPackage getPropertieseditorPackage() {
		return (PropertieseditorPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PropertieseditorPackage getPackage() {
		return PropertieseditorPackage.eINSTANCE;
	}

} //PropertieseditorFactoryImpl
