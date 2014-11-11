
package sk.upjs.ics.paz;

import java.util.List;

public interface StrediskaDao {
    List<Stredisko> dajVsetky();

    void save(Stredisko stredisko);

    void odstran(Stredisko stredisko);
}
