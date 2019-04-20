package eg.edu.alexu.csd.datastructure.linkedList.cs2cs16;

public class DLinkedList implements ILinkedList{

    DLinkedListNode head;
    DLinkedListNode tail;

    public void add(int index, Object element) {

        DLinkedListNode node = new DLinkedListNode(element);
        if (index == 0) {

            if (head == null) {

                node.next = tail;
                tail.prev = node;
                head = node;
            }
            else {

                node.next = head;
                head.prev = node;
                head = node;
            }
        }
        else if (index > size() - 1 || index < 0) {

            return;
        }
        else {

            DLinkedListNode n = head;
            for (int i = 0; i < index - 1; i++) {
                n = n.next;
            }
            node.next = n.next;
            n.next = node;
            node.prev = n;
            node.next.prev = node;
        }
    }

    public void add(Object element) {

        DLinkedListNode node = new DLinkedListNode(element);
        if (head == null) {

            head = node;
        }
        else {
            if (tail == null) {

                tail = node;
                tail.prev = head;
                head.next = tail;
            }
            else {

                tail.next = node;
                node.prev = tail;
                tail = node;
            }
        }
    }

    public Object get(int index) {

        if (index > size() - 1 || index < 0) {

            return null;
        }
        DLinkedListNode n = head;
        for (int i = 0; i < index; i++) {

            n = n.next;
        }
        return n.value;
    }

    public void set(int index, Object element) {

        if (index < 0 || index > size() - 1) {

            return;
        }
        DLinkedListNode n = head;
        for (int i = 0; i < index; i++) {

            n=n.next;
        }
        n.value = element;
    }

    public void clear() {

        head = null;
        tail = null;
    }

    public boolean isEmpty() {

        return head == null;
    }

    public void remove(int index) {

        if (index < 0 || index > size() - 1) {

            return;
        }
        DLinkedListNode n = head;
        for(int i = 0; i < index - 1; i++) {

            n = n.next;
        }
        n.next = n.next.next;
        n.next.prev = n;
    }

    public int size() {

        DLinkedListNode n = head;
        int size = 0;
        while (n != null) {

            size++;
            n = n.next ;
        }
        return size;
    }

    public DLinkedList sublist(int fromIndex, int toIndex) {

        if (fromIndex < 0) {

            fromIndex = 0;
        }
        if (toIndex > size() - 1) {

            toIndex = size() - 1;
        }

        DLinkedList ans = new DLinkedList();
        DLinkedListNode n = head;
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

        DLinkedListNode n = head;
        while (n != null) {

            if(n.value == o) {
                return true;
            }
            n = n.next;
        }
        return false;
    }
}
