public class SetUsingLinkedList<T> implements SetInterface<T> {
    
    Node <T> firstNode;

    int numberOfEntries;

    public SetUsingLinkedList() {

        firstNode = null;
        numberOfEntries = 0;

    }

    @Override
    public int getCurrentSize() {

        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return firstNode == null;
    }

    @Override
    public boolean add(T newEntry) {
        if(!contains(newEntry)) {
        Node<T> newNode = new Node<T>(newEntry);
        newNode.next = firstNode;
        firstNode = newNode;
        numberOfEntries++;
        return true;

        }
        return false;
    }

    @Override
    public boolean remove(T anEntry) {
        Node<T> currentNode = firstNode;
        Node<T> previousNode = null;

        while (currentNode !=null) {
            if(currentNode.data.equals(anEntry)) {
                if(previousNode == null) {
                    firstNode = currentNode.next;
                } else {
                    previousNode.next = currentNode.next;
                }
                numberOfEntries--;
                return true;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        return false;
    }

    @Override
    public void clear() {
        firstNode = null;
        numberOfEntries = 0;
    }

    @Override
    public boolean contains(T anEntry) {
        Node<T> currentNode = firstNode;
        while(currentNode != null) {
            if(currentNode.data.equals(anEntry)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    @Override

    @SuppressWarnings("unchecked")
    public T[] toArray() {

        T[] result = (T[]) new Object[numberOfEntries];
        int index = 0;
        Node<T> currentNode = firstNode;
        while (currentNode != null) {
            result[index++] = currentNode.data;
            currentNode = currentNode.next;
        }
        return result;

    }

}