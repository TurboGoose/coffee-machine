package ru.turbogoose.coffeemachine.model;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class CoffeeMachineTest {
    @Test
    public void fillWaterWhenEmpty() {
        CoffeeMachine coffeeMachine = CoffeeMachine.builder()
                .waterFilled(false)
                .build();

        coffeeMachine.fillWater();
        assertThat(coffeeMachine.isWaterFilled(), is(true));
    }

    @Test
    public void fillWaterWhenAlreadyFilled() {
        CoffeeMachine coffeeMachine = CoffeeMachine.builder()
                .waterFilled(true)
                .build();

        assertThrows(IllegalStateException.class, coffeeMachine::fillWater);
    }

    @Test
    public void fillGroundCoffeeWhenEmpty() {
        CoffeeMachine coffeeMachine = CoffeeMachine.builder()
                .groundCoffeeFilled(false)
                .build();

        coffeeMachine.fillGroundCoffee();
        assertThat(coffeeMachine.isGroundCoffeeFilled(), is(true));
    }

    @Test
    public void fillWaterWhenAlreadyFiled() {
        CoffeeMachine coffeeMachine = CoffeeMachine.builder()
                .groundCoffeeFilled(true)
                .build();

        assertThrows(IllegalStateException.class, coffeeMachine::fillGroundCoffee);
    }

    @Test
    public void pourGroundCoffeeWhenBoiled() {
        CoffeeMachine coffeeMachine = CoffeeMachine.builder()
                .coffeeBoiled(true)
                .build();

        coffeeMachine.pourCoffee();
        assertThat(coffeeMachine.isCoffeeBoiled(), is(false));
    }

    @Test
    public void pourGroundCoffeeWhenEmpty() {
        CoffeeMachine coffeeMachine = CoffeeMachine.builder()
                .coffeeBoiled(false)
                .build();

        assertThrows(IllegalStateException.class, coffeeMachine::boilCoffee);
    }

    @Test
    public void enableIdempotence() {
        CoffeeMachine coffeeMachine = CoffeeMachine.builder()
                .enabled(true)
                .build();

        coffeeMachine.enable();
        assertThat(coffeeMachine.isEnabled(), is(true));
        coffeeMachine.enable();
        assertThat(coffeeMachine.isEnabled(), is(true));
    }

    @Test
    public void disableIdempotence() {
        CoffeeMachine coffeeMachine = CoffeeMachine.builder()
                .enabled(false)
                .build();

        coffeeMachine.disable();
        assertThat(coffeeMachine.isEnabled(), is(false));
        coffeeMachine.disable();
        assertThat(coffeeMachine.isEnabled(), is(false));
    }

    @Test
    public void boilCoffee() {
        CoffeeMachine coffeeMachine = CoffeeMachine.builder()
                .enabled(true)
                .waterFilled(true)
                .groundCoffeeFilled(true)
                .coffeeBoiled(false)
                .build();

        coffeeMachine.boilCoffee();

        assertThat(coffeeMachine.isEnabled() ,is(true));
        assertThat(coffeeMachine.isWaterFilled() ,is(false));
        assertThat(coffeeMachine.isGroundCoffeeFilled() ,is(false));
        assertThat(coffeeMachine.isCoffeeBoiled() ,is(true));
    }

    @Test
    public void failBoilingWhenDisabled() {
        CoffeeMachine coffeeMachine = CoffeeMachine.builder()
                .enabled(false)
                .waterFilled(true)
                .groundCoffeeFilled(true)
                .coffeeBoiled(false)
                .build();

        assertThrows(IllegalStateException.class, coffeeMachine::boilCoffee);
    }

    @Test
    public void failBoilingWhenNoWater() {
        CoffeeMachine coffeeMachine = CoffeeMachine.builder()
                .enabled(true)
                .waterFilled(false)
                .groundCoffeeFilled(true)
                .coffeeBoiled(false)
                .build();

        assertThrows(IllegalStateException.class, coffeeMachine::boilCoffee);
    }

    @Test
    public void failBoilingWhenNoGroundCoffee() {
        CoffeeMachine coffeeMachine = CoffeeMachine.builder()
                .enabled(true)
                .waterFilled(true)
                .groundCoffeeFilled(false)
                .coffeeBoiled(false)
                .build();

        assertThrows(IllegalStateException.class, coffeeMachine::boilCoffee);
    }

    @Test
    public void failBoilingWhenAlreadyBoiled() {
        CoffeeMachine coffeeMachine = CoffeeMachine.builder()
                .enabled(true)
                .waterFilled(true)
                .groundCoffeeFilled(true)
                .coffeeBoiled(true)
                .build();

        assertThrows(IllegalStateException.class, coffeeMachine::boilCoffee);
    }
}