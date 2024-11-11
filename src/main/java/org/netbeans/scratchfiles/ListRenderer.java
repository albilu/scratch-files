package org.netbeans.scratchfiles;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JList;
import org.openide.util.Pair;

/**
 *
 * @author bilu
 */
public class ListRenderer extends DefaultListCellRenderer {

	private static final long serialVersionUID = 1L;

	@Override
	public Component getListCellRendererComponent(
			JList<?> list, Object value, int index,
			boolean isSelected, boolean cellHasFocus) {

		JLabel label = (JLabel) super.getListCellRendererComponent(
				list, value, index, isSelected, cellHasFocus);
		label.setIcon((Icon) ((Pair) value).first());
		label.setText((String) ((Pair) value).second());
		label.setHorizontalTextPosition(JLabel.RIGHT);
		return label;
	}
}
