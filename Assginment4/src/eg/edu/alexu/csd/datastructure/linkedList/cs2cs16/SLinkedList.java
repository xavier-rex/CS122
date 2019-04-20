package eg.edu.alexu.csd.datastructure.linkedList.cs2cs16;

public class SLinkedList implements ILinkedList {

    SLinkedListNode head;

    public void add(int index, Object element) {

        SLinkedListNode node = new SLinkedListNode(element);
        if (index == 0) {

            node.next = head;
            head = node;
        }
        else if (index > size() - 1 || index < 0) {

            return;
        }
        else {

            SLinkedListNode n = head;

            for(int i = 0; i < index - 1; i++) {

                n = n.next;
            }
            node.next = n.next;
            n.next = node;
        }
    }

    public void add(Object element) {

        SLinkedListNode node = new SLinkedListNode(element);
        if (head == null){

            head = node;
        }
        else {

            SLinkedListNode n = head;
            while (n.next != null)
            {
                n = n.next;
            }
            n.next = node;
        }
    }

    public Object get(int index) {

        if (index > size() - 1 || index < 0) {

            return null;
        }
        SLinkedListNode n = head;
        for(int i = 0; i < index; i++) {

            n = n.next;
        }
        return n.value;
    }

    public void set(int index, Object element) {

        if (index < 0 || index > size() - 1) {

            return;
        }
        SLinkedListNode n = head;
        for(int i = 0; i < index; i++) {

            n = n.next;
        }
        n.value = element;
    }

    public void clear() {

        head = null;
    }

    public boolean isEmpty() {

        return head == null;
    }

    public void remove(int index) {

        if (index < 0 || index > size() - 1) {

            return;
        }
        SLinkedListNode n = head;
        for(int i = 0; i < index - 1; i++) {

            n = n.next;
        }
        n.next = n.next.next;
    }

    public int size() {

        SLinkedListNode n = head;
        int size = 0;
        while (n != null) {

            size++;
            n = n.next ;
        }
        return size;
    }

    public SLinkedList sublist(int fromIndex, int toIndex) {

        if (fromIndex < 0) {

            fromIndex = 0;
        }
        if (toIndex > size() - 1) {

            toIndex = size() - 1;
        }

        SLinkedList ans = new SLinkedList();
        SLinkedListNode n = head;
        int counter = toIndex - fromIndex + 1;
        while (fromIndex != 0) {

            n = n.next;
            fromIndex--;
        }
        while (counter != 0) {

            ans.add(n.value);
            n = n.next;
            counter--;
        }
        return ans;
    }

    public boolean contains(Object o) {

        SLinkedListNode n = head;
        while (n != null) {

            if(n.value == o) {
                return true;
            }
            n = n.next;
        }
        return false;
    }
}
