package eg.edu.alexu.csd.datastructure.linkedList.cs2cs16;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Program to solve polynomial equations.
 */
public class PolynomialSolver implements IPolynomialSolver {

    /**
     * Linked lists to store the polynomials
     * and R is the result.
     */
    private DLinkedList A = new DLinkedList();
    private DLinkedList B = new DLinkedList();
    private DLinkedList C = new DLinkedList();
    private DLinkedList R = new DLinkedList();

    /**
     * The delimiter is used to end the input only if the user
     * entered new line.
     * Action variable used to determine which command to start.
     */
    private static Scanner input = new Scanner(System.in).useDelimiter("\n");
    private static int action = 0;

    /**
     * Method to sort the array in descending order.
     * @param arr The input array
     */
    private void sort(int[][] arr) {
        int n = arr.length;
        for (int i = n - 2; i >= 0; i--) {

            int keyCoef = arr[i][0];
            int keyExp = arr[i][1];

            int j = i + 1;

            while (j < n && arr[j][1] > keyExp) {

                arr[j - 1][0] = arr[j][0];
                arr[j - 1][1] = arr[j][1];
                j = j + 1;
            }
            arr[j - 1][0] = keyCoef;
            arr[j - 1][1] = keyExp;
        }
    }

    /**
     * @param poly The chosen polynomial character
     * @return the chosen polynomial linked list
     */
    private DLinkedList choose(char poly) {

        DLinkedList n = new DLinkedList();
        if (poly == 'A') {

            n = A;
        } else if (poly == 'B') {

            n = B;
        } else if (poly == 'C') {

            n = C;
        } else if (poly == 'R') {

            n = R;
        }
        return n;
    }

    /**
     * @param list the linked list to be converted to array
     * @return an array after converted from linked list
     */
    private int[][] listtoArr(DLinkedList list) {

        DLinkedListNode n = list.head;
        int[][] ans = new int[list.size()][2];
        int[] tmp;
        int i = 0;

        while (n != null) {

            tmp = (int[]) n.value;
            ans[i][0] = tmp[0];
            ans[i][1] = tmp[1];
            n = n.next;
            i++;
        }
        return ans;
    }

    /**
     * Method to remove the redundant element from array.
     * @param arr the input array
     * @param index the index of the unwanted element
     * @return an array without the unwanted element
     */
    private int[][] removeElement(int[][] arr, int index) {

        int[][] anotherArray = new int[arr.length - 1][2];
        for (int i = 0; i < index; i++) {

            System.arraycopy(arr[i], 0, anotherArray[i], 0, 2);
        }
        for (int i = index + 1; i < arr.length; i++) {

            System.arraycopy(arr[i], 0, anotherArray[i - 1], 0, 2);
        }
        return anotherArray;
    }

    /**
     * @return the input char after being checked
     */
    private char checkInput() {

        char variableName;
        do {

            System.out.println("Insert the variable name: A, B, C or R");
            variableName = input.next().charAt(0);
        } while (variableName != 'A' && variableName != 'B'
                && variableName != 'C' && variableName != 'R');

        if (action > 1 && action < 7) {
            while (choose(variableName).isEmpty() || (variableName != 'A'
                    && variableName != 'B' && variableName != 'C' && variableName != 'R')) {
                System.out.println("Variable not set");
                System.out.println("Insert the variable name: A, B, C or R");
                variableName = input.next().charAt(0);
            }
        }
        return variableName;
    }

    /**
     * Set polynomial terms (coefficients & exponents).
     * @param poly  name of the polynomial
     * @param terms array of [coefficients][exponents]
     */
    public void setPolynomial(char poly, int[][] terms) {

        DLinkedList n = choose(poly);
        for (int[] term : terms) {

            n.add(term);
        }
    }

    /**
     * Print the polynomial in ordered human readable representation.
     * @param poly name of the polynomial
     * @return polynomial in the form like 27x^2+x-1
     */
    public String print(char poly) {

        DLinkedListNode n = choose(poly).head;
        String ans = "";
        int[] tmp = (int[]) n.value;

        if (tmp[0] != 0) {

            if (tmp[1] == 0) {

                ans = ans + tmp[0];
            } else {

                if (tmp[0] == 1 && tmp[1] == 1) {

                    ans = ans + 'x';
                } else if (tmp[0] == -1 && tmp[1] == 1) {

                    ans = ans + "-x";
                } else if (tmp[0] == 1) {

                    ans = ans + "x^" + tmp[1];
                } else if (tmp[0] == -1) {

                    ans = ans + "-x^" + tmp[1];
                } else {

                    ans = ans + tmp[0] + "x^" + tmp[1];
                }
            }
        }

        n = n.next;
        while (n != null) {

            tmp = (int[]) n.value;
            if (tmp[0] < 0) {

                ans = ans + " - ";
                tmp[0] = -tmp[0];
            } else {

                ans = ans + " + ";
            }

            if (tmp[0] == 0) {

            } else if (tmp[0] == 1 && tmp[1] == 0) {

                ans = ans + '1';
            } else {

                if (tmp[0] == 1 && tmp[1] == 1) {

                    ans = ans + 'x';
                } else if (tmp[1] == 1) {

                    ans = ans + tmp[0] + 'x';
                } else if (tmp[1] == 0) {

                    ans = ans + tmp[0];
                } else {

                    ans = ans + tmp[0] + "x^" + tmp[1];
                }
            }
            n = n.next;
        }
        return ans;
    }

    /**
     * Clear the polynomial.
     * @param poly name of the polynomial
     */
    public void clearPolynomial(char poly) {

        DLinkedList n = choose(poly);
        n.clear();
    }

    /**
     * Evaluate the polynomial.
     * @param poly  name of the polynomial
     * @param value polynomial constant value
     * @return the value of the polynomial
     */
    public float evaluatePolynomial(char poly, float value) {

        DLinkedListNode n = choose(poly).head;
        float sum = 0;
        int[] tmp;
        while (n != null) {

            tmp = (int[]) n.value;
            if (tmp[0] == 0) {

                continue;
            } else {

                sum += (tmp[0] * Math.pow(value, tmp[1]));
            }
            n = n.next;
        }
        return sum;
    }

    /**
     * Add two polynomials.
     * @param poly1 first polynomial
     * @param poly2 second polynomial
     * @return the result polynomial
     */
    public int[][] add(char poly1, char poly2) {

        R.clear();
        DLinkedListNode n1 = choose(poly1).head;
        DLinkedListNode n2 = choose(poly2).head;
        int[] n1_tmp, n2_tmp;

        while (n1 != null && n2 != null) {

            n1_tmp = (int[]) n1.value;
            n2_tmp = (int[]) n2.value;
            if (n1_tmp[1] == n2_tmp[1]) {

                int[] ans_tmp = new int[2];
                ans_tmp[0] = n1_tmp[0] + n2_tmp[0];
                ans_tmp[1] = n1_tmp[1];
                R.add(ans_tmp);
                n1 = n1.next;
                n2 = n2.next;
            } else if (n1_tmp[1] > n2_tmp[1]) {

                R.add(n1_tmp);
                n1 = n1.next;
            } else {

                R.add(n2_tmp);
                n2 = n2.next;
            }
        }

        if (n1 != null) {
            while (n1 != null) {

                n1_tmp = (int[]) n1.value;
                R.add(n1_tmp);
                n1 = n1.next;
            }
        }
        if (n2 != null) {
            while (n2 != null) {

                n2_tmp = (int[]) n2.value;
                R.add(n2_tmp);
                n2 = n2.next;
            }
        }

        return listtoArr(R);
    }

    /**
     * Subtract two polynomials.
     * @param poly1 first polynomial
     * @param poly2 second polynomial
     * @return the result polynomial
     */
    public int[][] subtract(char poly1, char poly2) {

        R.clear();
        DLinkedListNode n1 = choose(poly1).head;
        DLinkedListNode n2 = choose(poly2).head;
        int[] n1_tmp, n2_tmp;

        while (n1 != null && n2 != null) {

            n1_tmp = (int[]) n1.value;
            n2_tmp = (int[]) n2.value;
            if (n1_tmp[1] == n2_tmp[1]) {

                int[] ans_tmp = new int[2];
                ans_tmp[0] = n1_tmp[0] - n2_tmp[0];
                ans_tmp[1] = n1_tmp[1];
                R.add(ans_tmp);
                n1 = n1.next;
                n2 = n2.next;
            } else if (n1_tmp[1] > n2_tmp[1]) {

                R.add(n1_tmp);
                n1 = n1.next;
            } else {

                int[] ans_tmp = new int[2];
                ans_tmp[0] = -n2_tmp[0];
                ans_tmp[1] = n2_tmp[1];
                R.add(ans_tmp);
                n2 = n2.next;
            }
        }
        if (n1 != null) {
            while (n1 != null) {

                n1_tmp = (int[]) n1.value;
                R.add(n1_tmp);
                n1 = n1.next;
            }
        }
        if (n2 != null) {
            while (n2 != null) {

                int[] ans_tmp = new int[2];
                n2_tmp = (int[]) n2.value;
                ans_tmp[0] = -n2_tmp[0];
                ans_tmp[1] = n2_tmp[1];
                R.add(ans_tmp);
                n2 = n2.next;
            }
        }
        return listtoArr(R);
    }

    /**
     * Multiply two polynomials.
     * @param poly1 first polynomial
     * @param poly2 second polynomial
     * @return the result polynomial
     */
    public int[][] multiply(char poly1, char poly2) {

        R.clear();
        DLinkedListNode n1 = choose(poly1).head;
        DLinkedListNode n2 = choose(poly2).head;
        int[] n1_tmp, n2_tmp;
        int size = choose(poly1).size() * choose(poly2).size();
        int[][] ans = new int[size][2];
        int k = 0;

        while (n1 != null) {

            n1_tmp = (int[]) n1.value;
            while (n2 != null) {

                n2_tmp = (int[]) n2.value;
                ans[k][0] = n1_tmp[0] * n2_tmp[0];
                ans[k][1] = n1_tmp[1] + n2_tmp[1];
                n2 = n2.next;
                k++;
            }
            n2 = choose(poly2).head;
            n1 = n1.next;
        }

        sort(ans);

        for (int i = 0; i < ans.length - 1; i++) {
            if (ans[i][1] == ans[i + 1][1]) {

                ans[i][0] += ans[i + 1][0];
                ans = removeElement(ans, i + 1);
            }
        }

        for (int[] term : ans) {

            R.add(term);
        }
        return listtoArr(R);
    }

    public static void main(String[] args) {

        PolynomialSolver polynomialSolver = new PolynomialSolver();

        while (action != 8) {

            System.out.println("Please choose an action");
            System.out.println("-----------------------");
            System.out.println("1- Set a polynomial variable");
            System.out.println("2- Print the value of a polynomial variable");
            System.out.println("3- Add two polynomials");
            System.out.println("4- Subtract two polynomials");
            System.out.println("5- Multiply two polynomials");
            System.out.println("6- Evaluate a polynomial at some point");
            System.out.println("7- Clear a polynomial variable");
            System.out.println("8- Exit");

            try {

                action = input.nextInt();
            } catch (InputMismatchException e) {

                System.out.println("Enter valid number!");
                input.next();
            }

            if (action == 1) {

                char variable = polynomialSolver.checkInput();
                System.out.println("Insert the polynomial terms in the form:");
                System.out.println("(coeff1, exponent1), (coeff2, exponent2), ..");
                String line = input.next();

                int counter = 0;
                for (int i = 0, len = line.length(); i < len; i++) {

                    if (line.charAt(i) == '(') {

                        counter++;
                    }
                }

                int[][] terms = new int[counter][2];
                boolean negative;
                int k = 0, len = line.length();
                for (int i = 0; i < counter; i++) {
                    for (int j = 0; j < 2; j++) {

                        negative = false;
                        for (; k < len; k++) {

                            if (line.charAt(k) == '-') {

                                negative = true;
                            }
                            if (Character.isDigit(line.charAt(k)) && Character.isDigit(line.charAt(k + 1))
                                    && Character.isDigit(line.charAt(k + 2))) {

                                terms[i][j] = Character.getNumericValue(line.charAt(k)) * 100
                                        + Character.getNumericValue(line.charAt(k + 1)) * 10
                                        + Character.getNumericValue(line.charAt(k + 2));
                                if (negative) {

                                    terms[i][j] = -terms[i][j];
                                }
                                k += 3;
                                break;
                            }
                            else if (Character.isDigit(line.charAt(k)) && Character.isDigit(line.charAt(k + 1))) {

                                terms[i][j] = Character.getNumericValue(line.charAt(k)) * 10
                                        + Character.getNumericValue(line.charAt(k + 1));
                                if (negative) {

                                    terms[i][j] = -terms[i][j];
                                }
                                k += 2;
                                break;
                            } else if (Character.isDigit(line.charAt(k))) {

                                terms[i][j] = Character.getNumericValue(line.charAt(k));
                                if (negative) {

                                    terms[i][j] = -terms[i][j];
                                }
                                k++;
                                break;
                            }
                        }
                    }
                }
                polynomialSolver.sort(terms);
                polynomialSolver.setPolynomial(variable, terms);
            }

            if (action == 2) {

                char variable = polynomialSolver.checkInput();
                System.out.println(polynomialSolver.print(variable));
            }

            if (action == 3) {

                char variable1 = polynomialSolver.checkInput();
                char variable2 = polynomialSolver.checkInput();
                polynomialSolver.add(variable1, variable2);
                System.out.println("Result = " + polynomialSolver.print('R'));
            }
            if (action == 4) {

                char variable1 = polynomialSolver.checkInput();
                char variable2 = polynomialSolver.checkInput();
                polynomialSolver.subtract(variable1, variable2);
                System.out.println("Result = " + polynomialSolver.print('R'));
            }

            if (action == 5) {

                char variable1 = polynomialSolver.checkInput();
                char variable2 = polynomialSolver.checkInput();
                polynomialSolver.multiply(variable1, variable2);
                System.out.println("Result = " + polynomialSolver.print('R'));
            }

            if (action == 6) {

                char variable = polynomialSolver.checkInput();
                System.out.println("Insert the substituted number");
                float no = input.nextFloat();
                System.out.print("The polynomial at point " + no + " = ");
                System.out.println(polynomialSolver.evaluatePolynomial(variable, no));
            }
            if (action == 7) {

                char variable = polynomialSolver.checkInput();
                polynomialSolver.clearPolynomial(variable);
                System.out.println("Polynomial " + variable + " is cleared.");
            }
        }
    }
}
