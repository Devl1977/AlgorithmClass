
public class Node <T> {

    T data;

    Node<T> next;


    public Node() {
        next = null;
    }
    
    public Node(T data) {
        this.data = data;

        this.next = null;
    }
}