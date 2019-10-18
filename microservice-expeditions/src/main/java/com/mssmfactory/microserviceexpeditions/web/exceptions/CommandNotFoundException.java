package com.mssmfactory.microserviceexpeditions.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CommandNotFoundException extends RuntimeException {
}
