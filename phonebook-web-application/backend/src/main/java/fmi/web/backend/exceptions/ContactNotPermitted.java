package fmi.web.backend.exceptions;

public class ContactNotPermitted extends Exception{
    public ContactNotPermitted() {
        super();
    }

    public ContactNotPermitted(String message) {
        super(message);
    }
}
