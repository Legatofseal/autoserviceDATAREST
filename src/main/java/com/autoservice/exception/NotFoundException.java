package com.autoservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    public NotFoundException(String entityType, Object id) {
        super("Entity of type: '" + entityType + "' is not found by id: '" + id + "'");
    }
}
