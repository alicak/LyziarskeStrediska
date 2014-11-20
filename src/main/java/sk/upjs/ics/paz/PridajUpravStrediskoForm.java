package sk.upjs.ics.paz;

import java.awt.Frame;
import java.math.BigDecimal;

public class PridajUpravStrediskoForm extends javax.swing.JDialog {

    private Stredisko stredisko;
    private static final StrediskaDao strediskaDao = DaoFactory.INSTANCE.getStrediskaDao();

    /**
     * Creates new form PridajUpravStrediskoForm
     *
     * @param parent rodicovske okno
     * @param modal ci je okno modalne
     */
    public PridajUpravStrediskoForm(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * Konstruktor modalneho okna pre upravu existujuceho strediska
     *
     * @param parent rodicovske okno
     * @param stredisko stredisko, ktore upravujeme
     */
    public PridajUpravStrediskoForm(Frame parent, Stredisko stredisko) {
        this(parent, true);
        this.stredisko = stredisko;
        this.setTitle("Úprava strediska");

        this.txtNazov.setText(stredisko.getNazov());
        this.txtVyskaSnehu.setText(Integer.toString(stredisko.getVyskaSnehu()));
        // TODO otestovat, ci to funguje
        this.cmbPodmienky.setSelectedItem(stredisko.getPodmienky());
        this.txtPocetVlekovVPrevadzke.setText(Integer.toString(stredisko.getPocetVlekovVPrevadzke()));
        this.txtPocetVlekov.setText(Integer.toString(stredisko.getPocetVlekov()));
        this.txtPocetLanoviekVPrevadzke.setText(Integer.toString(stredisko.getPocetLanoviekVPrevadzke()));
        this.txtPocetLanoviek.setText(Integer.toString(stredisko.getPocetLanoviek()));
        // TODO odkomentovat, ked pridame premenne
        // this.txtPocetTratiVPrevadzke.setText(Integer.toString(stredisko.getPocetTratiVPrevadzke()));
        // this.txtPocetTrati.setText(Integer.toString(stredisko.getPocetTrati()));
        this.chkPozicanieVystroje.setSelected(stredisko.isDaSaPozicatVystroj());
        this.chkUbytovanie.setSelected(stredisko.isDaSaUbytovat());
        this.txtGpsSirka.setText(stredisko.getGpsSirka().toString());
        this.txtGpsDlzka.setText(stredisko.getGpsDlzka().toString());
        this.txtListokDospely.setText(stredisko.getCenaListkaDospely().toString());
        this.txtListokDieta.setText(stredisko.getCenaListkaDieta().toString());
        this.txtListokStudent.setText(stredisko.getCenaListkaStudent().toString());
    }

    /**
     * Konstruktor modalneho okna pre pridanie noveho strediska
     *
     * @param parent rodicovske stredisko
     */
    public PridajUpravStrediskoForm(Frame parent) {
        this(parent, new Stredisko());
        this.setTitle("Pridanie nového strediska");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNazov = new javax.swing.JLabel();
        lblVyskaSnehu = new javax.swing.JLabel();
        lblPodmienky = new javax.swing.JLabel();
        txtNazov = new javax.swing.JTextField();
        cmbPodmienky = new javax.swing.JComboBox();
        txtVyskaSnehu = new javax.swing.JTextField();
        lblCm = new javax.swing.JLabel();
        lblPocetVlekov = new javax.swing.JLabel();
        txtPocetVlekovVPrevadzke = new javax.swing.JTextField();
        lblLomka1 = new javax.swing.JLabel();
        txtPocetVlekov = new javax.swing.JTextField();
        lblVPrevadzke = new javax.swing.JLabel();
        lblVsetky = new javax.swing.JLabel();
        lblPocetLanoviek = new javax.swing.JLabel();
        txtPocetLanoviekVPrevadzke = new javax.swing.JTextField();
        lblLomka2 = new javax.swing.JLabel();
        txtPocetLanoviek = new javax.swing.JTextField();
        lblPocetTrati = new javax.swing.JLabel();
        txtPocetTratiVPrevadzke = new javax.swing.JTextField();
        lblLomka3 = new javax.swing.JLabel();
        txtPocetTrati = new javax.swing.JTextField();
        chkPozicanieVystroje = new javax.swing.JCheckBox();
        chkUbytovanie = new javax.swing.JCheckBox();
        lblCenyListkov = new javax.swing.JLabel();
        lblListokDospely = new javax.swing.JLabel();
        lblListokDieta = new javax.swing.JLabel();
        lblListokStudent = new javax.swing.JLabel();
        txtListokDospely = new javax.swing.JTextField();
        txtListokDieta = new javax.swing.JTextField();
        txtListokStudent = new javax.swing.JTextField();
        lblGps = new javax.swing.JLabel();
        lblSirka = new javax.swing.JLabel();
        lblDlzka = new javax.swing.JLabel();
        txtGpsSirka = new javax.swing.JTextField();
        txtGpsDlzka = new javax.swing.JTextField();
        btnUloz = new javax.swing.JButton();
        btnStorno = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblNazov.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNazov.setText("Názov:");

        lblVyskaSnehu.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblVyskaSnehu.setText("Výška snehu:");

        lblPodmienky.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPodmienky.setText("Podmienky:");

        cmbPodmienky.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "nezadané", "výborné", "veľmi dobré", "dobré", "obmedzené", "nevyhovujúce" }));

        lblCm.setText("cm");

        lblPocetVlekov.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPocetVlekov.setText("Počet vlekov:");

        lblLomka1.setText("/");

        lblVPrevadzke.setText("v prevádzke");

        lblVsetky.setText("všetky");

        lblPocetLanoviek.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPocetLanoviek.setText("Počet lanoviek:");

        lblLomka2.setText("/");

        lblPocetTrati.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPocetTrati.setText("Počet tratí:");

        lblLomka3.setText("/");

        chkPozicanieVystroje.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        chkPozicanieVystroje.setText("možnosť požičania výstroje");

        chkUbytovanie.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        chkUbytovanie.setText("možnosť ubytovania");

        lblCenyListkov.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblCenyListkov.setText("Ceny lístkov");

        lblListokDospely.setText("Dospelý:");

        lblListokDieta.setText("Dieťa:");

        lblListokStudent.setText("Študent:");

        lblGps.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblGps.setText("GPS súradnice");

        lblSirka.setText("Šírka:");

        lblDlzka.setText("Dĺžka:");

        btnUloz.setText("Ulož");
        btnUloz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUlozActionPerformed(evt);
            }
        });

        btnStorno.setText("Storno");
        btnStorno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStornoActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPocetVlekov)
                            .addComponent(lblPocetLanoviek)
                            .addComponent(lblPocetTrati))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblVPrevadzke)
                                .addGap(27, 27, 27)
                                .addComponent(lblVsetky))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtPocetTratiVPrevadzke, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPocetLanoviekVPrevadzke, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPocetVlekovVPrevadzke, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblLomka1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPocetVlekov, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblLomka2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPocetLanoviek))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblLomka3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPocetTrati))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNazov)
                            .addComponent(lblPodmienky))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(cmbPodmienky, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtNazov, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblVyskaSnehu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtVyskaSnehu, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCm))
                    .addComponent(chkUbytovanie)
                    .addComponent(chkPozicanieVystroje))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblGps)
                            .addComponent(lblCenyListkov)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblListokDospely)
                                    .addComponent(lblListokDieta)
                                    .addComponent(lblListokStudent))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtListokDieta, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtListokDospely, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtListokStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSirka)
                                    .addComponent(lblDlzka))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtGpsSirka, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                                    .addComponent(txtGpsDlzka)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btnUloz, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnStorno, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNazov)
                    .addComponent(txtNazov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGps))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVyskaSnehu)
                    .addComponent(txtVyskaSnehu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCm)
                    .addComponent(lblSirka)
                    .addComponent(txtGpsSirka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPodmienky)
                    .addComponent(cmbPodmienky, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDlzka)
                    .addComponent(txtGpsDlzka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVPrevadzke)
                    .addComponent(lblVsetky)
                    .addComponent(lblCenyListkov))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPocetVlekov)
                    .addComponent(txtPocetVlekovVPrevadzke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLomka1)
                    .addComponent(txtPocetVlekov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblListokDospely)
                    .addComponent(txtListokDospely, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPocetLanoviek)
                    .addComponent(txtPocetLanoviekVPrevadzke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLomka2)
                    .addComponent(txtPocetLanoviek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblListokDieta)
                    .addComponent(txtListokDieta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPocetTrati)
                    .addComponent(txtPocetTratiVPrevadzke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLomka3)
                    .addComponent(txtPocetTrati, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblListokStudent)
                    .addComponent(txtListokStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(chkPozicanieVystroje)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkUbytovanie))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUloz)
                            .addComponent(btnStorno))))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Ignoruje vsetky zmeny a zavrie okno
     *
     * @param evt
     */
    private void btnStornoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStornoActionPerformed
        dispose();
    }//GEN-LAST:event_btnStornoActionPerformed

    /**
     * Ulozi zmeny do strediska a zavrie okno
     *
     * @param evt
     */
    private void btnUlozActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUlozActionPerformed
        // TODO overenie, ci su policka vyplnene, ak nie, tak tam dat nuly alebo nejake ine predvolene hodnoty
        stredisko.setNazov(txtNazov.getText());
        stredisko.setVyskaSnehu(new Integer(txtVyskaSnehu.getText()));
        stredisko.setPodmienky(cmbPodmienky.getSelectedItem().toString());
        stredisko.setPocetVlekov(new Integer(txtPocetVlekov.getText()));
        stredisko.setPocetVlekovVPrevadzke(new Integer(txtPocetVlekovVPrevadzke.getText()));
        stredisko.setPocetLanoviek(new Integer(txtPocetLanoviek.getText()));
        stredisko.setPocetLanoviekVPrevadzke(new Integer(txtPocetLanoviekVPrevadzke.getText()));
        // TODO odkomentovat, ked dodame stlpce do tabulky 
        // stredisko.setPocetTrati(new Integer(txtPocetTrati.getText()));
        // stredisko.setPocetTratiVPrevadzke(new Integer(txtPocetTratiVPrevadzke.getText()));
        stredisko.setDaSaPozicatVystroj(chkPozicanieVystroje.isSelected());
        stredisko.setDaSaUbytovat(chkUbytovanie.isSelected());
        stredisko.setGpsSirka(new BigDecimal(txtGpsSirka.getText()));
        stredisko.setGpsDlzka(new BigDecimal(txtGpsDlzka.getText()));
        stredisko.setCenaListkaDospely(new BigDecimal(txtListokDospely.getText()));
        stredisko.setCenaListkaDieta(new BigDecimal(txtListokDieta.getText()));
        stredisko.setCenaListkaStudent(new BigDecimal(txtListokStudent.getText()));

        strediskaDao.uloz(stredisko);
        dispose();
    }//GEN-LAST:event_btnUlozActionPerformed

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
            java.util.logging.Logger.getLogger(PridajUpravStrediskoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PridajUpravStrediskoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PridajUpravStrediskoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PridajUpravStrediskoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PridajUpravStrediskoForm dialog = new PridajUpravStrediskoForm(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnStorno;
    private javax.swing.JButton btnUloz;
    private javax.swing.JCheckBox chkPozicanieVystroje;
    private javax.swing.JCheckBox chkUbytovanie;
    private javax.swing.JComboBox cmbPodmienky;
    private javax.swing.JLabel lblCenyListkov;
    private javax.swing.JLabel lblCm;
    private javax.swing.JLabel lblDlzka;
    private javax.swing.JLabel lblGps;
    private javax.swing.JLabel lblListokDieta;
    private javax.swing.JLabel lblListokDospely;
    private javax.swing.JLabel lblListokStudent;
    private javax.swing.JLabel lblLomka1;
    private javax.swing.JLabel lblLomka2;
    private javax.swing.JLabel lblLomka3;
    private javax.swing.JLabel lblNazov;
    private javax.swing.JLabel lblPocetLanoviek;
    private javax.swing.JLabel lblPocetTrati;
    private javax.swing.JLabel lblPocetVlekov;
    private javax.swing.JLabel lblPodmienky;
    private javax.swing.JLabel lblSirka;
    private javax.swing.JLabel lblVPrevadzke;
    private javax.swing.JLabel lblVsetky;
    private javax.swing.JLabel lblVyskaSnehu;
    private javax.swing.JTextField txtGpsDlzka;
    private javax.swing.JTextField txtGpsSirka;
    private javax.swing.JTextField txtListokDieta;
    private javax.swing.JTextField txtListokDospely;
    private javax.swing.JTextField txtListokStudent;
    private javax.swing.JTextField txtNazov;
    private javax.swing.JTextField txtPocetLanoviek;
    private javax.swing.JTextField txtPocetLanoviekVPrevadzke;
    private javax.swing.JTextField txtPocetTrati;
    private javax.swing.JTextField txtPocetTratiVPrevadzke;
    private javax.swing.JTextField txtPocetVlekov;
    private javax.swing.JTextField txtPocetVlekovVPrevadzke;
    private javax.swing.JTextField txtVyskaSnehu;
    // End of variables declaration//GEN-END:variables
}
