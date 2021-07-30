package main;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberPrinter {
    // Main method would probably not live in this class in prod code, but for simplicity I'll leave it here
    public static void main(String[] args) {
        System.out.println(getPrintableRangeWithTypes(1, 100));
    }

    /*  Returns a range of numbers from start to end inclusive as a single string. Will also append "EVEN" or "ODD"
        and "PRIME" after each number if it applies */
    public static String getPrintableRangeWithTypes(int start, int end) {
        // IntStream's range function is end *exclusive*, so add 1 to our end
        return IntStream.range(start, end + 1)
                .boxed()
                .map(number -> String.valueOf(number) + getNumberTypeAsString(number))
                .collect(Collectors.joining("\n"));     // Collect to a string and delimit with a newline
    }

    /*  Since these two functions below are relatively straightforward and used here only, I would make them private in
        production code and just unit test the high level logic of this class (the print method). But I'll test it all
        for the purpose of demonstrating TDD. */

    public static String getNumberTypeAsString(int number) {
        // This logic could probably just be placed right in the forEachOrdered computation on the stream, but I'll split it off
        String numberType = (number % 2 == 0) ? " EVEN" : " ODD";
        return isNumberPrime(number) ? (numberType + " PRIME") : numberType;    // Note the space before each string
    }

    public static boolean isNumberPrime(int number) {
        // Logic taken from GeeksForGeeks (https://www.geeksforgeeks.org/java-program-to-check-if-a-number-is-prime-or-not/)
        // Why reinvent the wheel? This is already a very streamlined method for checking primality
        if (number <= 1) {
            return false;
        }

        if (number <= 3) {
            return true;
        }

        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }

        for (int i = 5; i * i <= number; i = i + 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }
}
