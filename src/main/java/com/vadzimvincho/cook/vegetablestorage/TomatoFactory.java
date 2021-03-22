package com.vadzimvincho.cook.vegetablestorage;

import com.vadzimvincho.cook.model.vegetable.Tomato;
import com.vadzimvincho.cook.model.vegetable.Vegetable;
import com.vadzimvincho.cook.util.VegetableSupplier;

import java.util.ArrayList;
import java.util.List;

public class TomatoFactory implements VegetableFactory {

    @Override
    public List<Vegetable> getVegetables(String vegetableName) {
        List<Vegetable> vegetables = new ArrayList<>();
        for (List<String> line : VegetableSupplier.getVegetablesFromFile(vegetableName)) {
            Tomato tomato = new Tomato();
            tomato.setName(line.get(0));
            tomato.setTomatoColor(line.get(1));
            tomato.setTomatoShape(line.get(2));
            tomato.setCalories(Integer.parseInt(line.get(3)));
            tomato.setWeight(Integer.parseInt(line.get(4)));
            vegetables.add(tomato);
        }
        return vegetables;
    }
}