package br.com.henrique.curse.services.exceptions;

import br.com.henrique.curse.entities.User;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Long id) {
        super("Resource not found. ID" + id);
    }
}
