/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.scratchfiles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "File",
        id = "org.netbeans.scratchfiles.ScratchFiles"
)
@ActionRegistration(
        displayName = "#CTL_ScratchFiles",
        iconInMenu = true,
        iconBase = "org/netbeans/scratchfiles/newFile.png"
)
@ActionReferences({
    @ActionReference(path = "Menu/File", position = 300),
    @ActionReference(path = "Shortcuts", name = "DO-N")
})
@Messages("CTL_ScratchFiles=New Scratch File...")
public final class ScratchFiles implements ActionListener {

    ScratchFilesFrame scratchFilesFrame;
    ScratchDialog dlg;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (dlg == null) {
            scratchFilesFrame = new ScratchFilesFrame();
            dlg = new ScratchDialog(scratchFilesFrame, "New Scratch File");
            dlg.add(scratchFilesFrame.scratchPanel);
            dlg.setSize(608, 533);
            dlg.setLocationRelativeTo(null);
        }
        dlg.setVisible(true);
    }
}
