package definingClasses.exercise.carSalesman;

 class Car {

     private String model;
     private Engine engine;
     private int weight;
     private String color;

     public Car (String model, Engine engine, int weight, String color) {
         this.model = model;
         this.engine = engine;
         this.weight = weight;
         this.color = color;
     }

     public Car (String model, Engine engine, int weight) {
         this (model, engine, weight, "n/a");
     }

     public Car (String model, Engine engine, String color) {
         this (model, engine, -1, color);
     }

     public Car (String model, Engine engine) {
         this (model, engine, -1, "n/a");
     }

     @Override
     public String toString() {
         StringBuilder sb = new StringBuilder();
         sb
                 .append(model + ":")
                 .append(System.lineSeparator())
                 .append(engine.getModel() + ":")
                 .append(System.lineSeparator())
                 .append("Power: ")
                 .append(engine.getPower())
                 .append(System.lineSeparator())
                 .append("Displacement: ");

         if (engine.getDisplacement() == - 1) {
             sb.append("n/a");
         } else {
             sb.append(engine.getDisplacement());
         }
         sb
                 .append(System.lineSeparator())
                 .append("Efficiency: ")
                 .append(engine.getEfficiency())
                 .append(System.lineSeparator())
                 .append("Weight: ");

         if (weight == - 1) {
             sb.append("n/a");
         } else {
             sb.append(weight);
         }
         sb
                 .append(System.lineSeparator())
                 .append("Color: ")
                 .append(color);

         return sb.toString();
     }
 }
