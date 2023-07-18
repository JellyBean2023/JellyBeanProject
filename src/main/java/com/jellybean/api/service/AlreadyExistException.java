package com.jellybean.api.service;

import org.springframework.dao.DataIntegrityViolationException;

public class AlreadyExistException extends Throwable {
    public AlreadyExistException(String s, DataIntegrityViolationException e) {
    }
}
