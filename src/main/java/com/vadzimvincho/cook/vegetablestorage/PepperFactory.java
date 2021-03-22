package com.vadzimvincho.cook.vegetablestorage;

import com.vadzimvincho.cook.model.vegetable.Pepper;
import com.vadzimvincho.cook.model.vegetable.Vegetable;
import com.vadzimvincho.cook.util.VegetableSupplier;

import java.util.ArrayList;
import java.util.List;

public class PepperFactory implements VegetableFactory {
    @Override
    public List<Vegetable> getVegetables(String name) {
        List<Vegetable> vegetables = new ArrayList<>();
        for (List<String> line : VegetableSupplier.getVegetablesFromFile(name)) {
            Pepper pepper = new Pepper();
            pepper.setName(line.get(0));
            pepper.setGenus(line.get(1));
            pepper.setPepperColor(line.get(2));
            pepper.setCalories(Integer.parseInt(line.get(3)));
            pepper.setWeight(Integer.parseInt(line.get(4)));
            vegetables.add(pepper);
        }
        return vegetables;
    }
}
