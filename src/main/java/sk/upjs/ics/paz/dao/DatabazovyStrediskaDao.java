package sk.upjs.ics.paz.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import sk.upjs.ics.paz.entity.Pouzivatel;
import sk.upjs.ics.paz.entity.Stredisko;

public class DatabazovyStrediskaDao implements StrediskaDao {

    private final JdbcTemplate jdbcTemplate;
    private static final BeanPropertyRowMapper<Stredisko> mapovac = new BeanPropertyRowMapper<>(Stredisko.class);
    private final String tabulkaSKtorouPracujem;

    public DatabazovyStrediskaDao(Pouzivatel pouzivatel, JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

        if (pouzivatel == null) {
            tabulkaSKtorouPracujem = "strediska";
            return;
        }

        tabulkaSKtorouPracujem = pouzivatel.getNazovTabulky();
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
     * Vrati zoznam stredisk nachadzajucich sa v danom okruhu
     *
     * @param sirka zemepisna sirka miesta
     * @param dlzka zemepisna dlzka miesta 
     * @param okruh polomer okruhu v kilometroch
     * @return
     */
    public List<Stredisko> najdiStrediskaVOkruhu(BigDecimal sirka, BigDecimal dlzka, double okruh) {
        List<Stredisko> vysledok = new ArrayList<>();
        for (Stredisko s : dajVsetky()) {
            if (vzdialenostMedziMiestami(sirka.doubleValue(), 
                    dlzka.doubleValue(), 
                    s.getGpsSirka().doubleValue(), 
                    s.getGpsDlzka().doubleValue()) 
                    <= okruh) {
                vysledok.add(s);
            }
        }
        return vysledok;
    }

    /**
     * Na zaklade suradnic vypocita vzdialenost medzi dvoma miestami
     *
     * @param lat1 sirka miesta1
     * @param lon1 dlzka miesta1
     * @param lat2 sirka miesta2
     * @param lon2 dlzka miesta2
     * @return vzdialenost medzi miestom1 a miestom2
     */
    private double vzdialenostMedziMiestami(double lat1, double lon1, double lat2, double lon2) {
        double R = 6372.8; // In kilometers
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.sin(dLon / 2) * Math.sin(dLon / 2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.asin(Math.sqrt(a));
        return R * c;
    }
}