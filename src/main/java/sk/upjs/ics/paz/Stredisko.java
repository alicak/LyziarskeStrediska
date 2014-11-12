
package sk.upjs.ics.paz;

public class Stredisko {
    private Long id;
    private String nazov;
    private int vyskaSnehu;
    private String podmienky;
    private int pocetVlekov;
    private int pocetVlekovVPrevadzke;
    private int pocetLanoviek;
    private int pocetLanoviekVPrevadzke;
    private double cenaListkaDospely;
    private double cenaListkaDieta;
    private double cenaListkaStudent;
    private boolean daSaPozicatVystroj;
    private boolean daSaUbytovat;
    private double gpsSirka;
    private double gpsDlzka;
    

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

    public double getCenaListkaDospely() {
        return cenaListkaDospely;
    }

    public void setCenaListkaDospely(double cenaListkaDospely) {
        this.cenaListkaDospely = cenaListkaDospely;
    }

    public double getCenaListkaDieta() {
        return cenaListkaDieta;
    }

    public void setCenaListkaDieta(double cenaListkaDieta) {
        this.cenaListkaDieta = cenaListkaDieta;
    }

    public double getCenaListkaStudent() {
        return cenaListkaStudent;
    }

    public void setCenaListkaStudent(double cenaListkaStudent) {
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

    public double getGpsSirka() {
        return gpsSirka;
    }

    public void setGpsSirka(double gpsSirka) {
        this.gpsSirka = gpsSirka;
    }

    public double getGpsDlzka() {
        return gpsDlzka;
    }
    
    public void setGpsDlzka(double gpsDlzka) {
        this.gpsDlzka = gpsDlzka;
    }
    
}
