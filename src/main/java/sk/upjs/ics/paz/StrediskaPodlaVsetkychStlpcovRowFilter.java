package sk.upjs.ics.paz;

import javax.swing.RowFilter;

public class StrediskaPodlaVsetkychStlpcovRowFilter extends RowFilter {

    private String hladanyVyraz = "";

    public void setHladanyVyraz(String hladanyVyraz) {
        this.hladanyVyraz = hladanyVyraz;
    }

    @Override
    public boolean include(Entry entry) {
        for (int i = 0; i < 3; i++) {
            String string = entry.getStringValue(i).toUpperCase();
            if (string.contains(hladanyVyraz)) {
                return true;
            }
        }
        return false;
    }

}
