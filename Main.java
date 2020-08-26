package com.johnmsaylor;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Loan - Monthly Payment Calculator");
        System.out.print("Principal: ");
        int principal = scanner.nextInt();
        System.out.print("Interest: ");
        double interest = ((scanner.nextDouble() / 100) / 12);
        System.out.print("Term (in years): ");
        int term = scanner.nextInt() * 12;

        double answer = (interest * Math.pow(interest + 1, term));
        answer = answer / (Math.pow(interest + 1, term) - 1);

        answer = Math.ceil(principal * answer);

        System.out.println(answer);
    }
}
