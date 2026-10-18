package Recursion;

import java.util.Scanner;

public class TowerOfHanoi {

    public static void solveTowerOfHanoi(
            int n, String Source, String Helper, String Destination) {

        if (n == 1) {
            System.out.println("Transfer disk " + n + " from "
                    + Source + " to " + Destination);
            return;
        }

        solveTowerOfHanoi(n - 1, Source, Destination, Helper);

        System.out.println("Transfer disk " + n + " from "
                + Source + " to " + Destination);

        solveTowerOfHanoi(n - 1, Helper, Source, Destination);
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the number of disks: ");

            if (!sc.hasNextInt()) {
                System.out.println("Please enter a valid integer.");
                return;
            }

            int n = sc.nextInt();

            if (n < 1) {
                System.out.println("Number of disks must be at least 1.");
                return;
            }

            solveTowerOfHanoi(n, "S", "H", "D");
            System.out.println("Tower of Hanoi solved successfully!");
        }
    }
}

