package iteratorsAndComparators.listIterator;


import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ListyIterator implements Iterable<String>{

   private List<String> elements;
   private int index;




    private class CustomIterator implements Iterator<String> {
       @Override
       public boolean hasNext() {
           return index < elements.size() - 1;
       }

       @Override
       public String next() {
           if (hasNext()) {
               index++;
               return elements.get(index);
           }
           return null;
       }
   }

    public ListyIterator(String...elements) {
        this.elements = List.of(elements);
        this.index = 0;
    }

    public boolean moveIndex() {
       if (iterator().hasNext()) {
           index++;
           return true;
       }
       return false;
    }

    public void print() {
        if (!elements.isEmpty()){
            System.out.println(elements.get(index));
        } else {
            throw new NoSuchElementException("Invalid Operation!");
        }
    }

    public void printAll() {
        String result = String.join(" ", elements);
        System.out.printf("%s%n", result);
    }


    @Override
    public Iterator<String> iterator() {
        return new CustomIterator();
    }
}
