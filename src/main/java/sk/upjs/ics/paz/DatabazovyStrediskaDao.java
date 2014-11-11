
package sk.upjs.ics.paz;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

public class DatabazovyStrediskaDao implements StrediskaDao{
    
    private JdbcTemplate jdbcTemplate;
    BeanPropertyRowMapper<Stredisko> mapovac = new BeanPropertyRowMapper<>(Stredisko.class);
    
    public DatabazovyStrediskaDao() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://db4free.net:3306/paz1c2014ak");
        dataSource.setUser("alica");
        dataSource.setPassword("fdacbeedk");
        
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    @Override
    public List<Stredisko> dajVsetky() {
        return jdbcTemplate.query("SELECT * FROM skusobnaTabulka", mapovac);
    }

    @Override
    public void save(Stredisko stredisko) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void odstran(Stredisko stredisko) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
