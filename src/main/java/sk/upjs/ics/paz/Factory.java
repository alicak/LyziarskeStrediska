package sk.upjs.ics.paz;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public enum Factory {

    INSTANCE;

    private JdbcTemplate jdbcTemplate;
    private StrediskaDao strediskaDao;
    private PouzivateliaDao pouzivateliaDao;
    private Pouzivatel pouzivatel;
    
    public Pouzivatel getPouzivatel() {
        return pouzivatel;
    }
    
    public void setPouzivatel(Pouzivatel pouzivatel) {
        this.pouzivatel = pouzivatel;
    }

    public StrediskaDao getNovyStrediskaDao(Pouzivatel pouzivatel) {
        strediskaDao = new DatabazovyStrediskaDao(pouzivatel, getJdbcTemplate());
        return strediskaDao;
    }

    public StrediskaDao getStrediskaDao(Pouzivatel pouzivatel) {
        if (strediskaDao == null) {
            strediskaDao = new DatabazovyStrediskaDao(pouzivatel, getJdbcTemplate());
        }
        return strediskaDao;
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
