package sk.upjs.ics.paz.gui;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.JTextField;

// Regularne vyrazy:
// http://ocpsoft.org/opensource/guide-to-regular-expressions-in-java-part-1/
public class VerifikatorVstupov {

    private String nadpisChybovejHlasky = "Chyba - nesprávny vstup";

    public boolean jeNeprazdny(JTextField pole) {
        return !pole.getText().equals("");
    }

    private boolean jeDesatinneCislo(JTextField pole) {
        // regularny vyraz - znamena 0 alebo 1 minus,
        // 1 alebo viac cislic, za tym bodku a za tym zase 1 alebo viac cislic
        return pole.getText().matches("-?\\d+\\.\\d+");
    }

    private boolean jeCeleCislo(JTextField pole) {
        // regularny vyraz - znamena 0 alebo 1 minus
        // a za tym 1 alebo viac cislic
        return pole.getText().matches("-?\\d+");
    }

    private boolean jeCeleAleboDesatinneCislo(JTextField pole) {
        return jeDesatinneCislo(pole) || jeCeleCislo(pole);
    }

    // ---------------------
    // Metody pre overovanie
    // ---------------------
    public boolean jeCeleCisloVRozsahu(JTextField pole, int min, int max) {
        if (!jeCeleCislo(pole)) {
            return false;
        }
        int hodnota = Integer.valueOf(pole.getText());
        return (hodnota >= min && hodnota <= max);
    }

    public boolean jeCeleAleboDesatinneCisloVRozsahu(JTextField pole, double min, double max) {
        if (!jeCeleAleboDesatinneCislo(pole)) {
            return false;
        }
        double hodnota = Double.valueOf(pole.getText());
        return (hodnota >= min && hodnota <= max);
    }

    public boolean jeMaxDlzky(JTextField pole, int maxDlzka) {
        int dlzka = pole.getText().length();
        return dlzka <= maxDlzka;
    }

    public boolean jeNeprazdneMaxDlzky(JTextField pole, int maxDlzka) {
        if (!jeNeprazdny(pole)) {
            return false;
        }
        int dlzka = pole.getText().length();
        return dlzka <= maxDlzka;
    }

    public boolean jeVPrevadzkeMenejAkoVsetkych(JTextField vPrevadzke, JTextField vsetky) {
        return Integer.valueOf(vPrevadzke.getText()) <= Integer.valueOf(vsetky.getText());
    }

    // ---------------------------
    // Vytvaranie chybovych hlasok
    // ---------------------------
    public void hlaskaPrazdneAleboZleCeleCislo(JDialog parent, JTextField pole, int min, int max) {
        String sprava = "Zadali ste nesprávny formát čísla v poli "
                + pole.getName()
                + ". \nPole musí byť vyplnené a môžete do neho zadávať iba celé čísla v rozsahu "
                + min
                + " až "
                + max
                + ".";
        JOptionPane.showMessageDialog(parent, sprava, nadpisChybovejHlasky, ERROR_MESSAGE);
    }

    public void hlaskaPrazdneAleboZleCeleAleboDesatinneCislo(JDialog parent, JTextField pole, double min, double max) {
        String sprava = "Zadali ste nesprávny formát čísla v poli "
                + pole.getName()
                + ". \nPole musí byť vyplnené a môžete do neho zadávať čísla v rozsahu "
                + min
                + " až "
                + max
                + ". \nAko oddeľovač desatinnej časti použite znak bodky.";
        JOptionPane.showMessageDialog(parent, sprava, nadpisChybovejHlasky, ERROR_MESSAGE);
    }

    public void hlaskaPrazdnyAleboDlhyString(JDialog parent, JTextField pole, int maxDlzka) {
        String sprava = "Zadali ste nesprávny reťazec v poli "
                + pole.getName()
                + ". \nPole musí byť vyplnené a maximálna dĺžka reťazca je "
                + maxDlzka
                + ".";
        JOptionPane.showMessageDialog(parent, sprava, nadpisChybovejHlasky, ERROR_MESSAGE);
    }

    public void hlaskaDlhyString(JDialog parent, JTextField pole, int maxDlzka) {
        String sprava = "Zadali ste nesprávny reťazec v poli "
                + pole.getName()
                + ". \nMaximálna dĺžka reťazca je "
                + maxDlzka
                + ".";
        JOptionPane.showMessageDialog(parent, sprava, nadpisChybovejHlasky, ERROR_MESSAGE);
    }

    public void hlaskaVelaVPrevadzke(JDialog parent, JTextField vPrevadzke, JTextField vsetky) {
        String sprava = "Zadali ste nesprávne hodnoty v poliach "
                + vPrevadzke.getName()
                + " a "
                + vsetky.getName()
                + ".\nHodnota v prevádzke musí byť menšia alebo rovná hodnote všetky.";
        JOptionPane.showMessageDialog(parent, sprava, nadpisChybovejHlasky, ERROR_MESSAGE);
    }
}
