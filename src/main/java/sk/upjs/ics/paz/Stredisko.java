
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
    
}
