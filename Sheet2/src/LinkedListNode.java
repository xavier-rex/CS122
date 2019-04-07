public class LinkedListNode
{
    int value;
    LinkedListNode next;

    LinkedListNode()
    {

    }
    LinkedListNode(int value, LinkedListNode next)
    {
        this.value = value;
        this.next = next;
    }

    public int getValue()
    {
        return value;
    }

    public LinkedListNode getNext()
    {
        return next;
    }
}
