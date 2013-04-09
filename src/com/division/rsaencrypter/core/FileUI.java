package com.division.rsaencrypter.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Evan
 */
public class FileUI extends javax.swing.JFrame {

    private File sourceFile;
    private File destinationFile;
    private UI parent;

    /**
     * Creates new form FileUI
     */
    public FileUI() {
        initComponents();
    }

    public FileUI(UI parent) {
        initComponents();
        this.parent = parent;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        srcLbl = new javax.swing.JLabel();
        txtEncrypterBtn = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        browseSrc = new javax.swing.JButton();
        destLbl = new javax.swing.JLabel();
        browseDest = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        encryptBtn = new javax.swing.JButton();
        decryptBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Encrypt a file.");

        srcLbl.setText("Source File:");

        txtEncrypterBtn.setText("Switch to Text");
        txtEncrypterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEncrypterBtnActionPerformed(evt);
            }
        });

        browseSrc.setText("Browse For Source File");
        browseSrc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseSrcActionPerformed(evt);
            }
        });

        destLbl.setText("Destination File: ");

        browseDest.setText("Browse For Destination File");
        browseDest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseDestActionPerformed(evt);
            }
        });

        encryptBtn.setText("Encrypt");
        encryptBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encryptBtnActionPerformed(evt);
            }
        });

        decryptBtn.setText("Decrypt");
        decryptBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decryptBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(encryptBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(decryptBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jTextField2)
                    .addComponent(jTextField1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(srcLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                        .addComponent(browseSrc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEncrypterBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(destLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(browseDest)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(srcLbl)
                    .addComponent(txtEncrypterBtn)
                    .addComponent(browseSrc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(destLbl)
                    .addComponent(browseDest))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(encryptBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                    .addComponent(decryptBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void browseSrcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseSrcActionPerformed
        JFileChooser browser = new JFileChooser();
        int returnVal = browser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            jTextField1.setText(browser.getSelectedFile().getAbsolutePath());
            sourceFile = browser.getSelectedFile();
        }
    }//GEN-LAST:event_browseSrcActionPerformed

    private void browseDestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseDestActionPerformed
        JFileChooser browser = new JFileChooser();
        int returnVal = browser.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            if (browser.getSelectedFile().exists()) {
                int confirm = JOptionPane.showConfirmDialog(this, "The file " + browser.getSelectedFile().getName() + " already exists. Do you want to overwrite this file?", "Overwrite?", JOptionPane.YES_NO_OPTION);
                if (confirm != JOptionPane.YES_OPTION) {
                    //Hacky way to get the dialog to reappear.
                    browseDest.doClick();
                    return;
                }
            }
            jTextField2.setText(browser.getSelectedFile().getAbsolutePath());
            destinationFile = browser.getSelectedFile();
        }

    }//GEN-LAST:event_browseDestActionPerformed

    private void encryptBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encryptBtnActionPerformed
        if (sourceFile != null && destinationFile != null) {
            String source = loadFile(sourceFile);
            if (source == null) {
                JOptionPane.showMessageDialog(this, "The source file contains no data.");
                return;
            }
            String output = "";
            PublicKey publicKey = null;
            try {
                publicKey = RSAFileIO.load(parent.getRSADir());
            } catch (Exception ex) {
            }
            if (source.length() > 245) {
                int buffer = 0;
                try {
                    while (buffer < source.length()) {
                        int next = buffer + 245;
                        if (next > source.length()) {
                            next = source.length();
                        }
                        String subSource = source.substring(buffer, next);
                        byte[] bytes = RSA.encrypt(subSource.getBytes(), publicKey);
                        output += DatatypeConverter.printBase64Binary(bytes);
                        buffer += 245;
                    }
                } catch (Exception ex) {
                }
            } else {
                try {
                    output = DatatypeConverter.printBase64Binary(RSA.encrypt(source.getBytes(), publicKey));
                } catch (Exception ex) {
                }
            }
            try {
                if (!destinationFile.exists()) {
                    destinationFile.createNewFile();
                }
                FileOutputStream fos = new FileOutputStream(destinationFile);
                fos.write(output.getBytes());
            } catch (Exception ex) {
            }
        }
        JOptionPane.showMessageDialog(this, "File: " + sourceFile.getName() + " has been encrypted.", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_encryptBtnActionPerformed

    private void decryptBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decryptBtnActionPerformed
        if (sourceFile != null && destinationFile != null) {
            String source = loadFile(sourceFile);
            if (source == null) {
                JOptionPane.showMessageDialog(this, "The source file contains no data.");
                return;
            }
            String output = "";
            PrivateKey privateKey = null;
            try {
                privateKey = RSAFileIO.loadPrivateKey(parent.getRSADir());
            } catch (Exception ex) {
                Logger.getLogger(FileUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (source.getBytes().length > 256) {
                try {
                    byte[] sourceBytes = DatatypeConverter.parseBase64Binary(source);
                    int byteBuffer = 0;
                    while (byteBuffer < sourceBytes.length) {
                        byte[] trim = new byte[256];
                        System.arraycopy(sourceBytes, byteBuffer, trim, 0, 256);
                        byte[] bytes = RSA.decrypt(trim, privateKey);
                        output += readString(bytes, 0);
                        byteBuffer += 256;
                    }
                } catch (Exception ex) {
                }
            } else {
                try {
                    output = readString(RSA.decrypt(source.getBytes(), privateKey), 0);
                } catch (Exception ex) {
                }
            }
            try {
                if (!destinationFile.exists()) {
                    destinationFile.createNewFile();
                }
                FileOutputStream fos = new FileOutputStream(destinationFile);
                fos.write(output.getBytes());
            } catch (Exception ex) {
            }
        }
        JOptionPane.showMessageDialog(this, "File: " + sourceFile.getName() + " has been decrypted.", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_decryptBtnActionPerformed

    private void txtEncrypterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEncrypterBtnActionPerformed
        parent.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_txtEncrypterBtnActionPerformed

    private String readString(byte[] data, int offset) {
        StringBuilder builder = new StringBuilder();
        for (int i = offset; i < data.length; i++) {
            builder.append((char) data[i]);
        }
        return builder.toString();
    }

    private String loadFile(File file) {
        String output = "";
        try {
            FileInputStream fis = new FileInputStream(file);
            byte[] bytesRec = new byte[256];
            int byteIn;
            while ((byteIn = fis.read(bytesRec, 0, bytesRec.length)) != -1) {
                output += new String(bytesRec, 0, byteIn);
            }
        } catch (Exception ex) {
            Logger.getLogger(FileUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FileUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FileUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FileUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FileUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FileUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseDest;
    private javax.swing.JButton browseSrc;
    private javax.swing.JButton decryptBtn;
    private javax.swing.JLabel destLbl;
    private javax.swing.JButton encryptBtn;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel srcLbl;
    private javax.swing.JButton txtEncrypterBtn;
    // End of variables declaration//GEN-END:variables
}