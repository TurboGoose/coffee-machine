package ru.turbogoose.coffeemachine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.turbogoose.coffeemachine.model.CoffeeMachine;

@Repository
public interface CoffeeMachineRepository extends JpaRepository<CoffeeMachine, Integer> {
}
