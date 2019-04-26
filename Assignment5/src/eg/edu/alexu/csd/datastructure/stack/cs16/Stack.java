package eg.edu.alexu.csd.datastructure.stack.cs16;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Stack implements IStack {

    public Node top;
    private int size = 0;

    /**
     * Removes the element at the top of stack and returns that element.
     *
     * @return top of stack element, or through exception if empty
     */
    public Object pop() {
        if (top != null) {

            Object element = top.getValue();
            top = top.getNext();
            size--;
            return element;
        }
        return null;
    }

    /**
     * Get the element at the top of stack without removing it from stack.
     *
     * @return top of stack element, or through exception if empty
     */
    public Object peek() {

        if (top != null) {

            return top.getValue();
        }
        return null;
    }

    /**
     * Pushes an item onto the top of this stack.
     *
     * @param element to insert
     */
    public void push(Object element) {

        Node n = new Node(element, top);
        top = n;
        size++;
    }

    /**
     * Tests if this stack is empty
     *
     * @return true if stack empty
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Returns the number of elements in the stack.
     *
     * @return number of elements in the stack
     */
    public int size() {
        return size;
    }

    public static void main(String[] args) {

        int action = 0;
        Scanner input = new Scanner(System.in);
        Stack stack = new Stack();

        while (action != 6) {

            System.out.println("Test the stack using the following commands:");
            System.out.println("--------------------------------------------");
            System.out.println("1: Push");
            System.out.println("2: Pop");
            System.out.println("3: Peak");
            System.out.println("4: Get size");
            System.out.println("5: Check if empty");
            System.out.println("6: Exit");

            try {

                action = input.nextInt();
            } catch (InputMismatchException e) {

                System.out.println("Enter valid number!!");
                input.next();
            }

            if (action == 1) {

                System.out.print("Enter the object to be pushed: ");
                Object tmp = input.next();
                stack.push(tmp);
            } else if (action == 2) {

                System.out.println(stack.pop());
            } else if (action == 3) {

                System.out.println(stack.peek());
            } else if (action == 4) {

                System.out.println(stack.size());
            } else if (action == 5) {

                System.out.println(stack.isEmpty());
            }
        }
    }
}
