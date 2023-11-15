package ru.turbogoose.coffeemachine.dtos;

import lombok.Data;

@Data
public class CoffeeMachineResponseDto {
    private Integer id;
    private boolean enabled;
    private boolean waterFilled;
    private boolean groundCoffeeFilled;
    private boolean coffeeFilled;
}
