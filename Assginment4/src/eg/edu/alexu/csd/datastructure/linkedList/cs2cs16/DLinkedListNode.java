package eg.edu.alexu.csd.datastructure.linkedList.cs2cs16;

public class DLinkedListNode {

    Object value;
    DLinkedListNode next;
    DLinkedListNode prev;

    DLinkedListNode (Object value, DLinkedListNode next, DLinkedListNode prev)
    {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    DLinkedListNode (Object value)
    {
        this.value = value;
    }

    DLinkedListNode ()
    {

    }
}