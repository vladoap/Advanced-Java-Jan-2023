package examPreparation.christmas;


import java.util.*;

public class Bag {

    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;

    }

    public String getColor() {
        return color;
    }

    public int count() {
        return data.size();
    }

    public void add(Present present) {
        data.add(present);
    }

    public boolean remove(String name) {
        Present presentToRemove = data.stream().filter(pr -> pr.getName().equals(name)).findFirst().orElse(null);
        if (presentToRemove != null) {
            data.remove(presentToRemove);
            return true;
        }
        return false;
    }

    public Present heaviestPresent() {
        return data.stream().max(Comparator.comparingDouble(Present::getWeight)).get();
    }

    public Present getPresent(String name) {
        return data.stream().filter(pr -> pr.getName().equals(name)).findFirst().get();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s bag contains:", getColor()));
        for (Present present : data) {
            sb.append(System.lineSeparator())
                    .append(present.toString());
        }
        return sb.toString().trim();

    }
}
