package Exceptions;

public class FailedOrderFullfilmentException extends RuntimeException{
    public FailedOrderFullfilmentException(String message) {
        super(message);
    }
}
