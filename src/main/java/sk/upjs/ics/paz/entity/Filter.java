package sk.upjs.ics.paz.entity;

import java.math.BigDecimal;

public class Filter {

    // pri vsetkych intoch je prazdna hodnota zadana -1
    private Long id;
    private String nazov;
    private String menoUzivatela;
    private String nazovObsahuje;
    private int minVyskaSnehu;
    private String minPodmienky;
    private int minPocetVlekovVPrevadzke;
    private int minPocetLanoviekVPrevadzke;
    private int minPocetTratiVPrevadzke;
    private BigDecimal maxCenaListkaDospely;
    private BigDecimal maxCenaListkaDieta;
    private BigDecimal maxCenaListkaStudent;
    private boolean daSaPozicatVystroj;
    private boolean daSaUbytovat;

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public String getMenoUzivatela() {
        return menoUzivatela;
    }

    public void setMenoUzivatela(String menoUzivatela) {
        this.menoUzivatela = menoUzivatela;
    }

    public String getNazovObsahuje() {
        return nazovObsahuje;
    }

    public void setNazovObsahuje(String nazovObsahuje) {
        this.nazovObsahuje = nazovObsahuje;
    }

    public int getMinVyskaSnehu() {
        return minVyskaSnehu;
    }

    public void setMinVyskaSnehu(int minVyskaSnehu) {
        this.minVyskaSnehu = minVyskaSnehu;
    }

    public String getMinPodmienky() {
        return minPodmienky;
    }

    public void setMinPodmienky(String minPodmienky) {
        this.minPodmienky = minPodmienky;
    }

    public int getMinPocetVlekovVPrevadzke() {
        return minPocetVlekovVPrevadzke;
    }

    public void setMinPocetVlekovVPrevadzke(int minPocetVlekovVPrevadzke) {
        this.minPocetVlekovVPrevadzke = minPocetVlekovVPrevadzke;
    }

    public int getMinPocetLanoviekVPrevadzke() {
        return minPocetLanoviekVPrevadzke;
    }

    public void setMinPocetLanoviekVPrevadzke(int minPocetLanoviekVPrevadzke) {
        this.minPocetLanoviekVPrevadzke = minPocetLanoviekVPrevadzke;
    }

    public int getMinPocetTratiVPrevadzke() {
        return minPocetTratiVPrevadzke;
    }

    public void setMinPocetTratiVPrevadzke(int minPocetTratiVPrevadzke) {
        this.minPocetTratiVPrevadzke = minPocetTratiVPrevadzke;
    }

    public BigDecimal getMaxCenaListkaDospely() {
        return maxCenaListkaDospely;
    }

    public void setMaxCenaListkaDospely(BigDecimal maxCenaListkaDospely) {
        this.maxCenaListkaDospely = maxCenaListkaDospely;
    }

    public BigDecimal getMaxCenaListkaDieta() {
        return maxCenaListkaDieta;
    }

    public void setMaxCenaListkaDieta(BigDecimal maxCenaListkaDieta) {
        this.maxCenaListkaDieta = maxCenaListkaDieta;
    }

    public BigDecimal getMaxCenaListkaStudent() {
        return maxCenaListkaStudent;
    }

    public void setMaxCenaListkaStudent(BigDecimal maxCenaListkaStudent) {
        this.maxCenaListkaStudent = maxCenaListkaStudent;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
