package sk.upjs.ics.paz;

import java.math.BigDecimal;

public interface PouzivateliaDao {
    
    Pouzivatel dajUzivatela(String meno, String heslo);
    void registruj(String meno, String heslo, BigDecimal gpsSirka, BigDecimal gpsDlzka);
    boolean existujePouzivatel(String meno);
    
}
