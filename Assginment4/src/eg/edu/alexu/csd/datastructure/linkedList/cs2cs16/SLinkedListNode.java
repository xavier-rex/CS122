package eg.edu.alexu.csd.datastructure.linkedList.cs2cs16;

public class SLinkedListNode {

    Object value;
    SLinkedListNode next;

    SLinkedListNode (Object value, SLinkedListNode next)
    {
        this.value = value;
        this.next = next;
    }

    SLinkedListNode (Object value)
    {
        this.value = value;
    }

    SLinkedListNode ()
    {

    }

}