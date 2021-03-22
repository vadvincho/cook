package com.vadzimvincho.cook.vegetablestorage;

import com.vadzimvincho.cook.model.vegetable.Cucumber;
import com.vadzimvincho.cook.model.vegetable.Vegetable;
import com.vadzimvincho.cook.util.VegetableSupplier;

import java.util.ArrayList;
import java.util.List;

public class CucumberFactory implements VegetableFactory {

    @Override
    public List<Vegetable> getVegetables(String name) {
        List<Vegetable> vegetables = new ArrayList<>();
        for (List<String> line : VegetableSupplier.getVegetablesFromFile(name)) {
            Cucumber cucumber = new Cucumber();
            cucumber.setName(line.get(0));
            cucumber.setThornsColor(line.get(1));
            cucumber.setShirt(line.get(2));
            cucumber.setCalories(Integer.parseInt(line.get(3)));
            cucumber.setWeight(Integer.parseInt(line.get(4)));
            vegetables.add(cucumber);
        }
        return vegetables;
    }
}