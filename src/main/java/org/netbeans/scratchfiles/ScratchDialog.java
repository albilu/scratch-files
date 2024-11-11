package org.netbeans.scratchfiles;

import java.awt.event.ActionEvent;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.KeyStroke;

/**
 *
 * @author bilu
 */
public class ScratchDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	public ScratchDialog(ScratchFilesFrame scratchFilesFrame, String dialogTitle) {
		super(scratchFilesFrame, dialogTitle);
		setRootDialogFrameBehaviour(scratchFilesFrame);
	}

	private void setRootDialogFrameBehaviour(ScratchFilesFrame scratchFilesFrame) {
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
				KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Close");
		getRootPane().getActionMap().put("Close", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
				KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Enter");
		getRootPane().getActionMap().put("Enter", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				scratchFilesFrame.create();
			}
		});
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent evt) {
				dispose();
			}
		});
		addComponentListener(new ComponentListener() {
			@Override
			public void componentResized(ComponentEvent e) {
			}

			@Override
			public void componentMoved(ComponentEvent e) {
			}

			@Override
			public void componentShown(ComponentEvent e) {
				scratchFilesFrame.getCurrentContext();
			}

			@Override
			public void componentHidden(ComponentEvent e) {
			}
		});
	}
}
