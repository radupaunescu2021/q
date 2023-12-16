package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Hello world!
 *
 */
public class App {
    public static int pascal(int c, int r) {
        //Throw exception for negative column or row
        if (c < 0 || r < 0 || c > r) {
            throw new IllegalArgumentException("Row and column must be non-negative and column cannot be greater than row.");
        }
        // Base case
        if (c == 0 || c == r) {
            return 1;
        }

        // Recursive call
        return pascal(c - 1, r - 1) + pascal(c, r - 1);
    }



    public static boolean balance(List<Character> chars) {

        // Initialize a stack to keep track of opening parentheses.
        Stack<Character> stack = new Stack<>();

        // Iterate through each character in the list.
        for (char ch : chars) {
            if (ch == '(') {
                // If the current character is an opening parenthesis.Push to stack
                stack.push(ch);
            } else if (ch == ')') {
                // Check if the stack is empty. If it is, there is no corresponding opening parenthesis.
                if (stack.isEmpty()) {
                    return false;
                }
                // If the current character is a closing parenthesis.Pop of the stack
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {


    }

}
