package eg.edu.alexu.csd.datastructure.stack.cs16;

import java.util.Scanner;

public class ExpressionEvaluator implements IExpressionEvaluator {

    /**
     * Takes an operator as input and returns its value in comparison
     * to other operators
     *
     * @param sign the operator
     * @return the value of the operator
     */
    public static int order(char sign) {

        if (sign == '+' || sign == '-') {
            return 0;
        } else if (sign == '*' || sign == '/') {
            return 1;
        }
        return -1;
    }

    /**
     * Takes a stack of operators and sort them
     *
     * @param stack the input stack
     */
    public static void sort(Stack stack) {

        Node n = stack.top;
        while (n != null) {
            if (((char) n.getValue() == '+' || (char) n.getValue() == '-') && n.getNext() != null) {
                if ((char) n.getNext().getValue() == '*' || (char) n.getNext().getValue() == '/') {

                    char tmp = (char) n.getValue();
                    n.setValue(n.getNext().getValue());
                    n.getNext().setValue(tmp);
                }
            }
            n = n.getNext();
        }
    }

    /**
     * Takes a symbolic/numeric infix expression as input and converts it to
     * postfix notation. There is no assumption on spaces between terms or the
     * length of the term (e.g., two digits symbolic or numeric term)
     *
     * @param expression infix expression
     * @return postfix expression
     */
    public String infixToPostfix(String expression) {

        String postfix = "";
        Stack stack = new Stack();
        int len = expression.length(), k = 0;

        while (k != len) {
            if (expression.charAt(k) == ' ') {

                k++;
                continue;
            } else if (expression.charAt(k) == '*' || expression.charAt(k) == '/' ||
                    expression.charAt(k) == '+' || expression.charAt(k) == '-' ||
                    expression.charAt(k) == '(') {
                if (!stack.isEmpty() && expression.charAt(k) != '(') {

                    sort(stack);
                    while (!stack.isEmpty() && order((char) stack.peek()) >= order(expression.charAt(k))) {

                        postfix += stack.pop() + " ";
                    }
                    stack.push(expression.charAt(k));
                } else {

                    stack.push(expression.charAt(k));
                }
            } else if (expression.charAt(k) == ')') {

                sort(stack);
                while (!stack.isEmpty() && (char) stack.peek() != '(') {

                    postfix += stack.pop() + " ";
                }
                if (stack.isEmpty()) {

                    System.out.println("Invalid expression");
                } else {

                    stack.pop();
                }
            } else {

                if (Character.isDigit(expression.charAt(k))) {

                    int j = k;
                    while (j != len && Character.isDigit(expression.charAt(j))) {
                        j++;
                    }
                    j--;
                    postfix += expression.substring(k, j + 1) + " ";
                    k = j;
                } else {

                    postfix += expression.charAt(k) + " ";
                }
            }
            k++;
        }

        while (!stack.isEmpty()) {

            if ((char) stack.peek() == ')') {

                stack.pop();
                continue;
            }
            postfix += stack.pop() + " ";
        }
        return postfix;
    }

    /**
     * Evaluate a postfix numeric expression, with a single space separator
     *
     * @param expression postfix expression
     * @return the expression evaluated value
     */
    public int evaluate(String expression) {

        Stack stack = new Stack();
        Float result = 0.0f, a, b;
        int len = expression.length(), k = 0;
        while (k != len) {
            if (expression.charAt(k) == ' ') {
                k++;
                continue;
            } else if (expression.charAt(k) == '*') {

                b = (Float) stack.pop();
                a = (Float) stack.pop();
                result = b * a;
                stack.push(result);
            } else if (expression.charAt(k) == '/') {

                b = (Float) stack.pop();
                a = (Float) stack.pop();
                result = b / a;
                stack.push(result);
            } else if (expression.charAt(k) == '+') {

                b = (Float) stack.pop();
                a = (Float) stack.pop();
                result = b + a;
                stack.push(result);
            } else if (expression.charAt(k) == '-') {

                b = (Float) stack.pop();
                a = (Float) stack.pop();
                result = b - a;
                stack.push(result);
            } else if (!Character.isDigit(expression.charAt(k))) {

                System.out.println(expression.charAt(k) + " is not a number!!");
            } else {
                if (Character.isDigit(expression.charAt(k))) {
                    int j = k;
                    while (j != len && Character.isDigit(expression.charAt(j))) {

                        j++;
                    }
                    stack.push(Float.valueOf(expression.substring(k, j)));
                    k = j - 1;
                } else {

                    stack.push(Float.valueOf((Character.toString(expression.charAt(k)))));
                }
            }
            k++;
        }
        return Math.round(result);
    }

    public static void main(String[] args) {

        ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Enter the infix: use only */+-() and numbers or variables");
        String infix = input.next();
        String postfix = expressionEvaluator.infixToPostfix(infix);
        System.out.println(postfix);
        System.out.println(expressionEvaluator.evaluate(postfix));
    }
}
