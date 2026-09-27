package ru.pologova.SpringBootLab2.model;

import lombok.Data;

@Data
public class Response {

    private String uid;
    private String operationUid;
    private String systemTime;
    private String code;
    private String errorCode;
    private String errorMessage;
}