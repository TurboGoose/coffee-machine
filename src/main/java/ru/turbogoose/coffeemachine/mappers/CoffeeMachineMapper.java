package ru.turbogoose.coffeemachine.mappers;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.turbogoose.coffeemachine.dtos.CoffeeMachineResponseDto;
import ru.turbogoose.coffeemachine.models.CoffeeMachine;

@Component
@RequiredArgsConstructor
public class CoffeeMachineMapper {
    private final ModelMapper modelMapper;

    public CoffeeMachineResponseDto toDto(CoffeeMachine model) {
        return modelMapper.map(model, CoffeeMachineResponseDto.class);
    }
}
