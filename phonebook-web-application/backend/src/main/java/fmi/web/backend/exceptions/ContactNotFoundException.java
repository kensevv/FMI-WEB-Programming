package fmi.web.backend.exceptions;

public class ContactNotFoundException extends Exception {

    public ContactNotFoundException() {
        super();
    }

    public ContactNotFoundException(String msg) {
        super(msg);
    }
}
