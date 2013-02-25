package net.moon.util.bundlePropertiesEditor;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.FocusCellHighlighter;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

public class FocusCellOwnerDrawHighlighterWithFullSelection extends
		FocusCellHighlighter {
	private ViewerCell currentFocusCell;
	private Color selectedRowColor;
	private final ColumnViewer viewer;

	public FocusCellOwnerDrawHighlighterWithFullSelection(ColumnViewer viewer) {
		super(viewer);
		this.viewer = viewer;
		viewer.getControl().addListener(SWT.EraseItem, new Listener() {
			@Override
			public void handleEvent(Event event) {
				eraseItem(event);
			}
		});

		viewer.getControl().addDisposeListener(new DisposeListener() {
			@Override
			public void widgetDisposed(DisposeEvent e) {
				if (selectedRowColor != null
						&& selectedRowColor.isDisposed() == false) {
					FocusCellOwnerDrawHighlighterWithFullSelection.this.selectedRowColor
							.dispose();
				}
			}
		});
	}

	protected void eraseItem(Event event) {
		if (this.viewer.getControl() instanceof Tree) {
			event.doit = !renderTreeCell(event);
		}
		else if (this.viewer.getControl() instanceof Table) {
			event.doit = !renderTableCell(event);
		}
	}

	@Override
	protected void focusCellChanged(ViewerCell newCell, ViewerCell oldCell) {
		this.currentFocusCell = newCell;
		if (newCell != null) {
			Rectangle rect = newCell.getBounds();
			int x = newCell.getColumnIndex() == 0 ? 0 : rect.x;
			int width = newCell.getColumnIndex() == 0 ? rect.x + rect.width
					: rect.width;
			newCell.getControl().redraw(x, rect.y - 1, width, rect.height + 1,
					false);
		}

		if (oldCell != null) {
			try {
				Rectangle rect = oldCell.getBounds();
				int x = oldCell.getColumnIndex() == 0 ? 0 : rect.x;
				int width = oldCell.getColumnIndex() == 0 ? rect.x + rect.width
						: rect.width;
				oldCell.getControl().redraw(x, rect.y - 1, width,
						rect.height + 1, false);
			}
			catch (Exception e) {

			}
		}

		this.viewer.getControl().update();
	}

	public Color getSelectedCellColor() {
		if (hasFocus()) {
			return ColorConstants.menuBackgroundSelected;
		}
		else {
			return ColorConstants.darkGray;
		}
	}

	public Color getSelectedRowColor() {
		if (hasFocus()) {
			if (this.selectedRowColor == null
					|| this.selectedRowColor.isDisposed()) {
				RGB back = this.viewer.getControl().getBackground().getRGB();
				RGB sel = getSelectedCellColor().getRGB();
				this.selectedRowColor = new Color(this.viewer.getControl()
						.getDisplay(), mix(back, sel));
			}

			return this.selectedRowColor;
		}

		else {
			return ColorConstants.lightGray;
		}
	}

	private boolean hasFocus() {
		Control control = getViewer().getControl();
		if (control.isFocusControl()) {
			return true;
		}
		Control currentFocus = control.getDisplay().getFocusControl();
		while (currentFocus != null) {
			currentFocus = currentFocus.getParent();
			if (currentFocus == control) {
				return true;
			}
		}
		return false;
	}

	public ColumnViewer getViewer() {
		return this.viewer;
	}

	private RGB mix(RGB rgb1, RGB rgb2) {
		return new RGB((rgb1.red + rgb2.red) / 2,
				(rgb1.green + rgb2.green) / 2, (rgb1.blue + rgb2.blue) / 2);
	}

	private boolean renderTreeCell(Event event) {
		FlagSupport detail = new FlagSupport(event.detail);
		GC gc = event.gc;
		TreeItem treeItem = (TreeItem) event.item;
		int colIndex = event.index;

		if (detail.isTrue(SWT.SELECTED)) {
			if (this.currentFocusCell != null
					&& this.currentFocusCell.getItem() == treeItem) {
				if (colIndex == this.currentFocusCell.getColumnIndex()) {
					gc.setForeground(ColorConstants.menuForegroundSelected);
					gc.setBackground(getSelectedCellColor());
				}
				else {
					gc.setForeground(this.viewer.getControl().getForeground());
					gc.setBackground(getSelectedRowColor());

				}
			}
			else {
				gc.setForeground(this.viewer.getControl().getForeground());
				gc.setBackground(getSelectedRowColor());
			}
			Rectangle bounds = treeItem.getBounds(colIndex);
			int x = bounds.x;
			gc.fillRectangle(event.x, event.y, event.width, event.height);
			if (treeItem.getImage(colIndex) != null) {
				x += 3;
				gc.drawImage(treeItem.getImage(colIndex), x, bounds.y);
				x += treeItem.getImageBounds(colIndex).width + 4;
			}
			else {
				x += 5;
			}

			String text = treeItem.getText(colIndex);
			if (text != null) {
				Point textExtent = gc.textExtent(text);
				gc.drawString(text, x, bounds.y
						+ (bounds.height - textExtent.y) / 2, true);
			}

			return true;
		}

		else {
			return false;
		}
	}

	private boolean renderTableCell(Event event) {
		FlagSupport detail = new FlagSupport(event.detail);
		GC gc = event.gc;
		TableItem tableItem = (TableItem) event.item;
		int colIndex = event.index;

		if (detail.isTrue(SWT.SELECTED)) {
			if (this.currentFocusCell != null
					&& this.currentFocusCell.getItem() == tableItem) {
				if (colIndex == this.currentFocusCell.getColumnIndex()) {
					gc.setForeground(ColorConstants.menuForegroundSelected);
					gc.setBackground(getSelectedCellColor());
				}
				else {
					gc.setForeground(this.viewer.getControl().getForeground());
					gc.setBackground(getSelectedRowColor());

				}
			}
			else {
				gc.setForeground(this.viewer.getControl().getForeground());
				gc.setBackground(getSelectedRowColor());
			}
			Rectangle bounds = tableItem.getBounds(colIndex);
			int x = bounds.x;
			gc.fillRectangle(event.x, event.y, event.width, event.height);
			if (tableItem.getImage(colIndex) != null) {
				x += 3;
				gc.drawImage(tableItem.getImage(colIndex), x, bounds.y);
				x += tableItem.getImageBounds(colIndex).width + 4;
			}
			else {
				x += 5;
			}

			String text = tableItem.getText(colIndex);
			if (text != null) {
				Point textExtent = gc.textExtent(text);
				gc.drawString(text, x, bounds.y
						+ (bounds.height - textExtent.y) / 2, true);
			}

			return true;
		}

		else {
			return false;
		}
	}
}