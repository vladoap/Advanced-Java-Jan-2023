package definingClasses.exercise.pokemonTrainer;

import java.util.ArrayList;
import java.util.List;

class Trainer {

  private String name;
  private int numberOfBadges;
  private List<Pokemon> pokemons;

  public Trainer(String trainerName) {
    this.name = trainerName;
    this.numberOfBadges = 0;
    pokemons = new ArrayList<>();
  }


  public String getName() {
    return name;
  }

  public List<Pokemon> getPokemons() {
    return pokemons;
  }

  public int getCountPokemons () {
    return pokemons.size();
  }

  public int getNumberOfBadges () {
    return numberOfBadges;
  }

  public void checkElement(String element) {
    boolean hasElement = pokemons.stream().anyMatch(pokemon -> pokemon.getElement().equals(element));

    if (hasElement) {
      numberOfBadges++;
    } else {
      pokemons.forEach(pokemon -> pokemon.reduceHealth());
      pokemons.removeIf(pokemon -> pokemon.getHealth() <= 0);
    }
  }

  @Override
  public String toString() {
    return String.format("%s %d %d", name, numberOfBadges, pokemons.size());
  }
}
