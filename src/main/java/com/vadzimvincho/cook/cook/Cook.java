package com.vadzimvincho.cook.cook;

import com.vadzimvincho.cook.model.salad.Salad;
import com.vadzimvincho.cook.model.vegetable.Vegetable;

import java.util.List;

public interface Cook {
    Salad cookSaladFromMenu(Recipe recipe);

    Salad cookSaladByChef(int amount);

    List<Vegetable> sortByName(Salad salad);

    List<Vegetable> sortByCalories(Salad salad);

    int getCalories(Salad salad);

    List<Vegetable> getVegetableByCalories(Salad salad, int minCalories, int maxCalories);
}
