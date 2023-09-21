package web.models;

public class Car {
    private String name;
    private String model;
    private int years;

    public Car(String name, String model, int years) {
        this.name = name;
        this.model = model;
        this.years = years;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }
}
