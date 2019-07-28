package br.com.acme.gui;

import br.com.acme.AcademicLibrary;
import br.com.acme.User;
import br.com.acme.logic.ALManager;
import br.com.acme.logic.LastAcess;
import com.sun.glass.events.KeyEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Vinicios, gabid
 */
public class LoginForm extends javax.swing.JDialog {

    static AcademicLibrary library = null;

    /**
     * Creates new form LoginForm
     */
    public LoginForm() {
        try {
            String lastUsed = LastAcess.loadAcess();
            ALManager.loadLibrary(lastUsed);
            library = ALManager.getInstance();
        } catch (IOException | ClassNotFoundException ex) {
            if (library.log) {
                ALManager.addToLog(ex.toString());
            }
        }
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jfcSelection = new javax.swing.JFileChooser();
        jbValidate = new javax.swing.JButton();
        jbCancel = new javax.swing.JButton();
        jlAcadLibSystem = new javax.swing.JLabel();
        jlLoginAc = new javax.swing.JLabel();
        jlPass = new javax.swing.JLabel();
        jtfLogin = new javax.swing.JTextField();
        jpfPassword = new javax.swing.JPasswordField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jmiNew = new javax.swing.JMenuItem();
        jmiOpen = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login");

        jbValidate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/jb/accept.png"))); // NOI18N
        jbValidate.setText("Validate");
        jbValidate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbValidateActionPerformed(evt);
            }
        });

        jbCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/jb/cross.png"))); // NOI18N
        jbCancel.setText("Cancel");
        jbCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelActionPerformed(evt);
            }
        });

        jlAcadLibSystem.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jlAcadLibSystem.setText("Academic Library Control System");

        jlLoginAc.setText("Login:");

        jlPass.setText("Password:");

        jpfPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jpfPasswordKeyPressed(evt);
            }
        });

        jMenu2.setText("Library");

        jmiNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/jmb/file/page_white.png"))); // NOI18N
        jmiNew.setText("Add");
        jmiNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiNewActionPerformed(evt);
            }
        });
        jMenu2.add(jmiNew);

        jmiOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/jtb/folder.png"))); // NOI18N
        jmiOpen.setText("Open");
        jmiOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiOpenActionPerformed(evt);
            }
        });
        jMenu2.add(jmiOpen);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlPass, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlLoginAc, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jpfPassword)
                            .addComponent(jtfLogin)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jlAcadLibSystem, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jbValidate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jlAcadLibSystem)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlLoginAc)
                    .addComponent(jtfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlPass)
                    .addComponent(jpfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbValidate)
                    .addComponent(jbCancel))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jpfPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpfPasswordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jbValidateActionPerformed(null);
        }
    }//GEN-LAST:event_jpfPasswordKeyPressed

    private void jmiOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiOpenActionPerformed
        // Abre o arquivo que o usuário selecionar.
        int result = jfcSelection.showOpenDialog(this);

        if (result == JFileChooser.CANCEL_OPTION) {
            return;
        }
        File file = jfcSelection.getSelectedFile();
        try {
            ALManager.loadLibrary(file.getAbsolutePath());
            library = ALManager.getInstance();
        } catch (IOException | ClassNotFoundException ex) {
            if (library.log) {
                ALManager.addToLog(ex.toString());
            }
        }
    }//GEN-LAST:event_jmiOpenActionPerformed

    private void jmiNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiNewActionPerformed
        // Cria uma nova library.
        NewLibraryForm nlf = new NewLibraryForm(null, rootPaneCheckingEnabled);
        nlf.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jmiNewActionPerformed

    private void jbValidateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbValidateActionPerformed
        // Vai verificar se o usuário e sua senha estão de acordo com o login.
        String pass = new String(jpfPassword.getPassword());

        if (pass.trim().matches("[0-9]+")) {
            validateUser();
        } else if (pass.trim().isEmpty()) {
            GUIMessage.error("Fill up the passoword field!   ");
        } else {
            GUIMessage.error("The password contains only NUMBERS!    ");
        }
    }//GEN-LAST:event_jbValidateActionPerformed

    private void jbCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelActionPerformed
        int result = GUIMessage.question("Do you really want to close the application?");
        if (result == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jbCancelActionPerformed

    /**
     * Valida o user e abre a tela principal do programa.
     */
    private void validateUser() {
        updateLibrary();
        String login = jtfLogin.getText();
        String password = new String(jpfPassword.getPassword());
        int senha = Integer.parseInt(password.trim());
        User usr = new User();
        usr.setLogin(login);
        usr.setPassword(senha);
        boolean result = library.validateUser(login, senha);
        if (result) {
            MainWindowForm form = new MainWindowForm(this, usr);
            form.setVisible(true);
            this.setVisible(false);
        } else {
            GUIMessage.inf("Invalid User!");
        }
    }

    /**
     * Atualiza a library, evitando escapes de erros.
     */
    public static void updateLibrary() {
        library = ALManager.getInstance();
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginForm dialog = new LoginForm();
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton jbCancel;
    private javax.swing.JButton jbValidate;
    private javax.swing.JFileChooser jfcSelection;
    private javax.swing.JLabel jlAcadLibSystem;
    private javax.swing.JLabel jlLoginAc;
    private javax.swing.JLabel jlPass;
    private javax.swing.JMenuItem jmiNew;
    private javax.swing.JMenuItem jmiOpen;
    private javax.swing.JPasswordField jpfPassword;
    private javax.swing.JTextField jtfLogin;
    // End of variables declaration//GEN-END:variables
}