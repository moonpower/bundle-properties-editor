package net.moon.util.bundlePropertiesEditor.editor;

import java.util.ArrayList;
import java.util.List;

import net.moon.util.bundlePropertiesEditor.BundlePropertiesParser;
import net.moon.util.bundlePropertiesEditor.StringUtil;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.Properties;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.PropertiesEditor;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.Property;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.PropertieseditorFactoryImpl;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ColumnViewerEditor;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationEvent;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationStrategy;
import org.eclipse.jface.viewers.FocusCellOwnerDrawHighlighter;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TableViewerEditor;
import org.eclipse.jface.viewers.TableViewerFocusCellManager;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.part.FileEditorInput;


public class BundlePropertiesEditor extends EditorPart {
	public static final String id = "com.moon.util.editor";
	private PropertiesEditor propertiesEditor;
	private FileEditorInput fileInput;
	private TableViewer tableViewer;

	public BundlePropertiesEditor() {

	}

	@Override
	public void doSave(IProgressMonitor monitor) {

	}

	@Override
	public void doSaveAs() {

	}

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {

		if (!(input instanceof FileEditorInput)) {
			setInput(input);
			setSite(site);
			return;
		}

		fileInput = (FileEditorInput) input;
		IFile file = fileInput.getFile();

		initProperties(file);
		setInput(input);
		setSite(site);
	}

	private void initProperties(IFile file) {
		propertiesEditor = PropertieseditorFactoryImpl.eINSTANCE
				.createPropertiesEditor();
		addProperties(file);
		initSubProperties(file);
	}

	private void initSubProperties(IFile file) {
		String fileFullName = file.getName();
		int indexOf = fileFullName.indexOf('.');
		final String fileName = fileFullName.substring(0, indexOf);
		IProject project = file.getProject();

		final List<IPath> list = new ArrayList<IPath>();
		try {
			project.accept(new IResourceVisitor() {

				@Override
				public boolean visit(IResource resource) throws CoreException {

					if (resource.getName().startsWith(fileName + "_")
							&& resource instanceof IFile) {
						list.add(resource.getProjectRelativePath());
						return true;
					}
					return resource instanceof IContainer;
				}
			});
		}
		catch (CoreException e) {
			e.printStackTrace();
		}
		for (IPath eachPath : list) {
			IFile eachPathFile = project.getFile(eachPath);
			addProperties(eachPathFile);
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

		Properties properties = propertiesParser.parse(read);

		String language = null;
		if (file.getName().contains("_")) {
			String[] split = file.getName().split("_");
			language = split[1];
		}
		else {
			language = "default";
		}
		properties.setLanguage(language);
		properties.setName(file.getName());
		propertiesEditor.getProperties().add(properties);
	}

	@Override
	public boolean isDirty() {
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	@Override
	public void createPartControl(Composite parent) {
		if (propertiesEditor == null) {
			return;
		}

		Composite container = new Composite(parent, SWT.NORMAL);
		container.setLayout(new GridLayout(2, false));
		tableViewer = createTableViewer(container);

		createButtonBar(container);
		tableViewer.setInput(propertiesEditor.getProperties().get(0));

	}

	private void createButtonBar(Composite container) {
		Composite buttonBar = new Composite(container, SWT.NONE);
		buttonBar.setLayoutData(new GridData(SWT.RIGHT, SWT.FILL, false, false,
				2, 1));
		buttonBar.setLayout(new GridLayout(2, false));
		Button refreshButton = new Button(buttonBar, SWT.PUSH);
		refreshButton.setText("Refresh");
		refreshButton.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				initProperties(fileInput.getFile());
				tableViewer.setInput(propertiesEditor.getProperties().get(0));
			}
		});
		Button applyButton = new Button(buttonBar, SWT.PUSH);
		applyButton.setText("Save");
		applyButton.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				ReplacePluginFile.saveProperties(propertiesEditor,
						fileInput.getFile());

			}
		});
	}

	private TableViewer createTableViewer(Composite parent) {
		TableViewer tableViewer = new TableViewer(parent, SWT.FULL_SELECTION
				| SWT.BORDER);
		tableViewer.setContentProvider(new TableContentProvider());

		Table table = tableViewer.getTable();
		table.setLayoutData(new GridData(GridData.FILL_BOTH));
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableViewerColumn keyColumn = createViewerColumn(tableViewer, "Key",
				100);
		keyColumn.setLabelProvider(new CellLabelProvider() {

			@Override
			public void update(ViewerCell cell) {
				Property property = (Property) cell.getElement();
				cell.setText(StringUtil.getUnicodeToUnicodeText(property
						.getKey()));
			}
		});
		keyColumn.setEditingSupport(new KeyEditingSupport(tableViewer,
				propertiesEditor));

		for (Properties each : propertiesEditor.getProperties()) {
			TableViewerColumn valueColumn = createViewerColumn(tableViewer, "<"
					+ each.getLanguage() + ">", 100);
			final int index = propertiesEditor.getProperties().indexOf(each);
			valueColumn.setLabelProvider(new CellLabelProvider() {

				@Override
				public void update(ViewerCell cell) {
					Object element = cell.getElement();
					Property property = (Property) element;
					EList<Property> properties = propertiesEditor
							.getProperties().get(index).getProperty();
					for (Property each : properties) {
						if (property.getOldKey().equals(each.getOldKey())) {
							cell.setText(StringUtil
									.getUnicodeToUnicodeText(each.getValue()));
						}
					}

				}
			});
			valueColumn.setEditingSupport(new ValueEditingSupport(tableViewer,
					each, index));

		}

		TableViewerFocusCellManager manager = new TableViewerFocusCellManager(
				tableViewer, new FocusCellOwnerDrawHighlighter(tableViewer));
		ColumnViewerEditorActivationStrategy actSupport = new ColumnViewerEditorActivationStrategy(
				tableViewer) {
			@Override
			protected boolean isEditorActivationEvent(
					ColumnViewerEditorActivationEvent event) {
				return event.eventType == ColumnViewerEditorActivationEvent.TRAVERSAL
						|| event.eventType == ColumnViewerEditorActivationEvent.MOUSE_DOUBLE_CLICK_SELECTION
						|| (event.eventType == ColumnViewerEditorActivationEvent.KEY_PRESSED && event.keyCode == SWT.CR)
						|| event.eventType == ColumnViewerEditorActivationEvent.PROGRAMMATIC;
			}
		};

		TableViewerEditor.create(tableViewer, manager, actSupport,
				ColumnViewerEditor.TABBING_HORIZONTAL
						| ColumnViewerEditor.TABBING_MOVE_TO_ROW_NEIGHBOR
						| ColumnViewerEditor.TABBING_VERTICAL
						| ColumnViewerEditor.KEYBOARD_ACTIVATION);

		return tableViewer;
	}

	private TableViewerColumn createViewerColumn(TableViewer tableViewer,
			String text, int width) {
		TableViewerColumn viewerColumn = new TableViewerColumn(tableViewer,
				SWT.NORMAL);
		TableColumn column = viewerColumn.getColumn();
		column.setText(text);
		column.setWidth(width);
		column.setResizable(true);
		column.setMoveable(true);
		return viewerColumn;
	}

	@Override
	public void setFocus() {

	}

}
