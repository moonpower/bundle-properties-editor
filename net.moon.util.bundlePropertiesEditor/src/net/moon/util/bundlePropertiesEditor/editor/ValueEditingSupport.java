package net.moon.util.bundlePropertiesEditor.editor;

import net.moon.util.bundlePropertiesEditor.StringUtil;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.Properties;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.Property;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.PropertieseditorFactoryImpl;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.widgets.Composite;


public class ValueEditingSupport extends EditingSupport {
	int index;
	Properties properties;

	public ValueEditingSupport(ColumnViewer viewer, Properties properties,
			int index) {
		super(viewer);
		this.index = index;
		this.properties = properties;
	}

	@Override
	protected CellEditor getCellEditor(Object element) {

		TextCellEditor textCellEditor = new TextCellEditor(
				(Composite) getViewer().getControl());
		return textCellEditor;
	}

	@Override
	protected boolean canEdit(Object element) {

		return true;
	}

	@Override
	protected Object getValue(Object element) {
		String key = ((Property) element).getKey();
		if (key == null) {
			return "";
		}
		for (Property each : properties.getProperty()) {
			if (key.equals(each.getKey())) {
				return StringUtil.getUnicodeToUnicodeText(each.getValue());
			}
		}
		return "";

	}

	@Override
	protected void setValue(Object element, Object value) {
		Property property = (Property) element;
		String key = property.getKey();
		String result = StringUtil
				.getUnicodeTextToText(value.toString().trim());
		int count = 0;
		for (Property each : properties.getProperty()) {
			if (key.equals(each.getKey())) {
				each.setValue(result);
				count++;
				break;
			}
		}

		if (count == 0) {
			Property newProperty = PropertieseditorFactoryImpl.eINSTANCE
					.createProperty();
			newProperty.setKey(property.getKey());
			newProperty.setOldKey(property.getOldKey());
			newProperty.setOldValue(property.getOldValue());
			newProperty.setValue(result);
			properties.getProperty().add(newProperty);
		}
		getViewer().refresh(element);
	}
}
