package dao;

public class StateNotServicedException extends Exception {
    public StateNotServicedException(String message) {
        super(message);
    }

    public StateNotServicedException(String message, Throwable cause) {
        super(message, cause);
    }

}