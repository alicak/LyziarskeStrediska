package sk.upjs.ics.paz.tests;

import javax.swing.JTextField;
import org.junit.Test;
import static org.junit.Assert.*;
import sk.upjs.ics.paz.gui.VerifikatorVstupov;

public class VerifikatorVstupovTest {

    private final VerifikatorVstupov verifikaciaVstupov = new VerifikatorVstupov();
    private final JTextField jTextField = new JTextField();

    @Test
    public void jeNeprazdnyAnoTest() {
        String string = "";
        jTextField.setText(string);

        assertFalse(verifikaciaVstupov.jeNeprazdny(jTextField));
    }

    @Test
    public void jeNeprazdnyNieTest() {
        String string = "hahaha";
        jTextField.setText(string);

        assertTrue(verifikaciaVstupov.jeNeprazdny(jTextField));
    }

    @Test
    public void jeCeleCisloVRozsahuAnoTest() {
        String string = "15";
        jTextField.setText(string);

        assertTrue(verifikaciaVstupov.jeCeleCisloVRozsahu(jTextField, 10, 20));
    }

    @Test
    public void jeCeleCisloVRozsahuNieTest() {
        String string = "30";
        jTextField.setText(string);

        assertFalse(verifikaciaVstupov.jeCeleCisloVRozsahu(jTextField, 10, 20));
    }

    @Test
    public void jeCeleCisloVRozsahuAnoTestSCelymCislom() {
        String string = "15";
        jTextField.setText(string);

        assertTrue(verifikaciaVstupov.jeCeleAleboDesatinneCisloVRozsahu(jTextField, 10, 20));
    }

    @Test
    public void jeCeleCisloVRozsahuNieTestSCelymCislom() {
        String string = "30";
        jTextField.setText(string);

        assertFalse(verifikaciaVstupov.jeCeleAleboDesatinneCisloVRozsahu(jTextField, 10, 20));
    }

    @Test
    public void jeCeleCisloVRozsahuAnoTestSDesatinnymCislom() {
        String string = "10.789";
        jTextField.setText(string);

        assertTrue(verifikaciaVstupov.jeCeleAleboDesatinneCisloVRozsahu(jTextField, 10.512, 20.236));
    }

    @Test
    public void jeCeleCisloVRozsahuNieTestSDesatinnymCislom() {
        String string = "30.126";
        jTextField.setText(string);

        assertFalse(verifikaciaVstupov.jeCeleAleboDesatinneCisloVRozsahu(jTextField, 10.512, 20.236));
    }

    @Test
    public void jeMaxDlzkyAnoTest() {
        String string = "0123456789";
        jTextField.setText(string);

        assertTrue(verifikaciaVstupov.jeMaxDlzky(jTextField, 10));
    }

    @Test
    public void jeMaxDlzkyNieTest() {
        String string = "01234567890";
        jTextField.setText(string);

        assertFalse(verifikaciaVstupov.jeMaxDlzky(jTextField, 10));
    }

    @Test
    public void jeNeprazdneMaxDlzkyAnoTest() {
        String string = "0123456789";
        jTextField.setText(string);

        assertTrue(verifikaciaVstupov.jeNeprazdneMaxDlzky(jTextField, 10));
    }

    @Test
    public void jeNeprazdneMaxDlzkyNieTest() {
        String string = "01234567890";
        jTextField.setText(string);

        assertFalse(verifikaciaVstupov.jeNeprazdneMaxDlzky(jTextField, 10));
    }

    @Test
    public void jeNeprazdneMaxDlzkyNieTestPrePrazdne() {
        String string = "";
        jTextField.setText(string);

        assertFalse(verifikaciaVstupov.jeNeprazdneMaxDlzky(jTextField, 10));
    }

    @Test
    public void jeVPrevadzkeMenejAkoVsetkychAnoTest() {
        String string = "10";
        jTextField.setText(string);

        JTextField vsetky = new JTextField();
        vsetky.setText("20");

        assertTrue(verifikaciaVstupov.jeVPrevadzkeMenejAkoVsetkych(jTextField, vsetky));
    }

    @Test
    public void jeVPrevadzkeMenejAkoVsetkychNieTest() {
        String string = "30";
        jTextField.setText(string);

        JTextField vsetky = new JTextField();
        vsetky.setText("20");

        assertFalse(verifikaciaVstupov.jeVPrevadzkeMenejAkoVsetkych(jTextField, vsetky));
    }

    @Test
    public void jeVPoliCeleCisloAnoTest() {
        String string = "30";
        jTextField.setText(string);

        assertTrue(verifikaciaVstupov.jeCeleCislo(jTextField));
    }

    @Test
    public void jeVPoliCeleCisloNieTestPreDesatinne() {
        String string = "30.126";
        jTextField.setText(string);

        assertFalse(verifikaciaVstupov.jeCeleCislo(jTextField));
    }

    @Test
    public void jeVPoliCeleCisloNieTestPrePrazdnyString() {
        String string = "";
        jTextField.setText(string);

        assertFalse(verifikaciaVstupov.jeCeleCislo(jTextField));
    }

    @Test
    public void jeVPoliCeleCisloNieTestPreNezmysel() {
        String string = "asd)9as[f;zx";
        jTextField.setText(string);

        assertFalse(verifikaciaVstupov.jeCeleCislo(jTextField));
    }

    @Test
    public void jeVPoliDesatinneCisloAnoTest() {
        String string = "30.126";
        jTextField.setText(string);

        assertTrue(verifikaciaVstupov.jeDesatinneCislo(jTextField));
    }

    @Test
    public void jeVPoliDesatinneCisloAnoTestPreCele() {
        String string = "30";
        jTextField.setText(string);

        assertTrue(verifikaciaVstupov.jeDesatinneCislo(jTextField));
    }

    @Test
    public void jeVPoliDesatinneCisloNieTestPrePrazdnyString() {
        String string = "";
        jTextField.setText(string);

        assertFalse(verifikaciaVstupov.jeDesatinneCislo(jTextField));
    }

    @Test
    public void jeVPoliDesatinneCisloNieTestPreNezmysel() {
        String string = "asd)9as[f;zx";
        jTextField.setText(string);

        assertFalse(verifikaciaVstupov.jeDesatinneCislo(jTextField));
    }
}
