package ru.turbogoose.coffeemachine.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.turbogoose.coffeemachine.dtos.CoffeeMachineResponseDto;
import ru.turbogoose.coffeemachine.dtos.CoffeeMachinesResponseDto;
import ru.turbogoose.coffeemachine.exceptions.CoffeeMachineNotFound;
import ru.turbogoose.coffeemachine.mappers.CoffeeMachineMapper;
import ru.turbogoose.coffeemachine.models.CoffeeMachine;
import ru.turbogoose.coffeemachine.repositories.CoffeeMachineRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoffeeMachineService {
    private final CoffeeMachineRepository repository;
    private final CoffeeMachineMapper mapper;

    public CoffeeMachinesResponseDto getAllCoffeeMachines() {
        List<CoffeeMachine> coffeeMachines = repository.findAll();
        return CoffeeMachinesResponseDto.builder()
                .coffeeMachines(coffeeMachines.stream()
                        .map(mapper::toDto)
                        .toList())
                .build();
    }

    public CoffeeMachineResponseDto createCoffeeMachine() {
        CoffeeMachine coffeeMachine = repository.save(new CoffeeMachine());
        return mapper.toDto(coffeeMachine);
    }

    public CoffeeMachineResponseDto getCoffeeMachine(int id) {
        CoffeeMachine coffeeMachine = repository.findById(id).orElseThrow(
                () -> new CoffeeMachineNotFound(String.format("Coffee machine with id %d not found", id)));
        return mapper.toDto(coffeeMachine);
    }
}
