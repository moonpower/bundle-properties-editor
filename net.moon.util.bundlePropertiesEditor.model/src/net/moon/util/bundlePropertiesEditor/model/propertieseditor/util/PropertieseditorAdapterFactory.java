/**
 */
package net.moon.util.bundlePropertiesEditor.model.propertieseditor.util;

import net.moon.util.bundlePropertiesEditor.model.propertieseditor.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.PropertieseditorPackage
 * @generated
 */
public class PropertieseditorAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PropertieseditorPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertieseditorAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = PropertieseditorPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertieseditorSwitch<Adapter> modelSwitch =
		new PropertieseditorSwitch<Adapter>() {
			@Override
			public Adapter caseProperties(Properties object) {
				return createPropertiesAdapter();
			}
			@Override
			public Adapter caseProperty(Property object) {
				return createPropertyAdapter();
			}
			@Override
			public Adapter caseAnnotation(Annotation object) {
				return createAnnotationAdapter();
			}
			@Override
			public Adapter casePropertiesEditor(PropertiesEditor object) {
				return createPropertiesEditorAdapter();
			}
			@Override
			public Adapter caseDefaultProperty(DefaultProperty object) {
				return createDefaultPropertyAdapter();
			}
			@Override
			public Adapter caseDefaultProperties(DefaultProperties object) {
				return createDefaultPropertiesAdapter();
			}
			@Override
			public Adapter caseSubProperties(SubProperties object) {
				return createSubPropertiesAdapter();
			}
			@Override
			public Adapter caseMerge(Merge object) {
				return createMergeAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.Properties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.Properties
	 * @generated
	 */
	public Adapter createPropertiesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.Property
	 * @generated
	 */
	public Adapter createPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.Annotation <em>Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.Annotation
	 * @generated
	 */
	public Adapter createAnnotationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.PropertiesEditor <em>Properties Editor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.PropertiesEditor
	 * @generated
	 */
	public Adapter createPropertiesEditorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.DefaultProperty <em>Default Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.DefaultProperty
	 * @generated
	 */
	public Adapter createDefaultPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.DefaultProperties <em>Default Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.DefaultProperties
	 * @generated
	 */
	public Adapter createDefaultPropertiesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.SubProperties <em>Sub Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.SubProperties
	 * @generated
	 */
	public Adapter createSubPropertiesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.moon.util.bundlePropertiesEditor.model.propertieseditor.Merge <em>Merge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.moon.util.bundlePropertiesEditor.model.propertieseditor.Merge
	 * @generated
	 */
	public Adapter createMergeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //PropertieseditorAdapterFactory
