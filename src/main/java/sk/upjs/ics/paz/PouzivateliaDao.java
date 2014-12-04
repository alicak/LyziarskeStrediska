package sk.upjs.ics.paz;

public interface PouzivateliaDao {
    
    Pouzivatel dajUzivatela(String meno, String heslo);
    void registruj(String meno, String heslo);
    boolean existujePouzivatel(String meno);
    
}
