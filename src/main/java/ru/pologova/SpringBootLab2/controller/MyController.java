package ru.pologova.SpringBootLab2.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.pologova.SpringBootLab2.enums.Codes;
import ru.pologova.SpringBootLab2.enums.ErrorCodes;
import ru.pologova.SpringBootLab2.enums.ErrorMessages;
import ru.pologova.SpringBootLab2.exception.UnsupportedCodeException;
import ru.pologova.SpringBootLab2.model.Request;
import ru.pologova.SpringBootLab2.model.Response;
import ru.pologova.SpringBootLab2.service.ModifyResponseService;
import ru.pologova.SpringBootLab2.service.ValidationService;

@Slf4j
@RestController
public class MyController {

    private final ValidationService validationService;
    private final ModifyResponseService modifyResponseServiceUid;
    private final ModifyResponseService modifyResponseServiceDate;

    public MyController(
            ValidationService validationService,
            @Qualifier("ModifyResponseServiceUid")
            ModifyResponseService modifyResponseServiceUid,
            @Qualifier("ModifyResponseServiceDate")
            ModifyResponseService modifyResponseServiceDate) {

        this.validationService = validationService;
        this.modifyResponseServiceUid = modifyResponseServiceUid;
        this.modifyResponseServiceDate = modifyResponseServiceDate;
    }

    @PostMapping("/feedback")
    public Response feedback(
            @Valid @RequestBody Request request,
            BindingResult bindingResult) {

        log.info("Получен request: {}", request);

        validationService.validate(bindingResult);

        log.info("Request успешно прошел валидацию");

        if ("123".equals(request.getUid())) {
            log.error(
                    "UnsupportedCodeException: uid = {}",
                    request.getUid()
            );

            throw new UnsupportedCodeException(
                    "Не поддерживаемый код"
            );
        }

        Response response = new Response();

        response.setUid(request.getUid());
        response.setOperationUid(request.getOperationUid());
        response.setSystemTime(request.getSystemTime());
        response.setCode(Codes.SUCCESS);
        response.setErrorCode(ErrorCodes.EMPTY);
        response.setErrorMessage(ErrorMessages.EMPTY);

        log.info("Первоначальный response: {}", response);

        response = modifyResponseServiceUid.modify(response);

        log.info(
                "Response после изменения operationUid: {}",
                response
        );

        response = modifyResponseServiceDate.modify(response);

        log.info(
                "Response после изменения systemTime: {}",
                response
        );

        log.info("Итоговый response: {}", response);

        return response;
    }
}