package sk.upjs.ics.paz.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import sk.upjs.ics.paz.exceptions.NedostatocneOpravneniaNaOperaciuException;
import sk.upjs.ics.paz.entity.*;

public class DatabazovyFiltreDao implements FiltreDao {

    private final JdbcTemplate jdbcTemplate;
    private static final BeanPropertyRowMapper<Filter> mapovac = new BeanPropertyRowMapper<>(Filter.class);
    // meno aktualne prihlaseneho pouzivatela
    private final String menoPouzivatela;
    private final Pouzivatel pouzivatel;

    public DatabazovyFiltreDao(Pouzivatel pouzivatel, JdbcTemplate jdbcTemplate) {
        this.pouzivatel = pouzivatel;
        this.jdbcTemplate = jdbcTemplate;
        mapovac.setPrimitivesDefaultedForNullValue(true);

        // ak pouzivatel nie je prihlaseny, tak sa mu zobrazuju 
        // defaultne filtre, ktore maju nastavene meno pouzivatela "neprihlaseny"
        if (this.pouzivatel == null) {
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
     *
     * @param filter filter, s ktorym narabame
     */
    @Override
    public void uloz(Filter filter) {
        if (pouzivatel == null) {
            throw new NedostatocneOpravneniaNaOperaciuException("Nie som prihlaseny a chcem ukladat.");
        }
        // ak filter nema ziadne id, tak to znamena, ze este nie je v databaze
        if (filter.getId() == null) {
            ulozNovy(filter);
        } else {
            obnov(filter);
        }
    }

    /**
     * upravi existujuci filter
     *
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
            filter.isNutnostPozicatVystroj(),
            filter.isNutnostUbytovat(),
            filter.getId()});
    }

    /**
     * ulozi novy filter
     *
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
        hodnoty.put("daSaPozicatVystroj", filter.isNutnostPozicatVystroj());
        hodnoty.put("daSaUbytovat", filter.isNutnostUbytovat());

        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);

        insert.setTableName("Filtre");
        insert.setGeneratedKeyName("id");
        Number id = insert.executeAndReturnKey(hodnoty);
        filter.setId(id.longValue());
    }

    /**
     * Odstrani filter z databazy
     *
     * @param filter filter, s ktorym narabame
     */
    @Override
    public void odstran(Filter filter) {
        if (pouzivatel == null) {
            throw new NedostatocneOpravneniaNaOperaciuException("Nie som prihlaseny a chcem odstranovat.");
        }
        jdbcTemplate.update("DELETE FROM Filtre WHERE id = ?", filter.getId());
    }

    @Override
    public Filter dajPodlaNazvu(String nazov) {
        String sql = "SELECT * FROM Filtre WHERE nazov = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{nazov}, mapovac);
    }
}
