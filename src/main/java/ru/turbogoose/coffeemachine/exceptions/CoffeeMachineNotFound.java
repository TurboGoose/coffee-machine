package ru.turbogoose.coffeemachine.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CoffeeMachineNotFound extends RuntimeException {
    public CoffeeMachineNotFound(String message) {
        super(message);
    }
}
