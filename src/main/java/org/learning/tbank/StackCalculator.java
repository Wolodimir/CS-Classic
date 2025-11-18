package org.learning.tbank;

import java.util.Stack;

public class StackCalculator {

    public static void main(String[] args) {
        System.out.println(calculate("13 * 6 + 55"));
    }

    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int number = 0;
        char lastOp = '+';

        for (int i = 0; i <= s.length(); i++) {

            char c = i < s.length() ? s.charAt(i) : '+';
            if (c == ' ') continue;

            if (Character.isDigit(c)) {
                number = number * 10 + Character.getNumericValue(c);
            }

            if (c == '+' || c == '*') {
                if (lastOp == '+') {
                    stack.push(number);
                } else {
                    stack.push(stack.pop() * number);
                }
                number = 0;
                lastOp = c;
            }

        }
        int result = 0;
        while (!stack.isEmpty()) result += stack.pop();
        return result;
    }

}
