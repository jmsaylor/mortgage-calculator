package com.johnmsaylor;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Loan - Monthly Payment Calculator");

        int principal = (int)readNumber("Enter principal amount: ", 100000, 1000000);
        int term = (int)readNumber("Enter term of loan (years): ", 10, 30);
        double interest = readNumber("Enter interest rate: ", 0, 50);

        float monthlyPayment = (float)calculateMortgage(principal, interest, term);
        System.out.println(monthlyPayment);

        for (int i = 0; i < term * 12; i++ ) {
            float balance = (float)calculateBalance(principal, i,interest,term);
            System.out.println(balance);
        }


    }

    public static double readNumber(String prompt, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        double value = 0;
        while (true) {
            value = scanner.nextDouble();
            if (value >= min && value <= max) break;
            System.out.println("Enter a value between " + min + "and " + max);
        }
        return value;

    }

    public static double calculateBalance(int principal, int month, double interest, int term) {

        interest = (interest / 100) / 12;
        term = term * 12;

        double answer = Math.pow((1 + interest), term) - Math.pow((1 + interest), month);
        answer = principal * answer;
        answer = answer / (Math.pow((1 + interest), term) - 1);

        return Math.ceil(answer);

    }





    public static double calculateMortgage(int principal, double interest, int term) {
        interest = (interest / 100) / 12;
        term = term * 12;

        double answer = (interest * Math.pow(interest + 1, term));
        answer = answer / (Math.pow(interest + 1, term) - 1);

        return Math.ceil(principal * answer);

    }

}
