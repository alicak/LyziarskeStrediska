package sk.upjs.ics.paz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class DatabazovyFiltreDao implements FiltreDao {

    private final JdbcTemplate jdbcTemplate;
    private static final BeanPropertyRowMapper<Filter> mapovac = new BeanPropertyRowMapper<>(Filter.class);
    // meno aktualne prihlaseneho pouzivatela
    private String menoPouzivatela;

    public DatabazovyFiltreDao(Pouzivatel pouzivatel, JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

        // ak pouzivatel nie je prihlaseny, tak sa mu zobrazuju 
        // defaultne filtre, ktore maju nastavene meno pouzivatela "neprihlaseny"
        if (pouzivatel == null) {
            menoPouzivatela = "neprihlaseny";
            return;
        }

        menoPouzivatela = pouzivatel.getMeno();
    }

    /** 
     * @return zoznam vsetkych filtrov aktualneho pouzivatela
     */
    @Override
    public List<Filter> dajVsetky() {
        String sql = "SELECT * FROM Filtre WHERE menoUzivatela = ?";
        return jdbcTemplate.query(sql, new Object[]{menoPouzivatela}, mapovac);
    }

    /**
     * vytvori novy / upravi existujuci filter
     * @param filter filter, s ktorym narabame
     */
    @Override
    public void uloz(Filter filter) {
        // ak filter nema ziadne id, tak to znamena, ze este nie je v databaze
        if (filter.getId() == null) {
            ulozNovy(filter);
        } else {
            obnov(filter);
        }
    }

    /**
     * upravi existujuci filter
     * @param filter filter, s ktorym narabame
     */
    private void obnov(Filter filter) {
        String sql = "UPDATE Filtre \n"
                + "SET nazov = ?,\n"
                + "menoUzivatela = ?,\n"
                + "nazovObsahuje = ?,\n"
                + "minVyskaSnehu = ?,\n"
                + "minPodmienky = ?,\n"
                + "minPocetVlekovVPrevadzke = ?,\n"
                + "minPocetLanoviekVPrevadzke = ?,\n"
                + "minPocetTratiVPrevadzke = ?,\n"
                + "maxCenaListkaDospely = ?,\n"
                + "maxCenaListkaDieta = ?,\n"
                + "maxCenaListkaStudent = ?,\n"
                + "daSaPozicatVystroj = ?,\n"
                + "daSaUbytovat = ?,\n"
                + "WHERE id = ?";

        jdbcTemplate.update(sql, new Object[]{
            filter.getNazov(),
            filter.getMenoUzivatela(),
            filter.getNazovObsahuje(),
            filter.getMinVyskaSnehu(),
            filter.getMinPodmienky(),
            filter.getMinPocetVlekovVPrevadzke(),
            filter.getMinPocetLanoviekVPrevadzke(),
            filter.getMinPocetTratiVPrevadzke(),
            filter.getMaxCenaListkaDospely(),
            filter.getMaxCenaListkaDieta(),
            filter.getMaxCenaListkaStudent(),
            filter.isDaSaPozicatVystroj(),
            filter.isDaSaUbytovat(),
            filter.getId()});
    }

    /**
     * ulozi novy filter
     * @param filter filter, s ktorym narabame
     */
    private void ulozNovy(Filter filter) {
        Map<String, Object> hodnoty = new HashMap<>();
        hodnoty.put("nazov", filter.getNazov());
        hodnoty.put("menoUzivatela", filter.getMenoUzivatela());
        hodnoty.put("nazovObsahuje", filter.getNazovObsahuje());
        hodnoty.put("nazov", filter.getNazov());
        hodnoty.put("minVyskaSnehu", filter.getMinVyskaSnehu());
        hodnoty.put("minPodmienky", filter.getMinPodmienky());
        hodnoty.put("minPocetVlekovVPrevadzke", filter.getMinPocetVlekovVPrevadzke());
        hodnoty.put("minPocetLanoviekVPrevadzke", filter.getMinPocetLanoviekVPrevadzke());
        hodnoty.put("minPocetTratiVPrevadzke", filter.getMinPocetTratiVPrevadzke());
        hodnoty.put("maxCenaListkaDospely", filter.getMaxCenaListkaDospely());
        hodnoty.put("maxCenaListkaDieta", filter.getMaxCenaListkaDieta());
        hodnoty.put("maxCenaListkaStudent", filter.getMaxCenaListkaStudent());
        hodnoty.put("daSaPozicatVystroj", filter.isDaSaPozicatVystroj());
        hodnoty.put("daSaUbytovat", filter.isDaSaUbytovat());

        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);

        insert.setGeneratedKeyName("id");
        Number id = insert.executeAndReturnKey(hodnoty);
        filter.setId(id.longValue());
    }

    /**
     * Odstrani filter z databazy
     * @param filter filter, s ktorym narabame
     */
    @Override
    public void odstran(Filter filter) {
        jdbcTemplate.update("DELETE FROM Filtre WHERE id = ?", filter.getId());
    }

    /**
     * Princip filtrovania je taky, ze sa do vysledneho zoznamu pridaju strediska
     * z povodneho zoznamu, ktore vyhovuju prvej podmienke. Potom sa vyberaju tie,
     * ktore vyhovuju druhej podmienke, ale uz nie z povodneho zoznamu, ale z toho,
     * ktory presiel prvou podmienkou. Atd.
     * @param zoznamStredisk zoznam, ktory filtrujeme
     * @param filter filter, ktory pouzivame
     * @return zoznam, ktory je podmnozinou vstupneho zoznamu a vyhovuje podmienkam filtra
     */
    public List<Stredisko> filtruj(List<Stredisko> zoznamStredisk, Filter filter) {
        List<Stredisko> pomocny = new ArrayList<>(zoznamStredisk);
        List<Stredisko> vysledok = new ArrayList<>();

        if (filter.getNazovObsahuje() != null) {
            for (Stredisko s : pomocny) {
                if (s.getNazov().contains(filter.getNazovObsahuje())) {
                    vysledok.add(s);
                }
            }
            pomocny = new ArrayList<>(vysledok);
            vysledok = new ArrayList<>();
        }

        if (filter.getMinVyskaSnehu() > 0) {
            for (Stredisko s : pomocny) {
                if (s.getVyskaSnehu() >= filter.getMinVyskaSnehu()) {
                    vysledok.add(s);
                }
            }
            pomocny = new ArrayList<>(vysledok);
            vysledok = new ArrayList<>();
        }

        if (!filter.getMinPodmienky().equals("nezadané")) {
            Set<String> vyhovujuce = dajLepsiePodmienky(filter.getMinPodmienky());
            for (Stredisko s : pomocny) {
                if (vyhovujuce.contains(s.getPodmienky()));
                vysledok.add(s);
            }
            pomocny = new ArrayList<>(vysledok);
            vysledok = new ArrayList<>();
        }

        if (filter.getMinPocetVlekovVPrevadzke() > 0) {
            for (Stredisko s : pomocny) {
                if (s.getPocetVlekovVPrevadzke() >= filter.getMinPocetVlekovVPrevadzke()) {
                    vysledok.add(s);
                }
            }
            pomocny = new ArrayList<>(vysledok);
            vysledok = new ArrayList<>();
        }

        if (filter.getMinPocetLanoviekVPrevadzke() > 0) {
            for (Stredisko s : pomocny) {
                if (s.getPocetLanoviekVPrevadzke() >= filter.getMinPocetLanoviekVPrevadzke()) {
                    vysledok.add(s);
                }
            }
            pomocny = new ArrayList<>(vysledok);
            vysledok = new ArrayList<>();
        }

        if (filter.getMinPocetTratiVPrevadzke() > 0) {
            for (Stredisko s : pomocny) {
                if (s.getPocetTratiVPrevadzke() >= filter.getMinPocetTratiVPrevadzke()) {
                    vysledok.add(s);
                }
            }
            pomocny = new ArrayList<>(vysledok);
            vysledok = new ArrayList<>();
        }

        if (filter.getMaxCenaListkaDospely().intValue() > 0) {
            for (Stredisko s : pomocny) {
                if (s.getCenaListkaDospely().doubleValue() <= filter.getMaxCenaListkaDospely().doubleValue()) {
                    vysledok.add(s);
                }
            }
            pomocny = new ArrayList<>(vysledok);
            vysledok = new ArrayList<>();
        }

        if (filter.getMaxCenaListkaDieta().intValue() > 0) {
            for (Stredisko s : pomocny) {
                if (s.getCenaListkaDieta().doubleValue() <= filter.getMaxCenaListkaDieta().doubleValue()) {
                    vysledok.add(s);
                }
            }
            pomocny = new ArrayList<>(vysledok);
            vysledok = new ArrayList<>();
        }

        if (filter.getMaxCenaListkaStudent().intValue() > 0) {
            for (Stredisko s : pomocny) {
                if (s.getCenaListkaStudent().doubleValue() <= filter.getMaxCenaListkaStudent().doubleValue()) {
                    vysledok.add(s);
                }
            }
            pomocny = new ArrayList<>(vysledok);
            vysledok = new ArrayList<>();
        }

        for (Stredisko s : pomocny) {
            if (s.isDaSaPozicatVystroj() == filter.isDaSaPozicatVystroj()) {
                vysledok.add(s);
            }
        }
        pomocny = new ArrayList<>(vysledok);
        vysledok = new ArrayList<>();

        for (Stredisko s : pomocny) {
            if (s.isDaSaUbytovat() == filter.isDaSaUbytovat()) {
                vysledok.add(s);
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
