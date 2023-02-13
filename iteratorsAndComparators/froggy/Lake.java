package iteratorsAndComparators.froggy;

import java.util.Arrays;
import java.util.Iterator;

public class Lake implements Iterable<Integer> {

    private int[] numbers;
    private int index;

    private class Frog implements Iterator<Integer> {
        int startIndex = 0;
        boolean hasEndEvens = false;
        @Override
        public boolean hasNext() {
            return index < numbers.length;
        }

        @Override
        public Integer next() {
            if (startIndex >= numbers.length && !hasEndEvens) {
               hasEndEvens = true;
               startIndex = 1;
            }

            int currentNum = numbers[startIndex];
            startIndex += 2;
            index++;
            return currentNum;
        }
    }

    public Lake(int...numbers) {
        this.numbers = numbers;
        index = 0;
    }


    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }
}
