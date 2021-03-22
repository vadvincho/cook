package com.vadzimvincho.cook.model.salad;

import com.vadzimvincho.cook.model.vegetable.Vegetable;

import java.util.ArrayList;
import java.util.List;

public class Salad {
    private List<Vegetable> vegetables = new ArrayList<>();
    private String name;

    public Salad(String name) {
        this.name = name;
    }

    public List<Vegetable> getVegetables() {
        return vegetables;
    }

    public void setVegetables(List<Vegetable> vegetables) {
        this.vegetables = vegetables;
    }

    public void addVegetable(Vegetable vegetable) {
        vegetables.add(vegetable);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Salad{" +
                "name='" + name + '\'' +
                ", vegetables=" + vegetables +
                '}';
    }
}