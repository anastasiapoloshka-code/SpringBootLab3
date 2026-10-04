package ru.pologova.SpringBootLab2.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.pologova.SpringBootLab2.enums.Codes;
import ru.pologova.SpringBootLab2.enums.ErrorCodes;
import ru.pologova.SpringBootLab2.enums.ErrorMessages;
import ru.pologova.SpringBootLab2.model.Response;
import ru.pologova.SpringBootLab2.util.DateTimeUtil;

import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidationFailedException.class)
    public Response handleValidationException(
            ValidationFailedException exception) {

        Response response = new Response();

        response.setUid("");
        response.setOperationUid("");
        response.setSystemTime(
                DateTimeUtil.getCustomFormat().format(new Date())
        );
        response.setCode(Codes.FAILED);
        response.setErrorCode(ErrorCodes.VALIDATION_EXCEPTION);
        response.setErrorMessage(ErrorMessages.VALIDATION_ERROR);

        return response;
    }

    @ExceptionHandler(UnsupportedCodeException.class)
    public Response handleUnsupportedCodeException(
            UnsupportedCodeException exception) {

        Response response = new Response();

        response.setUid("");
        response.setOperationUid("");
        response.setSystemTime(
                DateTimeUtil.getCustomFormat().format(new Date())
        );
        response.setCode(Codes.FAILED);
        response.setErrorCode(ErrorCodes.UNSUPPORTED_CODE_EXCEPTION);
        response.setErrorMessage(ErrorMessages.UNSUPPORTED_CODE);

        return response;
    }
}