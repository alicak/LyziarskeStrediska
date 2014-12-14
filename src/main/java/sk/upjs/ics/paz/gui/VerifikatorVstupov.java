package sk.upjs.ics.paz.gui;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.JTextField;

/**
 * Obsahuje metody pre overovanie vstupu a na vyhadzovanie chybovych hlasok.
 * Zdroj pre regularne vyrazy:
 * http://ocpsoft.org/opensource/guide-to-regular-expressions-in-java-part-1/
 */
public class VerifikatorVstupov {

    // nadpis, ktory budu mat vsetky chybove hlasky
    private final String NADPIS_CHYBOVEJ_HLASKY = "Chyba - nesprávny vstup";

    /**
     * @param pole pole, ktore overujeme
     * @return true, ak je neprazdne
     */
    public boolean jeNeprazdny(JTextField pole) {
        return !pole.getText().equals("");
    }

    /**
     *
     * @param pole pole, ktore overujeme
     * @return true, ak je v nom desatinne cislo (musi mat desatinnu cast!)
     */
    public boolean jeDesatinneCislo(JTextField pole) {
        // regularny vyraz - znamena 0 alebo 1 minus,
        // 1 alebo viac cislic, za tym bodku a za tym zase 1 alebo viac cislic
        return pole.getText().matches("-?\\d+\\.\\d+")
                || pole.getText().matches("-?\\d+");
    }

    /**
     * @param pole pole, ktore overujeme
     * @return true, ak je v nom cele cislo
     */
    public boolean jeCeleCislo(JTextField pole) {
        // regularny vyraz - znamena 0 alebo 1 minus
        // a za tym 1 alebo viac cislic
        return pole.getText().matches("-?\\d+");
    }

    /**
     * @param pole pole, ktore overujeme
     * @return true, ak je v nom cele alebo desatinne cislo
     */
    private boolean jeCeleAleboDesatinneCislo(JTextField pole) {
        return jeDesatinneCislo(pole) || jeCeleCislo(pole);
    }

    /**
     *
     * @param pole pole, ktore overujeme
     * @param min minimalna hodnota
     * @param max maximalna hodnota
     * @return true, ak je hodnota cele cislo medzi min a max (vratane)
     */
    public boolean jeCeleCisloVRozsahu(JTextField pole, int min, int max) {
        if (!jeCeleCislo(pole)) {
            return false;
        }
        int hodnota = Integer.valueOf(pole.getText());
        return (hodnota >= min && hodnota <= max);
    }

    /**
     *
     * @param pole pole, ktore overujeme
     * @param min minimalna hodnota
     * @param max maximalna hodnota
     * @return true, ak je hodnota cele alebo desatinne cislo medzi min a max
     * (vratane)
     */
    public boolean jeCeleAleboDesatinneCisloVRozsahu(JTextField pole, double min, double max) {
        if (!jeCeleAleboDesatinneCislo(pole)) {
            return false;
        }
        double hodnota = Double.valueOf(pole.getText());
        return (hodnota >= min && hodnota <= max);
    }

    /**
     *
     * @param pole pole, ktore overujeme
     * @param maxDlzka maximalna dlzka retazca
     * @return true, ak retazec nepresahuje max dlzku
     */
    public boolean jeMaxDlzky(JTextField pole, int maxDlzka) {
        int dlzka = pole.getText().length();
        return dlzka <= maxDlzka;
    }

    /**
     *
     * @param pole pole, ktore overujeme
     * @param maxDlzka maximalna dlzka retazca
     * @return true, ak je retazec neprazny a nepresahuje max dlzku
     */
    public boolean jeNeprazdneMaxDlzky(JTextField pole, int maxDlzka) {
        if (!jeNeprazdny(pole)) {
            return false;
        }
        int dlzka = pole.getText().length();
        return dlzka <= maxDlzka;
    }

    /**
     * Pocet vlekov/lanoviek/trati v prevadzke nemoze byt vacsi ako pocet
     * vsetkych.
     *
     * @param vPrevadzke pocet v prevazdke
     * @param vsetky pocet vsetkych
     * @return true, ak je v prevadzke menej alebo rovnako ako vsetkych
     */
    public boolean jeVPrevadzkeMenejAkoVsetkych(JTextField vPrevadzke, JTextField vsetky) {
        return Integer.valueOf(vPrevadzke.getText()) <= Integer.valueOf(vsetky.getText());
    }

//    /**
//     * Vrati, ci je zadane cislo cele (ci nie je string, desatinne)
//     *
//     * @param pole
//     * @return true, ak je zadany string mozne prekonvertovat na cele cislo
//     */
//    public boolean jeVPoliCeleCislo(JTextField pole) {
//        try {
//            Integer.parseInt(pole.getText());
//            return true;
//        } catch (NumberFormatException e) {
//            return false;
//        }
//    }
//
//    /**
//     * Vrati, ci je zadane cislo cele (ci nie je string)
//     *
//     * @param pole
//     * @return true, ak je zadany string mozne prekonvertovat na desatinne cislo
//     */
//    public boolean jeVPoliDesatinneCislo(JTextField pole) {
//        try {
//            Double.parseDouble(pole.getText());
//            return true;
//        } catch (NumberFormatException e) {
//            return false;
//        }
//    }
    /**
     * Hlaska pre povinne cele cislo
     *
     * @param parent rodic hlasky
     * @param pole pole, ktore overujeme
     */
    public void hlaskaCisloNieJeVSpravnomFormate(JDialog parent, JTextField pole) {
        String sprava = "Zadali ste nesprávny formát čísla v poli "
                + pole.getName()
                + ".";
        JOptionPane.showMessageDialog(parent, sprava, NADPIS_CHYBOVEJ_HLASKY, ERROR_MESSAGE);
    }

    /**
     * Hlaska pre povinne cele cislo
     *
     * @param parent rodic hlasky
     * @param pole pole, ktore overujeme
     * @param min min hodnota
     * @param max max hodnota
     */
    public void hlaskaPrazdneAleboZleCeleCislo(JDialog parent, JTextField pole, int min, int max) {
        String sprava = "Zadali ste nesprávny formát čísla v poli "
                + pole.getName()
                + ". \nPole musí byť vyplnené a môžete do neho zadávať iba celé čísla v rozsahu "
                + min
                + " až "
                + max
                + ".";
        JOptionPane.showMessageDialog(parent, sprava, NADPIS_CHYBOVEJ_HLASKY, ERROR_MESSAGE);
    }

    /**
     * Hlaska pre povinne cele alebo desatinne cislo
     *
     * @param parent rodic hlasky
     * @param pole pole, ktore overujeme
     * @param min min hodnota
     * @param max max hodnota
     */
    public void hlaskaPrazdneAleboZleCeleAleboDesatinneCislo(JDialog parent, JTextField pole, double min, double max) {
        String sprava = "Zadali ste nesprávny formát čísla v poli "
                + pole.getName()
                + ". \nPole musí byť vyplnené a môžete do neho zadávať čísla v rozsahu "
                + min
                + " až "
                + max
                + ". \nAko oddeľovač desatinnej časti použite znak bodky.";
        JOptionPane.showMessageDialog(parent, sprava, NADPIS_CHYBOVEJ_HLASKY, ERROR_MESSAGE);
    }

    /**
     * Hlaska pre povinny string
     *
     * @param parent rodic hlasky
     * @param pole pole, ktore overujeme
     * @param maxDlzka
     */
    public void hlaskaPrazdnyAleboDlhyString(JDialog parent, JTextField pole, int maxDlzka) {
        String sprava = "Zadali ste nesprávny reťazec v poli "
                + pole.getName()
                + ". \nPole musí byť vyplnené a maximálna dĺžka reťazca je "
                + maxDlzka
                + ".";
        JOptionPane.showMessageDialog(parent, sprava, NADPIS_CHYBOVEJ_HLASKY, ERROR_MESSAGE);
    }

    /**
     * Hlaska pre nepovinny string
     *
     * @param parent rodic hlasky
     * @param pole pole, ktore overujeme
     * @param maxDlzka
     */
    public void hlaskaDlhyString(JDialog parent, JTextField pole, int maxDlzka) {
        String sprava = "Zadali ste nesprávny reťazec v poli "
                + pole.getName()
                + ". \nMaximálna dĺžka reťazca je "
                + maxDlzka
                + ".";
        JOptionPane.showMessageDialog(parent, sprava, NADPIS_CHYBOVEJ_HLASKY, ERROR_MESSAGE);
    }

    /**
     * Hlaska pre viac vlekov/lanoviek/trati v prevadzke ako vsetkych
     *
     * @param parent rodic hlasky
     * @param vPrevadzke pocet v prevadzke
     * @param vsetky pocet vsetkych
     */
    public void hlaskaVelaVPrevadzke(JDialog parent, JTextField vPrevadzke, JTextField vsetky) {
        String sprava = "Zadali ste nesprávne hodnoty v poliach "
                + vPrevadzke.getName()
                + " a "
                + vsetky.getName()
                + ".\nHodnota v prevádzke musí byť menšia alebo rovná hodnote všetky.";
        JOptionPane.showMessageDialog(parent, sprava, NADPIS_CHYBOVEJ_HLASKY, ERROR_MESSAGE);
    }

}
