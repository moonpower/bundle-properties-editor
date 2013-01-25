/**
 */
package net.moon.util.bundlePropertiesEditor.model.propertieseditor;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
	String eNS_URI = "https://github.com/moonpower/bundle-properties-editor.git";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "net.moon.util.bundlePropertiesEditor";

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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES__NAME = 0;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES__ANNOTATION = 1;

	/**
	 * The feature id for the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES__FILE = 2;

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
	 * The feature id for the '<em><b>Sub Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_EDITOR__SUB_PROPERTIES = 0;

	/**
	 * The feature id for the '<em><b>Default Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_EDITOR__DEFAULT_PROPERTIES = 1;

	/**
	 * The number of structural features of the '<em>Properties Editor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_EDITOR_FEATURE_COUNT = 2;


	/**
	 * The meta object id for the '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.DefaultPropertyImpl <em>Default Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.DefaultPropertyImpl
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.PropertieseditorPackageImpl#getDefaultProperty()
	 * @generated
	 */
	int DEFAULT_PROPERTY = 4;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_PROPERTY__KEY = PROPERTY__KEY;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_PROPERTY__VALUE = PROPERTY__VALUE;

	/**
	 * The feature id for the '<em><b>Old Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_PROPERTY__OLD_KEY = PROPERTY__OLD_KEY;

	/**
	 * The feature id for the '<em><b>Old Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_PROPERTY__OLD_VALUE = PROPERTY__OLD_VALUE;

	/**
	 * The feature id for the '<em><b>Sub Property</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_PROPERTY__SUB_PROPERTY = PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Default Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_PROPERTY_FEATURE_COUNT = PROPERTY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.DefaultPropertiesImpl <em>Default Properties</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.DefaultPropertiesImpl
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.PropertieseditorPackageImpl#getDefaultProperties()
	 * @generated
	 */
	int DEFAULT_PROPERTIES = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_PROPERTIES__NAME = PROPERTIES__NAME;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_PROPERTIES__ANNOTATION = PROPERTIES__ANNOTATION;

	/**
	 * The feature id for the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_PROPERTIES__FILE = PROPERTIES__FILE;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_PROPERTIES__LANGUAGE = PROPERTIES__LANGUAGE;

	/**
	 * The feature id for the '<em><b>Property</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_PROPERTIES__PROPERTY = PROPERTIES_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Merges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_PROPERTIES__MERGES = PROPERTIES_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Default Properties</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_PROPERTIES_FEATURE_COUNT = PROPERTIES_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.SubPropertiesImpl <em>Sub Properties</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.SubPropertiesImpl
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.PropertieseditorPackageImpl#getSubProperties()
	 * @generated
	 */
	int SUB_PROPERTIES = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROPERTIES__NAME = PROPERTIES__NAME;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROPERTIES__ANNOTATION = PROPERTIES__ANNOTATION;

	/**
	 * The feature id for the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROPERTIES__FILE = PROPERTIES__FILE;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROPERTIES__LANGUAGE = PROPERTIES__LANGUAGE;

	/**
	 * The feature id for the '<em><b>Property</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROPERTIES__PROPERTY = PROPERTIES_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sub Properties</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROPERTIES_FEATURE_COUNT = PROPERTIES_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.MergeImpl <em>Merge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.MergeImpl
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.PropertieseditorPackageImpl#getMerge()
	 * @generated
	 */
	int MERGE = 7;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGE__PROPERTY = 0;

	/**
	 * The feature id for the '<em><b>Merged Property</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGE__MERGED_PROPERTY = 1;

	/**
	 * The number of structural features of the '<em>Merge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '<em>EFile</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.core.resources.IFile
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.PropertieseditorPackageImpl#getEFile()
	 * @generated
	 */
	int EFILE = 8;


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
	 * Returns the meta object for the attribute '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.Properties#getFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File</em>'.
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.Properties#getFile()
	 * @see #getProperties()
	 * @generated
	 */
	EAttribute getProperties_File();

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
	 * Returns the meta object for the containment reference list '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.PropertiesEditor#getSubProperties <em>Sub Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Properties</em>'.
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.PropertiesEditor#getSubProperties()
	 * @see #getPropertiesEditor()
	 * @generated
	 */
	EReference getPropertiesEditor_SubProperties();

	/**
	 * Returns the meta object for the containment reference '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.PropertiesEditor#getDefaultProperties <em>Default Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Default Properties</em>'.
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.PropertiesEditor#getDefaultProperties()
	 * @see #getPropertiesEditor()
	 * @generated
	 */
	EReference getPropertiesEditor_DefaultProperties();

	/**
	 * Returns the meta object for class '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.DefaultProperty <em>Default Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Default Property</em>'.
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.DefaultProperty
	 * @generated
	 */
	EClass getDefaultProperty();

	/**
	 * Returns the meta object for the containment reference list '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.DefaultProperty#getSubProperty <em>Sub Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Property</em>'.
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.DefaultProperty#getSubProperty()
	 * @see #getDefaultProperty()
	 * @generated
	 */
	EReference getDefaultProperty_SubProperty();

	/**
	 * Returns the meta object for class '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.DefaultProperties <em>Default Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Default Properties</em>'.
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.DefaultProperties
	 * @generated
	 */
	EClass getDefaultProperties();

	/**
	 * Returns the meta object for the containment reference list '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.DefaultProperties#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Property</em>'.
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.DefaultProperties#getProperty()
	 * @see #getDefaultProperties()
	 * @generated
	 */
	EReference getDefaultProperties_Property();

	/**
	 * Returns the meta object for the containment reference list '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.DefaultProperties#getMerges <em>Merges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Merges</em>'.
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.DefaultProperties#getMerges()
	 * @see #getDefaultProperties()
	 * @generated
	 */
	EReference getDefaultProperties_Merges();

	/**
	 * Returns the meta object for class '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.SubProperties <em>Sub Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub Properties</em>'.
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.SubProperties
	 * @generated
	 */
	EClass getSubProperties();

	/**
	 * Returns the meta object for the containment reference list '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.SubProperties#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Property</em>'.
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.SubProperties#getProperty()
	 * @see #getSubProperties()
	 * @generated
	 */
	EReference getSubProperties_Property();

	/**
	 * Returns the meta object for class '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.Merge <em>Merge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Merge</em>'.
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.Merge
	 * @generated
	 */
	EClass getMerge();

	/**
	 * Returns the meta object for the reference '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.Merge#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Property</em>'.
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.Merge#getProperty()
	 * @see #getMerge()
	 * @generated
	 */
	EReference getMerge_Property();

	/**
	 * Returns the meta object for the reference list '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.Merge#getMergedProperty <em>Merged Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Merged Property</em>'.
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.Merge#getMergedProperty()
	 * @see #getMerge()
	 * @generated
	 */
	EReference getMerge_MergedProperty();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.core.resources.IFile <em>EFile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>EFile</em>'.
	 * @see org.eclipse.core.resources.IFile
	 * @model instanceClass="org.eclipse.core.resources.IFile"
	 * @generated
	 */
	EDataType getEFile();

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
		 * The meta object literal for the '<em><b>File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTIES__FILE = eINSTANCE.getProperties_File();

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
		 * The meta object literal for the '<em><b>Sub Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTIES_EDITOR__SUB_PROPERTIES = eINSTANCE.getPropertiesEditor_SubProperties();

		/**
		 * The meta object literal for the '<em><b>Default Properties</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTIES_EDITOR__DEFAULT_PROPERTIES = eINSTANCE.getPropertiesEditor_DefaultProperties();

		/**
		 * The meta object literal for the '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.DefaultPropertyImpl <em>Default Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.DefaultPropertyImpl
		 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.PropertieseditorPackageImpl#getDefaultProperty()
		 * @generated
		 */
		EClass DEFAULT_PROPERTY = eINSTANCE.getDefaultProperty();

		/**
		 * The meta object literal for the '<em><b>Sub Property</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEFAULT_PROPERTY__SUB_PROPERTY = eINSTANCE.getDefaultProperty_SubProperty();

		/**
		 * The meta object literal for the '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.DefaultPropertiesImpl <em>Default Properties</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.DefaultPropertiesImpl
		 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.PropertieseditorPackageImpl#getDefaultProperties()
		 * @generated
		 */
		EClass DEFAULT_PROPERTIES = eINSTANCE.getDefaultProperties();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEFAULT_PROPERTIES__PROPERTY = eINSTANCE.getDefaultProperties_Property();

		/**
		 * The meta object literal for the '<em><b>Merges</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEFAULT_PROPERTIES__MERGES = eINSTANCE.getDefaultProperties_Merges();

		/**
		 * The meta object literal for the '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.SubPropertiesImpl <em>Sub Properties</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.SubPropertiesImpl
		 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.PropertieseditorPackageImpl#getSubProperties()
		 * @generated
		 */
		EClass SUB_PROPERTIES = eINSTANCE.getSubProperties();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUB_PROPERTIES__PROPERTY = eINSTANCE.getSubProperties_Property();

		/**
		 * The meta object literal for the '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.MergeImpl <em>Merge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.MergeImpl
		 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.PropertieseditorPackageImpl#getMerge()
		 * @generated
		 */
		EClass MERGE = eINSTANCE.getMerge();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MERGE__PROPERTY = eINSTANCE.getMerge_Property();

		/**
		 * The meta object literal for the '<em><b>Merged Property</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MERGE__MERGED_PROPERTY = eINSTANCE.getMerge_MergedProperty();

		/**
		 * The meta object literal for the '<em>EFile</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.core.resources.IFile
		 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.PropertieseditorPackageImpl#getEFile()
		 * @generated
		 */
		EDataType EFILE = eINSTANCE.getEFile();

	}

} //PropertieseditorPackage
