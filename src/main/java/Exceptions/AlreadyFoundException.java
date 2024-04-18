package Exceptions;

public class AlreadyFoundException extends RuntimeException{
    public AlreadyFoundException(String message) {
        super(message);
    }
}
