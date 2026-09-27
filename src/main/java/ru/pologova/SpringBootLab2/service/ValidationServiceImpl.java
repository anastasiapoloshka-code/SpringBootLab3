package ru.pologova.SpringBootLab2.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.pologova.SpringBootLab2.exception.ValidationFailedException;

@Service
public class ValidationServiceImpl implements ValidationService {

    @Override
    public void validate(BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            String errorMessage = bindingResult
                    .getFieldErrors()
                    .stream()
                    .map(error -> error.getDefaultMessage())
                    .findFirst()
                    .orElse("Ошибка валидации");

            throw new ValidationFailedException(errorMessage);
        }
    }
}