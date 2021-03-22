package com.vadzimvincho.cook.model.vegetable;

public class Tomato extends Vegetable {

    private String tomatoColor;
    private String tomatoShape;

    public Tomato() {
    }

    public Tomato(String name, String tomatoColor, String tomatoShape, int calories, int weight) {
        super(name, calories, weight);
        this.tomatoColor = tomatoColor;
        this.tomatoShape = tomatoShape;
    }

    public String getTomatoColor() {
        return tomatoColor;
    }

    public void setTomatoColor(String tomatoColor) {
        this.tomatoColor = tomatoColor;
    }

    public String getTomatoShape() {
        return tomatoShape;
    }

    public void setTomatoShape(String tomatoShape) {
        this.tomatoShape = tomatoShape;
    }

    @Override
    public String toString() {
        return "Tomato{} " + super.toString();
    }
}
