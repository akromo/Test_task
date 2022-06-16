package com.akromo;

//1. Create a simple program that calculates a Factorial of an Integer (easy)

import java.math.BigDecimal;
import java.util.Scanner;


/**
 * Read strings from terminal while input != "stop"
 * Limited by 100_000 because after that value BigDecimal have overflow
 *
 * @author grekov
 */
public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNext("stop")) {
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                System.out.println(number <= 100000? getFactorial(number) : "Number must be <= 100_000");

            } else {
                System.out.println(String.format("%s is not a integer", scanner.next()));
            }

        }
    }

    /**
     * Finding good multipliers by Tree algorithm, greater speed compared to a simple algorithm (2 * 3 * 4 ... * n)
     * The meaning of the algorithm is to find factors of approximately the same length, we divide the passed range
     * into 2 parts until we come to a simple case where we can multiply the received values ​​​​and return the result
     * Example:
     * 1. getFactorialByTree(2, 5) => getFactorialByTree(2, 3) * getFactorialByTree(4,5)
     * 2. getFactorialByTree(2, 3) = 6
     * 3. getFactorialByTree(4, 5) = 20
     * 5. 6 * 20 = 120
     *
     * @param l left limit of searching interval
     * @param r right limit of searching interval
     * @return factorial for requested interval
     */
    public static BigDecimal getFactorialByTree(int l, int r) {
        if (l > r) {
            return BigDecimal.ONE;
        }
        if (l == r) {
            return BigDecimal.valueOf(l);
        }
        if (r - l == 1) {
            return BigDecimal.valueOf(l * r);
        }
        int m = (l + r) / 2;
        return getFactorialByTree(l, m).multiply(getFactorialByTree(m + 1, r));
    }

    /**
     * Return factorial if we have simple case or delegate calculating to Factorial#getFactorialByTree(l, r)
     *
     * @param n number for calculating factorial
     * @return factorial
     */
    public static BigDecimal getFactorial(int n) {
        if (n < 0) {
            return BigDecimal.ZERO;
        }
        if (n == 0 || n == 1 ) {
            return BigDecimal.ONE;
        }
        if (n == 2) {
            return BigDecimal.valueOf(n);
        }
        return getFactorialByTree(2, n);
    }

}
