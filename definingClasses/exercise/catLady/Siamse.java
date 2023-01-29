package definingClasses.exercise.catLady;

 class Siamse extends Cat{

  private double earSize;

  public Siamse(String name, double earSize) {
   super(name);
   this.earSize = earSize;
  }

  @Override
  public String toString() {
   return String.format("Siamese %s %.2f", getName(), earSize);
  }
 }
