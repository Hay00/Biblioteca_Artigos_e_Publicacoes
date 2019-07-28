package br.com.acme.gui;

import br.com.acme.AcademicLibrary;
import br.com.acme.Article;
import br.com.acme.Author;
import br.com.acme.Journal;
import br.com.acme.logic.ALManager;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vinicios, gabid
 */
public class SearchArticlesForm extends javax.swing.JDialog {

    /**
     * Creates new form SearchArticlesForm
     */
    private AcademicLibrary library;

    public SearchArticlesForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        library = ALManager.getInstance();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jtArticlesSearched = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jtfSearchBar = new javax.swing.JTextField();
        jcbSearchOptions = new javax.swing.JComboBox<>();
        jbSearch = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jtArticlesSearched.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title", "Year", "Volume", "Language", "ISSN", "Start page", "End page", "Journal", "Impact Factor", "Publisher", "Country"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Short.class, java.lang.Byte.class, java.lang.String.class, java.lang.Long.class, java.lang.Short.class, java.lang.Short.class, java.lang.String.class, java.lang.Byte.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtArticlesSearched);

        jLabel1.setText("Find Article:");

        jtfSearchBar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfSearchBarKeyPressed(evt);
            }
        });

        jcbSearchOptions.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Title", "ISSN" }));

        jbSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/jmb/publications/search.png"))); // NOI18N
        jbSearch.setText("Search");
        jbSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSearchActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("Search Articles");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfSearchBar)
                                .addGap(18, 18, 18)
                                .addComponent(jcbSearchOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(420, 420, 420)
                        .addComponent(jLabel2)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfSearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbSearchOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSearch))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSearchActionPerformed
        if (jtfSearchBar.getText().trim().isEmpty()) {
            DefaultTableModel model = (DefaultTableModel) jtArticlesSearched.getModel();
            model.setRowCount(0);
        } else {
            if (jcbSearchOptions.getSelectedIndex() == 0) {
                // Busca pelo Title.

                String findThis = jtfSearchBar.getText();
                populateTable(library.findArticle(findThis));
            } else if (jcbSearchOptions.getSelectedIndex() == 1 && jtfSearchBar.getText().trim().matches("[0-9]+")) {
                // Busca pelo ISSN

                DefaultTableModel model = (DefaultTableModel) jtArticlesSearched.getModel();
                Long is = Long.parseLong(jtfSearchBar.getText());
                Article a = library.findArticle(is);

                if (a != null) {
                    // Se encontrou algo

                    model.setRowCount(0);

                    String authorName = "";
                    for (Author aut : a.getAuthors()) {
                        authorName = authorName + aut.getName();
                    }

                    ArrayList<String> keyWords = a.getKeyWords();
                    String s = "";
                    for (String k : keyWords) {
                        s = s + k + ", ";
                    }
                    Journal j = a.getJournal();

                    // Joga os dados na tabela.
                    model.addRow(new Object[]{a.getTitle(), authorName, a.getYear(), a.getVolume(),
                        keyWords, a.getIssn(), a.getStartPage() + "-" + a.getEndPage(), j.getName(),
                        j.getImpactFactor(), j.getPublisher().getName(), j.getPublisher().getCountry()});
                } else {
                    // Se não encontrou nada é limpado a tela.
                    model.setRowCount(0);
                }
            }
        }
    }//GEN-LAST:event_jbSearchActionPerformed

    private void jtfSearchBarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfSearchBarKeyPressed
        // Atalho para pesquisar usando o ENTER na jtfSearchBar.
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jbSearchActionPerformed(null);
        }
    }//GEN-LAST:event_jtfSearchBarKeyPressed

    /**
     * Coloca as informações na tabela dependendo da pesquisa do usuário.
     *
     * @param articlesFound articles que foram encontrados.
     */
    private void populateTable(ArrayList<Article> articlesFound) {
        DefaultTableModel model = (DefaultTableModel) jtArticlesSearched.getModel();
        model.setRowCount(0);

        for (Article a : articlesFound) {
            String authorName = "";
            for (Author aut : a.getAuthors()) {
                authorName = authorName + aut.getName();
            }

            ArrayList<String> keyWords = a.getKeyWords();
            String s = "";
            for (String k : keyWords) {
                s = s + k + ", ";
            }
            Journal j = a.getJournal();

            // Joga os dados na tabela.
            model.addRow(new Object[]{a.getTitle(), authorName, a.getYear(), a.getVolume(),
                keyWords, a.getIssn(), a.getStartPage() + "-" + a.getEndPage(), a.getJournal().getName(),
                j.getImpactFactor(), j.getPublisher().getName(), j.getPublisher().getCountry()});

        }
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
            java.util.logging.Logger.getLogger(SearchArticlesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchArticlesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchArticlesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchArticlesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SearchArticlesForm dialog = new SearchArticlesForm(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbSearch;
    private javax.swing.JComboBox<String> jcbSearchOptions;
    private javax.swing.JTable jtArticlesSearched;
    private javax.swing.JTextField jtfSearchBar;
    // End of variables declaration//GEN-END:variables
}
