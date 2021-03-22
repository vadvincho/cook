package com.vadzimvincho.cook.vegetablestorage;

import com.vadzimvincho.cook.cook.Recipe;
import com.vadzimvincho.cook.model.vegetable.Vegetable;

import java.util.List;

public interface VegetableStorage {
    List<Vegetable> getVegetablesByRecipe(Recipe recipe);

    List<Vegetable> getVegetablesRandom(int amount);
}
