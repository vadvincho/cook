package com.vadzimvincho.cook.cook;

import java.util.List;

public enum Recipe {
    DIETARY_SALAD(List.of("cucumber-gerasim", "tomato-agafia","pepper-aries")),
    GREEK(List.of("tomato-black_prince", "cucumber-blick")),
    LIGHT_SALAD(List.of("tomato-apricot", "cabbage-savoy")),
    PARMIGIANA(List.of("pepper-capsicum", "cabbage-colored","cucumber-blick")),
    SALAD(List.of("cucumber-vegetable1","vegetable2"));

    private final List<String> recipe;

    public List<String> getRecipe() {
        return recipe;
    }

    Recipe(List<String> recipe) {
        this.recipe = recipe;
    }
}
