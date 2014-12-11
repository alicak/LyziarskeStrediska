package sk.upjs.ics.paz.gui;

import java.util.LinkedList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import sk.upjs.ics.paz.dao.Factory;
import sk.upjs.ics.paz.dao.FiltreDao;
import sk.upjs.ics.paz.entity.Filter;

public class FiltreListAndComboBoxModel extends AbstractListModel implements ComboBoxModel {

    // zoznam filtrov, ktore chceme zobrazovat
    private List<Filter> zoznamFiltrov = new LinkedList<>();
    private FiltreDao filtreDao = Factory.INSTANCE.getFiltreDao();
    private Object vybranyPrvokVComboBoxe;

    @Override
    public int getSize() {
        return zoznamFiltrov.size();
    }

    @Override
    public Object getElementAt(int index) {
        return zoznamFiltrov.get(index).getNazov();
    }

    public void obnov() {
        filtreDao = Factory.INSTANCE.getFiltreDao();
        zoznamFiltrov = filtreDao.dajVsetky();
        fireContentsChanged(this, 0, this.getSize()-1);
        setSelectedItem(null);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        vybranyPrvokVComboBoxe = anItem;
    }

    @Override
    public Object getSelectedItem() {
        return vybranyPrvokVComboBoxe;
    }

}
