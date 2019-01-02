package io.github.jhipster.application.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class FileManagerException extends RuntimeException {
    public FileManagerException(String message) {
        super(message);
    }
}
