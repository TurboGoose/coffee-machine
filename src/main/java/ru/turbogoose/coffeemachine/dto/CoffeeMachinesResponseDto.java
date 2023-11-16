package ru.turbogoose.coffeemachine.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CoffeeMachinesResponseDto {
    private List<CoffeeMachineResponseDto> coffeeMachines;
}
