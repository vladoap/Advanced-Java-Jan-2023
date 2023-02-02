package generics.lab.genericScale;

public class Main {
    public static void main(String[] args) {


        Scale<String> stringScale = new Scale<>("a", "c");
        System.out.println(stringScale.getHeavier());

        Scale<Integer> integerScale = new Scale<>(15, 100);
        System.out.println(integerScale.getHeavier());


    }
}
