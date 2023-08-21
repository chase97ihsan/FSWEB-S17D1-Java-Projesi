package com.workintech.res.controller;

import com.workintech.res.entity.Animal;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AnimalController {
    @Value("${instructor.name}")
    private String name;

    private Map<Integer, Animal> animals;

    @PostConstruct   //constructordan sonra çalışacak ilk metoddur.
    public void init() {
        this.animals = new HashMap<>();
    }

    @GetMapping("/workintech/animal")
    public List<Animal> get() {
        return animals.values().stream().toList();
    }

    @GetMapping("/workintech/animal/{id}")
    public Animal get(@PathVariable int id) {
        if (id < 0) {
            //TODO is not valid!
        }
        if (!animals.containsKey(id)) {
            //TODO this key is not.

        }
        return animals.get(id);
    }

    @PostMapping("/workintech/animal")
    public Animal save(@RequestBody Animal animal) {
        if (animals.containsKey(animal.getId())) {
            //TODO this key id is not available.
        }
        if (animal.getId() < 0 || animal.getName() == null || animal.getName().isEmpty()) {
            //TODO animal credentials are not valid.
        }
        animals.put(animal.getId(), animal);
        return animals.get(animal.getId());
    }

    @PutMapping("/workintech/animal/{id}")
    public Animal put(@PathVariable int id, @RequestBody Animal animal) {
        if (animals.containsKey(id)) {
            //TODO key is not exist.
        }
        if (animal.getId() < 0 || animal.getName() == null || animal.getName().isEmpty()) {
            //TODO animal credentials are not valid.
        }
        animals.put(id, new Animal(id, animal.getName()));
        return animals.get(id);
    }

    @DeleteMapping("/workintech/animal/{id}")

    public Animal delete(@PathVariable int id) {
        if (animals.containsKey(id)) {
            //TODO key is not exist.
        }
        return animals.remove(id);
    }
}
