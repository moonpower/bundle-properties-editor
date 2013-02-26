package net.moon.util.bundlePropertiesEditor.editor.pages;

import net.moon.util.bundlePropertiesEditor.StringUtil;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.DefaultProperty;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.Properties;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.widgets.Composite;

public class ValueEditingSupport extends EditingSupport {
	Properties properties;

	public ValueEditingSupport(ColumnViewer viewer) {
		super(viewer);
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

		String value = property.getValue();
		String unicodeTextToText = StringUtil.getUnicodeToUnicodeText(value);
		return unicodeTextToText;

	}

	@Override
	protected void setValue(Object element, Object value) {
		DefaultProperty property = (DefaultProperty) element;
		String textValue = value.toString();
		String result = StringUtil.getUnicodeTextToText(textValue);
		property.setValue(result);

		getViewer().refresh(element);
	}
}
