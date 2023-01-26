package definingClasses.exercise.speedRacing;

class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostPer1Km;
    private int distanceTraveled;

    public Car(String model, double fuelAmount, double fuelCostPer1Km) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPer1Km = fuelCostPer1Km;
        this.distanceTraveled = 0;
    }

    public String getModel() {
        return model;
    }

    public boolean isFuelEnough (double distance) {
        return distance * fuelCostPer1Km <= fuelAmount;
    }

    public void drive(double distance) {
          if (isFuelEnough(distance)) {
              distanceTraveled += distance;
              fuelAmount -= distance * fuelCostPer1Km;
          } else {
              System.out.println("Insufficient fuel for the drive");
          }
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", model, fuelAmount, distanceTraveled);
    }
}

