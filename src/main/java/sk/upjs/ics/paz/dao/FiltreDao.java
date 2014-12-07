package sk.upjs.ics.paz.dao;

import java.util.List;
import sk.upjs.ics.paz.entity.Filter;

public interface FiltreDao {
    
    List<Filter> dajVsetky();

    void uloz(Filter filter);

    void odstran(Filter filter);    
}
