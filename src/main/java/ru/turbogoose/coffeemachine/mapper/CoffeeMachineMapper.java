package ru.turbogoose.coffeemachine.mapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.turbogoose.coffeemachine.dto.CoffeeMachineResponseDto;
import ru.turbogoose.coffeemachine.model.CoffeeMachine;

@Component
@RequiredArgsConstructor
public class CoffeeMachineMapper {
    private final ModelMapper modelMapper;

    public CoffeeMachineResponseDto toDto(CoffeeMachine model) {
        return modelMapper.map(model, CoffeeMachineResponseDto.class);
    }
}
