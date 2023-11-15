package ru.turbogoose.coffeemachine.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.turbogoose.coffeemachine.dtos.ErrorResponseDto;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(CoffeeMachineNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponseDto handleNotFound(RuntimeException exception) {
        return composeResponse(exception.getMessage());
    }

    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponseDto handleIllegalState(RuntimeException exception) {
        return composeResponse(exception.getMessage());
    }

    private ErrorResponseDto composeResponse(String message) {
        return ErrorResponseDto.builder()
                .message(message)
                .build();
    }
}
