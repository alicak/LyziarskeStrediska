package sk.upjs.ics.paz;

import javax.swing.RowFilter;

public class StrediskaPodlaVsetkychStlpcovRowFilter extends RowFilter {

    private String hladanyVyraz = "";

    public void setHladanyVyraz(String hladanyVyraz) {
        this.hladanyVyraz = hladanyVyraz;
    }

    /**
     * @param entry riadok so strediskom
     * @return true, ak nazov strediska na danom riadku obsahuje hladany string
     */
    @Override
    public boolean include(Entry entry) {
        String string = entry.getStringValue(0).toUpperCase();
        if (string.contains(hladanyVyraz)) {
            return true;
        }
        return false;
    }

}
