package generics.lab.jarOfT;



public class Main {
    public static void main(String[] args) {

        Jar<String> stringJar = new Jar<>();

        stringJar.add("Gosho");
        stringJar.add("Pesho");

        Jar<Integer> numbers = new Jar<>();

        numbers.add(13);

    }
}
