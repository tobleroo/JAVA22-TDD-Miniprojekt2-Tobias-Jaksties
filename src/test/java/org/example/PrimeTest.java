package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrimeTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    @DisplayName("Makes sure valid inputs does not throw Ex")
    void testValidRange() {
        assertDoesNotThrow(() -> new Prime(10, 20));
    }

    @Test
    @DisplayName("Makes sure constructor throws on invalid inputs")
    void testInvalidRange() {
        assertThrows(IllegalArgumentException.class, () -> new Prime(1001, 1002));
        assertThrows(IllegalArgumentException.class, () -> new Prime(-1, 10));
        assertThrows(IllegalArgumentException.class, () -> new Prime(20, 10));
    }

    @Test
    @DisplayName("Makes sure prime count works correctly")
    void testPrimeCount() {
        Prime prime = new Prime(10, 20);
        // Assuming the known count of primes between 10 and 20
        assertEquals(4, prime.getCount());
    }

    @Test
    @DisplayName("Makes sure the highest and lowest values that works")
    void testBoundaryConditions() {
        assertDoesNotThrow(() -> new Prime(0, 1));
        assertDoesNotThrow(() -> new Prime(999, 1000));
    }

    @Test
    @DisplayName("Makes sure sum of primes are correctly calculated")
    void testGetRightSum(){
        Prime prime = new Prime(10, 20);

        assertEquals(60, prime.getSum());
    }

    @Test
    @DisplayName("makes sure it is empty on count")
    void testPrimeCountForEmptyRange() {
        Prime prime = new Prime(24, 25);
        assertEquals(0, prime.getCount());
    }

    @Test
    @DisplayName("Makes sure print is correctly done with amounts")
    void testPrintCount() {
        Prime prime = new Prime(0, 1000);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        prime.printCount();
        String expectedOutput = "Hej, det finns " + prime.getCount() + " primtal mellan 0 och 1000!" + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
        System.setOut(System.out);
    }

    @Test
    @DisplayName("Makes sure sum is printed correctly")
    void testPrintSum() {
        Prime prime = new Prime(0,1000);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        prime.printSum();
        String expectedOutput = "Och den totala summan av dessa primtal är " + prime.getSum() + "." + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
        System.setOut(System.out);
    }

    @Test
    @DisplayName("Boundary test of the max and min input values")
    void testMaxBoundary() {
        assertDoesNotThrow(() -> new Prime(0, 1000));
    }

}