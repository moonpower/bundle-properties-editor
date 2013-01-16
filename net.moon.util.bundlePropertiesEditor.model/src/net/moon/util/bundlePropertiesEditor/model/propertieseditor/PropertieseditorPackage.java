/**
 */
package net.moon.util.bundlePropertiesEditor.model.propertieseditor;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.PropertieseditorFactory
 * @model kind="package"
 * @generated
 */
public interface PropertieseditorPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "propertieseditor";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "com.bundle.util";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "com.bundle.util.model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PropertieseditorPackage eINSTANCE = net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.PropertieseditorPackageImpl.init();

	/**
	 * The meta object id for the '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.PropertiesImpl <em>Properties</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.PropertiesImpl
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.PropertieseditorPackageImpl#getProperties()
	 * @generated
	 */
	int PROPERTIES = 0;

	/**
	 * The feature id for the '<em><b>Property</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES__PROPERTY = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES__NAME = 1;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES__ANNOTATION = 2;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES__LANGUAGE = 3;

	/**
	 * The number of structural features of the '<em>Properties</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.PropertyImpl <em>Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.PropertyImpl
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.PropertieseditorPackageImpl#getProperty()
	 * @generated
	 */
	int PROPERTY = 1;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__VALUE = 1;

	/**
	 * The feature id for the '<em><b>Old Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__OLD_KEY = 2;

	/**
	 * The feature id for the '<em><b>Old Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__OLD_VALUE = 3;

	/**
	 * The number of structural features of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.AnnotationImpl <em>Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.AnnotationImpl
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.PropertieseditorPackageImpl#getAnnotation()
	 * @generated
	 */
	int ANNOTATION = 2;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__CONTENT = 0;

	/**
	 * The number of structural features of the '<em>Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.PropertiesEditorImpl <em>Properties Editor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.PropertiesEditorImpl
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.PropertieseditorPackageImpl#getPropertiesEditor()
	 * @generated
	 */
	int PROPERTIES_EDITOR = 3;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_EDITOR__PROPERTIES = 0;

	/**
	 * The number of structural features of the '<em>Properties Editor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_EDITOR_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.Properties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Properties</em>'.
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.Properties
	 * @generated
	 */
	EClass getProperties();

	/**
	 * Returns the meta object for the containment reference list '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.Properties#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Property</em>'.
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.Properties#getProperty()
	 * @see #getProperties()
	 * @generated
	 */
	EReference getProperties_Property();

	/**
	 * Returns the meta object for the attribute '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.Properties#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.Properties#getName()
	 * @see #getProperties()
	 * @generated
	 */
	EAttribute getProperties_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.Properties#getAnnotation <em>Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Annotation</em>'.
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.Properties#getAnnotation()
	 * @see #getProperties()
	 * @generated
	 */
	EReference getProperties_Annotation();

	/**
	 * Returns the meta object for the attribute '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.Properties#getLanguage <em>Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Language</em>'.
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.Properties#getLanguage()
	 * @see #getProperties()
	 * @generated
	 */
	EAttribute getProperties_Language();

	/**
	 * Returns the meta object for class '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property</em>'.
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.Property
	 * @generated
	 */
	EClass getProperty();

	/**
	 * Returns the meta object for the attribute '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.Property#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.Property#getKey()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Key();

	/**
	 * Returns the meta object for the attribute '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.Property#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.Property#getValue()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Value();

	/**
	 * Returns the meta object for the attribute '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.Property#getOldKey <em>Old Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Old Key</em>'.
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.Property#getOldKey()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_OldKey();

	/**
	 * Returns the meta object for the attribute '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.Property#getOldValue <em>Old Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Old Value</em>'.
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.Property#getOldValue()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_OldValue();

	/**
	 * Returns the meta object for class '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.Annotation <em>Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotation</em>'.
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.Annotation
	 * @generated
	 */
	EClass getAnnotation();

	/**
	 * Returns the meta object for the attribute '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.Annotation#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content</em>'.
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.Annotation#getContent()
	 * @see #getAnnotation()
	 * @generated
	 */
	EAttribute getAnnotation_Content();

	/**
	 * Returns the meta object for class '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.PropertiesEditor <em>Properties Editor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Properties Editor</em>'.
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.PropertiesEditor
	 * @generated
	 */
	EClass getPropertiesEditor();

	/**
	 * Returns the meta object for the reference list '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.PropertiesEditor#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Properties</em>'.
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.PropertiesEditor#getProperties()
	 * @see #getPropertiesEditor()
	 * @generated
	 */
	EReference getPropertiesEditor_Properties();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PropertieseditorFactory getPropertieseditorFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.PropertiesImpl <em>Properties</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.PropertiesImpl
		 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.PropertieseditorPackageImpl#getProperties()
		 * @generated
		 */
		EClass PROPERTIES = eINSTANCE.getProperties();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTIES__PROPERTY = eINSTANCE.getProperties_Property();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTIES__NAME = eINSTANCE.getProperties_Name();

		/**
		 * The meta object literal for the '<em><b>Annotation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTIES__ANNOTATION = eINSTANCE.getProperties_Annotation();

		/**
		 * The meta object literal for the '<em><b>Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTIES__LANGUAGE = eINSTANCE.getProperties_Language();

		/**
		 * The meta object literal for the '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.PropertyImpl <em>Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.PropertyImpl
		 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.PropertieseditorPackageImpl#getProperty()
		 * @generated
		 */
		EClass PROPERTY = eINSTANCE.getProperty();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__KEY = eINSTANCE.getProperty_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__VALUE = eINSTANCE.getProperty_Value();

		/**
		 * The meta object literal for the '<em><b>Old Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__OLD_KEY = eINSTANCE.getProperty_OldKey();

		/**
		 * The meta object literal for the '<em><b>Old Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__OLD_VALUE = eINSTANCE.getProperty_OldValue();

		/**
		 * The meta object literal for the '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.AnnotationImpl <em>Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.AnnotationImpl
		 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.PropertieseditorPackageImpl#getAnnotation()
		 * @generated
		 */
		EClass ANNOTATION = eINSTANCE.getAnnotation();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANNOTATION__CONTENT = eINSTANCE.getAnnotation_Content();

		/**
		 * The meta object literal for the '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.PropertiesEditorImpl <em>Properties Editor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.PropertiesEditorImpl
		 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.PropertieseditorPackageImpl#getPropertiesEditor()
		 * @generated
		 */
		EClass PROPERTIES_EDITOR = eINSTANCE.getPropertiesEditor();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTIES_EDITOR__PROPERTIES = eINSTANCE.getPropertiesEditor_Properties();

	}

} //PropertieseditorPackage
