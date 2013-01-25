package net.moon.util.bundlePropertiesEditor.editor;

import java.util.ArrayList;
import java.util.List;

import net.moon.util.bundlePropertiesEditor.StringUtil;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.DefaultProperties;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.DefaultProperty;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.Merge;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.PropertiesEditor;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.Property;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.PropertieseditorFactoryImpl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ColumnViewerEditor;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationEvent;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationStrategy;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.FocusCellOwnerDrawHighlighter;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TableViewerEditor;
import org.eclipse.jface.viewers.TableViewerFocusCellManager;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.FileEditorInput;

public abstract class AbstractPropertiesPage extends Composite {
	// protected CheckboxTableViewer tableViewer;
	protected PropertiesEditor propertiesEditor;
	protected FileEditorInput fileInput;
	private BundlePropertiesEditor editor;
	private TableViewerComparator comparator;
	private ViewerCell currentCell;

	public AbstractPropertiesPage(BundlePropertiesEditor bundlePropertiesEditor) {
		super(bundlePropertiesEditor.getContainer(), SWT.NORMAL);
		this.editor = bundlePropertiesEditor;
		if (bundlePropertiesEditor.getEditorInput() instanceof FileEditorInput) {
			fileInput = (FileEditorInput) bundlePropertiesEditor
					.getEditorInput();
		}
		comparator = new TableViewerComparator();
		propertiesEditor = PropertieseditorFactoryImpl.eINSTANCE
				.createPropertiesEditor();
	}

	protected CheckboxTableViewer createTableViewer(Composite parent,
			final int index) {
		Composite container = new Composite(parent, SWT.NORMAL);
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		Table table = new Table(container, SWT.FULL_SELECTION | SWT.BORDER
				| SWT.CHECK | SWT.NO_SCROLL | SWT.V_SCROLL);
		CheckboxTableViewer tableViewer = new CheckboxTableViewer(table);

		tableViewer.setContentProvider(new TableContentProvider());
		tableViewer.setComparator(comparator);
		table = tableViewer.getTable();
		table.setLayoutData(new GridData(GridData.FILL_BOTH));
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		TableColumnLayout tableColumnLayout = new TableColumnLayout();
		container.setLayout(tableColumnLayout);
		TableViewerColumn checkBoxColumn = createViewerColumn(tableViewer, "",
				30, 9);

		checkBoxColumn.setLabelProvider(new CellLabelProvider() {

			@Override
			public void update(ViewerCell cell) {

			}
		});

		int colNumber = 1;
		TableViewerColumn keyColumn = createDefaultKeyColumn(tableViewer,
				colNumber);
		colNumber++;

		DefaultProperties defaultProperties = propertiesEditor
				.getDefaultProperties();

		TableViewerColumn defaultValueColumn = createDefaultValueColumn(
				tableViewer, colNumber, defaultProperties);
		colNumber++;

		TableViewerColumn valueColumn = createSubValueColumn(tableViewer,
				index, colNumber);

		colNumber++;

		TableColumn column0 = checkBoxColumn.getColumn();
		tableColumnLayout.setColumnData(column0, new ColumnWeightData(4));
		TableColumn column1 = keyColumn.getColumn();
		tableColumnLayout.setColumnData(column1, new ColumnWeightData(32));
		TableColumn column2 = defaultValueColumn.getColumn();
		tableColumnLayout.setColumnData(column2, new ColumnWeightData(32));
		TableColumn column3 = valueColumn.getColumn();
		tableColumnLayout.setColumnData(column3, new ColumnWeightData(32));

		createTableViewerEditor(tableViewer);
		return tableViewer;
	}

	private TableViewerColumn createSubValueColumn(
			CheckboxTableViewer tableViewer, final int index, int colNumber) {
		TableViewerColumn valueColumn = createViewerColumn(tableViewer, "<"
				+ propertiesEditor.getSubProperties().get(index).getLanguage()
				+ ">", 150, colNumber);

		valueColumn.setLabelProvider(new CellLabelProvider() {

			@Override
			public void update(ViewerCell cell) {
				Object element = cell.getElement();
				DefaultProperty property = (DefaultProperty) element;
				if (property.getSubProperty().size() != 0) {
					String value = StringUtil.getUnicodeToUnicodeText(property
							.getSubProperty().get(index).getValue());
					cell.setText(value);
				}

			}
		});
		valueColumn.setEditingSupport(new SubValueEditingSupport(tableViewer,
				index));
		return valueColumn;
	};

	protected CheckboxTableViewer createDefaultTableViewer(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		Table table = new Table(container, SWT.FULL_SELECTION | SWT.BORDER
				| SWT.CHECK | SWT.NO_SCROLL | SWT.V_SCROLL);
		CheckboxTableViewer tableViewer = new CheckboxTableViewer(table);
		tableViewer.setContentProvider(new TableContentProvider());

		tableViewer.setComparator(comparator);

		table.setLayoutData(new GridData(GridData.FILL_BOTH));
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableViewerColumn checkBoxColumn = createViewerColumn(tableViewer, "",
				30, 9);

		checkBoxColumn.setLabelProvider(new CellLabelProvider() {

			@Override
			public void update(ViewerCell cell) {

			}
		});

		int colNumber = 1;

		TableViewerColumn keyColumn = createDefaultKeyColumn(tableViewer,
				colNumber);

		colNumber++;

		DefaultProperties defaultProperties = propertiesEditor
				.getDefaultProperties();

		TableViewerColumn defaultValueColumn = createDefaultValueColumn(
				tableViewer, colNumber, defaultProperties);

		colNumber++;

		createTableViewerEditor(tableViewer);
		TableColumn column0 = checkBoxColumn.getColumn();
		TableColumn column1 = keyColumn.getColumn();
		TableColumn column2 = defaultValueColumn.getColumn();
		TableColumnLayout tableColumnLayout = new TableColumnLayout();
		tableColumnLayout.setColumnData(column0, new ColumnWeightData(4));
		tableColumnLayout.setColumnData(column1, new ColumnWeightData(48));
		tableColumnLayout.setColumnData(column2, new ColumnWeightData(48));
		container.setLayout(tableColumnLayout);
		return tableViewer;
	}

	private void createTableViewerEditor(final CheckboxTableViewer tableViewer) {
		TableViewerFocusCellManager manager = new TableViewerFocusCellManager(
				tableViewer, new FocusCellOwnerDrawHighlighter(tableViewer));

		ColumnViewerEditorActivationStrategy actSupport = new ColumnViewerEditorActivationStrategy(
				tableViewer) {
			@Override
			protected boolean isEditorActivationEvent(
					ColumnViewerEditorActivationEvent event) {
				ViewerCell viewerCell = (ViewerCell) event.getSource();
				currentCell = viewerCell;
				Text textArea = (Text) tableViewer.getData("textArea");
				textArea.setText(viewerCell.getText());
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
	}

	private TableViewerColumn createDefaultValueColumn(
			CheckboxTableViewer tableViewer, int colNumber,
			DefaultProperties defaultProperties) {
		TableViewerColumn defaultValueColumn = createViewerColumn(tableViewer,
				"<" + defaultProperties.getLanguage() + ">", 150, colNumber);

		defaultValueColumn.setLabelProvider(new CellLabelProvider() {

			@Override
			public void update(ViewerCell cell) {
				Object element = cell.getElement();
				DefaultProperty property = (DefaultProperty) element;
				String value = StringUtil.getUnicodeToUnicodeText(property
						.getValue());
				cell.setText(value);
			}
		});

		defaultValueColumn.setEditingSupport(new ValueEditingSupport(
				tableViewer));
		return defaultValueColumn;
	}

	private TableViewerColumn createDefaultKeyColumn(
			CheckboxTableViewer tableViewer, int colNumber) {
		TableViewerColumn keyColumn = createViewerColumn(tableViewer, "Key",
				150, colNumber);

		keyColumn.setLabelProvider(new CellLabelProvider() {

			@Override
			public void update(ViewerCell cell) {

				Property property = (Property) cell.getElement();
				cell.setText(StringUtil.getUnicodeToUnicodeText(property
						.getKey()));
				EList<DefaultProperty> properties = propertiesEditor
						.getDefaultProperties().getProperty();
				int count = 0;
				for (Property each : properties) {
					if (each.getKey() == property.getKey()) {
						count++;
					}

				}
				if (count > 1) {
					cell.setBackground(Display.getDefault().getSystemColor(
							SWT.COLOR_INFO_BACKGROUND));
				}

				refreshModel();
			}
		});

		keyColumn.setEditingSupport(new KeyEditingSupport(tableViewer,
				propertiesEditor));
		return keyColumn;
	};

	protected Text createTextArea(SashForm sashForm) {
		final Text textArea = new Text(sashForm, SWT.MULTI | SWT.BORDER
				| SWT.H_SCROLL);
		GridData gridData = new GridData();
		gridData.horizontalSpan = 2;
		gridData.horizontalAlignment = SWT.FILL;
		gridData.verticalAlignment = SWT.FILL;
		textArea.setLayoutData(gridData);
		Font font = textArea.getFont();
		FontData[] fontData = font.getFontData();
		for (FontData each : fontData) {
			each.setHeight(18);
		}
		Font newFont = new Font(Display.getDefault(), fontData);
		textArea.setFont(newFont);

		textArea.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				currentCell.setText(textArea.getText());
			}
		});
		return textArea;
	}

	private TableViewerColumn createViewerColumn(
			CheckboxTableViewer tableViewer, String text, int width,
			int colNumber) {
		TableViewerColumn viewerColumn = new TableViewerColumn(tableViewer,
				SWT.NORMAL);
		TableColumn column = viewerColumn.getColumn();
		column.setText(text);
		column.setWidth(width);
		column.setResizable(true);
		column.setMoveable(true);

		column.addSelectionListener(getSelectionAdapter(tableViewer, column,
				colNumber));
		return viewerColumn;
	}

	private SelectionAdapter getSelectionAdapter(
			final CheckboxTableViewer tableViewer, final TableColumn column,
			final int index) {
		SelectionAdapter selectionAdapter = new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				comparator.setColumn(index);
				int dir = comparator.getDirection();
				tableViewer.getTable().setSortDirection(dir);
				tableViewer.getTable().setSortColumn(column);
				tableViewer.refresh();
			}
		};
		return selectionAdapter;
	}

	protected void createButtonBar(Composite container,
			final CheckboxTableViewer tableViewer) {
		Composite buttonBar = new Composite(container, SWT.NONE);
		buttonBar.setLayoutData(new GridData(SWT.RIGHT, SWT.FILL, false, false,
				1, 1));
		buttonBar.setLayout(new GridLayout(2, false));
		Button refreshButton = new Button(buttonBar, SWT.PUSH);
		refreshButton.setText("Refresh");
		refreshButton.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {

				tableViewer.setInput(propertiesEditor.getDefaultProperties());
			}
		});
		Button applyButton = new Button(buttonBar, SWT.PUSH);
		applyButton.setText("Merge");
		applyButton.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				List<DefaultProperty> list = new ArrayList<DefaultProperty>();
				for (DefaultProperty each : propertiesEditor
						.getDefaultProperties().getProperty()) {
					boolean checked = tableViewer.getChecked(each);
					if (checked) {
						list.add(each);
					}
				}
				if (list.size() == 0) {
					return;
				}
				MergeDialog dialog = new MergeDialog(new Shell(event.display),
						list);
				if (IDialogConstants.OK_ID == dialog.open()) {
					Merge merge = dialog.getMerge();
					propertiesEditor.getDefaultProperties().getMerges()
							.add(merge);
					propertiesEditor.getDefaultProperties().getProperty()
							.add(merge.getProperty());
					tableViewer.setInput(propertiesEditor
							.getDefaultProperties());
					for (DefaultProperty each : merge.getMergedProperty()) {
						propertiesEditor.getDefaultProperties().getProperty()
								.remove(each);
					}
				}

			}
		});
	}

	protected void refreshModel() {

	}

	public PropertiesEditor getPropertiesEditor() {
		return this.propertiesEditor;
	}

	protected BundlePropertiesEditor getEditor() {
		return this.editor;
	}

}
