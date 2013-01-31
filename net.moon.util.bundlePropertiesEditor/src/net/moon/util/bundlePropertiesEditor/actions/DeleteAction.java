package net.moon.util.bundlePropertiesEditor.actions;

import net.moon.util.bundlePropertiesEditor.model.propertieseditor.DefaultProperties;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.DefaultProperty;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ViewerCell;

public class DeleteAction extends Action {
	CheckboxTableViewer tableViewer;
	DefaultProperties properties;

	public DeleteAction(DefaultProperties properties,
			CheckboxTableViewer tableViewer) {
		setText("ªË¡¶");
		this.tableViewer = tableViewer;
		this.properties = properties;
	}

	@Override
	public void run() {
		IStructuredSelection selection = (IStructuredSelection) tableViewer
				.getSelection();
		ViewerCell focusCell = tableViewer.getColumnViewerEditor()
				.getFocusCell();

		int columnIndex = focusCell.getColumnIndex();
		System.out.println(columnIndex);
		if (columnIndex == 3) {
			DefaultProperty element = (DefaultProperty) focusCell.getElement();
			System.out.println(element);
		}
		DefaultProperty property = (DefaultProperty) selection
				.getFirstElement();
		super.run();
	}
}
