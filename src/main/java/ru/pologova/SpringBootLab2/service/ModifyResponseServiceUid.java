package ru.pologova.SpringBootLab2.service;

import org.springframework.stereotype.Service;
import ru.pologova.SpringBootLab2.model.Response;

import java.util.UUID;

@Service("ModifyResponseServiceUid")
public class ModifyResponseServiceUid implements ModifyResponseService {

    @Override
    public Response modify(Response response) {

        UUID uuid = UUID.randomUUID();

        response.setOperationUid(uuid.toString());

        return response;
    }
}