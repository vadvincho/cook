package com.vadzimvincho.cook.model.vegetable;

public abstract class Vegetable {
    private String name;
    private int calories;
    private int weight;

    public Vegetable() {
    }

    public Vegetable(String name, int calories, int weight) {
        this.name = name;
        this.calories = calories;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Vegetable{" +
                "name='" + name +
                "', calories=" + calories +
                ", weight=" + weight +
                '}';
    }
}