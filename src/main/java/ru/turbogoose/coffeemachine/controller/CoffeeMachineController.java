package ru.turbogoose.coffeemachine.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.turbogoose.coffeemachine.dto.CoffeeMachineResponseDto;
import ru.turbogoose.coffeemachine.dto.CoffeeMachinesResponseDto;
import ru.turbogoose.coffeemachine.dto.ErrorResponseDto;
import ru.turbogoose.coffeemachine.service.CoffeeMachineService;
import ru.turbogoose.coffeemachine.service.Ingredient;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/coffeemachines")
@Tag(name = "Coffee machines", description = "Coffee machines management API")
public class CoffeeMachineController {
    private final CoffeeMachineService service;

    @GetMapping("/")
    @Operation(summary = "Get all coffee machines")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CoffeeMachinesResponseDto.class))})})
    public CoffeeMachinesResponseDto getAllCoffeeMachines() {
        return service.getAllCoffeeMachines();
    }

    @PostMapping("/")
    @Operation(summary = "Create new coffee machine")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CoffeeMachineResponseDto.class))})})
    public CoffeeMachineResponseDto createCoffeeMachine() {
        return service.createCoffeeMachine();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get coffee machine by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CoffeeMachineResponseDto.class))}),
            @ApiResponse(responseCode = "404", description = "Coffee machine not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class)))})
    public CoffeeMachineResponseDto getCoffeeMachine(@PathVariable int id) {
        return service.getCoffeeMachine(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete coffee machine by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200")})
    public void deleteCoffeeMachine(@PathVariable int id) {
        service.deleteCoffeeMachine(id);
    }

    @PutMapping("/{id}/enable")
    @Operation(summary = "Enable coffee machine")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CoffeeMachineResponseDto.class))}),
            @ApiResponse(responseCode = "404", description = "Coffee machine not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class)))})
    public CoffeeMachineResponseDto enableCoffeeMachine(@PathVariable int id) {
        return service.enableCoffeeMachine(id);
    }

    @PutMapping("/{id}/disable")
    @Operation(summary = "Disable coffee machine")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CoffeeMachineResponseDto.class))}),
            @ApiResponse(responseCode = "404", description = "Coffee machine not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class)))})
    public CoffeeMachineResponseDto disableCoffeeMachine(@PathVariable int id) {
        return service.disableCoffeeMachine(id);
    }

    @PostMapping("/{id}/fill")
    @Operation(summary = "Fill coffee machine with ingredients")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CoffeeMachineResponseDto.class))}),
            @ApiResponse(responseCode = "404", description = "Coffee machine not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))),
            @ApiResponse(responseCode = "409", description = "Coffee machine already filled with ingredients being passed",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class)))})
    public CoffeeMachineResponseDto fillCoffeeMachineWithIngredients(
            @PathVariable int id,
            @RequestParam("ingredient") List<Ingredient> ingredients) {
        return service.fillCoffeeMachineWithIngredients(id, ingredients);
    }

    @PutMapping("/{id}/boil")
    @Operation(summary = "Boil coffee in coffee machine")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CoffeeMachineResponseDto.class))}),
            @ApiResponse(responseCode = "404", description = "Coffee machine not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))),
            @ApiResponse(responseCode = "409", description = "Coffee is already boiled",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class)))})
    public CoffeeMachineResponseDto boilCoffeeInCoffeeMachine(@PathVariable int id) {
        return service.boilCoffeeInCoffeeMachine(id);
    }

    @PutMapping("/{id}/pour")
    @Operation(summary = "Pour boiled coffee from coffee machine")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CoffeeMachineResponseDto.class))}),
            @ApiResponse(responseCode = "404", description = "Coffee machine not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))),
            @ApiResponse(responseCode = "409", description = "Coffee is not boiled",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class)))})
    public CoffeeMachineResponseDto pourCoffeeFromCoffeeMachine(@PathVariable int id) {
        return service.pourCoffeeFromCoffeeMachine(id);
    }
}
