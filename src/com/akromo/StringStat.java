package com.akromo;

//2. Create a simple program that can read a string and return character
//        statistics
//
// example: input string is "this is a test PROBLEM", the expected
//        result will be: a => 1, b=> 1, e=>2 and so on.
//

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * Read strings from terminal while input != "!stop", apply String#toLowerCase() on input string
 *
 * @author grekov
 */
public class StringStat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (!scanner.hasNext("!stop")) {
            System.out.println(parceString(scanner.nextLine().toLowerCase()));
        }
    }

    /**
     * Collect character statistic.
     * Filling map by characters from input and increment value if same character already exist in map,
     * when Map filling is ended remove spacebars and start building result string.
     * Iterator<Character> used just for good ending of result string "iterator.hasNext() ? ", " : ".")"
     *
     * @param string string for statistic collecting
     * @return format string with character statistic
     */
    public static String parceString(String string) {
        Map<Character, Integer> stat = new HashMap<>();

        for (char c : string.toCharArray()) {
            stat.put(c, stat.containsKey(c) ? stat.get(c) + 1 : 1);
        }

        stat.remove(' ');
        Iterator<Character> iterator = stat.keySet().iterator();
        StringBuilder stringBuilder = new StringBuilder();

        while (iterator.hasNext()) {
            char c = iterator.next();
            stringBuilder.append(String.format("%c => %d%s ", c, stat.get(c), iterator.hasNext() ? ", " : "."));
        }
        return stringBuilder.toString();
    }
}
