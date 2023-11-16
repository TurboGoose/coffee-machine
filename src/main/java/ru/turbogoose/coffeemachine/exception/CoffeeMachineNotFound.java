package ru.turbogoose.coffeemachine.exception;

public class CoffeeMachineNotFound extends RuntimeException {
    public CoffeeMachineNotFound(String message) {
        super(message);
    }
}
