package org.pocketaces.exception;

/**
 * @author swatish.s
 */

import java.util.Objects;

import org.pocketaces.util.Constants;

import lombok.Getter;

/**
 * CustomException is the exception class we are using in our application. The application throws around CustomException
 * in case if some thing goes awry.
 */

@Getter
public class CustomException extends Exception {

    private static final long serialVersionUID = 1L;

    private Error             error;

    public CustomException(final Error error) {
        this.error = error;
    }

    @Override
    public String getMessage() {
        if (Objects.nonNull(error)) {
            return error.toString();
        }

        return Constants.UNKNOWN_ERROR;
    }
}
