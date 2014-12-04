package sk.upjs.ics.paz;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.util.HashMap;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class DatabazovyStrediskaDao implements StrediskaDao {

    private final JdbcTemplate jdbcTemplate;
    private static final BeanPropertyRowMapper<Stredisko> mapovac = new BeanPropertyRowMapper<>(Stredisko.class);
    private String tabulkaSKtorouPracujem;
    private boolean prihlaseny = false;

    public DatabazovyStrediskaDao(String meno, String heslo) {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://db4free.net:3306/paz1c2014ak");
        dataSource.setUser("alica");
        dataSource.setPassword("fdacbeedk");

        jdbcTemplate = new JdbcTemplate(dataSource);

        if (meno == null && heslo == null) {
            tabulkaSKtorouPracujem = "strediska";
            return;
        }

        if (!korektneMenoAHeslo(meno, heslo)) {
            throw new Error("Zle meno alebo heslo!");
        } else {
            tabulkaSKtorouPracujem = dajTabulku(meno);
            prihlaseny = true;
        }
    }

    /**
     * @return zoznam vsetkych poloziek z tabulky strediska
     */
    @Override
    public List<Stredisko> dajVsetky() {
        return jdbcTemplate.query("SELECT * FROM " + tabulkaSKtorouPracujem, mapovac);
    }

    /**
     * Ulozi nove / updatuje existujuce stredisko
     *
     * @param stredisko stredisko, ktore chceme pridat
     */
    @Override
    public void uloz(Stredisko stredisko) {
        if (stredisko.getId() == null) {
            ulozNove(stredisko);
        } else {
            obnov(stredisko);
        }
    }

    /**
     * Obnovi existujuce stredisko
     *
     * @param stredisko stredisko, ktore chceme obnovit
     */
    private void obnov(Stredisko stredisko) throws DataAccessException {
        String sql = "UPDATE " + tabulkaSKtorouPracujem + "\n"
                + "SET nazov = ?,\n"
                + "vyskaSnehu = ?,\n"
                + "podmienky = ?,\n"
                + "pocetVlekov = ?,\n"
                + "pocetVlekovVPrevadzke = ?,\n"
                + "pocetLanoviek = ?,\n"
                + "pocetLanoviekVPrevadzke = ?,\n"
                + "pocetTrati = ?,\n"
                + "pocetTratiVPrevadzke = ?,\n"
                + "cenaListkaDospely = ?,\n"
                + "cenaListkaDieta = ?,\n"
                + "cenaListkaStudent = ?,\n"
                + "daSaPozicatVystroj = ?,\n"
                + "daSaUbytovat = ?,\n"
                + "gpsSirka = ?,\n"
                + "gpsDlzka = ?\n"
                + "WHERE id = ?";

        // viac parametrov sa zadava ako pole objektov
        jdbcTemplate.update(sql, new Object[]{
            stredisko.getNazov(),
            stredisko.getVyskaSnehu(),
            stredisko.getPodmienky(),
            stredisko.getPocetVlekov(),
            stredisko.getPocetVlekovVPrevadzke(),
            stredisko.getPocetLanoviek(),
            stredisko.getPocetVlekovVPrevadzke(),
            stredisko.getPocetTrati(),
            stredisko.getPocetTratiVPrevadzke(),
            stredisko.getCenaListkaDospely(),
            stredisko.getCenaListkaDieta(),
            stredisko.getCenaListkaStudent(),
            stredisko.isDaSaPozicatVystroj(),
            stredisko.isDaSaUbytovat(),
            stredisko.getGpsSirka(),
            stredisko.getGpsDlzka(),
            stredisko.getId()});
    }

    /**
     * Ulozi nove stredisko
     *
     * @param stredisko stredisko, ktore chceme pridat
     */
    private void ulozNove(Stredisko stredisko) {
        Map<String, Object> hodnoty = new HashMap<>();
        hodnoty.put("nazov", stredisko.getNazov());
        hodnoty.put("vyskaSnehu", stredisko.getVyskaSnehu());
        hodnoty.put("podmienky", stredisko.getPodmienky());
        hodnoty.put("pocetVlekov", stredisko.getPocetVlekov());
        hodnoty.put("pocetVlekovVPrevadzke", stredisko.getPocetVlekovVPrevadzke());
        hodnoty.put("pocetLanoviek", stredisko.getPocetLanoviek());
        hodnoty.put("pocetLanoviekVPrevadzke", stredisko.getPocetVlekovVPrevadzke());
        hodnoty.put("pocetTrati", stredisko.getPocetTrati());
        hodnoty.put("pocetTratiVPrevadzke", stredisko.getPocetTratiVPrevadzke());
        hodnoty.put("cenaListkaDospely", stredisko.getCenaListkaDospely());
        hodnoty.put("cenaListkaDieta", stredisko.getCenaListkaDieta());
        hodnoty.put("cenaListkaStudent", stredisko.getCenaListkaStudent());
        hodnoty.put("daSaPozicatVystroj", stredisko.isDaSaPozicatVystroj());
        hodnoty.put("daSaUbytovat", stredisko.isDaSaUbytovat());
        hodnoty.put("gpsSirka", stredisko.getGpsSirka());
        hodnoty.put("gpsDlzka", stredisko.getGpsDlzka());

        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);

        insert.setGeneratedKeyName("id");

        insert.setTableName(tabulkaSKtorouPracujem);
        Number id = insert.executeAndReturnKey(hodnoty);
        stredisko.setId(id.longValue());
    }

    /**
     * Odstrani stredisko z databazy
     *
     * @param stredisko stredisko, ktore odstranujeme
     */
    @Override
    public void odstran(Stredisko stredisko) {
        // jdbcTemplate.update("DELETE FROM ? WHERE id = ?", tabulkaSKtorouPracujem, stredisko.getId());
        // meno tabulky nemoze vystupovat ako parameter v PreparedStatement, hadze to vynimky
        jdbcTemplate.update("DELETE FROM " + tabulkaSKtorouPracujem + " WHERE id = ?",
                stredisko.getId());

    }

    /**
     *
     * @return Vrati, ci uzivatel je alebo nie je prihlaseny.
     */
    @Override
    public boolean isPrihlaseny() {
        return prihlaseny;
    }

    /**
     * Overi, ci je zadane spravne meno a heslo
     *
     * @param meno prihlasovacie meno
     * @param heslo prihasovacie heslo
     * @return true ak je zadane korektne meno a heslo
     */
    public boolean korektneMenoAHeslo(String meno, String heslo) {
        String hesloZTabulky;
        try {
            String sql = "SELECT Heslo FROM Uzivatelia WHERE meno = ?";
            hesloZTabulky = (String) jdbcTemplate.queryForObject(
                    sql, new Object[]{meno}, String.class);
        } catch (EmptyResultDataAccessException e) {
            return false;
        }

        return hesloZTabulky.equals(heslo);
    }

    /**
     *
     * @param meno meno uzivatela, ktoreho tabulka sa ma vratit
     * @return vrati nazov tabulky pre zadaneho uzivatela
     */
    private String dajTabulku(String meno) {
        String sql = "SELECT Tabulka FROM Uzivatelia WHERE meno = ?";
        return (String) jdbcTemplate.queryForObject(
                sql, new Object[]{meno}, String.class);
    }

}
