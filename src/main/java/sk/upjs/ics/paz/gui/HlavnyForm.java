package sk.upjs.ics.paz.gui;

import sk.upjs.ics.paz.entity.*;
import sk.upjs.ics.paz.dao.*;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableRowSorter;

public class HlavnyForm extends javax.swing.JFrame {

    private StrediskaDao strediskaDao;
    private FiltreDao filtreDao;

    private final StrediskoTableModel strediskaTableModel = new StrediskoTableModel();

    private final TableRowSorter strediskaRowSorter = new TableRowSorter(strediskaTableModel);

    private final StrediskaPodlaNazvuRowFilter strediskaPodlaVsetkychStlpcovRowFilter
            = new StrediskaPodlaNazvuRowFilter();
    
    private Pouzivatel pouzivatel = Factory.INSTANCE.getPouzivatel();

    public HlavnyForm() {
        initComponents();
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N
        strediskaDao = Factory.INSTANCE.getStrediskaDao();

        strediskaRowSorter.setRowFilter(strediskaPodlaVsetkychStlpcovRowFilter);

        tabStrediska.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            // pri zmene (vybratie/nevybratie strediska) aktivuje/deaktivuje tlacitka
            public void valueChanged(ListSelectionEvent e) {
                tabStrediskaSelectionValueChanged(e);
            }
        });

        aktualizujZoznamStredisk();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void tabStrediskaSelectionValueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            if (!tabStrediska.getSelectionModel().isSelectionEmpty()) {
                btnZobrazDetail.setEnabled(true);
                if (pouzivatel != null) {
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLogo = new javax.swing.JLabel();
        btnPridaj = new javax.swing.JButton();
        btnVyhladavaj = new javax.swing.JButton();
        btnNajdiNajblizsie = new javax.swing.JButton();
        txtRychlyFilter = new javax.swing.JTextField();
        btnRychloFiltruj = new javax.swing.JButton();
        btnResetFiltra = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabStrediska = new javax.swing.JTable();
        btnZobrazDetail = new javax.swing.JButton();
        btnOdstran = new javax.swing.JButton();
        btnUprav = new javax.swing.JButton();
        lblRychlyFilter = new javax.swing.JLabel();
        lblMenoUzivatela = new javax.swing.JLabel();
        btnPrihlasenieOdhlasenie = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        menubarHlavneMenu = new javax.swing.JMenuBar();
        menuStredisko = new javax.swing.JMenu();
        menuitemPridaj = new javax.swing.JMenuItem();
        menuitemVyhladavaj = new javax.swing.JMenuItem();
        menuitemNajdiNajblizsie = new javax.swing.JMenuItem();
        menuUzivatel = new javax.swing.JMenu();
        menuitemPrihlasOdhlas = new javax.swing.JMenuItem();
        menuitemRegistruj = new javax.swing.JMenuItem();
        menuFilter = new javax.swing.JMenu();
        menuitemSpravaFiltrov = new javax.swing.JMenuItem();
        menuOPrograme = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lyžiarske strediská");

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N

        btnPridaj.setText("Pridaj nové...");
        btnPridaj.setEnabled(false);
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

        btnRychloFiltruj.setText("Filtruj");
        btnRychloFiltruj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRychloFiltrujActionPerformed(evt);
            }
        });

        btnResetFiltra.setText("Reset");
        btnResetFiltra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetFiltraActionPerformed(evt);
            }
        });

        tabStrediska.setModel(strediskaTableModel);
        tabStrediska.setRowSorter(strediskaRowSorter);
        tabStrediska.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabStrediskaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabStrediska);

        btnZobrazDetail.setText("Zobraz detail...");
        btnZobrazDetail.setEnabled(false);
        btnZobrazDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZobrazDetailActionPerformed(evt);
            }
        });

        btnOdstran.setText("Odstráň");
        btnOdstran.setEnabled(false);
        btnOdstran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdstranActionPerformed(evt);
            }
        });

        btnUprav.setText("Uprav...");
        btnUprav.setEnabled(false);
        btnUprav.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpravActionPerformed(evt);
            }
        });

        lblRychlyFilter.setText("Rýchly filter:");

        lblMenoUzivatela.setText("Užívateľ: neprihlásený");

        btnPrihlasenieOdhlasenie.setText("Prihlás...");
        btnPrihlasenieOdhlasenie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrihlasenieOdhlasenieActionPerformed(evt);
            }
        });

        menuStredisko.setText("Stredisko");

        menuitemPridaj.setText("Pridaj nové...");
        menuitemPridaj.setEnabled(false);
        menuitemPridaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitemPridajActionPerformed(evt);
            }
        });
        menuStredisko.add(menuitemPridaj);

        menuitemVyhladavaj.setText("Vyhľadávaj...");
        menuitemVyhladavaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitemVyhladavajActionPerformed(evt);
            }
        });
        menuStredisko.add(menuitemVyhladavaj);

        menuitemNajdiNajblizsie.setText("Nájdi najbližšie...");
        menuitemNajdiNajblizsie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitemNajdiNajblizsieActionPerformed(evt);
            }
        });
        menuStredisko.add(menuitemNajdiNajblizsie);

        menubarHlavneMenu.add(menuStredisko);

        menuUzivatel.setText("Užívateľ");

        menuitemPrihlasOdhlas.setText("Prihlás...");
        menuitemPrihlasOdhlas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitemPrihlasOdhlasActionPerformed(evt);
            }
        });
        menuUzivatel.add(menuitemPrihlasOdhlas);

        menuitemRegistruj.setText("Registruj...");
        menuitemRegistruj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitemRegistrujActionPerformed(evt);
            }
        });
        menuUzivatel.add(menuitemRegistruj);

        menubarHlavneMenu.add(menuUzivatel);

        menuFilter.setText("Filter");

        menuitemSpravaFiltrov.setText("Správa filtrov...");
        menuitemSpravaFiltrov.setEnabled(false);
        menuitemSpravaFiltrov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitemSpravaFiltrovActionPerformed(evt);
            }
        });
        menuFilter.add(menuitemSpravaFiltrov);

        menubarHlavneMenu.add(menuFilter);

        menuOPrograme.setText("O programe...");
        menuOPrograme.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuOProgrameMouseClicked(evt);
            }
        });
        menubarHlavneMenu.add(menuOPrograme);

        setJMenuBar(menubarHlavneMenu);
        menubarHlavneMenu.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblRychlyFilter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRychlyFilter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRychloFiltruj, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnResetFiltra)
                        .addGap(136, 136, 136))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnOdstran, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnUprav, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnZobrazDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnVyhladavaj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnNajdiNajblizsie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnPridaj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnPrihlasenieOdhlasenie, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(2, 2, 2))
                            .addComponent(lblMenoUzivatela, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
            .addComponent(jSeparator1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRychlyFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRychloFiltruj)
                    .addComponent(btnResetFiltra)
                    .addComponent(lblRychlyFilter))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblMenoUzivatela)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPrihlasenieOdhlasenie)
                        .addGap(18, 18, 18)
                        .addComponent(btnZobrazDetail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUprav)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOdstran)
                        .addGap(18, 18, 18)
                        .addComponent(btnPridaj)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVyhladavaj)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNajdiNajblizsie))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVyhladavajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVyhladavajActionPerformed
        vyhladavajAction();
    }//GEN-LAST:event_btnVyhladavajActionPerformed

    /**
     * Otvori modalne okno s podrobnym vyhladavanim
     */
    private void vyhladavajAction() {
        VyhladavajForm vyhladavajForm = new VyhladavajForm(this, true);
        vyhladavajForm.setVisible(true);
    }

    private void btnNajdiNajblizsieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNajdiNajblizsieActionPerformed
        najdiNajblizsieAction();
    }//GEN-LAST:event_btnNajdiNajblizsieActionPerformed

    /**
     * Otvori modalne okno s vyhladavanim najblizsieho strediska
     */
    private void najdiNajblizsieAction() {
        NajdiNajblizsieForm najdiNajblizsieForm = new NajdiNajblizsieForm(this, true);
        najdiNajblizsieForm.setVisible(true);
    }

    private void btnPridajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPridajActionPerformed
        pridajStrediskoAction();
    }//GEN-LAST:event_btnPridajActionPerformed

    /**
     * Otvori modalne okno pre pridanie noveho strediska
     */
    private void pridajStrediskoAction() {
        PridajUpravStrediskoForm pridajUpravStrediskoForm = new PridajUpravStrediskoForm(this);
        pridajUpravStrediskoForm.setVisible(true);
        aktualizujZoznamStredisk();
    }

    private void btnZobrazDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZobrazDetailActionPerformed
        zobrazDetailStrediskaAction();
    }//GEN-LAST:event_btnZobrazDetailActionPerformed

    /**
     * Otvori modalne okno s detailami vybraneho strediska
     */
    private void zobrazDetailStrediskaAction() {
        Stredisko vybraneStredisko = dajStrediskoZTabulky();
        ZobrazDetailForm zobrazDetailForm = new ZobrazDetailForm(this, vybraneStredisko);
        zobrazDetailForm.setVisible(true);
    }

    private void btnUpravActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpravActionPerformed
        upravStrediskoAction();
    }//GEN-LAST:event_btnUpravActionPerformed

    /**
     * Otvori modalne okno pre upravu vybraneho strediska
     */
    private void upravStrediskoAction() {
        Stredisko vybraneStredisko = dajStrediskoZTabulky();
        PridajUpravStrediskoForm pridajUpravStrediskoForm = new PridajUpravStrediskoForm(this, vybraneStredisko);
        pridajUpravStrediskoForm.setVisible(true);
        aktualizujZoznamStredisk();
    }

    private Stredisko dajStrediskoZTabulky() {
        // vrati cislo riadka v aktualnom zosorteni
        int vybranyRiadok = tabStrediska.getSelectedRow();
        // vrati cislo riadka v modeli
        int vybratyRiadokVModeli = tabStrediska.convertRowIndexToModel(vybranyRiadok);
        // z cisla riadka v modeli viem zistit stredisko na danom riadku
        Stredisko vybraneStredisko = strediskaTableModel.dajPodlaCislaRiadka(vybratyRiadokVModeli);

        return vybraneStredisko;
    }

    private void btnOdstranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdstranActionPerformed
        odstranStrediskoAction();
    }//GEN-LAST:event_btnOdstranActionPerformed

    /**
     * Odstrani vybrane stredisko, predtym si vypyta potvrdenie
     */
    private void odstranStrediskoAction() {
        int vybranyRiadok = tabStrediska.getSelectedRow();
        int vybratyRiadokVModeli = tabStrediska.convertRowIndexToModel(vybranyRiadok);
        Stredisko vybraneStredisko = strediskaTableModel.dajPodlaCislaRiadka(vybratyRiadokVModeli);

        int tlacidlo = JOptionPane.showConfirmDialog(
                this,
                "Naozaj chcete odstrániť vybrané stredisko?",
                "Odstrániť stredisko",
                JOptionPane.YES_NO_OPTION
        );

        if (tlacidlo == JOptionPane.YES_OPTION) {
            strediskaDao.odstran(vybraneStredisko);
            aktualizujZoznamStredisk();
        }
    }

    /**
     * Otvori okno s info o programe
     */
    private void oProgrameAction() {
        OProgrameForm oProgrameForm = new OProgrameForm(this, true);
        oProgrameForm.setVisible(true);
    }

    private void btnPrihlasenieOdhlasenieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrihlasenieOdhlasenieActionPerformed
        prihlasOdhlasAction();
    }//GEN-LAST:event_btnPrihlasenieOdhlasenieActionPerformed

    /**
     * Otvori prihlasovaci formular/odhlasi pouzivatela
     */
    private void prihlasOdhlasAction() {
        // ak je pouzivatel prihlaseny, tak sa odhlasi
        if (pouzivatel != null) {
            odhlas();
            aktualizujZoznamStredisk();
            return;
        }
        // ak nebol prihlaseny, tak sa prihlasi, 
        // a ak sa prihlasovanie podari, nastavia sa vsetky veci
        PrihlasovanieForm prihlasovanieForm = new PrihlasovanieForm(this, true);
        prihlasovanieForm.setVisible(true);
        aktualizujZoznamStredisk();
        prihlas();
    }

    /**
     * Prihlasi uzivatela
     */
    private void prihlas() {
        pouzivatel = Factory.INSTANCE.getPouzivatel();
        if (pouzivatel != null) {
            menuitemPridaj.setEnabled(true);
            btnPridaj.setEnabled(true);
            menuitemSpravaFiltrov.setEnabled(true);
            tabStrediska.clearSelection();

            lblMenoUzivatela.setText("Užívateľ: " + pouzivatel.getMeno());
            btnPrihlasenieOdhlasenie.setText("Odhlás");
            menuitemPrihlasOdhlas.setText("Odhlás");
        }
    }

    /**
     * Odhlasi pouzivatela
     */
    private void odhlas() {
        pouzivatel = null;
        Factory.INSTANCE.setPouzivatel(pouzivatel);
        strediskaDao = Factory.INSTANCE.getNovyStrediskaDao();
        filtreDao = Factory.INSTANCE.getNovyFiltreDao();

        menuitemPridaj.setEnabled(false);  
        btnPridaj.setEnabled(false);
        menuitemSpravaFiltrov.setEnabled(false);
        tabStrediska.clearSelection();

        lblMenoUzivatela.setText("Užívateľ: neprihlásený");
        btnPrihlasenieOdhlasenie.setText("Prihlás...");
        menuitemPrihlasOdhlas.setText("Prihlás...");
    }

    /**
     * Pri dvojkliku na stredisko v tabulke sa spusti jeho uprava
     *
     * @param evt
     */
    private void tabStrediskaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabStrediskaMouseClicked
        if (evt.getClickCount() == 2) {
            btnZobrazDetail.doClick();
        }
    }//GEN-LAST:event_tabStrediskaMouseClicked

    private void btnRychloFiltrujActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRychloFiltrujActionPerformed
        String filter = txtRychlyFilter.getText().trim().toUpperCase();
        strediskaPodlaVsetkychStlpcovRowFilter.setHladanyVyraz(filter);

        aktualizujZoznamStredisk();
    }//GEN-LAST:event_btnRychloFiltrujActionPerformed

    private void btnResetFiltraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetFiltraActionPerformed
        strediskaPodlaVsetkychStlpcovRowFilter.setHladanyVyraz("");

        aktualizujZoznamStredisk();
    }//GEN-LAST:event_btnResetFiltraActionPerformed

    private void menuitemPridajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitemPridajActionPerformed
        pridajStrediskoAction();
    }//GEN-LAST:event_menuitemPridajActionPerformed

    private void menuitemVyhladavajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitemVyhladavajActionPerformed
        vyhladavajAction();
    }//GEN-LAST:event_menuitemVyhladavajActionPerformed

    private void menuitemNajdiNajblizsieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitemNajdiNajblizsieActionPerformed
        najdiNajblizsieAction();
    }//GEN-LAST:event_menuitemNajdiNajblizsieActionPerformed

    private void menuitemPrihlasOdhlasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitemPrihlasOdhlasActionPerformed
        prihlasOdhlasAction();
    }//GEN-LAST:event_menuitemPrihlasOdhlasActionPerformed

    private void menuitemRegistrujActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitemRegistrujActionPerformed
        registrujAction();
    }//GEN-LAST:event_menuitemRegistrujActionPerformed

    private void menuOProgrameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuOProgrameMouseClicked
        oProgrameAction();
    }//GEN-LAST:event_menuOProgrameMouseClicked

    private void menuitemSpravaFiltrovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitemSpravaFiltrovActionPerformed
        spravaFiltrovAction();
    }//GEN-LAST:event_menuitemSpravaFiltrovActionPerformed

    /**
     * Otvori okno so spravou filtrov
     */
    private void spravaFiltrovAction()
    {
        SpravaFiltrovForm spravaFiltrovForm = new SpravaFiltrovForm(this, true);
        spravaFiltrovForm.setVisible(true);
    }
    
    /**
     * Otvori okno s registraciou noveho pouzivatela
     */
    private void registrujAction() {
        RegistraciaForm registraciaForm = new RegistraciaForm(this, true);
        registraciaForm.setVisible(true);
    }

    private void aktualizujZoznamStredisk() {
        strediskaTableModel.obnov();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Windows look and feel */
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
    private javax.swing.JButton btnOdstran;
    private javax.swing.JButton btnPridaj;
    private javax.swing.JButton btnPrihlasenieOdhlasenie;
    private javax.swing.JButton btnResetFiltra;
    private javax.swing.JButton btnRychloFiltruj;
    private javax.swing.JButton btnUprav;
    private javax.swing.JButton btnVyhladavaj;
    private javax.swing.JButton btnZobrazDetail;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblMenoUzivatela;
    private javax.swing.JLabel lblRychlyFilter;
    private javax.swing.JMenu menuFilter;
    private javax.swing.JMenu menuOPrograme;
    private javax.swing.JMenu menuStredisko;
    private javax.swing.JMenu menuUzivatel;
    private javax.swing.JMenuBar menubarHlavneMenu;
    private javax.swing.JMenuItem menuitemNajdiNajblizsie;
    private javax.swing.JMenuItem menuitemPridaj;
    private javax.swing.JMenuItem menuitemPrihlasOdhlas;
    private javax.swing.JMenuItem menuitemRegistruj;
    private javax.swing.JMenuItem menuitemSpravaFiltrov;
    private javax.swing.JMenuItem menuitemVyhladavaj;
    private javax.swing.JTable tabStrediska;
    private javax.swing.JTextField txtRychlyFilter;
    // End of variables declaration//GEN-END:variables

}
