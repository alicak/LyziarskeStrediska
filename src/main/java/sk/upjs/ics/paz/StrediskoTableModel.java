package sk.upjs.ics.paz;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class StrediskoTableModel extends AbstractTableModel {

    // zoznam stredisk, ktore chceme zobrazovat
    private List<Stredisko> zoznamStredisk = new LinkedList<>();
    private static final int POCET_STLPCOV = 3;
    private static final String[] NAZVY_STLPCOV = {"Názov", "Výška snehu", "Podmienky"};
    private static final Class[] TYPY_STLPCOV = {
        String.class,
        BigDecimal.class,
        String.class
    };

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

}
