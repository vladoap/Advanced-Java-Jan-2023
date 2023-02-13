package iteratorsAndComparators.stackIterator;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Stack;

public class customStack implements Iterable<Integer> {

    private ArrayDeque<Integer> stack;

    private class stackIterator implements Iterator<Integer> {

        @Override
        public boolean hasNext() {
            return stack.size() > 0;
        }

        @Override
        public Integer next() {
            if (hasNext()) {
                int currentElement = stack.pop();
                return currentElement;
            }
            return stack.peek();

        }
    }

    public customStack(int...elements) {
        stack = new ArrayDeque<>();
        for (int element : elements) {
            stack.push(element);
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
        } else {
            System.out.println("No elements");
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new stackIterator();
    }
}
