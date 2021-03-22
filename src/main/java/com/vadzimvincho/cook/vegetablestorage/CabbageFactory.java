package com.vadzimvincho.cook.vegetablestorage;

import com.vadzimvincho.cook.model.vegetable.Cabbage;
import com.vadzimvincho.cook.model.vegetable.Vegetable;
import com.vadzimvincho.cook.util.VegetableSupplier;

import java.util.ArrayList;
import java.util.List;

public class CabbageFactory implements VegetableFactory {
    @Override
    public List<Vegetable> getVegetables(String name) {
        List<Vegetable> vegetables = new ArrayList<>();
        for (List<String> line : VegetableSupplier.getVegetablesFromFile(name)) {
            Cabbage cabbage = new Cabbage();
            cabbage.setName(line.get(0));
            cabbage.setType(line.get(1));
            cabbage.setColorCabbage(line.get(2));
            cabbage.setCalories(Integer.parseInt(line.get(3)));
            cabbage.setWeight(Integer.parseInt(line.get(4)));
            vegetables.add(cabbage);
        }
        return vegetables;
    }
}