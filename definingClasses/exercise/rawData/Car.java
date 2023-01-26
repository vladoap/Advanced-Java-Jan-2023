package definingClasses.exercise.rawData;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class Car {

     private String model;
     private Engine engine;
     private Cargo cargo;
     private List<Tyre> tires;


     public Car(String model, int engineSpeed, int enginePower, int cargoWeight,
                String cargoType, double tire1Pressure, int tire1Age, double tire2Pressure,
                int tire2Age, double tire3Pressure, int tire3Age, double tire4Pressure, int tire4Age) {
          this.model = model;
          this.engine = new Engine(engineSpeed, enginePower);
          this.cargo = new Cargo(cargoWeight, cargoType);
          tires = new ArrayList<>();
          tires.add(new Tyre(tire1Pressure, tire1Age));
          tires.add(new Tyre(tire2Pressure, tire2Age));
          tires.add(new Tyre(tire3Pressure, tire3Age));
          tires.add(new Tyre(tire4Pressure, tire4Age));

     }

     public boolean isFragile() {
          return tires.stream().mapToDouble(tire -> tire.getTirePressure()).anyMatch(pressure -> pressure < 1);
     }

     public String getCargoType () {
          return cargo.getCargoType();
     }

     public int getEnginePower () {
          return engine.getEnginePower();
     }

     @Override
     public String toString() {
          return this.model;
     }
}
