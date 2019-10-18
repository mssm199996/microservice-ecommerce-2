package com.mpayment.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ImpossibleToAddPaymentException extends RuntimeException {


    public ImpossibleToAddPaymentException(String message) {
        super(message);
    }
}
