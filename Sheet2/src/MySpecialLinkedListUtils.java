public class MySpecialLinkedListUtils
{
    static LinkedListNode ans;     // Used in insertion sort and ans push functions

    public static double[] summary(LinkedListNode head)
    {
        double[] ans = new double[5];
        double sum = 0, average, median, max = -Double.MIN_VALUE, min = Double.MAX_VALUE;
        // Counter to calculate the no of nodes
        int counter = 1;
        while(head.getNext() != null) {

            sum += head.getValue();
            counter++;

            if (head.getValue() > max)
            {
                max = head.getValue();
            }
            if (head.getValue() < min)
            {
                min = head.getValue();
            }
            head = head.getNext();
        }

        if (head.getValue() > max)
        {
            max = head.getValue();
        }
        if (head.getValue() < min)
        {
            min = head.getValue();
        }

        sum += head.getValue();
        average = sum / counter;

        // One step pointer moves one node at a time while the other moves two nodes to reach the end
        LinkedListNode oneStepPtr = head;
        LinkedListNode twoStepPtr = head;
        while(twoStepPtr.next != null)
        {
            twoStepPtr = twoStepPtr.next.next;
            oneStepPtr = oneStepPtr.next;
        }
        median = oneStepPtr.value;

        ans[0] = sum;
        ans[1] = average;
        ans[2] = median;
        ans[3] = max;
        ans[4] = min;

        return ans;
    }

    public static LinkedListNode reverse(LinkedListNode head)
    {
        LinkedListNode prev = null;
        LinkedListNode current = head;
        LinkedListNode next;

        while(current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }

    public static boolean palindrome(LinkedListNode head)
    {
        LinkedListNode reverse = reverse(head);

        while (head != null)
        {
            if (head.value != reverse.value)
            {
                return false;
            }
            else
            {
                head = head.next;
                reverse = reverse.next;
            }
        }
        return true;
    }

    public static LinkedListNode evenIndexedElements (LinkedListNode head)
    {
        LinkedListNode n = head;
        int counter = 0;
        while (n.next != null)
        {
            counter++;
            n = n.next;
        }
        n = head;
        if (counter % 2 == 0)
        {
            while (n.next != null)
            {
                n.next = n.next.next;
                n = n.next;
            }
        }
        else
        {
            while (n.next != null && n.next.next != null)
            {
                n.next = n.next.next;
                n = n.next;
            }
            if (n.next.next == null)
            {
                n.next = null;
            }
        }
        return head;
    }

    public static LinkedListNode removeCentralNode (LinkedListNode head)
    {
        LinkedListNode n = head;
        int counter = 0;

        for (; n.next != null; counter++)
        {
            n = n.next;
        }

        n = head;
        int center = counter / 2 - 1;

        for (int i = 0; i < center; i++)
        {
            n = n.next;
        }
        n.next = n.next.next;

        return head;
    }

    public static void show (LinkedListNode head)
    {
        LinkedListNode n = head;
        while (n.next != null)
        {
            System.out.println(n.value);
            n = n.next;
        }
        System.out.println(n.value);
    }

    public static void ansPush(LinkedListNode n)
    {
        if (ans == null || n.value <= ans.value)
        {
            n.next = ans;
            ans = n;
        }
        else
        {
            LinkedListNode current = ans;

            while (current.next != null && current.next.value < n.value)
            {
                current = current.next;
            }
            n.next = current.next;
            current.next = n;
        }
    }

    public static LinkedListNode insertionSort (LinkedListNode head)
    {
        LinkedListNode current = head;

        while (current != null)
        {
            LinkedListNode next = current.next;
            ansPush(current);
            current = next;
        }
        return ans;
    }

    public static LinkedListNode findMid(LinkedListNode head)
    {
        if (head == null)
        {
            return head;
        }
        LinkedListNode twoStepPtr = head.next;
        LinkedListNode oneStepPtr = head;

        while (twoStepPtr != null)
        {
            twoStepPtr = twoStepPtr.next;
            if (twoStepPtr != null)
            {
                oneStepPtr = oneStepPtr.next;
                twoStepPtr = twoStepPtr.next;
            }
        }
        return oneStepPtr;
    }

    public static LinkedListNode sortMerge(LinkedListNode l, LinkedListNode r)
    {
        LinkedListNode ans = null;
        if (l == null)
        {
            return r;
        }
        if (r == null)
        {
            return l;
        }

        if (l.value <= r.value)
        {
            ans = l;
            ans.next = sortMerge(l.next, r);
        }
        else
        {
            ans = r;
            ans.next = sortMerge(l, r.next);
        }
        return ans;
    }

    public static LinkedListNode mergeSort(LinkedListNode head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }

        LinkedListNode mid = findMid(head);
        LinkedListNode midNext = mid.next;
        mid.next = null;
        LinkedListNode l = mergeSort(head);
        LinkedListNode r = mergeSort(midNext);
        LinkedListNode ans = sortMerge(l, r);
        return ans;
    }
    
    public static void main(String[] args)
    {

    }
}
