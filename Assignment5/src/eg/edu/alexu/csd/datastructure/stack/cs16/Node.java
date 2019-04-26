package eg.edu.alexu.csd.datastructure.stack.cs16;

public class Node {

    private Object value;
    private Node next;

    public Node() {

    }

    public Node(Object value, Node next) {

        this.value = value;
        this.next = next;
    }

    public Object getValue() {
        return value;
    }
    public Node getNext() {
        return next;
    }
    public void setValue(Object newValue) {
        value = newValue;
    }
    public void setNext(Node newNext) {
        next = newNext;
    }
}
