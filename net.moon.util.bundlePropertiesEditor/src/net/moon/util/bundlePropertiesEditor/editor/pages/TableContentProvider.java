package net.moon.util.bundlePropertiesEditor.editor.pages;

import net.moon.util.bundlePropertiesEditor.model.propertieseditor.DefaultProperties;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class TableContentProvider implements IStructuredContentProvider {

	@Override
	public void dispose() {

	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

	}

	@Override
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof DefaultProperties) {
			DefaultProperties properties = (DefaultProperties) inputElement;
			return properties.getProperty().toArray();
		}
		return null;
	}
}
