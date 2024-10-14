import java.util.Arrays;

public class SetUsingArray<T> implements SetInterface<T> {

    T[] myArray;
    int numberOfEntries;
    final int capacity = 7;

    @SuppressWarnings("unchecked")

    public SetUsingArray() {

        myArray = (T[]) new Object[capacity];

        numberOfEntries = 0;
        
    }

    @Override
    public int getCurrentSize() {

        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public boolean add(T newEntry) {
        if(!contains(newEntry)) {
            if(numberOfEntries == myArray.length) {
                myArray = Arrays.copyOf(myArray, 2 * myArray.length);
            }
            myArray[numberOfEntries++] = newEntry;
            return true;
        }

        return false;
    }

    @Override
    public boolean remove(T anEntry) {
        for (int i = 0; i < numberOfEntries; i++) {
            if(myArray[i].equals(anEntry)) {
                myArray[i] = myArray[numberOfEntries - 1];
                myArray[numberOfEntries - 1] = null;

                numberOfEntries--;

                return true;
            }
        }

        return false;
    }

    @Override
    public void clear() {
        while(!isEmpty()) {
            remove(myArray[0]);

        }
        
    }


    @Override
    public boolean contains(T anEntry) {
        for (int i = 0; i < numberOfEntries; i++) {
            if(myArray[i].equals(anEntry)) {
                return true;
            }
        }

        return false;
    }
    
    @Override
    public T[] toArray() {
        return Arrays.copyOf(myArray, numberOfEntries);
    }

}
