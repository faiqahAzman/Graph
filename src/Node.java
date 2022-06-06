

public class Node<E> {
    E element;
    Node<E> next;


    public Node(){}

    public Node(E element) {
        this.element = element;

    }

    @Override
    public String toString() {
        return "Node{" +
                "element=" + element +
                ", " + next +
                '}';
    }
}
