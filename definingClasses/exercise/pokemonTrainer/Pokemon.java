package definingClasses.exercise.pokemonTrainer;

 class Pokemon {

  private String name;
  private String element;
  private int health;


  public Pokemon(String pokemonName, String pokemonElement, int pokemonHealth) {
     this.name = pokemonName;
     this.element = pokemonElement;
     this.health = pokemonHealth;
  }

  public String getElement () {
      return element;
  }

     public void reduceHealth() {
         health -= 10;
     }

     public int getHealth() {
         return health;
     }
 }
