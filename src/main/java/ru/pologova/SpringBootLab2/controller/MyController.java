package ru.pologova.SpringBootLab2.controller;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.pologova.SpringBootLab2.exception.UnsupportedCodeException;
import ru.pologova.SpringBootLab2.model.Request;
import ru.pologova.SpringBootLab2.model.Response;
import ru.pologova.SpringBootLab2.service.ValidationService;

import java.time.Instant;

@RestController
public class MyController {

    private final ValidationService validationService;

    public MyController(ValidationService validationService) {
        this.validationService = validationService;
    }

    @PostMapping("/feedback")
    public Response feedback(
            @Valid @RequestBody Request request,
            BindingResult bindingResult) {

        validationService.validate(bindingResult);

        if ("123".equals(request.getUid())) {
            throw new UnsupportedCodeException("Не поддерживаемый код");
        }

        Response response = new Response();

        response.setUid(request.getUid());
        response.setOperationUid(request.getOperationUid());
        response.setSystemTime(Instant.now().toString());
        response.setCode("success");
        response.setErrorCode("");
        response.setErrorMessage("");

        return response;
    }
}