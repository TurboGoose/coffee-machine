package ru.turbogoose.coffeemachine.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.turbogoose.coffeemachine.dtos.CoffeeMachineResponseDto;
import ru.turbogoose.coffeemachine.dtos.CoffeeMachinesResponseDto;
import ru.turbogoose.coffeemachine.services.CoffeeMachineService;

@RestController
@RequiredArgsConstructor
public class CoffeeMachineController {
    private final CoffeeMachineService service;

    @GetMapping("/")
    public CoffeeMachinesResponseDto getAllCoffeeMachines() {
        return service.getAllCoffeeMachines();
    }

    @PostMapping("/")
    public CoffeeMachineResponseDto createCoffeeMachine() {
        return service.createCoffeeMachine();
    }
}
