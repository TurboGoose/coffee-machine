package ru.turbogoose.coffeemachine.exceptions;

public class CoffeeMachineNotFound extends RuntimeException {
    public CoffeeMachineNotFound(String message) {
        super(message);
    }
}
