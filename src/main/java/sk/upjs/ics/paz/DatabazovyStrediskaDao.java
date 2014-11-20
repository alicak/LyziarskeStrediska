package sk.upjs.ics.paz;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class DatabazovyStrediskaDao implements StrediskaDao {

    private JdbcTemplate jdbcTemplate;
    private BeanPropertyRowMapper<Stredisko> mapovac = new BeanPropertyRowMapper<>(Stredisko.class);
    private String tabulkaSKtorouPracujem;
    private int idUzivatela;
    private int menoUzivatela;

    public DatabazovyStrediskaDao() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://db4free.net:3306/paz1c2014ak");
        dataSource.setUser("alica");
        dataSource.setPassword("fdacbeedk");

        jdbcTemplate = new JdbcTemplate(dataSource);

        File subor = new File("LYZIARSKE_STREDISKA_FILE_DO_NOT_REMOVE_OR_EDIT");
        if (subor.exists()) {
            nacitajNazovTabulkyZoSuboru(subor);
        } else {
            vytvorNovehoUzivatela(subor);
        }
    }

    /**
     * Vrati zoznam vsetkych poloziek z tabulky strediska
     */
    @Override
    public List<Stredisko> dajVsetky() {
        return jdbcTemplate.query("SELECT * FROM ?", mapovac, tabulkaSKtorouPracujem);
    }

    /**
     * Ulozi nove / updatuje existujuce stredisko
     */
    @Override
    public void uloz(Stredisko stredisko) {
        if (stredisko.getId() == null) {
            Map<String, Object> hodnoty = new HashMap<String, Object>();
            hodnoty.put("nazov", stredisko.getNazov());
            hodnoty.put("vyskaSnehu", stredisko.getVyskaSnehu());
            hodnoty.put("podmienky", stredisko.getPodmienky());
            hodnoty.put("pocetVlekov", stredisko.getPocetVlekov());
            hodnoty.put("pocetVlekovVPrevadzke", stredisko.getPocetVlekovVPrevadzke());
            hodnoty.put("pocetLanoviek", stredisko.getPocetLanoviek());
            hodnoty.put("pocetLanoviekVPrevadzke", stredisko.getPocetVlekovVPrevadzke());
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
        } else {
            String sql = "UPDATE ?\n"
                    + "SET nazov = ?,\n"
                    + "vyskaSnehu = ?,\n"
                    + "podmienky = ?\n"
                    + "pocetVlekov = ?,\n"
                    + "pocetVlekovVPrevadzke = ?\n"
                    + "pocetLanoviek = ?,\n"
                    + "pocetLanoviekVPrevadzke = ?\n"
                    + "cenaListkaDospely = ?,\n"
                    + "cenaListkaDieta = ?\n"
                    + "cenaListkaStudent = ?,\n"
                    + "daSaPozicatVystroj = ?\n"
                    + "daSaUbytovat = ?,\n"
                    + "gpsSirka = ?\n"
                    + "gpsDlzka = ?\n"
                    + "WHERE id = ?";

            jdbcTemplate.update(sql,
                    tabulkaSKtorouPracujem,
                    stredisko.getNazov(),
                    stredisko.getVyskaSnehu(),
                    stredisko.getPodmienky(),
                    stredisko.getPocetVlekov(),
                    stredisko.getPocetVlekovVPrevadzke(),
                    stredisko.getPocetLanoviek(),
                    stredisko.getPocetVlekovVPrevadzke(),
                    stredisko.getCenaListkaDospely(),
                    stredisko.getCenaListkaDieta(),
                    stredisko.getCenaListkaStudent(),
                    stredisko.isDaSaPozicatVystroj(),
                    stredisko.isDaSaUbytovat(),
                    stredisko.getGpsSirka(),
                    stredisko.getGpsDlzka(),
                    stredisko.getId());
        }
    }

    /**
     * Odstrani stredisko z databazy
     */
    @Override
    public void odstran(Stredisko stredisko) {
        jdbcTemplate.update("DELETE FROM ? WHERE id = ?", tabulkaSKtorouPracujem,
                stredisko.getId());
    }

    /**
     * Nacita z lokalneho suboru tabulku pre konkretneho uzivatela
     */
    private void nacitajNazovTabulkyZoSuboru(File subor) {
        try (Scanner scanner = new Scanner(subor)) {
            idUzivatela = scanner.nextInt();
            menoUzivatela = scanner.nextInt();
            //if (suDataVTabUzivatelia(idUzivatela, menoUzivatela)) {
                tabulkaSKtorouPracujem = "tab" + idUzivatela + "_" + menoUzivatela;
            //} else {
            //    pouzijTempDatabazu();
            //}
        } catch (Exception e) {
            pouzijTempDatabazu();
        }
    }

    /**
     * Zapise do lokalneho suboru udaje pre noveho pouzivatela a vytvori pre
     * neho novu tabulku v databaze
     */
    private void vytvorNovehoUzivatela(File subor) {
        try (PrintWriter pw = new PrintWriter(subor)) {
            idUzivatela = maxIdUzivatelov() + 1;
            menoUzivatela = (int) (Math.random() * 100000000);
            pw.println(idUzivatela);
            pw.println(menoUzivatela);
            vlozDoTabulkyUzivatelia(menoUzivatela);
            vytvorTabulku("tab" + idUzivatela + "_" + menoUzivatela);
        } catch (Exception e) {
            pouzijTempDatabazu();
        }
    }

    /**
     * Pouzije docasnu tabulku (pre pripady, ze sa neda pouzit tabulka pouzivatela)
     */
    private void pouzijTempDatabazu() {
        jdbcTemplate.execute("DROP Temp TABLE IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE Temp LIKE strediska");
        jdbcTemplate.execute("INSERT Temp SELECT * FROM strediska");
        tabulkaSKtorouPracujem = "Temp";
    }

//    /**
//     * overi, ci uzivatel neprepisal subor so svojim menom a id
//     */
//    public boolean suDataVTabUzivatelia(int idUzivatela, int menoUzivatela) {
//        String sql = "SELECT meno FROM uzivatelia WHERE id = ?";
//        int meno = Integer.parseInt((String) jdbcTemplate.queryForObject(
//                sql, new Object[]{idUzivatela}, String.class));
//
//        return meno == menoUzivatela;
//    }

    /**
     * vrati maximalne id z existujucich
     */
    private int maxIdUzivatelov() {
        String sql = "SELECT MAX(id) FROM uzivatelia";
        int maxID = jdbcTemplate.queryForInt(sql);
        return maxID;
    }

    /**
     * Prida do tabulky pouzivatelov noveho pouzivatela
     */
    private void vlozDoTabulkyUzivatelia(int menoUzivatela) {
        jdbcTemplate.execute("INSERT INTO uzivatelia (meno) VALUES (" + menoUzivatela + ")");
    }

    /**
     * Vytvori novu tabulku pre strediska
     */
    private void vytvorTabulku(String nazov) {
        jdbcTemplate.execute("CREATE TABLE " + nazov + " LIKE strediska");
        jdbcTemplate.execute("INSERT " + nazov + " SELECT * FROM strediska");
        tabulkaSKtorouPracujem = nazov;
    }

}
