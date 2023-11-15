package ru.turbogoose.coffeemachine.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.turbogoose.coffeemachine.dtos.CoffeeMachineResponseDto;
import ru.turbogoose.coffeemachine.dtos.CoffeeMachinesResponseDto;
import ru.turbogoose.coffeemachine.dtos.ErrorResponseDto;
import ru.turbogoose.coffeemachine.exceptions.CoffeeMachineNotFound;
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

    @GetMapping("/{id}")
    public CoffeeMachineResponseDto getCoffeeMachine(@PathVariable int id) {
        return service.getCoffeeMachine(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCoffeeMachine(@PathVariable int id) {
        service.deleteCoffeeMachine(id);
    }

    @ExceptionHandler(CoffeeMachineNotFound.class)
    public ErrorResponseDto handleNotFound(RuntimeException exception) {
        return ErrorResponseDto.builder()
                .message(exception.getMessage())
                .build();
    }
}
