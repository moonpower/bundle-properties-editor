package net.moon.util.bundlePropertiesEditor.editor.pages;

import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class ColumnControlAdapter extends ControlAdapter {
	int currentColumnOrder[] = null;

	@Override
	public void controlMoved(ControlEvent e) {
		TableColumn column = (TableColumn) e.getSource();
		Table parent = column.getParent();
		if (currentColumnOrder == null) {
			currentColumnOrder = parent.getColumnOrder();
		}
		if (parent.getColumnOrder()[0] != 0 || parent.getColumnOrder()[1] != 1) {
			parent.setColumnOrder(currentColumnOrder);

		}
		currentColumnOrder = parent.getColumnOrder();
	}
}
