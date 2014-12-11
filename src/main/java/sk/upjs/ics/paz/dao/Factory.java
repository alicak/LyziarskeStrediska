package sk.upjs.ics.paz.dao;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.ics.paz.entity.Pouzivatel;

public enum Factory {

    INSTANCE;

    private JdbcTemplate jdbcTemplate;
    private StrediskaDao strediskaDao;
    private FiltreDao filtreDao;
    private PouzivateliaDao pouzivateliaDao;
    private Pouzivatel pouzivatel;

    public Pouzivatel getPouzivatel() {
        return pouzivatel;
    }

    public void setPouzivatel(Pouzivatel pouzivatel) {
        this.pouzivatel = pouzivatel;
    }

    public StrediskaDao getNovyStrediskaDao() {
        strediskaDao = new DatabazovyStrediskaDao(getPouzivatel(), getJdbcTemplate());
        return strediskaDao;
    }

    public StrediskaDao getStrediskaDao() {
        if (strediskaDao == null) {
            return getNovyStrediskaDao();
        }
        return strediskaDao;
    }

    public FiltreDao getNovyFiltreDao() {
        filtreDao = new DatabazovyFiltreDao(getPouzivatel(), getJdbcTemplate());
        return filtreDao;
    }

    public FiltreDao getFiltreDao() {
        if (filtreDao == null) {
            return getNovyFiltreDao();
        }
        return filtreDao;
    }

    public PouzivateliaDao getPouzivatelDao() {
        if (pouzivateliaDao == null) {
            pouzivateliaDao = new DatabazovyPouzivateliaDao(getJdbcTemplate());
        }
        return pouzivateliaDao;
    }

    private MysqlDataSource getDataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://db4free.net:3306/paz1c2014ak");
        dataSource.setUser("alica");
        dataSource.setPassword("fdacbeedk");

        return dataSource;
    }

    public JdbcTemplate getJdbcTemplate() {
        if (jdbcTemplate == null) {
            jdbcTemplate = new JdbcTemplate(getDataSource());
        }
        return jdbcTemplate;
    }
}
