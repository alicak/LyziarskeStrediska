package sk.upjs.ics.paz.gui;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import sk.upjs.ics.paz.dao.Factory;
import sk.upjs.ics.paz.dao.FiltreDao;
import sk.upjs.ics.paz.entity.Filter;
import sk.upjs.ics.paz.entity.Pouzivatel;

public class SpravaFiltrovForm extends javax.swing.JFrame {

    FiltreListAndComboBoxModel filtreListAndComboBoxModel = new FiltreListAndComboBoxModel();
    FiltreDao filtreDao = Factory.INSTANCE.getFiltreDao();
    Pouzivatel pouzivatel = Factory.INSTANCE.getPouzivatel();

    /**
     * Creates new form SpravaFiltrovForm
     */
    public SpravaFiltrovForm() {
        initComponents();
        aktualizujZoznamFiltrov();

        // zaktivuje tlacitko pre prihlaseneho pouzivatela
        if (pouzivatel != null) {
            btnPridajNovy.setEnabled(true);
        }

        lstZoznamFiltrov.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            // pri zmene (vybratie/nevybratie strediska) aktivuje/deaktivuje tlacitka
            public void valueChanged(ListSelectionEvent e) {
                lstZoznamFiltrovSelectionValueChanged(e);
            }
        });
    }

    private void lstZoznamFiltrovSelectionValueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            if (!lstZoznamFiltrov.getSelectionModel().isSelectionEmpty()) {
                // zobrazit detail moze kazdy
                btnZobrazDetail.setEnabled(true);
                if (pouzivatel != null) {
                    // ale upravovat data len prihlaseny uzivatel
                    btnUprav.setEnabled(true);
                    btnOdstran.setEnabled(true);
                }
            } else {
                btnZobrazDetail.setEnabled(false);
                btnUprav.setEnabled(false);
                btnOdstran.setEnabled(false);
            }
        }
    }

    private void aktualizujZoznamFiltrov() {
        filtreListAndComboBoxModel.obnov();
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
        lstZoznamFiltrov = new javax.swing.JList();
        btnZobrazDetail = new javax.swing.JButton();
        btnPridajNovy = new javax.swing.JButton();
        btnUprav = new javax.swing.JButton();
        btnOdstran = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        lstZoznamFiltrov.setModel(filtreListAndComboBoxModel);
        lstZoznamFiltrov.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstZoznamFiltrovMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lstZoznamFiltrov);

        btnZobrazDetail.setText("Zobraz detail...");
        btnZobrazDetail.setEnabled(false);
        btnZobrazDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZobrazDetailActionPerformed(evt);
            }
        });

        btnPridajNovy.setText("Pridaj nový...");
        btnPridajNovy.setEnabled(false);
        btnPridajNovy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPridajNovyActionPerformed(evt);
            }
        });

        btnUprav.setText("Uprav...");
        btnUprav.setEnabled(false);
        btnUprav.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpravActionPerformed(evt);
            }
        });

        btnOdstran.setText("Odstráň...");
        btnOdstran.setEnabled(false);
        btnOdstran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdstranActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnZobrazDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUprav, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOdstran, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPridajNovy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnZobrazDetail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUprav)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOdstran)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPridajNovy))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Otvori modalne okno s detailami vybraneho filtra
     *
     * @param evt
     */
    private void btnZobrazDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZobrazDetailActionPerformed
        Filter vybranyFilter = dajVybranyFilter();
        ZobrazDetailFiltraForm zobrazDetailFiltraForm = new ZobrazDetailFiltraForm(this, vybranyFilter);
        zobrazDetailFiltraForm.setVisible(true);
    }//GEN-LAST:event_btnZobrazDetailActionPerformed

    /**
     * Otvori modalne okno pre upravu vybraneho filtra
     *
     * @param evt
     */
    private void btnUpravActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpravActionPerformed
        Filter vybranyFilter = dajVybranyFilter();
        PridajUpravFilterForm pridajUpravFilterForm = new PridajUpravFilterForm(this, vybranyFilter);
        pridajUpravFilterForm.setVisible(true);
    }//GEN-LAST:event_btnUpravActionPerformed

    /**
     * Odstrani vybrany filter
     *
     * @param evt
     */
    private void btnOdstranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdstranActionPerformed
        Filter vybranyFilter = dajVybranyFilter();

        int tlacidlo = JOptionPane.showConfirmDialog(
                this,
                "Naozaj chcete odstrániť vybraný filter?",
                "Odstrániť filter",
                JOptionPane.YES_NO_OPTION
        );

        if (tlacidlo == JOptionPane.YES_OPTION) {
            filtreDao.odstran(vybranyFilter);
            aktualizujZoznamFiltrov();
        }
    }//GEN-LAST:event_btnOdstranActionPerformed

    /**
     * Otvori modalne okno pre pridanie noveho filtra
     *
     * @param evt
     */
    private void btnPridajNovyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPridajNovyActionPerformed
        PridajUpravFilterForm pridajUpravFilterForm = new PridajUpravFilterForm(this);
        pridajUpravFilterForm.setVisible(true);
        aktualizujZoznamFiltrov();
    }//GEN-LAST:event_btnPridajNovyActionPerformed

    /**
     * Pri dvojkliku na filter v tabulke sa zobrazi jeho detail
     *
     * @param evt
     */
    private void lstZoznamFiltrovMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstZoznamFiltrovMouseClicked
        if (evt.getClickCount() == 2) {
            btnZobrazDetail.doClick();
        }
    }//GEN-LAST:event_lstZoznamFiltrovMouseClicked

    /**
     * Vrati vybrany filter zo zoznamu
     *
     * @return
     */
    private Filter dajVybranyFilter() {
        int vybranyIndex = lstZoznamFiltrov.getSelectedIndex();
        return filtreDao.dajVsetky().get(vybranyIndex);
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
            java.util.logging.Logger.getLogger(SpravaFiltrovForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SpravaFiltrovForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SpravaFiltrovForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SpravaFiltrovForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SpravaFiltrovForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOdstran;
    private javax.swing.JButton btnPridajNovy;
    private javax.swing.JButton btnUprav;
    private javax.swing.JButton btnZobrazDetail;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lstZoznamFiltrov;
    // End of variables declaration//GEN-END:variables
}
