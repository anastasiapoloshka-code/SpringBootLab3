package ru.pologova.SpringBootLab2.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.pologova.SpringBootLab2.exception.ValidationFailedException;

@Slf4j
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

            log.error("Ошибка валидации: {}", errorMessage);

            throw new ValidationFailedException(errorMessage);
        }

        log.info("Ошибок валидации не обнаружено");
    }
}