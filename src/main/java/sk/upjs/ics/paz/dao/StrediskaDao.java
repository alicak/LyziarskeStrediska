package sk.upjs.ics.paz.dao;

import java.math.BigDecimal;
import java.util.List;
import sk.upjs.ics.paz.entity.Stredisko;

public interface StrediskaDao {

    List<Stredisko> dajVsetky();

    void uloz(Stredisko stredisko);

    void odstran(Stredisko stredisko);
    
    List<Stredisko> najdiStrediskaVOkruhu(BigDecimal sirka, BigDecimal dlzka, double okruh);
}
