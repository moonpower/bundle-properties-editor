package net.moon.util.bundlePropertiesEditor.editor;

import net.moon.util.bundlePropertiesEditor.StringUtil;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.Properties;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.PropertiesEditor;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.Property;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.widgets.Composite;


public class KeyEditingSupport extends EditingSupport {

	private PropertiesEditor propertiesEditor;

	public KeyEditingSupport(ColumnViewer viewer,
			PropertiesEditor propertiesEditor) {
		super(viewer);
		this.propertiesEditor = propertiesEditor;
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
		if (key == null || key == "") {
			return "";
		}

		return StringUtil.getUnicodeToUnicodeText(key);
	}

	@Override
	protected void setValue(Object element, Object value) {
		Property property = (Property) element;
		String text = value.toString().trim();
		if (text.contains(" ")) {
			System.out.println("공백 있음 에러");
			return;
		}
		String result = StringUtil.getUnicodeTextToText(text);
		for (Properties each : propertiesEditor.getProperties()) {
			for (Property eachPro : each.getProperty()) {
				if (property.getOldKey().equals(eachPro.getOldKey())) {
					eachPro.setKey(result);
				}
			}
		}
		property.setKey(result);
		getViewer().refresh(element);
	}
}
