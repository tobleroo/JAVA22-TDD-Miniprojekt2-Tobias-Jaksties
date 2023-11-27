package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner myScan = new Scanner(System.in)){

            System.out.print("first number: ");
            int start = myScan.nextInt();

            System.out.print("last number: ");
            int finish = myScan.nextInt();

            Prime prime = new Prime(start, finish);
            prime.printCount();
            prime.printSum();
        } catch (Exception e) {
            System.out.println("Hoppsan, fel intervall angivet!");
        }
    }
}