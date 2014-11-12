
package sk.upjs.ics.paz;

public class HlavnyForm extends javax.swing.JFrame {

    /**
     * Creates new form HlavnyForm
     */
    public HlavnyForm() {
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

        lblTagline = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        btnPridaj = new javax.swing.JButton();
        btnVyhladavaj = new javax.swing.JButton();
        btnNajdiNajblizsie = new javax.swing.JButton();
        btnOPrograme = new javax.swing.JButton();
        txtRychlyFilter = new javax.swing.JTextField();
        btnRychloFiltruj = new javax.swing.JButton();
        btnResetFiltra = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnZobrazDetail = new javax.swing.JButton();
        btnOdstran = new javax.swing.JButton();
        btnUprav = new javax.swing.JButton();
        lblRychlyFilter = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lyžiarske strediská");

        lblTagline.setText("miesto pre tagline");

        lblLogo.setText("miesto pre logo");

        btnPridaj.setText("Pridaj nové...");
        btnPridaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPridajActionPerformed(evt);
            }
        });

        btnVyhladavaj.setText("Vyhľadávaj...");
        btnVyhladavaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVyhladavajActionPerformed(evt);
            }
        });

        btnNajdiNajblizsie.setText("Nájdi najbližšie...");
        btnNajdiNajblizsie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNajdiNajblizsieActionPerformed(evt);
            }
        });

        btnOPrograme.setText("O programe...");
        btnOPrograme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOProgrameActionPerformed(evt);
            }
        });

        btnRychloFiltruj.setText("Filtruj");

        btnResetFiltra.setText("Reset");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnZobrazDetail.setText("Zobraz detail...");
        btnZobrazDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZobrazDetailActionPerformed(evt);
            }
        });

        btnOdstran.setText("Odstráň");
        btnOdstran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdstranActionPerformed(evt);
            }
        });

        btnUprav.setText("Uprav...");
        btnUprav.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpravActionPerformed(evt);
            }
        });

        lblRychlyFilter.setText("Rýchly filter:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblRychlyFilter)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRychlyFilter)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnRychloFiltruj)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnResetFiltra))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnOPrograme, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnOdstran, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnUprav, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnZobrazDetail, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnVyhladavaj, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnNajdiNajblizsie, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnPridaj, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(lblTagline, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                        .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTagline, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRychlyFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRychloFiltruj)
                    .addComponent(btnResetFiltra)
                    .addComponent(lblRychlyFilter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnZobrazDetail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUprav)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOdstran)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPridaj)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVyhladavaj)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNajdiNajblizsie))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOPrograme)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Otvori modalne okno s podrobnym vyhladavanim
     */
    private void btnVyhladavajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVyhladavajActionPerformed
        VyhladavajForm vyhladavajForm = new VyhladavajForm(this, true);
        vyhladavajForm.setVisible(true);
    }//GEN-LAST:event_btnVyhladavajActionPerformed

    /**
     * Otvori modalne okno s vyhladavanim najblizsieho strediska
     */
    private void btnNajdiNajblizsieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNajdiNajblizsieActionPerformed
        NajdiNajblizsieForm najdiNajblizsieForm = new NajdiNajblizsieForm(this, true);
        najdiNajblizsieForm.setVisible(true);
    }//GEN-LAST:event_btnNajdiNajblizsieActionPerformed

    /**
     * Otvori modalne okno pre pridanie noveho strediska
     */
    private void btnPridajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPridajActionPerformed
        PridajUpravStrediskoForm pridajUpravStrediskoForm = new PridajUpravStrediskoForm(this);
        pridajUpravStrediskoForm.setVisible(true);
    }//GEN-LAST:event_btnPridajActionPerformed

    /**
     * Otvori modalne okno s detailami vybraneho strediska
     */
    private void btnZobrazDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZobrazDetailActionPerformed
        ZobrazDetailForm zobrazDetailForm = new ZobrazDetailForm(this, true);
        zobrazDetailForm.setVisible(true);
    }//GEN-LAST:event_btnZobrazDetailActionPerformed

    /**
     * Otvori modalne okno pre upravu vybraneho strediska
     */
    private void btnUpravActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpravActionPerformed
        // TODO zistit z formulara, ktore stredisko bolo vybrane
        Stredisko vybraneStredisko = null;
        PridajUpravStrediskoForm pridajUpravStrediskoForm = new PridajUpravStrediskoForm(this, vybraneStredisko);
        pridajUpravStrediskoForm.setVisible(true);
    }//GEN-LAST:event_btnUpravActionPerformed

    /**
     * Odstrani vybrane stredisko, predtym si vypyta potvrdenie
     */
    private void btnOdstranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdstranActionPerformed
        // TODO vypytat si potvrdenie pre odstranenie teplakov, odstranit a zavriet okno
        // TODO zavriet okno, ak pouzivatel vybral "Storno"
    }//GEN-LAST:event_btnOdstranActionPerformed

    /**
     * Otvori okno s info o programe
     */
    private void btnOProgrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOProgrameActionPerformed
        OProgrameForm oProgrameForm = new OProgrameForm(this, true);
        oProgrameForm.setVisible(true);
    }//GEN-LAST:event_btnOProgrameActionPerformed

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
            java.util.logging.Logger.getLogger(HlavnyForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HlavnyForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HlavnyForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HlavnyForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HlavnyForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNajdiNajblizsie;
    private javax.swing.JButton btnOPrograme;
    private javax.swing.JButton btnOdstran;
    private javax.swing.JButton btnPridaj;
    private javax.swing.JButton btnResetFiltra;
    private javax.swing.JButton btnRychloFiltruj;
    private javax.swing.JButton btnUprav;
    private javax.swing.JButton btnVyhladavaj;
    private javax.swing.JButton btnZobrazDetail;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblRychlyFilter;
    private javax.swing.JLabel lblTagline;
    private javax.swing.JTextField txtRychlyFilter;
    // End of variables declaration//GEN-END:variables
}
