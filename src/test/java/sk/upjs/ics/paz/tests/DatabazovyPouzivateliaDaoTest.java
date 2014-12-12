package sk.upjs.ics.paz.tests;


import java.math.BigDecimal;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.ics.paz.dao.*;
import sk.upjs.ics.paz.entity.Pouzivatel;

public class DatabazovyPouzivateliaDaoTest {

    private static JdbcTemplate jdbcTemplate;
    private static PouzivateliaDao pouzivateliaDao;

    @BeforeClass
    public static void setUp() {
        jdbcTemplate = Factory.INSTANCE.getJdbcTemplate();
        pouzivateliaDao = new DatabazovyPouzivateliaDao(jdbcTemplate);
    }

    /**
     * Testujem, ci nevieme pridat uzivatela, ktoreho hodnota nesmie ist do
     * tabulky - pre null hodnoty
     */
    @Test(expected = DataIntegrityViolationException.class)
    public void dajVsetkyTest() {
        pouzivateliaDao.registruj(null, null, BigDecimal.ZERO, BigDecimal.ZERO);
    }

    /**
     * Testujem, ci nevieme pridat uzivatela, ktoreho hodnota nesmie ist do
     * tabulky - pre hodnotu, ktora tam uz je
     */
    @Test(expected = DuplicateKeyException.class)
    public void dajVsetkyTest2() {
        pouzivateliaDao.registruj("Admin", "", BigDecimal.ZERO, BigDecimal.ZERO);
    }

    /**
     * Testujem, ci nevieme pridat uzivatela, ktoreho hodnota nesmie ist do
     * tabulky - pridame realne uzivatela a overime, ci je v databaze a ma
     * spravne hodnoty
     */
    @Test
    public void dajVsetkyTest3() {
            BigDecimal sirka = new BigDecimal("40.12");
            BigDecimal dlzka = new BigDecimal("40.13");

            pouzivateliaDao.registruj("gadzo", "heslo", sirka, dlzka);

            String sql1 = "SELECT Heslo FROM Uzivatelia WHERE meno = ?";
            String heslo = (String) jdbcTemplate.queryForObject(
                    sql1, new Object[]{"gadzo"}, String.class);

            String sql2 = "SELECT GpsSirka FROM Uzivatelia WHERE meno = ?";
            BigDecimal gpsSirka = jdbcTemplate.queryForObject(
                    sql2, new Object[]{"gadzo"}, BigDecimal.class);

            String sql3 = "SELECT GpsDlzka FROM Uzivatelia WHERE meno = ?";
            BigDecimal gpsDlzka = jdbcTemplate.queryForObject(
                    sql3, new Object[]{"gadzo"}, BigDecimal.class);

            assertTrue(heslo.equals("heslo"));
            assertTrue(gpsSirka.compareTo(sirka) == 0);
            assertTrue(gpsDlzka.compareTo(dlzka) == 0);

            // dame do povodneho stavu
            jdbcTemplate.execute("DELETE FROM Uzivatelia WHERE meno = 'gadzo'");
            jdbcTemplate.execute("DROP TABLE gadzoTab");
    }

    /**
     * Ak nezadam ziadneho pouzivatela, tak by mi tato metoda mala dat null
     */
    @Test
    public void dajPouzivatelaTest() {
        Pouzivatel pouzivatel = pouzivateliaDao.dajUzivatela(null, null);
        assertNull(pouzivatel);
    }

    /**
     * Ak zadam zle heslo k menu, tak by mi tato metoda mala dat null
     */
    @Test
    public void dajPouzivatelaTest2() {
        Pouzivatel pouzivatel = pouzivateliaDao.dajUzivatela("Admin", "hahaha");
        assertNull(pouzivatel);
    }

    /**
     * Ak zadam meno, ktore nie je v tabulke, tak by mi tato metoda mala dat
     * null
     */
    @Test
    public void dajPouzivatelaTest3() {
        Pouzivatel pouzivatel = pouzivateliaDao.dajUzivatela("gadzo", "hahaha");
        assertNull(pouzivatel);
    }

    /**
     * Ak zadam zadam vsetko korektne, tak sa musia pouzivatelia zhodovat vo
     * svojich instanciach
     */
    @Test
    public void dajPouzivatelaTest4() {
        Pouzivatel pouzivatel = pouzivateliaDao.dajUzivatela("Admin", "qwerty123456");

        Pouzivatel naPorovnanie = new Pouzivatel();
        naPorovnanie.setMeno("Admin");
        naPorovnanie.setHeslo("qwerty123456");
        naPorovnanie.setNazovTabulky("strediska");

        assertNull(pouzivatel.getGpsDlzka());
        assertNull(pouzivatel.getGpsSirka());
        assertTrue(pouzivatel.getHeslo().equals(naPorovnanie.getHeslo()));
        assertTrue(pouzivatel.getMeno().equals(naPorovnanie.getMeno()));
        assertTrue(pouzivatel.getNazovTabulky().equals(naPorovnanie.getNazovTabulky()));
    }

    @Test
    public void existujeUzivatelTestAno() {
        boolean existujePouzivatel = pouzivateliaDao.existujePouzivatel("Admin");
        assertTrue(existujePouzivatel);
    }

    /**
     * So zlym menom
     */
    @Test
    public void existujeUzivatelTestNie() {
        boolean existujePouzivatel = pouzivateliaDao.existujePouzivatel("gadzo");
        assertFalse(existujePouzivatel);
    }

    /**
     * S menom ako null
     */
    @Test
    public void existujeUzivatelTestNie2() {
        boolean existujePouzivatel = pouzivateliaDao.existujePouzivatel(null);
        assertFalse(existujePouzivatel);
    }

}
