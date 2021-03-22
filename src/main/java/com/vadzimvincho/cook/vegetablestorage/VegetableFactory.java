package com.vadzimvincho.cook.vegetablestorage;

import com.vadzimvincho.cook.model.vegetable.Vegetable;

import java.util.List;

public interface VegetableFactory {
    List<Vegetable> getVegetables(String vegetableName);

    static VegetableFactory of(String vegetableName) {
        if (vegetableName.contains("tomato")) {
            return new TomatoFactory();
        } else if (vegetableName.contains("cucumber")) {
            return new CucumberFactory();
        } else if (vegetableName.contains("cabbage")) {
            return new CabbageFactory();
        } else if (vegetableName.contains("pepper")) {
            return new PepperFactory();
        } else {
            throw new UnsupportedOperationException("no factory corresponding to the vegetable. Vegetable: " + vegetableName);
        }
    }
}