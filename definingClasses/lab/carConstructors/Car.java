package definingClasses.lab.carConstructors;

class Car {

    private String brand;
    private String model;
    private int hp;

    public Car(String brand, String model, int hp) {
        this.brand = brand;
        this.model = model;
        this.hp = hp;
    }

    public Car(String brand) {
        this(brand, "unknown", -1);
    }

    public String carInfo() {
        return String.format("The car is: %s %s - %d HP.", brand, model, hp);
    }
}
