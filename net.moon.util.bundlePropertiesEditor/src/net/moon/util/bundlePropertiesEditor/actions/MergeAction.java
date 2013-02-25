package net.moon.util.bundlePropertiesEditor.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.moon.util.bundlePropertiesEditor.StringUtil;
import net.moon.util.bundlePropertiesEditor.dialogs.MergeDialog;
import net.moon.util.bundlePropertiesEditor.editor.BundlePropertiesEditor;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.DefaultProperty;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.Merge;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.PropertiesEditor;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.Property;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.SubProperties;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.PropertieseditorFactoryImpl;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Display;

public class MergeAction extends Action {
	private PropertiesEditor propertiesEditor;
	private TableViewer tableViewer;
	private BundlePropertiesEditor editor;

	public MergeAction(PropertiesEditor propertiesEditor,
			TableViewer tableViewer, BundlePropertiesEditor editor) {
		this.propertiesEditor = propertiesEditor;
		this.tableViewer = tableViewer;
		this.editor = editor;
		setText("º´ÇÕ");
	}

	@Override
	public void run() {
		List<DefaultProperty> list = new ArrayList<DefaultProperty>();
		IStructuredSelection selection = (IStructuredSelection) tableViewer
				.getSelection();
		if (selection.size() <= 1) {
			return;
		}
		Iterator iterator = selection.iterator();
		while (iterator.hasNext()) {
			DefaultProperty next = (DefaultProperty) iterator.next();
			list.add(next);
		}

		MergeDialog dialog = new MergeDialog(Display.getDefault()
				.getActiveShell(), list);
		if (IDialogConstants.OK_ID == dialog.open()) {
			Merge merge = dialog.getMerge();
			checkMergedProperty(merge);
			propertiesEditor.getDefaultProperties().getMerges().add(merge);
			propertiesEditor.getDefaultProperties().getProperty()
					.add(merge.getProperty());

			for (DefaultProperty each : merge.getMergedProperty()) {
				propertiesEditor.getDefaultProperties().getProperty()
						.remove(each);
			}
			tableViewer.setInput(propertiesEditor.getDefaultProperties());

			fireEditorPropertyChange();
		}

	}

	private void checkMergedProperty(Merge merge) {
		if (merge.getProperty().getSubProperty().size() != 0
				&& merge.getProperty().getSubProperty() != null) {
			return;
		}
		System.out.println(StringUtil.getUnicodeTextToText(merge.getProperty()
				.getKey()));
		for (SubProperties each : propertiesEditor.getSubProperties()) {
			Property property = PropertieseditorFactoryImpl.eINSTANCE
					.createProperty();
			property.setKey(merge.getProperty().getKey());
			property.setOldKey(merge.getProperty().getOldKey());
			property.setValue(merge.getProperty().getValue());
			property.setOldValue(merge.getProperty().getOldValue());
			merge.getProperty().getSubProperty().add(property);

		}
		System.out.println(merge.getProperty().getSubProperty().size());

	}

	private void fireEditorPropertyChange() {
		propertiesEditor.setModified(true);
		editor.firePropertyChange(BundlePropertiesEditor.PROP_DIRTY);
	}
}
