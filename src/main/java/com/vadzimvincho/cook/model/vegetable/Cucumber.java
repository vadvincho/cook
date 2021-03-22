package com.vadzimvincho.cook.model.vegetable;

public class Cucumber extends Vegetable {

    private String thornsColor; // white, black
    private String shirt;

    public Cucumber() {
    }

    public Cucumber(String name, String thornsColor, String shirt, int calories, int weight) {
        super(name, calories, weight);
        this.thornsColor = thornsColor;
        this.shirt = shirt;
    }

    public String getThornsColor() {
        return thornsColor;
    }

    public void setThornsColor(String thornsColor) {
        this.thornsColor = thornsColor;
    }

    public String getShirt() {
        return shirt;
    }

    public void setShirt(String shirt) {
        this.shirt = shirt;
    }

    @Override
    public String toString() {
        return "Cucumber{} " + super.toString();
    }
}
