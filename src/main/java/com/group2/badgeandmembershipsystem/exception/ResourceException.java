package com.group2.badgeandmembershipsystem.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ResourceException extends RuntimeException{
    private HttpStatus status = HttpStatus.NOT_FOUND;
    public ResourceException(String message) {
        super(message);
    }
    public ResourceException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
    public ResourceException() {
        super();
    }
}
