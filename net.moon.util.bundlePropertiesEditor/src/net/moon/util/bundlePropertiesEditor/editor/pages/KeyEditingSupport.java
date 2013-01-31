package net.moon.util.bundlePropertiesEditor.editor.pages;

import net.moon.util.bundlePropertiesEditor.StringUtil;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.DefaultProperty;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.PropertiesEditor;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.Property;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.widgets.Composite;

public class KeyEditingSupport extends EditingSupport {

	public KeyEditingSupport(ColumnViewer viewer,
			PropertiesEditor propertiesEditor) {
		super(viewer);
	}

	@Override
	protected CellEditor getCellEditor(final Object element) {

		final TextCellEditor textCellEditor = new TextCellEditor(
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
		if (key == null || key == "") {
			return "";
		}

		return StringUtil.getUnicodeToUnicodeText(key);
	}

	@Override
	protected void setValue(Object element, Object value) {
		DefaultProperty property = (DefaultProperty) element;
		String text = value.toString().trim();
		if (text.contains(" ")) {
			System.out.println("���� ���� ����");
			return;
		}

		String result = StringUtil.getUnicodeTextToText(text);

		property.setKey(result);
		for (Property each : property.getSubProperty()) {
			each.setKey(result);
		}

		getViewer().refresh(element);
	}
}