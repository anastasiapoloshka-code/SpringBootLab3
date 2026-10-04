package ru.pologova.SpringBootLab2.model;

import lombok.Data;
import ru.pologova.SpringBootLab2.enums.Codes;
import ru.pologova.SpringBootLab2.enums.ErrorCodes;
import ru.pologova.SpringBootLab2.enums.ErrorMessages;

@Data
public class Response {

    private String uid;
    private String operationUid;
    private String systemTime;
    private Codes code;
    private ErrorCodes errorCode;
    private ErrorMessages errorMessage;
}