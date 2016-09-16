package com.autoservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AlreadyExistsException extends RuntimeException {

    public AlreadyExistsException(String entityType, Object id) {
        super("Entity of type: '" + entityType + "' with id: '" + id + "' already exists");
    }
}
