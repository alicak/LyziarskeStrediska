package sk.upjs.ics.paz;

public enum DaoFactory {

    INSTANCE;

    public StrediskaDao getStrediskaDao(String meno, String heslo) {
        return new DatabazovyStrediskaDao(meno, heslo);
    }
}
