package ru.turbogoose.coffeemachine.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class CoffeeMachine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private boolean hasWater;
    private boolean hasGroundCoffee;
    private boolean hasCoffee;
    private boolean enabled;

    public void fillWater() {
        if (hasWater) {
            throw new IllegalStateException("Water already filled");
        }
        hasWater = true;
    }

    public void fillGroundCoffee() {
        if (hasGroundCoffee) {
            throw new IllegalStateException("Ground coffee already filled");
        }
        hasGroundCoffee = true;
    }

    public void pourCoffee() {
        if (!hasCoffee) {
            throw new IllegalStateException("No coffee boiled");
        }
        hasCoffee = false;
    }

    public void boilCoffee() {
        if (!hasWater) {
            throw new IllegalStateException("No water");
        }
        if (!hasGroundCoffee) {
            throw new IllegalStateException("No ground coffee");
        }
        if (!hasCoffee) {
            throw new IllegalStateException("Coffee already boiled");
        }
        hasWater = false;
        hasGroundCoffee = false;
        hasCoffee = true;
    }

    public void enable() {
        enabled = true;
    }

    public void disable() {
        enabled = false;
    }
}
