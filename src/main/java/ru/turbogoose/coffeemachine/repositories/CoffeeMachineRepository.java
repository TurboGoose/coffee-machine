package ru.turbogoose.coffeemachine.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.turbogoose.coffeemachine.models.CoffeeMachine;

@Repository
public interface CoffeeMachineRepository extends JpaRepository<CoffeeMachine, Integer> {
}
