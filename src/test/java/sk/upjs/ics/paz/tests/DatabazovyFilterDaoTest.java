package sk.upjs.ics.paz.tests;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.ics.paz.exceptions.NedostatocneOpravneniaNaOperaciuException;
import sk.upjs.ics.paz.dao.DatabazovyFiltreDao;
import sk.upjs.ics.paz.dao.DatabazovyPouzivateliaDao;
import sk.upjs.ics.paz.dao.Factory;
import sk.upjs.ics.paz.dao.FiltreDao;
import sk.upjs.ics.paz.dao.PouzivateliaDao;
import sk.upjs.ics.paz.entity.Filter;
import sk.upjs.ics.paz.entity.Pouzivatel;

public class DatabazovyFilterDaoTest {
    
    private static JdbcTemplate jdbcTemplate;
    private static FiltreDao filtreDao;
    private static PouzivateliaDao pouzivateliaDao;
    private static Pouzivatel pouzivatel;
    
    @BeforeClass
    public static void setUp() {
        jdbcTemplate = Factory.INSTANCE.getJdbcTemplate();
        pouzivateliaDao = new DatabazovyPouzivateliaDao(jdbcTemplate);
        pouzivatel = pouzivateliaDao.dajUzivatela("skuska", "ahoj");
        filtreDao = new DatabazovyFiltreDao(pouzivatel, jdbcTemplate);
    }

    /**
     * Otestujem, ci vyhodi vynimku, ak idem ukladat ako neprihlaseny uzivatel
     */
    @Test(expected = NedostatocneOpravneniaNaOperaciuException.class)
    public void ulozTest() {
        filtreDao = new DatabazovyFiltreDao(null, jdbcTemplate);
        
        filtreDao.uloz(new Filter());
    }

    /**
     * Otestujem, ci vyhodi vynimku, ak idem mazat ako neprihlaseny uzivatel
     */
    @Test(expected = NedostatocneOpravneniaNaOperaciuException.class)
    public void odstranTest() {
        filtreDao = new DatabazovyFiltreDao(null, jdbcTemplate);
        
        filtreDao.odstran(new Filter());
    }

    /**
     * Overim, ci dostanem vsetky filtre pre neprihlaseneho uzivatela
     */
    @Test
    public void dajVsetkyTestNeprihlaseny() {
        filtreDao = new DatabazovyFiltreDao(null, jdbcTemplate);
        
        List<Filter> filtre = filtreDao.dajVsetky();
        
        assertTrue(filtre.size() == 2);
    }

    /**
     * Overim, ci dostanem vsetky filtre pre prihlaseneho uzivatela
     */
    @Test
    public void dajVsetkyTestPrihlaseny() {
        filtreDao = new DatabazovyFiltreDao(pouzivatel, jdbcTemplate);
        
        List<Filter> filtre = filtreDao.dajVsetky();
        
        assertTrue(filtre.size() == 1);
    }

    /**
     * Overim, ci dostanem vsetky filtre pre uzivatela, ktory nema ziaden
     * filter
     */
    @Test
    public void dajVsetkyTestNemajuciFilter() {
        Pouzivatel admin = pouzivateliaDao.dajUzivatela("Admin", "qwerty123456");
        filtreDao = new DatabazovyFiltreDao(admin, jdbcTemplate);
        
        List<Filter> filtre = filtreDao.dajVsetky();
        
        assertTrue(filtre.isEmpty());
    }

    /**
     * Overim, ci mi da spravne id, ak vyhladam filter podla nazvu
     */
    @Test
    public void dajPodlaNazvuTest() {
        filtreDao = new DatabazovyFiltreDao(pouzivatel, jdbcTemplate);
        
        Filter filter = filtreDao.dajPodlaNazvu("skusobny filter 2");
        
        assertTrue(filter.getId() == 2);
    }
}
