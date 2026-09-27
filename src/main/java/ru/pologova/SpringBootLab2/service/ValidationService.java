package ru.pologova.SpringBootLab2.service;

import org.springframework.validation.BindingResult;

public interface ValidationService {

    void validate(BindingResult bindingResult);
}