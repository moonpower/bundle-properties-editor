package net.moon.util.bundlePropertiesEditor.editor;

import java.util.ArrayList;
import java.util.List;

import net.moon.util.bundlePropertiesEditor.BundlePropertiesParser;
import net.moon.util.bundlePropertiesEditor.StringUtil;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.DefaultProperties;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.DefaultProperty;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.Properties;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.Property;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.SubProperties;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.PropertieseditorFactoryImpl;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.IEditorPart;

public class PropertiesPage extends AbstractPropertiesPage {

	private boolean isPageModified;

	private final int DEFAULT_NLS = 0;
	private final int SUB_NLS = 1;
	private List<CheckboxTableViewer> list = new ArrayList<CheckboxTableViewer>();

	public PropertiesPage(BundlePropertiesEditor bundlePropertiesEditor) {
		super(bundlePropertiesEditor);
		IFile file = fileInput.getFile();
		initProperties(file);

		create();
	}

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
		tableViewer.setData("textArea", createTextArea(sashForm));

		sashForm.setWeights(new int[] { 2, 1 });
		tableViewer.setInput(propertiesEditor.getDefaultProperties());
		list.add(tableViewer);
		createButtonBar(container, tableViewer);

		item.setControl(container);
	}

	private void initProperties(IFile file) {
		addProperties(file);
		initSubProperties(file);
		addSubProperty();
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
					if (each.getOldKey().equals(eachProperty.getOldKey())
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
		for (IFile each : fileList) {
			addProperties(each);
		}
	}

	private void addProperties(IFile file) {
		String read = null;
		try {

			read = StringUtil.read(file.getContents());
		}
		catch (Exception e) {
			e.printStackTrace();
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
					if (msg.isTouch()) {
						tableModified();
						refresh();
					}
				}

				private void tableModified() {
					boolean dirty = getEditor().isDirty();
					isPageModified = true;
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
					if (msg.isTouch()) {
						tableModified();
					}
				}

				private void tableModified() {
					boolean dirty = getEditor().isDirty();
					isPageModified = true;
					if (!dirty) {
						getEditor().firePropertyChange(IEditorPart.PROP_DIRTY);
					}
				};

			});

		}
		String language = null;
		if (file.getName().contains("_")) {
			String[] split = file.getName().split("_");
			language = split[1];
		}
		else {
			language = "default";
		}
		subProperties.setLanguage(language);
		subProperties.setName(file.getName());
		subProperties.setFile(file);
		propertiesEditor.getSubProperties().add(subProperties);
	}

	public boolean isPageModified() {
		return isPageModified;
	}

	public void setPageModified(boolean isPageModified) {
		this.isPageModified = isPageModified;
	}

	public void refresh() {
		for (CheckboxTableViewer each : list) {
			each.refresh();
		}
	}
}
