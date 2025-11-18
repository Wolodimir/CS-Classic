package org.learning.tbank;

import java.util.ArrayList;
import java.util.List;

public class SubString {

    public static void main(String[] args) {
        System.out.println(stringCalculator("2 + 2 * 4 * 11 + 5 + 9"));
    }

    public static int stringCalculator(String s) {
        int n = s.length();
        int result = 0;
        int current = 1;
        int number = 0;
        char lastOp = '+';

        for (int i = 0; i <= n; i++) {
            char c = i < n ? s.charAt(i) : '+';

            if (c == ' ') continue;

            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } else if (c == '+' || c == '*') {
                if (lastOp == '+') {
                    result += current;
                    current = number;
                } else {
                    current *= number;
                }
                number = 0;
                lastOp = c;
            }
        }

        result += current - 1;

        return result;
    }

}
