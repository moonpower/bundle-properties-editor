package net.moon.util.bundlePropertiesEditor.editor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import net.moon.util.bundlePropertiesEditor.DebugStream;
import net.moon.util.bundlePropertiesEditor.editor.pages.PropertiesPage;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.Properties;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.PropertiesEditor;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.internal.ui.propertiesfileeditor.PropertiesFileEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.MultiPageEditorPart;

public class BundlePropertiesEditor extends MultiPageEditorPart {
	public static final String id = "com.moon.util.editor";

	private PropertiesPage propertiesPage;
	private PropertiesEditor propertiesEditor;
	private Map<String, PropertiesFileEditor> propertiesMap = new HashMap<String, PropertiesFileEditor>();

	public BundlePropertiesEditor() {

	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		if (getEditorInput() == null) {
			return;
		}
		propertiesPage.setSaving(true);
		if (getActivePage() == 0 && propertiesEditor.isModified()) {

			ReplacePluginFile.saveFiles(propertiesEditor);
			propertiesEditor.setModified(false);
			propertiesPage.refreshCheckboxTableViewer();

		}
		Set<Entry<String, PropertiesFileEditor>> entrySet = propertiesMap
				.entrySet();
		Iterator<Entry<String, PropertiesFileEditor>> iterator = entrySet
				.iterator();
		while (iterator.hasNext()) {
			Entry<String, PropertiesFileEditor> next = iterator.next();
			PropertiesFileEditor propertiesFileEditor2 = propertiesMap.get(next
					.getKey());
			if (propertiesFileEditor2.isDirty()) {
				propertiesFileEditor2.doSave(monitor);
			}
		}

		propertiesPage.setSaving(false);
		firePropertyChange(IEditorPart.PROP_DIRTY);

	}

	@Override
	protected void pageChange(int newPageIndex) {
		// switch (newPageIndex) {
		// case 0:
		// if (isDirty()) {
		// // updateTableFromTextEditor();
		// }
		// break;
		// case 1:
		// if (propertiesPage.isPageModified()) {
		// // updateTextEditorFromTable();
		// }
		// break;
		//
		// }
		// propertiesPage.setPageModified(false);

		super.pageChange(newPageIndex);
	}

	@Override
	public void doSaveAs() {
		if (getEditorInput() == null) {
			return;
		}

		if (getActivePage() == 0 && propertiesEditor.isModified()) {
			propertiesEditor.setModified(false);

		}
		if (isDirty()) {
			firePropertyChange(IEditorPart.PROP_DIRTY);
		}

	}

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		DebugStream.activate();
		if (!(input instanceof FileEditorInput)) {
			setInput(input);
			setSite(site);
			return;
		}

		setInput(input);
		setSite(site);

	}

	@Override
	public boolean isDirty() {
		return propertiesEditor.isModified();
	}

	@Override
	public boolean isSaveAsAllowed() {
		return true;
	}

	@Override
	protected void handlePropertyChange(int propertyId) {
		if (propertyId == IEditorPart.PROP_DIRTY) {
			propertiesEditor.setModified(isDirty());
		}
		super.handlePropertyChange(propertyId);
	}

	@Override
	public void setFocus() {

	}

	@Override
	protected void createPages() {
		propertiesPage = new PropertiesPage(this);
		propertiesEditor = propertiesPage.getPropertiesEditor();
		createPropertiesPage();
		createSourcePage(propertiesEditor.getDefaultProperties().getFile());
		for (Properties each : propertiesEditor.getSubProperties()) {
			createSourcePage(each.getFile());
		}

	}

	private void createPropertiesPage() {

		int index = addPage(propertiesPage);

		setPageText(index, "PropertiesEditor");
	}

	@SuppressWarnings("restriction")
	private void createSourcePage(IFile file) {
		try {
			PropertiesFileEditor propertiesFileEditor = new PropertiesFileEditor();

			propertiesMap.put(file.getName(), propertiesFileEditor);
			int index = addPage(propertiesFileEditor, new FileEditorInput(file));
			setPageText(index, file.getName());

		}
		catch (PartInitException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void firePropertyChange(int propertyId) {
		super.firePropertyChange(propertyId);
	}

	@Override
	public Composite getContainer() {
		return super.getContainer();
	}
}
