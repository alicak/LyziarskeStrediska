package sk.upjs.ics.paz.gui;

import sk.upjs.ics.paz.entity.Filter;

public class ZobrazDetailFiltraForm extends javax.swing.JDialog {

    /**
     * Creates new form ZobrazDetailFiltraForm
     */
    public ZobrazDetailFiltraForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public ZobrazDetailFiltraForm(java.awt.Frame parent, Filter filter) {
        this(parent, true);
        lblNazov.setText("Názov filtra: " + filter.getNazov());

        if (filter.getNazovObsahuje() != null) {
            lblNazovObsahuje.setText("Názov strediska obsahuje: " + filter.getNazov());
        } else {
            lblNazovObsahuje.setText("Názov strediska obsahuje: - ");
        }

        if (filter.getMinVyskaSnehu() != 0) {
            lblMinVyskaSnehu.setText("Minimálna výška snehu: " + filter.getMinVyskaSnehu());
        } else {
            lblMinVyskaSnehu.setText("Minimálna výška snehu: - ");
        }

        lblMinPodmienky.setText("Minimálne podmienky: " + filter.getMinPodmienky());

        if (filter.getMaxCenaListkaDospely() != null) {
            lblMaxCenaListkaDospely.setText("Dospelý: " + filter.getMaxCenaListkaDospely());
        } else {
            lblMaxCenaListkaDospely.setText("Dospelý: - ");
        }

        if (filter.getMaxCenaListkaDieta() != null) {
            lblMaxCenaListkaDieta.setText("Dieťa: " + filter.getMaxCenaListkaDieta());
        } else {
            lblMaxCenaListkaDieta.setText("Dieťa: - ");
        }

        if (filter.getMaxCenaListkaStudent() != null) {
            lblMaxCenaListkaStudent.setText("Študent: " + filter.getMaxCenaListkaStudent());
        } else {
            lblMaxCenaListkaStudent.setText("Študent: - ");
        }

        if (filter.getMinPocetVlekovVPrevadzke() != 0) {
            lblMinPocetVlekov.setText("Minimálny počet vlekov v prevádzke: " + filter.getMinPocetVlekovVPrevadzke());
        } else {
            lblMinPocetVlekov.setText("Minimálny počet vlekov v prevádzke: - ");
        }

        if (filter.getMinPocetLanoviekVPrevadzke() != 0) {
            lblMinPocetLanoviek.setText("Minimálny počet lanoviek v prevádzke: " + filter.getMinPocetLanoviekVPrevadzke());
        } else {
            lblMinPocetLanoviek.setText("Minimálny počet lanoviek v prevádzke: - ");
        }

        if (filter.getMinPocetTratiVPrevadzke() != 0) {
            lblMinPocetTrati.setText("Minimálny počet tratí v prevádzke: " + filter.getMinPocetTratiVPrevadzke());
        } else {
            lblMinPocetTrati.setText("Minimálny počet tratí v prevádzke: - ");
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblMaxCenyListkov = new javax.swing.JLabel();
        lblMaxCenaListkaDospely = new javax.swing.JLabel();
        lblMinPocetTrati = new javax.swing.JLabel();
        lblMinPocetLanoviek = new javax.swing.JLabel();
        lblMinPocetVlekov = new javax.swing.JLabel();
        lblMaxCenaListkaDieta = new javax.swing.JLabel();
        lblMaxCenaListkaStudent = new javax.swing.JLabel();
        lblMinPodmienky = new javax.swing.JLabel();
        lblNazovObsahuje = new javax.swing.JLabel();
        lblMinVyskaSnehu = new javax.swing.JLabel();
        lblNazov = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblMaxCenyListkov.setText("Maximálne ceny lístkov");

        lblMaxCenaListkaDospely.setText("Dospelý:");

        lblMinPocetTrati.setText("Minimálny počet tratí v prevádzke:");

        lblMinPocetLanoviek.setText("Minimálny počet lanoviek v prevádzke:");

        lblMinPocetVlekov.setText("Minimálny počet vlekov v prevádzke:");

        lblMaxCenaListkaDieta.setText("Dieťa:");

        lblMaxCenaListkaStudent.setText("Študent:");

        lblMinPodmienky.setText("Minimálne podmienky:");

        lblNazovObsahuje.setText("Názov strediska obsahuje:");

        lblMinVyskaSnehu.setText("Minimálna výška snehu:");

        lblNazov.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNazov.setText("Názov filtra:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblNazovObsahuje, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMinVyskaSnehu)
                            .addComponent(lblMinPodmienky)))
                    .addComponent(lblNazov)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblMinPocetVlekov)
                        .addComponent(lblMinPocetLanoviek)
                        .addComponent(lblMinPocetTrati))
                    .addComponent(lblMaxCenyListkov)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblMaxCenaListkaStudent, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblMaxCenaListkaDieta, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblMaxCenaListkaDospely, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNazov)
                .addGap(28, 28, 28)
                .addComponent(lblNazovObsahuje)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMinVyskaSnehu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMinPodmienky)
                .addGap(18, 18, 18)
                .addComponent(lblMaxCenyListkov)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMaxCenaListkaDospely)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMaxCenaListkaDieta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMaxCenaListkaStudent)
                .addGap(18, 18, 18)
                .addComponent(lblMinPocetVlekov)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMinPocetLanoviek)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMinPocetTrati)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ZobrazDetailFiltraForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ZobrazDetailFiltraForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ZobrazDetailFiltraForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ZobrazDetailFiltraForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ZobrazDetailFiltraForm dialog = new ZobrazDetailFiltraForm(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel lblMaxCenaListkaDieta;
    private javax.swing.JLabel lblMaxCenaListkaDospely;
    private javax.swing.JLabel lblMaxCenaListkaStudent;
    private javax.swing.JLabel lblMaxCenyListkov;
    private javax.swing.JLabel lblMinPocetLanoviek;
    private javax.swing.JLabel lblMinPocetTrati;
    private javax.swing.JLabel lblMinPocetVlekov;
    private javax.swing.JLabel lblMinPodmienky;
    private javax.swing.JLabel lblMinVyskaSnehu;
    private javax.swing.JLabel lblNazov;
    private javax.swing.JLabel lblNazovObsahuje;
    // End of variables declaration//GEN-END:variables
}
