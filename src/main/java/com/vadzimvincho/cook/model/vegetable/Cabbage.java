package com.vadzimvincho.cook.model.vegetable;

public class Cabbage extends Vegetable {
    private String type;
    private String colorCabbage;

    public Cabbage() {
    }

    public Cabbage(String name, String type, String colorCabbage, int calories, int weight) {
        super(name, calories, weight);
        this.type = type;
        this.colorCabbage = colorCabbage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColorCabbage() {
        return colorCabbage;
    }

    public void setColorCabbage(String colorCabbage) {
        this.colorCabbage = colorCabbage;
    }

    @Override
    public String toString() {
        return "Cabbage{} " + super.toString();
    }
}
