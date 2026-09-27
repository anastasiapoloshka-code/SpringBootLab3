package ru.pologova.SpringBootLab2.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.pologova.SpringBootLab2.model.Response;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidationFailedException.class)
    public Response handleValidationException(
            ValidationFailedException exception) {

        Response response = new Response();

        response.setUid("");
        response.setOperationUid("");
        response.setSystemTime(Instant.now().toString());
        response.setCode("failed");
        response.setErrorCode("ValidationException");
        response.setErrorMessage(exception.getMessage());

        return response;
    }
    @ExceptionHandler(UnsupportedCodeException.class)
    public Response handleUnsupportedCodeException(
            UnsupportedCodeException exception) {

        Response response = new Response();

        response.setUid("");
        response.setOperationUid("");
        response.setSystemTime(Instant.now().toString());
        response.setCode("failed");
        response.setErrorCode("UnsupportedCodeException");
        response.setErrorMessage(exception.getMessage());

        return response;
    }
}