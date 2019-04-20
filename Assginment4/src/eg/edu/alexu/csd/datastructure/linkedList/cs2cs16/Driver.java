package eg.edu.alexu.csd.datastructure.linkedList.cs2cs16;

public class Driver {

    public static void show(DLinkedList s) {

        DLinkedListNode n = s.head;
        while (n != null)
        {
            System.out.println(n.value);
            n = n.next;
        }
    }

    public static void main(String[] args) {

        DLinkedList test = new DLinkedList();

        test.add(27);
        test.add("Sayed is here");
        test.add('S');
        test.add("Abo Bakr");
        test.add(true);

        test.add(10, "S");

        show(test);

    }
}
