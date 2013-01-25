package net.moon.util.bundlePropertiesEditor.editor;

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
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.MultiPageEditorPart;

public class BundlePropertiesEditor extends MultiPageEditorPart {
	public static final String id = "com.moon.util.editor";

	private PropertiesFileEditor propertiesFileEditor;
	private PropertiesPage propertiesPage;
	private PropertiesEditor propertiesEditor;

	private FileEditorInput fileEditorInput;

	private TextEditor textEditor;

	public BundlePropertiesEditor() {

	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		if (getEditorInput() == null) {
			return;
		}

		if (getActivePage() == 0 && propertiesPage.isPageModified()) {

			ReplacePluginFile.saveFiles(propertiesEditor);
			propertiesFileEditor.doSave(monitor);
			propertiesPage.setPageModified(false);
			propertiesPage.refresh();
		}
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

		if (getActivePage() == 0 && propertiesPage.isPageModified()) {
			propertiesPage.setPageModified(false);
			propertiesFileEditor.doSaveAs();
			setInput(propertiesFileEditor.getEditorInput());

		}
		if (isDirty()) {
			firePropertyChange(IEditorPart.PROP_DIRTY);
		}

	}

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {

		if (!(input instanceof FileEditorInput)) {
			setInput(input);
			setSite(site);
			return;
		}

		if (input instanceof FileEditorInput) {
			fileEditorInput = (FileEditorInput) input;
		}
		setInput(input);
		setSite(site);

	}

	@Override
	public boolean isDirty() {
		return propertiesPage.isPageModified();
	}

	@Override
	public boolean isSaveAsAllowed() {
		return true;
	}

	@Override
	protected void handlePropertyChange(int propertyId) {
		if (propertyId == IEditorPart.PROP_DIRTY) {
			propertiesPage.setPageModified(isDirty());
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

		PropertiesRelativeFile relativeFile = new PropertiesRelativeFile(
				fileEditorInput.getFile());

		IFile loadManifestFile = relativeFile.loadManifestFile();
		if (loadManifestFile != null) {
			createManifestPage(loadManifestFile);
		}
		IFile loadPluginFile = relativeFile.loadPluginFile();
		if (loadPluginFile != null) {
			createManifestPage(loadPluginFile);
		}
	}

	private void createPropertiesPage() {

		int index = addPage(propertiesPage);

		setPageText(index, "Properties");
	}

	private void createSourcePage(IFile file) {
		try {
			propertiesFileEditor = new PropertiesFileEditor();
			int index = addPage(propertiesFileEditor, new FileEditorInput(file));
			setPageText(index, file.getName());

		}
		catch (PartInitException e) {
			e.printStackTrace();
		}

	}

	private void createManifestPage(IFile file) {
		try {
			textEditor = new TextEditor();
			int index = addPage(textEditor, new FileEditorInput(file));
			setPageText(index, file.getName());
		}
		catch (PartInitException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void firePropertyChange(int propertyId) {
		super.firePropertyChange(propertyId);
	}

	@Override
	protected Composite getContainer() {
		return super.getContainer();
	}
}
