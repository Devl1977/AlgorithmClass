
public interface SetInterface<T>
    {
        int getCurrentSize();

        boolean isEmpty();

        boolean add(T newEntry);

        boolean remove(T anEntry);

        void clear();

        boolean contains(T anEntry);

        T[] toArray();
    }
