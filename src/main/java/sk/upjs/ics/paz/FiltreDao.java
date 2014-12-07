package sk.upjs.ics.paz;

import java.util.List;

public interface FiltreDao {
    
    List<Filter> dajVsetky();

    void uloz(Filter filter);

    void odstran(Filter filter);    
}
