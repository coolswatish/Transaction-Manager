package org.pocketaces.exception;

/**
 * @author swatish.s
 */

/**
 * Error defines the standard errors using which we can create objects of CustomException
 */
public enum Error {

    TRANSACTION_ALREADY_EXISTS(1001, "Transaction already exists"),
    TRANSACTION_NOT_EXIST(1002, "Transaction does not exist"),
    TRANSACTION_TYPE_NOT_EXIST(1002, "Transaction type does not exist");



    private int    code;
    private String message;

    Error(final int errorCode, final String errorMessage) {
        code = errorCode;
        message = errorMessage;
    }

    @Override
    public String toString() {
        return message;
    }
}
