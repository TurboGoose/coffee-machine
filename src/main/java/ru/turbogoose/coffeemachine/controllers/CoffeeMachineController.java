package ru.turbogoose.coffeemachine.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.turbogoose.coffeemachine.dtos.CoffeeMachineResponseDto;
import ru.turbogoose.coffeemachine.dtos.CoffeeMachinesResponseDto;
import ru.turbogoose.coffeemachine.dtos.ErrorResponseDto;
import ru.turbogoose.coffeemachine.exceptions.CoffeeMachineNotFound;
import ru.turbogoose.coffeemachine.services.CoffeeMachineService;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/coffeemachines")
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

    @PutMapping("/{id}/enable")
    public CoffeeMachineResponseDto enableCoffeeMachine(@PathVariable int id) {
        return service.enableCoffeeMachine(id);
    }

    @PutMapping("/{id}/disable")
    public CoffeeMachineResponseDto disableCoffeeMachine(@PathVariable int id) {
        return service.disableCoffeeMachine(id);
    }

    @ExceptionHandler(CoffeeMachineNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponseDto handleNotFound(RuntimeException exception) {
        return ErrorResponseDto.builder()
                .message(exception.getMessage())
                .build();
    }
}
