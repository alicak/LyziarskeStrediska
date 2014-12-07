package sk.upjs.ics.paz.dao;

import java.util.List;
import sk.upjs.ics.paz.entity.Stredisko;

public interface StrediskaDao {

    List<Stredisko> dajVsetky();

    void uloz(Stredisko stredisko);

    void odstran(Stredisko stredisko);
}
