package sk.upjs.ics.paz.exceptions;

public class NedostatocneOpravneniaNaOperaciuException extends RuntimeException {

    private final String sprava = "Nemáte dostatočné opravnenia na vykonanie operácie.";
    private final String pricina;

    public String getSprava() {
        return sprava;
    }

    public String getPricina() {
        return pricina;
    }

    public NedostatocneOpravneniaNaOperaciuException(String sprava) {
        pricina = sprava;
    }

}
