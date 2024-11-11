package org.netbeans.scratchfiles;

import java.awt.Image;
import java.awt.Toolkit;
import java.beans.BeanInfo;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.JFrame;
import org.netbeans.api.actions.Openable;
import org.netbeans.api.project.FileOwnerQuery;
import org.netbeans.api.project.Project;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.loaders.DataObject;
import org.openide.loaders.DataObjectNotFoundException;
import org.openide.util.Exceptions;
import org.openide.util.ImageUtilities;
import org.openide.util.Pair;
import org.openide.windows.TopComponent;

/**
 *
 * @author bilu
 */
public class ScratchFilesFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    File scratchDirFiles = new File(System.getProperty("netbeans.user")
            + File.separator + "ScratchFiles");
    File scratchDirConf = new File(System.getProperty("netbeans.user")
            + File.separator + ".scratchfilesconf");

    /**
     * Creates new form ScratchFileFrame
     */
    public ScratchFilesFrame() {
        initComponents();
        setWindowsBehaviour();
        if (!scratchDirConf.exists()) {
            scratchDirConf.mkdirs();
        }
        getMimeTypes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scratchPanel = new javax.swing.JPanel();
        fileNameTextField = new javax.swing.JTextField();
        fileNameLabel = new javax.swing.JLabel();
        extensionsScrollPane = new javax.swing.JScrollPane();
        extensionsList = new javax.swing.JList<>();
        extensionsLabel = new javax.swing.JLabel();
        projectCheckBox = new javax.swing.JCheckBox();
        tempCheckBox = new javax.swing.JCheckBox();
        locationLabel = new javax.swing.JLabel();
        locationTextField = new javax.swing.JTextField();
        cancelButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(ScratchFilesFrame.class, "ScratchFilesFrame.title")); // NOI18N
        setAlwaysOnTop(true);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("frame-icon.png")));
        setMinimumSize(new java.awt.Dimension(608, 533));
        setResizable(false);

        fileNameTextField.setText(org.openide.util.NbBundle.getMessage(ScratchFilesFrame.class, "ScratchFilesFrame.fileNameTextField.text")); // NOI18N
        fileNameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fileNameTextFieldKeyReleased(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(fileNameLabel, org.openide.util.NbBundle.getMessage(ScratchFilesFrame.class, "ScratchFilesFrame.fileNameLabel.text")); // NOI18N

        extensionsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        extensionsScrollPane.setViewportView(extensionsList);

        org.openide.awt.Mnemonics.setLocalizedText(extensionsLabel, org.openide.util.NbBundle.getMessage(ScratchFilesFrame.class, "ScratchFilesFrame.extensionsLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(projectCheckBox, org.openide.util.NbBundle.getMessage(ScratchFilesFrame.class, "ScratchFilesFrame.projectCheckBox.text")); // NOI18N
        projectCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectCheckBoxActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(tempCheckBox, org.openide.util.NbBundle.getMessage(ScratchFilesFrame.class, "ScratchFilesFrame.tempCheckBox.text")); // NOI18N
        tempCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tempCheckBoxActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(locationLabel, org.openide.util.NbBundle.getMessage(ScratchFilesFrame.class, "ScratchFilesFrame.locationLabel.text")); // NOI18N

        locationTextField.setEditable(false);
        locationTextField.setText(org.openide.util.NbBundle.getMessage(ScratchFilesFrame.class, "ScratchFilesFrame.locationTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(cancelButton, org.openide.util.NbBundle.getMessage(ScratchFilesFrame.class, "ScratchFilesFrame.cancelButton.text")); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(okButton, org.openide.util.NbBundle.getMessage(ScratchFilesFrame.class, "ScratchFilesFrame.okButton.text")); // NOI18N
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout scratchPanelLayout = new javax.swing.GroupLayout(scratchPanel);
        scratchPanel.setLayout(scratchPanelLayout);
        scratchPanelLayout.setHorizontalGroup(
            scratchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scratchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(scratchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fileNameTextField)
                    .addComponent(extensionsScrollPane)
                    .addGroup(scratchPanelLayout.createSequentialGroup()
                        .addGroup(scratchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(extensionsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(scratchPanelLayout.createSequentialGroup()
                                .addComponent(projectCheckBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tempCheckBox))
                            .addComponent(locationLabel)
                            .addComponent(fileNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 265, Short.MAX_VALUE))
                    .addComponent(locationTextField)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, scratchPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(okButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton)))
                .addContainerGap())
        );
        scratchPanelLayout.setVerticalGroup(
            scratchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scratchPanelLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(fileNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fileNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(extensionsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(extensionsScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(scratchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(projectCheckBox)
                    .addComponent(tempCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(locationLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(locationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(scratchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(okButton))
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 608, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scratchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 533, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scratchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fileNameTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fileNameTextFieldKeyReleased
        extensionsList.setSelectedValue(null, true);
        String filter = fileNameTextField.getText();
        filterModel((DefaultListModel) extensionsList.getModel(), filter);

    }//GEN-LAST:event_fileNameTextFieldKeyReleased

    private void projectCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectCheckBoxActionPerformed
        if (projectCheckBox.isSelected()) {
            tempCheckBox.setSelected(false);
            getCurrentContext();
        }
    }//GEN-LAST:event_projectCheckBoxActionPerformed

    private void tempCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tempCheckBoxActionPerformed
        if (tempCheckBox.isSelected()) {
            projectCheckBox.setSelected(false);
            locationTextField.setText(scratchDirFiles.getPath() + File.separator);
        }
    }//GEN-LAST:event_tempCheckBoxActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        create();
    }//GEN-LAST:event_okButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel extensionsLabel;
    private javax.swing.JList<String> extensionsList;
    private javax.swing.JScrollPane extensionsScrollPane;
    private javax.swing.JLabel fileNameLabel;
    private javax.swing.JTextField fileNameTextField;
    private javax.swing.JLabel locationLabel;
    private javax.swing.JTextField locationTextField;
    private javax.swing.JButton okButton;
    private javax.swing.JCheckBox projectCheckBox;
    public javax.swing.JPanel scratchPanel;
    private javax.swing.JCheckBox tempCheckBox;
    // End of variables declaration//GEN-END:variables

    private void getMimeTypes() {
        DefaultListModel listModel = new DefaultListModel();
        List<String> mimeTypes = MimeTypeQueryImpl.getMimeTypes();
        mimeTypes.forEach(mimeType -> {
            try {
                File tmpFile = new File(scratchDirConf + File.separator + "tmp."
                        + mimeType);
                if (!tmpFile.exists()) {
                    tmpFile.createNewFile();
                }
                try {
                    DataObject dataObject = DataObject.find(FileUtil.toFileObject(tmpFile));
                    Image icon = dataObject.getNodeDelegate().getIcon(BeanInfo.ICON_COLOR_16x16);
                    listModel.addElement(Pair.of(ImageUtilities.image2Icon(icon), mimeType));
                    list.add(Pair.of(ImageUtilities.image2Icon(icon), mimeType));

                } catch (DataObjectNotFoundException ex) {
                    Exceptions.printStackTrace(ex);
                }
            } catch (DataObjectNotFoundException ex) {
                Exceptions.printStackTrace(ex);
            } catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            }
        });
        extensionsList.setModel(listModel);
    }

    List<Pair<Icon, String>> list = new ArrayList<>();

    public void filterModel(DefaultListModel<Pair<Icon, String>> model, String filter) {

        list.forEach(s -> {
            String rowText = s.second();
            Icon icon = s.first();
            if (!rowText.startsWith(filter)) {
                if (model.contains(Pair.of(icon, rowText))) {
                    model.removeElement(Pair.of(icon, rowText));
                }
            } else {
                if (!model.contains(Pair.of(icon, rowText))) {
                    model.addElement(Pair.of(icon, rowText));
                }
            }
            if (rowText.equals(filter)) {
                extensionsList.setSelectedValue(s, true);
            }
        });

    }

    public void getCurrentContext() {
        TopComponent activated = TopComponent.getRegistry().getActivated();
        if (activated != null) {
            Project p = activated.getLookup().lookup(Project.class);
            if (p == null) {
                DataObject dob = activated.getLookup().lookup(DataObject.class);
                if (dob != null) {
                    projectCheckBox.setEnabled(true);
                    projectCheckBox.setSelected(true);
                    tempCheckBox.setSelected(false);
                    FileObject fo = dob.getPrimaryFile();
                    if (!fo.isFolder()) {
                        String parentPath = fo.getParent().getPath();
                        locationTextField.setText(parentPath + File.separator);
                        return;
                    } else if (fo.isFolder()) {
                        String parentPath = fo.getPath();
                        locationTextField.setText(parentPath + File.separator);
                        return;
                    }
                    p = FileOwnerQuery.getOwner(fo);
                    locationTextField.setText(p.getProjectDirectory().getPath() + File.separator);
                } else {
                    projectCheckBox.setEnabled(false);
                    tempCheckBox.setSelected(true);
                    locationTextField.setText(scratchDirFiles.getPath() + File.separator);

                }

            } else {
                locationTextField.setText(p.getProjectDirectory().getPath() + File.separator);
            }
        } else {
            projectCheckBox.setEnabled(false);
            tempCheckBox.setSelected(true);
            locationTextField.setText(scratchDirFiles.getPath() + File.separator);
        }
    }

    public void create() {
        Object selected = extensionsList.getSelectedValue();
        String text = fileNameTextField.getText();
        String[] split = text.split("\\.");
        if (selected != null) {
            Object ext = ((Pair) selected).second();
            if (!((String) ext).isEmpty()) {
                Date now = new Date();
                String timestamp = new SimpleDateFormat("HHmmss", Locale.ROOT).format(now);
                commit("tmp_" + timestamp, (String) ext);
            }
        } else if (text.contains(".") && split[1] != null) {
            commit(split[0], split[1]);
        } else if (!text.isEmpty()) {
            commit(text, "");
        }
    }

    private void commit(String filename, String extension) {
        File extFolder = null;
        String location = locationTextField.getText();
        if (!location.isEmpty()) {
            if (location.equals(scratchDirFiles.getPath() + File.separator)) {
                extFolder = new File(location + (!extension.isEmpty()
                        ? File.separator + extension.toUpperCase() : ""));
                if (!extFolder.exists()) {
                    extFolder.mkdirs();
                }
            } else {
                extFolder = new File(location);
            }

            File scratchFile = new File(extFolder.getPath() + File.separator + filename + (!extension.isEmpty() ? "."
                    + extension : ""));
            if (!scratchFile.exists()) {
                try {
                    scratchFile.createNewFile();
                } catch (IOException ex) {
                    Exceptions.printStackTrace(ex);
                }
            }
            dispose();
            try {
                DataObject.find(FileUtil.toFileObject(scratchFile)).getLookup()
                        .lookup(Openable.class).open();
            } catch (DataObjectNotFoundException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
    }

    private void setWindowsBehaviour() {
        extensionsList.setCellRenderer(new ListRenderer());
    }

}