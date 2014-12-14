package sk.upjs.ics.paz.dao;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.ics.paz.entity.Pouzivatel;
import sk.upjs.ics.paz.entity.Stredisko;
import sk.upjs.ics.paz.gui.VerifikatorVstupov;

public enum Factory {

    INSTANCE;

    private JdbcTemplate jdbcTemplate;
    private StrediskaDao strediskaDao;
    private FiltreDao filtreDao;
    private PouzivateliaDao pouzivateliaDao;
    private Pouzivatel pouzivatel;
    private VerifikatorVstupov verifikator;
    private List<Stredisko> vlastnyZoznam;

    public PouzivateliaDao getPouzivateliaDao() {
        return pouzivateliaDao;
    }

    public void setPouzivateliaDao(PouzivateliaDao pouzivateliaDao) {
        this.pouzivateliaDao = pouzivateliaDao;
    }

    public List<Stredisko> getVlastnyZoznam() {
        return vlastnyZoznam;
    }

    public void setVlastnyZoznam(List<Stredisko> vlastnyZoznam) {
        this.vlastnyZoznam = vlastnyZoznam;
    }

    // vrati pouzivatela
    public Pouzivatel getPouzivatel() {
        return pouzivatel;
    }

    // nastavi pouzivatela
    public void setPouzivatel(Pouzivatel pouzivatel) {
        this.pouzivatel = pouzivatel;
    }

    // vytvori a vrati novy StrediskaDao
    public StrediskaDao getNovyStrediskaDao() {
        strediskaDao = new DatabazovyStrediskaDao(getPouzivatel(), getJdbcTemplate());
        return strediskaDao;
    }

    // vrati aktualny StrediskaDao, ak neexistuje, tak vytvori a vrati novy
    public StrediskaDao getStrediskaDao() {
        if (strediskaDao == null) {
            return getNovyStrediskaDao();
        }
        return strediskaDao;
    }

    // vytvori a vrati novy FiltreDao
    public FiltreDao getNovyFiltreDao() {
        filtreDao = new DatabazovyFiltreDao(getPouzivatel(), getJdbcTemplate());
        return filtreDao;
    }

    // vrati aktualny FiltreDao, ak neexistuje, tak vytvori a vrati novy
    public FiltreDao getFiltreDao() {
        if (filtreDao == null) {
            return getNovyFiltreDao();
        }
        return filtreDao;
    }

    // vrati aktualny PouzivateliaDao, ak neexistuje, tak vytvori a vrati novy
    public PouzivateliaDao getPouzivatelDao() {
        if (pouzivateliaDao == null) {
            pouzivateliaDao = new DatabazovyPouzivateliaDao(getJdbcTemplate());
        }
        return pouzivateliaDao;
    }

    // vrati DataSource pre pristup k databaze
    private MysqlDataSource getDataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://db4free.net:3306/paz1c2014ak");
        dataSource.setUser("alica");
        dataSource.setPassword("fdacbeedk");

        return dataSource;
    }

    // vrati aktualny JdbcTemplate, ak neexistuje, tak vytvori a vrati novy
    public JdbcTemplate getJdbcTemplate() {
        if (jdbcTemplate == null) {
            jdbcTemplate = new JdbcTemplate(getDataSource());
        }
        return jdbcTemplate;
    }

    // vrati aktualny VerifiaktorVstupov, ak neexistuje, tak vytvori a vrati novy
    public VerifikatorVstupov getVerifikator() {
        if(verifikator == null)
            return new VerifikatorVstupov();
        return verifikator;
    }
}
