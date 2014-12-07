package sk.upjs.ics.paz.gui;

import javax.swing.RowFilter;

public class StrediskaPodlaNazvuRowFilter extends RowFilter {

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
        return string.contains(hladanyVyraz);
    }

}