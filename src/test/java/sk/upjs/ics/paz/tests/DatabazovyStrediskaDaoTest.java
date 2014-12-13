package sk.upjs.ics.paz.tests;

import java.math.BigDecimal;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.ics.paz.exceptions.NedostatocneOpravneniaNaOperaciuException;
import sk.upjs.ics.paz.dao.DatabazovyPouzivateliaDao;
import sk.upjs.ics.paz.dao.DatabazovyStrediskaDao;
import sk.upjs.ics.paz.dao.Factory;
import sk.upjs.ics.paz.dao.PouzivateliaDao;
import sk.upjs.ics.paz.dao.StrediskaDao;
import sk.upjs.ics.paz.entity.Pouzivatel;
import sk.upjs.ics.paz.entity.Stredisko;

public class DatabazovyStrediskaDaoTest {

    private static JdbcTemplate jdbcTemplate;
    private static StrediskaDao strediskaDao;
    private static PouzivateliaDao pouzivateliaDao;
    private static Pouzivatel pouzivatel;

    @BeforeClass
    public static void setUp() {
        jdbcTemplate = Factory.INSTANCE.getJdbcTemplate();
        pouzivateliaDao = new DatabazovyPouzivateliaDao(jdbcTemplate);
        pouzivatel = pouzivateliaDao.dajUzivatela("Martin", "mato");
    }

    /**
     * Otestujem, ci vyhodi vynimku, ak idem ukladat ako neprihlaseny uzivatel
     */
    @Test(expected = NedostatocneOpravneniaNaOperaciuException.class)
    public void ulozTest() {
        strediskaDao = new DatabazovyStrediskaDao(null, jdbcTemplate);

        strediskaDao.uloz(new Stredisko());
    }

    /**
     * Otestujem, ci vyhodi vynimku, ak idem odstranovat ako neprihlaseny
     * uzivatel
     */
    @Test(expected = NedostatocneOpravneniaNaOperaciuException.class)
    public void odstranTest() {
        strediskaDao = new DatabazovyStrediskaDao(null, jdbcTemplate);

        strediskaDao.odstran(new Stredisko());
    }

    /**
     * Zistim, ci pocet danych stredisk sa rovna poctu stredisk v databaze (prv
     * pre neprihlaseneho uzivatela)
     */
    @Test
    public void dajVsetkyTestNeprihlaseny() {
        strediskaDao = new DatabazovyStrediskaDao(null, jdbcTemplate);

        List<Stredisko> strediska = strediskaDao.dajVsetky();

        assertEquals(strediska.size(), 5);
    }

    /**
     * Zistim, ci pocet danych stredisk sa rovna poctu stredisk v databaze
     * (teraz pre prihlaseneho uzivatela)
     */
    @Test
    public void dajVsetkyTestPrihlaseny() {
        strediskaDao = new DatabazovyStrediskaDao(pouzivatel, jdbcTemplate);

        List<Stredisko> strediska = strediskaDao.dajVsetky();

        assertEquals(strediska.size(), 4);
    }

    /**
     * Overim, ci som dostal na danom id korektny nazov strediska
     */
    @Test
    public void dajVsetkyTestOverimId() {
        strediskaDao = new DatabazovyStrediskaDao(pouzivatel, jdbcTemplate);

        List<Stredisko> strediska = strediskaDao.dajVsetky();

        String menoStrediska = "";
        for (Stredisko stredisko : strediska) {
            if (stredisko.getId() == 4) {
                menoStrediska = stredisko.getNazov();
                break;
            }
        }

        assertTrue(menoStrediska.equals("Tatranská Lomnica"));
    }

    /**
     * Dam okruh 0 a GPS suradnice podla presne jedneho strediska
     */
    @Test
    public void najdiStrediskaVOkruhuTestJedno() {
        strediskaDao = new DatabazovyStrediskaDao(pouzivatel, jdbcTemplate);

        List<Stredisko> strediska = strediskaDao.najdiStrediskaVOkruhu(new BigDecimal("48.87755900"),
                new BigDecimal("19.23549000"), 0);

        assertTrue(strediska.size() == 1);

        assertTrue(strediska.get(0).getNazov().equals("Donovaly"));
    }

    /**
     * Dam okruh nekonecno a lubovolne GPS a malo by vratit vsetky strediska
     */
    @Test
    public void najdiStrediskaVOkruhuTestNekonecno() {
        strediskaDao = new DatabazovyStrediskaDao(pouzivatel, jdbcTemplate);

        List<Stredisko> strediska = strediskaDao.najdiStrediskaVOkruhu(new BigDecimal("48.87755900"),
                new BigDecimal("19.23549000"), Double.POSITIVE_INFINITY);

        assertTrue(strediska.size() == 4);
    }
}
