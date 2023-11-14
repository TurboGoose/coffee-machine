package ru.turbogoose.coffeemachine.models;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class CoffeeMachineTest {
    @Test
    public void fillWaterWhenEmpty() {
        CoffeeMachine coffeeMachine = CoffeeMachine.builder()
                .hasWater(false)
                .build();

        coffeeMachine.fillWater();
        assertThat(coffeeMachine.isHasWater(), is(true));
    }

    @Test
    public void fillWaterWhenAlreadyFilled() {
        CoffeeMachine coffeeMachine = CoffeeMachine.builder()
                .hasWater(true)
                .build();

        assertThrows(IllegalStateException.class, coffeeMachine::fillWater);
    }

    @Test
    public void fillGroundCoffeeWhenEmpty() {
        CoffeeMachine coffeeMachine = CoffeeMachine.builder()
                .hasGroundCoffee(false)
                .build();

        coffeeMachine.fillGroundCoffee();
        assertThat(coffeeMachine.isHasGroundCoffee(), is(true));
    }

    @Test
    public void fillWaterWhenAlreadyFiled() {
        CoffeeMachine coffeeMachine = CoffeeMachine.builder()
                .hasGroundCoffee(true)
                .build();

        assertThrows(IllegalStateException.class, coffeeMachine::fillGroundCoffee);
    }

    @Test
    public void pourGroundCoffeeWhenBoiled() {
        CoffeeMachine coffeeMachine = CoffeeMachine.builder()
                .hasCoffee(true)
                .build();

        coffeeMachine.pourCoffee();
        assertThat(coffeeMachine.isHasCoffee(), is(false));
    }

    @Test
    public void pourGroundCoffeeWhenEmpty() {
        CoffeeMachine coffeeMachine = CoffeeMachine.builder()
                .hasCoffee(false)
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
                .hasWater(true)
                .hasGroundCoffee(true)
                .hasCoffee(false)
                .build();

        coffeeMachine.boilCoffee();

        assertThat(coffeeMachine.isEnabled() ,is(true));
        assertThat(coffeeMachine.isHasWater() ,is(false));
        assertThat(coffeeMachine.isHasGroundCoffee() ,is(false));
        assertThat(coffeeMachine.isHasCoffee() ,is(true));
    }

    @Test
    public void failBoilingWhenDisabled() {
        CoffeeMachine coffeeMachine = CoffeeMachine.builder()
                .enabled(false)
                .hasWater(true)
                .hasGroundCoffee(true)
                .hasCoffee(false)
                .build();

        assertThrows(IllegalStateException.class, coffeeMachine::boilCoffee);
    }

    @Test
    public void failBoilingWhenNoWater() {
        CoffeeMachine coffeeMachine = CoffeeMachine.builder()
                .enabled(true)
                .hasWater(false)
                .hasGroundCoffee(true)
                .hasCoffee(false)
                .build();

        assertThrows(IllegalStateException.class, coffeeMachine::boilCoffee);
    }

    @Test
    public void failBoilingWhenNoGroundCoffee() {
        CoffeeMachine coffeeMachine = CoffeeMachine.builder()
                .enabled(true)
                .hasWater(true)
                .hasGroundCoffee(false)
                .hasCoffee(false)
                .build();

        assertThrows(IllegalStateException.class, coffeeMachine::boilCoffee);
    }

    @Test
    public void failBoilingWhenAlreadyBoiled() {
        CoffeeMachine coffeeMachine = CoffeeMachine.builder()
                .enabled(true)
                .hasWater(true)
                .hasGroundCoffee(true)
                .hasCoffee(true)
                .build();

        assertThrows(IllegalStateException.class, coffeeMachine::boilCoffee);
    }
}