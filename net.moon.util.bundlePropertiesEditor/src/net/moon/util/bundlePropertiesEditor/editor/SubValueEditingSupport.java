package net.moon.util.bundlePropertiesEditor.editor;

import net.moon.util.bundlePropertiesEditor.StringUtil;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.DefaultProperty;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.Properties;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.PropertieseditorFactoryImpl;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.widgets.Composite;

public class SubValueEditingSupport extends EditingSupport {
	Properties properties;
	int index;

	public SubValueEditingSupport(ColumnViewer viewer, int index) {
		super(viewer);
		this.index = index;
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
		DefaultProperty property = (DefaultProperty) element;
		String value = null;
		if (property.getSubProperty().size() >= index) {

			value = property.getSubProperty().get(index).getValue();
		}
		return StringUtil.getUnicodeToUnicodeText(value);

	}

	@Override
	protected void setValue(Object element, Object value) {
		DefaultProperty property = (DefaultProperty) element;
		String textValue = value.toString().trim();
		if (!(property.getSubProperty().size() >= index)) {
			int size = property.getSubProperty().size();
			int result = index - size;
			for (int i = 0; i < result; i++) {
				property.getSubProperty().add(
						PropertieseditorFactoryImpl.eINSTANCE.createProperty());
			}
		}
		String result = StringUtil.getUnicodeTextToText(textValue);

		property.getSubProperty().get(index).setValue(result);
		getViewer().refresh(element);
	}
}
