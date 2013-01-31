package net.moon.util.bundlePropertiesEditor.editor.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.moon.util.bundlePropertiesEditor.BundlePropertiesParser;
import net.moon.util.bundlePropertiesEditor.StringUtil;
import net.moon.util.bundlePropertiesEditor.actions.AddAction;
import net.moon.util.bundlePropertiesEditor.actions.DeleteAction;
import net.moon.util.bundlePropertiesEditor.actions.MergeAction;
import net.moon.util.bundlePropertiesEditor.editor.BundlePropertiesEditor;
import net.moon.util.bundlePropertiesEditor.editor.PropertiesRelativeFile;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.DefaultProperties;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.DefaultProperty;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.Properties;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.Property;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.SubProperties;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.PropertieseditorFactoryImpl;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.FindReplaceDocumentAdapter;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.pde.internal.ui.editor.text.ColorManager;
import org.eclipse.pde.internal.ui.editor.text.IColorManager;
import org.eclipse.pde.internal.ui.editor.text.XMLConfiguration;
import org.eclipse.pde.internal.ui.editor.text.XMLPartitionScanner;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.IEditorPart;

@SuppressWarnings("restriction")
public class PropertiesPage extends AbstractPropertiesPage {

	private final int DEFAULT_NLS = 0;
	private final int SUB_NLS = 1;
	private List<CheckboxTableViewer> list = new ArrayList<CheckboxTableViewer>();
	private List<SourceViewer> sourceViewerList = new ArrayList<SourceViewer>();

	public PropertiesPage(BundlePropertiesEditor bundlePropertiesEditor) {
		super(bundlePropertiesEditor);
		IFile file = fileInput.getFile();
		if (file.getName().contains("_")) {
			PropertiesRelativeFile propertiesRelativeFile = new PropertiesRelativeFile(
					file);
			file = propertiesRelativeFile.loadRelativeDefaultFile();
		}
		initProperties(file);

		create();
	}

	@Override
	public void create() {
		if (propertiesEditor == null) {
			return;
		}
		this.setLayout(new FillLayout());

		TabFolder folder = new TabFolder(this, SWT.NORMAL);

		addTabItem(folder, propertiesEditor.getDefaultProperties(),
				DEFAULT_NLS, 0);

		int index = 0;

		for (Properties each : propertiesEditor.getSubProperties()) {
			addTabItem(folder, each, SUB_NLS, index);
			index++;
		}

	}

	private void addTabItem(TabFolder folder, Properties properties, int nls,
			int index) {

		TabItem item = new TabItem(folder, SWT.NONE);
		Composite container = new Composite(folder, SWT.NONE);
		container.setLayout(new GridLayout());
		container.setLayoutData(new GridData(GridData.FILL_BOTH));

		SashForm sashForm = new SashForm(container, SWT.VERTICAL);
		sashForm.setLayout(new GridLayout());
		sashForm.setLayoutData(new GridData(GridData.FILL_BOTH));

		CheckboxTableViewer tableViewer = null;
		switch (nls) {
		case DEFAULT_NLS:
			tableViewer = createDefaultTableViewer(sashForm);
			item.setText(properties.getLanguage());
			break;
		case SUB_NLS:
			tableViewer = createTableViewer(sashForm, index);
			item.setText(properties.getLanguage());
			break;
		}

		DeleteAction deleteAction = new DeleteAction(
				propertiesEditor.getDefaultProperties(), tableViewer);
		MergeAction mergeAction = new MergeAction();
		AddAction addAction = new AddAction(propertiesEditor);
		MenuManager menuManager = new MenuManager("TableViewerMenu");
		menuManager.add(deleteAction);
		menuManager.add(mergeAction);
		menuManager.add(addAction);
		Menu createContextMenu = menuManager.createContextMenu(sashForm);
		tableViewer.getTable().setMenu(createContextMenu);

		SourceViewer sourceViewer = new SourceViewer(sashForm, null,
				SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER);
		sourceViewer.setEditable(false);
		sourceViewer.getTextWidget().setFont(JFaceResources.getTextFont());
		IColorManager colorManager = ColorManager.getDefault();
		sourceViewer.configure(new XMLConfiguration(colorManager));
		Document document = new Document();
		IFile loadPluginFile = new PropertiesRelativeFile(propertiesEditor
				.getDefaultProperties().getFile()).loadPluginFile();

		String read = null;
		try {
			read = StringUtil.read(loadPluginFile.getContents(), "UTF-8");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (CoreException e) {
			e.printStackTrace();
		}
		IDocumentPartitioner partitioner = new FastPartitioner(
				new XMLPartitionScanner(), new String[] {
						XMLPartitionScanner.XML_TAG,
						XMLPartitionScanner.XML_COMMENT });
		sourceViewer.setDocument(document);
		partitioner.connect(document);
		document.setDocumentPartitioner(partitioner);
		document.set(read);
		findReplaceDocumentAdapter = new FindReplaceDocumentAdapter(document);

		tableViewer.setData("sourceViewer", sourceViewer);
		sashForm.setWeights(new int[] { 2, 1 });
		tableViewer.setInput(propertiesEditor.getDefaultProperties());
		sourceViewerList.add(sourceViewer);
		list.add(tableViewer);
		// createButtonBar(container, tableViewer);

		item.setControl(container);
	}

	private void initProperties(IFile file) {
		addProperties(file);
		initSubProperties(file);

	}

	private void addSubProperty() {
		EList<DefaultProperty> property = propertiesEditor
				.getDefaultProperties().getProperty();
		for (SubProperties eachProperties : propertiesEditor.getSubProperties()) {

			for (DefaultProperty each : property) {
				int count = 0;
				List<Property> tempList = new ArrayList<Property>();
				tempList.addAll(eachProperties.getProperty());
				for (Property eachProperty : tempList) {
					if (each.getOldKey().toUpperCase()
							.equals(eachProperty.getOldKey().toUpperCase())
							&& count == 0) {
						each.getSubProperty().add(eachProperty);
						count++;
					}
				}
				if (count == 0) {
					each.getSubProperty().add(
							PropertieseditorFactoryImpl.eINSTANCE
									.createDefaultProperty());
					count++;
				}

			}
		}

	}

	private void initSubProperties(IFile file) {

		PropertiesRelativeFile relativeFile = new PropertiesRelativeFile(file);
		List<IFile> fileList = relativeFile.loadRelativeLanguageFile();
		if (fileList == null || fileList.size() == 0) {
			return;
		}
		for (IFile each : fileList) {
			addProperties(each);
		}

		addSubProperty();
	}

	private void addProperties(IFile file) {
		String read = null;
		try {
			read = StringUtil.read(file.getContents());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		if (read == null) {
			return;
		}
		BundlePropertiesParser propertiesParser = new BundlePropertiesParser(
				file.getName());
		if (file.getName().contains("_")) {
			SubProperties properties = propertiesParser
					.parseSubProperties(read);
			addSubProperties(file, properties);
		}
		else {
			DefaultProperties properties = propertiesParser
					.parseDefaultProperties(read);

			addDefaultProperties(file, properties);
		}
	}

	private void addDefaultProperties(IFile file, DefaultProperties properties) {
		for (DefaultProperty each : properties.getProperty()) {
			each.eAdapters().add(new AdapterImpl() {
				@Override
				public void notifyChanged(Notification msg) {
					if (msg.getEventType() == Notification.SET
							&& !(msg.getNewValue().equals(msg.getOldValue()))) {
						tableModified();
					}
				}

				private void tableModified() {
					boolean dirty = getEditor().isDirty();
					propertiesEditor.setModified(true);
					if (!dirty) {
						getEditor().firePropertyChange(IEditorPart.PROP_DIRTY);
					}
				};

			});

		}

		properties.setName(file.getName());
		properties.setFile(file);
		propertiesEditor.setDefaultProperties(properties);
	}

	private void addSubProperties(IFile file, SubProperties subProperties) {
		for (Property each : subProperties.getProperty()) {
			each.eAdapters().add(new AdapterImpl() {
				@Override
				public void notifyChanged(Notification msg) {
					if (msg.getEventType() == Notification.SET
							&& !(msg.getNewValue().equals(msg.getOldValue()))) {
						tableModified();
					}
				}

				private void tableModified() {
					boolean dirty = getEditor().isDirty();
					propertiesEditor.setModified(true);
					if (!dirty) {
						getEditor().firePropertyChange(IEditorPart.PROP_DIRTY);
					}
				};

			});

		}
		String language = null;
		if (file.getName().contains("_")) {
			int indexOf = 1 + file.getName().indexOf("_");
			language = file.getName().substring(indexOf, indexOf + 2);

		}
		else {
			language = "default";
		}
		subProperties.setLanguage(language);
		subProperties.setName(file.getName());
		subProperties.setFile(file);
		propertiesEditor.getSubProperties().add(subProperties);
	}

	public void refreshCheckboxTableViewer() {
		for (CheckboxTableViewer each : list) {
			each.refresh();
		}
	}

	public void refreshDocument() {
		Document document = new Document();
		IFile loadPluginFile = new PropertiesRelativeFile(propertiesEditor
				.getDefaultProperties().getFile()).loadPluginFile();

		String read = null;
		try {
			read = StringUtil.read(loadPluginFile.getContents(), "UTF-8");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (CoreException e) {
			e.printStackTrace();
		}
		IDocumentPartitioner partitioner = new FastPartitioner(
				new XMLPartitionScanner(), new String[] {
						XMLPartitionScanner.XML_TAG,
						XMLPartitionScanner.XML_COMMENT });
		partitioner.connect(document);

		document.setDocumentPartitioner(partitioner);
		document.set(read);

		for (SourceViewer each : sourceViewerList) {
			each.setDocument(document);

		}
		findReplaceDocumentAdapter = new FindReplaceDocumentAdapter(document);
	}

}
