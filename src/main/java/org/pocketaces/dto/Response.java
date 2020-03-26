package org.pocketaces.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import org.pocketaces.exception.CustomException;
import org.springframework.http.HttpStatus;

import lombok.Data;

/**
 * @author swatish.s
 */

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    private HttpStatus status;
    private Object     data;
    private String     error;

    public Response(final Object data) {
        this.data = data;
    }

    public Response(final CustomException ex) {
        this.error = ex.getError().toString();
    }

    public Response(final HttpStatus status) {
        this.status = status;
    }
}
