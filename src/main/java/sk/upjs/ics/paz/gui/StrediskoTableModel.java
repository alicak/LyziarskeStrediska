package sk.upjs.ics.paz.gui;

import sk.upjs.ics.paz.entity.Stredisko;
import sk.upjs.ics.paz.dao.StrediskaDao;
import sk.upjs.ics.paz.dao.Factory;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class StrediskoTableModel extends AbstractTableModel {

    // zoznam stredisk, ktore chceme zobrazovat
    private List<Stredisko> zoznamStredisk = new ArrayList<>();
    private static final int POCET_STLPCOV = 3;
    private static final String[] NAZVY_STLPCOV = {"Názov", "Výška snehu", "Podmienky"};
    private static final Class[] TYPY_STLPCOV = {
        String.class,
        BigDecimal.class,
        String.class
    };
    private StrediskaDao strediskaDao = Factory.INSTANCE.getStrediskaDao();

    /**
     * @return pocet riadkov tabulky
     */
    @Override
    public int getRowCount() {
        return zoznamStredisk.size();
    }

    /**
     * @return pocet stlpcov tabulky
     */
    @Override
    public int getColumnCount() {
        return POCET_STLPCOV;
    }

    /**
     * @param rowIndex cislo riadka
     * @param columnIndex cislo stlpca
     * @return hodnota na danom riadku a stlpci
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Stredisko vybraneStredisko = zoznamStredisk.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return vybraneStredisko.getNazov();
            case 1:
                return vybraneStredisko.getVyskaSnehu();
            case 2:
                return vybraneStredisko.getPodmienky();
            default:
                return "???";
        }
    }

    /**
     * Aktualizuje zoznam stredisk
     */
    public void obnov() {
        strediskaDao = Factory.INSTANCE.getStrediskaDao();
        zoznamStredisk = strediskaDao.dajVsetky();
        fireTableDataChanged();
    }
    
    /**
     * Zobrazi v tabulke zoznam, ktory zadame
     * @param zoznam 
     */
    public void zobrazZadanyZoznam(List<Stredisko> zoznam)
    {
        zoznamStredisk = zoznam;
        fireTableDataChanged();
    }

    /**
     * @param column index stlpca
     * @return nazov stlpca
     */
    @Override
    public String getColumnName(int column) {
        return NAZVY_STLPCOV[column];
    }

    /**
     * @param columnIndex index stlpca
     * @return trieda
     */
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return TYPY_STLPCOV[columnIndex];
    }
    
    /**
     * @param riadok
     * @return stredisko na danom riadku
     */
    public Stredisko dajPodlaCislaRiadka(int riadok)
    {
        return zoznamStredisk.get(riadok);
    }

}
