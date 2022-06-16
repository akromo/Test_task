package com.akromo;


//3. Create a simple program that can get a file as parameter and output
//unique words dictionary file with the words sorted.



import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/** Reads from a file, the path to the file is passed as an argument when starting the program.
 * The read line is split into separate lines through spaces and placed in a collection with unique values,
 * the contents are sorted before being output to the console.
 */
public class FileSort {
    public static void main(String[] args) throws IOException {
        try (InputStream inputStream = new FileInputStream(args[0])) {
            StringBuilder stringBuilder = new StringBuilder();
            while(inputStream.available() > 0) {
                stringBuilder.append((char) inputStream.read());
            }
            Set<String> result = new HashSet<>(Arrays.asList(stringBuilder.toString().split(" ")));
            result.stream().sorted().forEach(System.out::println);
        }
    }
}
