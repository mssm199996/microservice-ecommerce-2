package com.mssmfactory.client.decoders;

import com.mssmfactory.client.exceptions.EntityNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class CustomErrorDecoder implements ErrorDecoder {

    public ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String s, Response response) {
        if (response.status() == HttpStatus.NOT_FOUND.value()) {
            throw new EntityNotFoundException("Entity not found !");
        }

        return this.defaultErrorDecoder.decode(s, response);
    }
}
