package main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberPrinterTest {
    // This was my starting test; I think it was a bit too granular but I left it for posterity
/*    @Test
    public void printsOne_successfully() {
        NumberPrinter.print();
        assertPrintStatement("1");
    }*/

    @Test
    public void getNumberTypeAsString_forOddNumber_returnsSuccessfully() {
        // 9 is odd but not prime
        assertEquals(" ODD", NumberPrinter.getNumberTypeAsString(9));
    }

    @Test
    public void getNumberTypeAsString_forEvenNumber_returnsSuccessfully() {
        // 4, like most even numbers, is not prime
        assertEquals(" EVEN", NumberPrinter.getNumberTypeAsString(4));
    }

    @Test
    public void getNumberTypeAsString_forOddPrimeNumber_returnsSuccessfully() {
        // 3 is both odd and prime
        assertEquals(" ODD PRIME", NumberPrinter.getNumberTypeAsString(3));
    }

    @Test
    public void getNumberTypeAsString_forEvenPrimeNumber_returnsSuccessfully() {
        // 2 is the only even prime number
        assertEquals(" EVEN PRIME", NumberPrinter.getNumberTypeAsString(2));
    }

    @Test
    public void isNumberPrime_forPrimeNumber_returnsTrue() {
        // 7 is prime
        assertTrue(NumberPrinter.isNumberPrime(7));
    }

    @Test
    public void isNumberPrime_forNonPrimeNumber_returnsFalse() {
        // 8 is not prime
        assertFalse(NumberPrinter.isNumberPrime(8));
    }

    @Test
    public void getPrintableRangeWithTypes_oneToFive_returnsSuccessfully() {
        /*  Create a test string from 1 to 5 with the expected types and newlines (note that 1 is not prime). Only test
            1 to 5 because it contains all possible test cases without becoming too burdensome (like setting up a test
            string for 1 to 100). We expect that if 1 to 5 works, then so will 1 to 100 */
        final String testString = "1 ODD\n2 EVEN PRIME\n3 ODD PRIME\n4 EVEN\n5 ODD PRIME";
        assertEquals(testString, NumberPrinter.getPrintableRangeWithTypes(1, 5));
    }
}
