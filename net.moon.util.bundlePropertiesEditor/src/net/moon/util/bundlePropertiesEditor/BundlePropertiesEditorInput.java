package net.moon.util.bundlePropertiesEditor;

import net.moon.util.bundlePropertiesEditor.model.propertieseditor.PropertiesEditor;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;


public class BundlePropertiesEditorInput implements IEditorInput {
	private PropertiesEditor properties;
	private IFile file;

	public BundlePropertiesEditorInput(PropertiesEditor properties, IFile file) {
		this.properties = properties;
		this.file = file;
	}

	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		return null;
	}

	@Override
	public boolean exists() {
		return false;
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return null;
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public IPersistableElement getPersistable() {
		return null;
	}

	@Override
	public String getToolTipText() {
		return null;
	}

	public PropertiesEditor getProperties() {
		return properties;
	}

	public IFile getFile() {
		return file;
	}

}
