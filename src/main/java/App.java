/*
 * UCF COP3330 SUMMER 2021 ASSIGNMENT 1 SOLUTION
 * COPYRIGHT 2021 ALEXANDER DE CORTE
 */

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        double p = 0, r = 0, t = 0, A = 0;
        int n = 0;
        boolean isNumeric = false;
        Scanner input = new Scanner(System.in);

        while(!isNumeric) {
            try {
                System.out.print("What is the principal amount ? ");
                p = Double.parseDouble(input.nextLine());
                System.out.print("What is the rate? ");
                r = Double.parseDouble(input.nextLine());
                System.out.print("What is the number of years? ");
                t = Double.parseDouble(input.nextLine());
                System.out.print("what is the number of times the interest is compounded per year? ");
                n = Integer.parseInt(input.nextLine());
                isNumeric = true;
            } catch (NumberFormatException nfe) {
                System.out.println("That is not a valid numeric input.");
                isNumeric = false;
            }
        }

        CompoundCalc calc = new CompoundCalc(p, r, t, n);
        A = calc.getFinAmount();

        System.out.printf("$%.2f invested at %.1f%% for %.1f years compounded %d times per year is $%.2f\n",
                p, r, t, n, A);
    }
}

class CompoundCalc {
    private double principal;
    private double rate;
    private double time;
    private int numCompounded;
    private double finAmount;

    public CompoundCalc(double p, double r, double t, int n) {
        principal = p;
        rate = r / 100;
        time = t;
        numCompounded = n;
        finAmount = 0;
    }

    public double getFinAmount() {
        finAmount = principal * Math.pow((1 + rate / numCompounded), (numCompounded * time));

        return finAmount;
    }
}