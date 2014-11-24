package sk.upjs.ics.paz;

import java.math.BigDecimal;

public class Stredisko {

    private Long id;
    private String nazov;
    private int vyskaSnehu;
    private String podmienky;
    private int pocetVlekov;
    private int pocetVlekovVPrevadzke;
    private int pocetLanoviek;
    private int pocetLanoviekVPrevadzke;
    //TODO tieto premenne treba este pridat do databazy
    //private int pocetTrati;
    //private int pocetTratiVPrevadzke;
    private BigDecimal cenaListkaDospely;
    private BigDecimal cenaListkaStudent;
    private BigDecimal cenaListkaDieta;
    private boolean daSaPozicatVystroj;
    private boolean daSaUbytovat;
    private BigDecimal gpsSirka;
    private BigDecimal gpsDlzka;

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getVyskaSnehu() {
        return vyskaSnehu;
    }

    public void setVyskaSnehu(int vyskaSnehu) {
        this.vyskaSnehu = vyskaSnehu;
    }

    public String getPodmienky() {
        return podmienky;
    }

    public void setPodmienky(String podmienky) {
        this.podmienky = podmienky;
    }

    public int getPocetVlekov() {
        return pocetVlekov;
    }

    public void setPocetVlekov(int pocetVlekov) {
        this.pocetVlekov = pocetVlekov;
    }

    public int getPocetVlekovVPrevadzke() {
        return pocetVlekovVPrevadzke;
    }

    public void setPocetVlekovVPrevadzke(int pocetVlekovVPrevadzke) {
        this.pocetVlekovVPrevadzke = pocetVlekovVPrevadzke;
    }

    public int getPocetLanoviek() {
        return pocetLanoviek;
    }

    public void setPocetLanoviek(int pocetLanoviek) {
        this.pocetLanoviek = pocetLanoviek;
    }

    public int getPocetLanoviekVPrevadzke() {
        return pocetLanoviekVPrevadzke;
    }

    public void setPocetLanoviekVPrevadzke(int pocetLanoviekVPrevadzke) {
        this.pocetLanoviekVPrevadzke = pocetLanoviekVPrevadzke;
    }
    
//    public int getPocetTrati() {
//        return pocetTrati;
//    }
//    
//    public int setPocetTrati(int pocetTrati) {
//        this.pocetTrati = pocetTrati;
//    }
//    
//    public int getPocetTratiVPrevadzke() {
//        return pocetTratiVPrevadzke;
//    }
//    
//    public int setPocetTratiVPrevadzke(int pocetTratiVPrevadzke) {
//        this.pocetTratiVPrevadzke = pocetTratiVPrevadzke;
//    }

    public BigDecimal getCenaListkaDospely() {
        return cenaListkaDospely;
    }

    public void setCenaListkaDospely(BigDecimal cenaListkaDospely) {
        this.cenaListkaDospely = cenaListkaDospely;
    }

    public BigDecimal getCenaListkaDieta() {
        return cenaListkaDieta;
    }

    public void setCenaListkaDieta(BigDecimal cenaListkaDieta) {
        this.cenaListkaDieta = cenaListkaDieta;
    }

    public BigDecimal getCenaListkaStudent() {
        return cenaListkaStudent;
    }

    public void setCenaListkaStudent(BigDecimal cenaListkaStudent) {
        this.cenaListkaStudent = cenaListkaStudent;
    }

    public boolean isDaSaPozicatVystroj() {
        return daSaPozicatVystroj;
    }

    public void setDaSaPozicatVystroj(boolean daSaPozicatVystroj) {
        this.daSaPozicatVystroj = daSaPozicatVystroj;
    }

    public boolean isDaSaUbytovat() {
        return daSaUbytovat;
    }

    public void setDaSaUbytovat(boolean daSaUbytovat) {
        this.daSaUbytovat = daSaUbytovat;
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
