public class MySpecialLinkedListUtils
{
    public static double[] summary(LinkedListNode head)
    {
        double[] ans = new double[5];
        double sum = 0, average, median, max = -Double.MIN_VALUE, min = Double.MAX_VALUE;
        int counter = 1;

        LinkedListNode OneStepPtr = head;
        LinkedListNode TwoStepPtr = head;
        while(head.getNext() != null)
        {
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

        while(TwoStepPtr.next != null)
        {
            TwoStepPtr = TwoStepPtr.next.next;
            OneStepPtr = OneStepPtr.next;
        }
        median = OneStepPtr.value;

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
        LinkedListNode node = head;
        LinkedListNode reverse = reverse(head);

        while(node.next != null)
        {
            if(node.value != reverse.value)
            {
                return false;
            }
            node = node.next;
            reverse = reverse.next;
        }

        return true;
    }
}
