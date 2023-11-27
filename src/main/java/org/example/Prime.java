package org.example;
import java.util.ArrayList;
import java.util.List;


/**
* This program counts the sum and the number of prime (int) numbers in interval 0-1000
*/
public class Prime {

    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 1000;
    private int start;
    private int finish;
    private int count = 0;
    private int sumOfPrimes = 0;

    public Prime(int start, int finish) throws IllegalArgumentException {
        validateRange(start, finish);
        this.start = start;
        this.finish = finish;
        calculatePrimes();
    }

    private void validateRange(int start, int finish) {
        if (start < MIN_VALUE || finish > MAX_VALUE || start > finish) {
            throw new IllegalArgumentException("Hoppsan, fel intervall angivet!");
        }
    }

    private void calculatePrimes() {
        for (int current = start; current <= finish; current++) {
            if (isPrime(current)) {
                count++;
                sumOfPrimes += current;
            }
        }
    }

    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int getCount(){
        return count;
    }

    public int getSum(){
        return sumOfPrimes;
    }

    public void printCount() {
        System.out.println("Hej, det finns " + count + " primtal mellan 0 och 1000!");
    }

    public void printSum() {
        System.out.println("Och den totala summan av dessa primtal är " + sumOfPrimes + ".");
    }
}
