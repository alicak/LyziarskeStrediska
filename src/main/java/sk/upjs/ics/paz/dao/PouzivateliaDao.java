package sk.upjs.ics.paz.dao;

import java.math.BigDecimal;
import sk.upjs.ics.paz.entity.Pouzivatel;

public interface PouzivateliaDao {
    
    Pouzivatel dajUzivatela(String meno, String heslo);
    void registruj(String meno, String heslo, BigDecimal gpsSirka, BigDecimal gpsDlzka);
    boolean existujePouzivatel(String meno);
    
}
