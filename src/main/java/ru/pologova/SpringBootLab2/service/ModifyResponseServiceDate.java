package ru.pologova.SpringBootLab2.service;

import org.springframework.stereotype.Service;
import ru.pologova.SpringBootLab2.model.Response;
import ru.pologova.SpringBootLab2.util.DateTimeUtil;

import java.util.Date;

@Service("ModifyResponseServiceDate")
public class ModifyResponseServiceDate implements ModifyResponseService {

    @Override
    public Response modify(Response response) {

        response.setSystemTime(
                DateTimeUtil.getCustomFormat().format(new Date())
        );

        return response;
    }
}