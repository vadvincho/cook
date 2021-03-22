package com.vadzimvincho.cook.cook;

import com.vadzimvincho.cook.model.salad.Salad;
import com.vadzimvincho.cook.model.vegetable.Vegetable;
import com.vadzimvincho.cook.util.VegetableComparator;
import com.vadzimvincho.cook.vegetablestorage.VegetableStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Chef implements Cook {
    private static final Logger LOGGER = LoggerFactory.getLogger(Chef.class);
    private VegetableStorage vegetableStorage;

    public Chef(VegetableStorage vegetableStorage) {
        this.vegetableStorage = vegetableStorage;
    }

    @Override
    public Salad cookSaladFromMenu(Recipe recipe) {
        Salad salad = new Salad(recipe.name());
        try {
            salad.setVegetables(vegetableStorage.getVegetablesByRecipe(recipe));
            LOGGER.info("Salad {} is ready", salad.getName());
        } catch (NoSuchElementException | UnsupportedOperationException e) {
            LOGGER.info("Salad can't be prepared with this recipe. You must choose another. " + e.toString());
        }
        return salad;
    }

    @Override
    public Salad cookSaladByChef(int amount) {
        Salad salad = new Salad("SALAD_BY_CHEF");
        salad.setVegetables(vegetableStorage.getVegetablesRandom(amount));
        LOGGER.info("Salad {} is ready", salad.getName());
        return salad;
    }

    @Override
    public int getCalories(Salad salad) {
        int calories = 0;
        for (Vegetable vegetable : salad.getVegetables()) {
            calories += vegetable.getCalories() * vegetable.getWeight() / 100;
        }
        LOGGER.info("Salad contains {} calories", calories);
        return calories;
    }

    @Override
    public List<Vegetable> getVegetableByCalories(Salad salad, int minCalories, int maxCalories) {
        List<Vegetable> vegetables = new ArrayList<>();
        for (Vegetable vegetable : salad.getVegetables()) {
            int calories = vegetable.getCalories();
            if (calories >= minCalories && calories <= maxCalories) {
                vegetables.add(vegetable);
            }
        }
        LOGGER.info("Salad includes vegetables that contain {} to {} calories: {}", minCalories, maxCalories, vegetables);
        return vegetables;
    }

    @Override
    public List<Vegetable> sortByName(Salad salad) {
        return sort(salad, VegetableComparator.SORT_BY_NAME);
    }

    @Override
    public List<Vegetable> sortByCalories(Salad salad) {
        return sort(salad, VegetableComparator.SORT_BY_CALORIES);
    }

    private List<Vegetable> sort(Salad salad, VegetableComparator vegetableComparator) {
        List<Vegetable> sortList = vegetableComparator.sort(salad.getVegetables());
        LOGGER.info("List of vegetable {} : {}", vegetableComparator.name(), sortList);
        return sortList;
    }
}