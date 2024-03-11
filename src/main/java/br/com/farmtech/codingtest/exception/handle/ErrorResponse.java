package br.com.farmtech.codingtest.exception.handle;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class ErrorResponse implements Serializable {

    private String message;
    private Date timestamp;

    public ErrorResponse(String message, Date timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }
}
