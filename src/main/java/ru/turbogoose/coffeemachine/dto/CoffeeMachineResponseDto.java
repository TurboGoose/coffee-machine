package ru.turbogoose.coffeemachine.dto;

import lombok.Data;

@Data
public class CoffeeMachineResponseDto {
    private Integer id;
    private boolean enabled;
    private boolean waterFilled;
    private boolean groundCoffeeFilled;
    private boolean coffeeBoiled;
}
