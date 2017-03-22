package api.exceptions;

public class NotFoundTicketReferenceException extends ApiException {

    private static final long serialVersionUID = 3117076866914877491L;

    public static final String DESCRIPTION = "No se encuentra el ticket con la referencia indicada";

    public static final int CODE = 10;

    public NotFoundTicketReferenceException() {
        this("");
    }

    public NotFoundTicketReferenceException(String detail) {
        super(DESCRIPTION + ". " + detail, CODE);
    }

}
