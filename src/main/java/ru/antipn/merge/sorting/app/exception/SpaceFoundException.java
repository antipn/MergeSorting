package ru.antipn.merge.sorting.app.exception;

public class SpaceFoundException extends RuntimeException {
    private String message;

    public SpaceFoundException(String error) {
        super(error);
        this.message = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
