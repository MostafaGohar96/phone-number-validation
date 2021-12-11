package com.jumia.task.validation.phonenumbers.utilities.response;

import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ToString
public class GenericResponse<T> {
    private final ResponseEntity<Response<T>> response;

    public GenericResponse(final Response<T> genericResponse, final HttpStatus statusCode) {
        this.response = new ResponseEntity<>(genericResponse, statusCode);
    }

    public ResponseEntity<Response<T>> getResponse() {
        return response;
    }
}
