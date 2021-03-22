package com.vadzimvincho.cook.model.vegetable;

public class Pepper extends Vegetable{

    private String genus;
    private String pepperColor;

    public Pepper() {
    }

    public Pepper(String name, String genus, String pepperColor, int calories, int weight) {
        super(name, calories, weight);
        this.genus = genus;
        this.pepperColor = pepperColor;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    public String getPepperColor() {
        return pepperColor;
    }

    public void setPepperColor(String pepperColor) {
        this.pepperColor = pepperColor;
    }

    @Override
    public String toString() {
        return "Pepper{} " + super.toString();
    }
}
