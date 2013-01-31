package net.moon.util.bundlePropertiesEditor.actions;

import net.moon.util.bundlePropertiesEditor.dialogs.AddElementDialog;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.PropertiesEditor;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.widgets.Display;

public class AddAction extends Action {
	private PropertiesEditor propertiesEditor;

	public AddAction(PropertiesEditor propertiesEditor) {
		this.propertiesEditor = propertiesEditor;
		setText("Ãß°¡");
	}

	@Override
	public void run() {
		AddElementDialog dialog = new AddElementDialog(Display.getDefault()
				.getActiveShell(), this.propertiesEditor);
		if (dialog.open() == IDialogConstants.OK_ID) {

		}
		super.run();
	}
}
