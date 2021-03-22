package com.vadzimvincho.cook;

import com.vadzimvincho.cook.cook.Recipe;
import com.vadzimvincho.cook.model.salad.Salad;
import com.vadzimvincho.cook.vegetablestorage.RestaurantVegetableStorage;
import com.vadzimvincho.cook.vegetablestorage.VegetableStorage;
import com.vadzimvincho.cook.cook.Cook;
import com.vadzimvincho.cook.cook.Chef;

public class Application {
    public static void main(String[] args) {
        VegetableStorage vegetableStorage = new RestaurantVegetableStorage();

        Cook cook = new Chef(vegetableStorage);

        Salad salad = cook.cookSaladFromMenu(Recipe.DIETARY_SALAD);
        cook.getCalories(salad);
        cook.getVegetableByCalories(salad,50,120);
        cook.sortByCalories(salad);
        cook.sortByName(salad);

        Salad salad1 = cook.cookSaladByChef(5);
        cook.getCalories(salad1);
        cook.getVegetableByCalories(salad1,50,120);
        cook.sortByCalories(salad1);
        cook.sortByName(salad1);

        Salad salad3 = cook.cookSaladFromMenu(Recipe.SALAD);


    }
}
