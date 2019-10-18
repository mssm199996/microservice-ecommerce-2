package com.mssmfactory.microserviceexpeditions.decoders;

import com.mssmfactory.microserviceexpeditions.web.exceptions.CommandNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        if (response.status() == HttpStatus.NOT_FOUND.value())
            return new CommandNotFoundException();

        else return new RuntimeException();
    }
}
