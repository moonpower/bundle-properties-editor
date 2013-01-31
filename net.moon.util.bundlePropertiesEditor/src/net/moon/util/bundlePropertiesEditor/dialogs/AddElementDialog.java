package net.moon.util.bundlePropertiesEditor.dialogs;

import net.moon.util.bundlePropertiesEditor.model.propertieseditor.DefaultProperties;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.DefaultProperty;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.PropertiesEditor;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.PropertieseditorFactoryImpl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class AddElementDialog extends Dialog {

	private Text keyText;
	private Text valueText;
	private PropertiesEditor propertiesEditor;

	public AddElementDialog(Shell parentShell, PropertiesEditor propertiesEditor) {
		super(parentShell);
		this.propertiesEditor = propertiesEditor;
		setShellStyle(SWT.SHELL_TRIM | SWT.APPLICATION_MODAL);
	}

	@Override
	protected void configureShell(Shell newShell) {
		newShell.setText("Add Element");
		super.configureShell(newShell);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(4, false));
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		Label label = new Label(container, SWT.NORMAL);
		label.setText("Key : ");
		keyText = new Text(container, SWT.BORDER);
		keyText.setLayoutData(new GridData(GridData.FILL_BOTH));
		label = new Label(container, SWT.NORMAL);
		label.setText("Value : ");
		valueText = new Text(container, SWT.BORDER);
		valueText.setLayoutData(new GridData(GridData.FILL_BOTH));
		return container;
	}

	@Override
	protected void okPressed() {
		String key = keyText.getText();
		String value = valueText.getText();
		DefaultProperty property = PropertieseditorFactoryImpl.eINSTANCE
				.createDefaultProperty();
		property.setKey(key);
		property.setOldKey(key);
		property.setValue(value);
		property.setOldValue(value);
		property.eAdapters().add(new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				if (msg.isTouch()) {
					propertiesEditor.setModified(true);

				}
			}

		});
		DefaultProperties properties = this.propertiesEditor
				.getDefaultProperties();
		properties.getProperty().add(property);

		super.okPressed();
	}
}
