package com.vadzimvincho.cook.vegetablestorage;

import com.vadzimvincho.cook.cook.Recipe;
import com.vadzimvincho.cook.model.vegetable.Vegetable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RestaurantVegetableStorage implements VegetableStorage {
    private static final Logger LOGGER = LoggerFactory.getLogger(RestaurantVegetableStorage.class);

    private final List<Vegetable> vegetableStorage = new ArrayList<>();

    public RestaurantVegetableStorage() {
        initVegetableStorage();
    }

    private void initVegetableStorage() {
        vegetableStorage.addAll(getVegetablesFromVegetableFactory("cabbage"));
        vegetableStorage.addAll(getVegetablesFromVegetableFactory("cucumber"));
        vegetableStorage.addAll(getVegetablesFromVegetableFactory("pepper"));
        vegetableStorage.addAll(getVegetablesFromVegetableFactory("tomato"));
        LOGGER.debug("Vegetable storage initialization was successful");
    }

    public List<Vegetable> getVegetablesByRecipe(Recipe recipe) {
        List<Vegetable> vegetables = new ArrayList<>();
        List<String> recipeList = recipe.getRecipe();
        Vegetable vegetableByRecipe = null;

        for (String vegetableName : recipeList) {
            try {
                vegetableByRecipe = getVegetable(vegetableName, vegetableStorage);
                vegetableStorage.remove(vegetableByRecipe);
            } catch (NoSuchElementException e) {
                LOGGER.debug("No such vegetable in vegetable storage. Vegetable: " + vegetableName);
                try {
                    List<Vegetable> vegetableFromVegetableFactory = getVegetablesFromVegetableFactory(vegetableName);
                    vegetableByRecipe = getVegetable(vegetableName, vegetableFromVegetableFactory);
                } catch (NoSuchElementException ex){
                    LOGGER.debug("No such vegetable on vegetable factory. Vegetable: " + vegetableName);
                    throw new NoSuchElementException();
                }
            }
            vegetables.add(vegetableByRecipe);
        }
        LOGGER.debug("list of vegetables compiled according to the recipe");
        return vegetables;
    }

    @Override
    public List<Vegetable> getVegetablesRandom(int amount) {
        Random random = new Random();
        return IntStream
                .generate(() -> random.nextInt(vegetableStorage.size()))
                .distinct()
                .limit(amount)
                .mapToObj(index -> vegetableStorage.get(index))
                .collect(Collectors.toList());
    }

    private Vegetable getVegetable(String vegetableName, List<Vegetable> vegetableList) {
        Vegetable vegetableByRecipe;
        vegetableByRecipe = vegetableList.stream()
                .filter(vegetable -> vegetable.getName().equalsIgnoreCase(vegetableName))
                .findFirst().get();
        return vegetableByRecipe;
    }

    private List<Vegetable> getVegetablesFromVegetableFactory(String vegetableName) {
        List<Vegetable> vegetables;
        try {
            VegetableFactory factory = VegetableFactory.of(vegetableName);
            vegetables = factory.getVegetables(vegetableName);
        } catch (UnsupportedOperationException e) {
            LOGGER.debug(e.getMessage());
            throw new UnsupportedOperationException(e.getMessage());
        }
        return vegetables;
    }
}