package sk.upjs.ics.paz;

import java.util.HashMap;
import java.util.Map;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

class DatabazovyPouzivateliaDao implements PouzivateliaDao {

    JdbcTemplate jdbcTemplate;

    public DatabazovyPouzivateliaDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Registruje noveho uzivatela
     * @param meno registracne meno
     * @param heslo registracne heslo
     */
    @Override
    public void registruj(String meno, String heslo) {
        String nazovTabulky = meno + "Tab";

        Map<String, Object> hodnoty = new HashMap<>();
        hodnoty.put("Meno", meno);
        hodnoty.put("Heslo", heslo);
        hodnoty.put("Tabulka", nazovTabulky);

        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
        insert.setTableName("Uzivatelia");
        insert.execute(hodnoty);

        vytvorTabulku(nazovTabulky);
    }

    /**
     *
     * @param meno meno uzivatela
     * @param heslo heslo uzivatela
     * @return vrati referenziu na uzivatela zo zadanym menom a heslom
     */
    @Override
    public Pouzivatel dajUzivatela(String meno, String heslo) {
        Pouzivatel pouzivatel = null;
        if (korektneMenoAHeslo(meno, heslo)) {
            pouzivatel = new Pouzivatel();

            pouzivatel.setMeno(meno);
            pouzivatel.setHeslo(heslo);
            pouzivatel.setNazovTabulky(dajTabulku(meno));
        }

        return pouzivatel;
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

    /**
     * Vytvori novy tabulku v databaze
     *
     * @param nazovTabulky nazov vytvaranej tabulky
     */
    private void vytvorTabulku(String nazovTabulky) {
        jdbcTemplate.execute("CREATE TABLE " + nazovTabulky + " LIKE strediska");
        jdbcTemplate.execute("INSERT " + nazovTabulky + " SELECT * FROM strediska");
    }

    @Override
    public boolean existujePouzivatel(String meno) {
        String tabulka = null;
        try {
            String sql = "SELECT Tabulka FROM Uzivatelia WHERE meno = ?";
            tabulka = (String) jdbcTemplate.queryForObject(
                    sql, new Object[]{meno}, String.class);
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
        
        return true;
    }

}
