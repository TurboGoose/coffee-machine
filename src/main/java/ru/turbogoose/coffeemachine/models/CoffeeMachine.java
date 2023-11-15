package ru.turbogoose.coffeemachine.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "coffee_machines")
public class CoffeeMachine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "enabled")
    private boolean enabled;
    @Column(name = "water_filled")
    private boolean waterFilled;
    @Column(name = "ground_coffee_filled")
    private boolean groundCoffeeFilled;
    @Column(name = "coffee_filled")
    private boolean coffeeFilled;

    public void fillWater() {
        if (waterFilled) {
            throw new IllegalStateException("Water already filled");
        }
        waterFilled = true;
    }

    public void fillGroundCoffee() {
        if (groundCoffeeFilled) {
            throw new IllegalStateException("Ground coffee already filled");
        }
        groundCoffeeFilled = true;
    }

    public void pourCoffee() {
        if (!coffeeFilled) {
            throw new IllegalStateException("No coffee boiled");
        }
        coffeeFilled = false;
    }

    public void boilCoffee() {
        if (!enabled) {
            throw new IllegalStateException("Coffee machine is disabled");
        }
        if (!waterFilled) {
            throw new IllegalStateException("No water");
        }
        if (!groundCoffeeFilled) {
            throw new IllegalStateException("No ground coffee");
        }
        if (coffeeFilled) {
            throw new IllegalStateException("Coffee already boiled");
        }
        waterFilled = false;
        groundCoffeeFilled = false;
        coffeeFilled = true;
    }

    public void enable() {
        enabled = true;
    }

    public void disable() {
        enabled = false;
    }
}
