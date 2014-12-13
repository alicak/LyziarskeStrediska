package sk.upjs.ics.paz.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Filter {

    // povinne udaje
    private Long id;
    private String nazov;
    private String menoUzivatela;

    // nepovinne udaje
    
    // ak nema nejaky udaj zadanu hodnotu, tak to bude 
    // defaultna hodnota novej premennej (kvoli nullom v databaze)
    // String - "", int - 0, BigDecimal - null
    
    private String nazovObsahuje;
    private int minVyskaSnehu;
    private String minPodmienky;
    private int minPocetVlekovVPrevadzke;
    private int minPocetLanoviekVPrevadzke;
    private int minPocetTratiVPrevadzke;
    private BigDecimal maxCenaListkaDospely;
    private BigDecimal maxCenaListkaDieta;
    private BigDecimal maxCenaListkaStudent;
    private boolean nutnostPozicatVystroj;
    private boolean nutnostUbytovat;

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

    public boolean isNutnostPozicatVystroj() {
        return nutnostPozicatVystroj;
    }

    public void setNutnostPozicatVystroj(boolean daSaPozicatVystroj) {
        this.nutnostPozicatVystroj = daSaPozicatVystroj;
    }

    public boolean isNutnostUbytovat() {
        return nutnostUbytovat;
    }

    public void setNutnostUbytovat(boolean daSaUbytovat) {
        this.nutnostUbytovat = daSaUbytovat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Princip filtrovania je taky, ze sa do vysledneho zoznamu pridaju
     * strediska z povodneho zoznamu, ktore vyhovuju prvej podmienke. Potom sa
     * vyberaju tie, ktore vyhovuju druhej podmienke, ale uz nie z povodneho
     * zoznamu, ale z toho, ktory presiel prvou podmienkou. Atd.
     *
     * @param zoznamStredisk zoznam, ktory filtrujeme
     * @param filter filter, ktory pouzivame
     * @return zoznam, ktory je podmnozinou vstupneho zoznamu a vyhovuje
     * podmienkam filtra
     */
    public List<Stredisko> filtruj(List<Stredisko> zoznamStredisk) {
        List<Stredisko> pomocny = new ArrayList<>();
        List<Stredisko> vysledok = new ArrayList<>(zoznamStredisk);

        if (nazovObsahuje != null) {
            pomocny = new ArrayList<>(zoznamStredisk);
            vysledok = new ArrayList<>();
            for (Stredisko s : pomocny) {
                if (s.getNazov().contains(nazovObsahuje)) {
                    vysledok.add(s);
                }
            }
        }

        if (minVyskaSnehu > 0) {
            pomocny = new ArrayList<>(vysledok);
            vysledok = new ArrayList<>();
            for (Stredisko s : pomocny) {
                if (s.getVyskaSnehu() >= minVyskaSnehu) {
                    vysledok.add(s);
                }
            }

        }

        if (!minPodmienky.equals("nezadané")) {
            pomocny = new ArrayList<>(vysledok);
            vysledok = new ArrayList<>();
            Set<String> vyhovujuce = dajLepsiePodmienky(minPodmienky);
            for (Stredisko s : pomocny) {
                if (vyhovujuce.contains(s.getPodmienky()));
                vysledok.add(s);
            }
        }

        if (minPocetVlekovVPrevadzke > 0) {
            pomocny = new ArrayList<>(vysledok);
            vysledok = new ArrayList<>();
            for (Stredisko s : pomocny) {
                if (s.getPocetVlekovVPrevadzke() >= minPocetVlekovVPrevadzke) {
                    vysledok.add(s);
                }
            }
        }

        if (minPocetLanoviekVPrevadzke > 0) {
            pomocny = new ArrayList<>(vysledok);
            vysledok = new ArrayList<>();
            for (Stredisko s : pomocny) {
                if (s.getPocetLanoviekVPrevadzke() >= minPocetLanoviekVPrevadzke) {
                    vysledok.add(s);
                }
            }
        }

        if (minPocetTratiVPrevadzke > 0) {
            pomocny = new ArrayList<>(vysledok);
            vysledok = new ArrayList<>();
            for (Stredisko s : pomocny) {
                if (s.getPocetTratiVPrevadzke() >= minPocetTratiVPrevadzke) {
                    vysledok.add(s);
                }
            }
        }

        if (maxCenaListkaDospely != null) {
            pomocny = new ArrayList<>(vysledok);
            vysledok = new ArrayList<>();
            for (Stredisko s : pomocny) {
                if (s.getCenaListkaDospely().doubleValue() <= maxCenaListkaDospely.doubleValue()) {
                    vysledok.add(s);
                }
            }
        }

        if (maxCenaListkaDieta != null) {
            pomocny = new ArrayList<>(vysledok);
            vysledok = new ArrayList<>();
            for (Stredisko s : pomocny) {
                if (s.getCenaListkaDieta().doubleValue() <= maxCenaListkaDieta.doubleValue()) {
                    vysledok.add(s);
                }
            }
        }

        if (maxCenaListkaStudent != null) {
            pomocny = new ArrayList<>(vysledok);
            vysledok = new ArrayList<>();
            for (Stredisko s : pomocny) {
                if (s.getCenaListkaStudent().doubleValue() <= maxCenaListkaStudent.doubleValue()) {
                    vysledok.add(s);
                }
            }
        }

        if (nutnostPozicatVystroj) {
            pomocny = new ArrayList<>(vysledok);
            vysledok = new ArrayList<>();
            for (Stredisko s : pomocny) {
                if (s.isDaSaPozicatVystroj()) {
                    vysledok.add(s);
                }
            }
        }

        if (nutnostPozicatVystroj) {
            pomocny = new ArrayList<>(vysledok);
            vysledok = new ArrayList<>();
            for (Stredisko s : pomocny) {
                if (s.isDaSaUbytovat()) {
                    vysledok.add(s);
                }
            }
        }
        return vysledok;
    }

    /**
     * @param podmienky najhorsie mozne podmienky
     * @return mnozinu podmienok, ktore su lepsie alebo rovnake ako vstupne
     */
    private Set<String> dajLepsiePodmienky(String podmienky) {
        Set<String> vysledok = new HashSet<>();

        if (podmienky.equals("výborné")) {
            vysledok.add("výborné");
        } else if (podmienky.equals("veľmi dobré")) {
            vysledok.add("výborné");
            vysledok.add("veľmi dobré");
        } else if (podmienky.equals("dobré")) {
            vysledok.add("výborné");
            vysledok.add("veľmi dobré");
            vysledok.add("dobré");
        } else if (podmienky.equals("obmedzené")) {
            vysledok.add("výborné");
            vysledok.add("veľmi dobré");
            vysledok.add("dobré");
            vysledok.add("obmedzené");
        }

        return vysledok;
    }

}
