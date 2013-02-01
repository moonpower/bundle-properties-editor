package net.moon.util.bundlePropertiesEditor.dialogs;

import java.util.List;

import net.moon.util.bundlePropertiesEditor.StringUtil;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.DefaultProperty;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.Merge;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.Property;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.PropertieseditorFactoryImpl;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

public class MergeDialog extends Dialog {

	private Text keyText;
	private Text valueText;
	private List<DefaultProperty> list;

	public MergeDialog(Shell parentShell, List<DefaultProperty> list) {
		super(parentShell);
		setShellStyle(SWT.SHELL_TRIM | SWT.APPLICATION_MODAL);
		this.list = list;

	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("대표 개체 선택");
	}

	@Override
	protected Control createDialogArea(Composite parent) {

		Composite container = new Composite(parent, SWT.NORMAL);
		container.setLayout(new GridLayout(2, false));
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		Label titleLable = new Label(container, SWT.NORMAL);
		GridData layoutData = new GridData();
		layoutData.horizontalSpan = 2;

		titleLable.setLayoutData(layoutData);
		titleLable.setText("합병할 대표 Key와 Value을 정해주세요.");
		TableViewer tableViewer = new TableViewer(container, SWT.FULL_SELECTION
				| SWT.BORDER);

		tableViewer.setContentProvider(contentProvider);
		Table table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		layoutData = new GridData();
		layoutData.horizontalSpan = 2;
		layoutData.horizontalAlignment = SWT.FILL;
		layoutData.verticalAlignment = SWT.FILL;
		table.setLayoutData(layoutData);

		TableViewerColumn keyColumn = createTableViewerColumn("Key", 100,
				tableViewer);

		keyColumn.setLabelProvider(new CellLabelProvider() {

			@Override
			public void update(ViewerCell cell) {
				Object element = cell.getElement();
				DefaultProperty property = (DefaultProperty) element;
				String key = StringUtil.getUnicodeToUnicodeText(property
						.getKey());
				cell.setText(key);

			}
		});

		TableViewerColumn valueColumn = createTableViewerColumn("Value", 100,
				tableViewer);
		valueColumn.setLabelProvider(new CellLabelProvider() {

			@Override
			public void update(ViewerCell cell) {
				Object element = cell.getElement();
				DefaultProperty property = (DefaultProperty) element;
				String value = StringUtil.getUnicodeToUnicodeText(property
						.getValue());
				cell.setText(value);
			}
		});

		tableViewer.setInput(this.list);
		Label label = new Label(container, SWT.NORMAL);
		label.setText("Key : ");

		keyText = new Text(container, SWT.NORMAL | SWT.BORDER);
		keyText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		label = new Label(container, SWT.NORMAL);
		label.setText("Value : ");
		valueText = new Text(container, SWT.NORMAL | SWT.BORDER);
		valueText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		tableViewer
				.addSelectionChangedListener(new ISelectionChangedListener() {

					@Override
					public void selectionChanged(SelectionChangedEvent event) {
						IStructuredSelection selection = (IStructuredSelection) event
								.getSelection();
						Object firstElement = selection.getFirstElement();
						Property property = (Property) firstElement;

						String key = StringUtil
								.getUnicodeToUnicodeText(property.getKey());
						keyText.setText(key);
						String value = StringUtil
								.getUnicodeToUnicodeText(property.getValue());
						valueText.setText(value);
					}
				});

		return container;
	}

	private TableViewerColumn createTableViewerColumn(String text, int width,
			TableViewer viewer) {
		TableViewerColumn tableViewerColumn = new TableViewerColumn(viewer,
				SWT.NORMAL);
		TableColumn column = tableViewerColumn.getColumn();
		column.setText(text);
		column.setMoveable(false);
		column.setResizable(true);
		column.setWidth(width);
		return tableViewerColumn;

	}

	@Override
	protected void okPressed() {
		merge = PropertieseditorFactoryImpl.eINSTANCE.createMerge();
		merge.getMergedProperty().addAll(list);
		DefaultProperty property = PropertieseditorFactoryImpl.eINSTANCE
				.createDefaultProperty();
		String key = StringUtil.getUnicodeTextToText(keyText.getText().trim());
		String value = StringUtil.getUnicodeTextToText(valueText.getText()
				.trim());
		property.setKey(key);
		property.setOldKey(key);
		property.setValue(value);
		property.setOldValue(value);

		merge.setProperty(property);
		System.out.println(merge.getProperty());
		System.out.println(merge.getMergedProperty());
		super.okPressed();
	}

	public Merge getMerge() {
		return merge;
	}

	private IStructuredContentProvider contentProvider = new IStructuredContentProvider() {

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

		}

		@Override
		public void dispose() {

		}

		@Override
		public Object[] getElements(Object inputElement) {
			List<Property> list = (List<Property>) inputElement;

			return list.toArray();
		}
	};
	private Merge merge;
}
