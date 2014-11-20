package sk.upjs.ics.paz;

public enum DaoFactory {

    INSTANCE;

    public StrediskaDao getStrediskaDao() {
        return new DatabazovyStrediskaDao();
    }
}
