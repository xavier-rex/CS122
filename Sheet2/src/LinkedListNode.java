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

    public LinkedListNode insert(LinkedListNode head, int value)
    {
        LinkedListNode n = head;
        LinkedListNode node = new LinkedListNode(value, null);

        while (n.next != null)
        {
            n = n.next;
        }
        n.next = node;
        return head;
    }
}
