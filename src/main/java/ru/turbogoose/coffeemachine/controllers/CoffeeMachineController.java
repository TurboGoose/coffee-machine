package ru.turbogoose.coffeemachine.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.turbogoose.coffeemachine.dtos.CoffeeMachineResponseDto;
import ru.turbogoose.coffeemachine.dtos.CoffeeMachinesResponseDto;
import ru.turbogoose.coffeemachine.services.CoffeeMachineService;
import ru.turbogoose.coffeemachine.services.Ingredient;

import java.util.List;

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

    @PostMapping("/{id}/fill")
    public CoffeeMachineResponseDto fillCoffeeMachineWithIngredients(
            @PathVariable int id,
            @RequestParam("ingredient") List<Ingredient> ingredients) {
        return service.fillCoffeeMachineWithIngredients(id, ingredients);
    }

    @PutMapping("/{id}/boil")
    public CoffeeMachineResponseDto boilCoffeeInCoffeeMachine(@PathVariable int id) {
        return service.boilCoffeeInCoffeeMachine(id);
    }

    @PutMapping("/{id}/pour")
    public CoffeeMachineResponseDto pourCoffeeFromCoffeeMachine(@PathVariable int id) {
        return service.pourCoffeeFromCoffeeMachine(id);
    }
}
