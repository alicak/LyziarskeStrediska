package sk.upjs.ics.paz;

import java.math.BigDecimal;

class Pouzivatel {
    private String meno;

    private String heslo;

    private String nazovTabulky;
    
    private BigDecimal gpsSirka;
    
    private BigDecimal gpsDlzka;

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public String getHeslo() {
        return heslo;
    }

    public void setHeslo(String heslo) {
        this.heslo = heslo;
    }

    public String getNazovTabulky() {
        return nazovTabulky;
    }

    public void setNazovTabulky(String nazovTabulky) {
        this.nazovTabulky = nazovTabulky;
    }

    public BigDecimal getGpsSirka() {
        return gpsSirka;
    }

    public void setGpsSirka(BigDecimal gpsSirka) {
        this.gpsSirka = gpsSirka;
    }


    public BigDecimal getGpsDlzka() {
        return gpsDlzka;
    }

    public void setGpsDlzka(BigDecimal gpsDlzka) {
        this.gpsDlzka = gpsDlzka;
    }
}
