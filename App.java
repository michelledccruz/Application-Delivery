/***************************************************************
 * Name: Michelle Cruz
 * Date: May 10, 2026
 * Assignment: Project 5.2 - Application Delivery
 *
 * Main application class.
 * This final calculator program includes basic math operations,
 * memory/list features, and exception handling.
 ***************************************************************/

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<Integer> memoryList = new ArrayList<Integer>();

        double singleMemory = 0;
        int choice = 0;

        System.out.println("Michelle Cruz - Final Calculator Application");
        System.out.println("Welcome to my final calculator program.");
        System.out.println("This program can add, subtract, multiply, divide, and use calculator memory.");
        System.out.println();

        while (choice != 12) {
            try {
                System.out.println("Calculator Menu");
                System.out.println("1. Add");
                System.out.println("2. Subtract");
                System.out.println("3. Multiply");
                System.out.println("4. Divide");
                System.out.println("5. Store single memory value");
                System.out.println("6. Retrieve single memory value");
                System.out.println("7. Clear single memory value");
                System.out.println("8. Add integer to memory list");
                System.out.println("9. Display memory list");
                System.out.println("10. Display sum and average of memory list");
                System.out.println("11. Display difference of first and last memory list value");
                System.out.println("12. Quit");
                System.out.print("Please select an option: ");

                choice = input.nextInt();
                System.out.println();

                if (choice >= 1 && choice <= 4) {
                    System.out.print("Please enter the first number: ");
                    double num1 = input.nextDouble();

                    System.out.print("Please enter the second number: ");
                    double num2 = input.nextDouble();

                    if (choice == 1) {
                        System.out.printf("Result: %.2f + %.2f = %.2f%n", num1, num2, add(num1, num2));
                    } else if (choice == 2) {
                        System.out.printf("Result: %.2f - %.2f = %.2f%n", num1, num2, subtract(num1, num2));
                    } else if (choice == 3) {
                        System.out.printf("Result: %.2f * %.2f = %.2f%n", num1, num2, multiply(num1, num2));
                    } else if (choice == 4) {
                        if (num2 == 0) {
                            throw new ArithmeticException("Cannot divide by zero.");
                        }
                        System.out.printf("Result: %.2f / %.2f = %.2f%n", num1, num2, divide(num1, num2));
                    }

                } else if (choice == 5) {
                    System.out.print("Enter a value to store in memory: ");
                    singleMemory = input.nextDouble();
                    System.out.println("Memory value has been stored.");

                } else if (choice == 6) {
                    System.out.println("Current memory value: " + singleMemory);

                } else if (choice == 7) {
                    singleMemory = 0;
                    System.out.println("Memory value has been cleared.");

                } else if (choice == 8) {
                    if (memoryList.size() < 10) {
                        System.out.print("Enter an integer value to add to memory list: ");
                        int value = input.nextInt();
                        memoryList.add(value);
                        System.out.println("Value added to memory list.");
                    } else {
                        System.out.println("Memory list is full. It can only hold 10 values.");
                    }

                } else if (choice == 9) {
                    displayList(memoryList);

                } else if (choice == 10) {
                    if (memoryList.size() > 0) {
                        System.out.println("Sum of memory list: " + getSum(memoryList));
                        System.out.printf("Average of memory list: %.2f%n", getAverage(memoryList));
                    } else {
                        System.out.println("No values are stored in memory list.");
                    }

                } else if (choice == 11) {
                    if (memoryList.size() >= 2) {
                        int difference = memoryList.get(0) - memoryList.get(memoryList.size() - 1);
                        System.out.println("Difference of first and last memory list value: " + difference);
                    } else {
                        System.out.println("At least two values are needed for this calculation.");
                    }

                } else if (choice == 12) {
                    System.out.println("Thank you for using my final calculator program.");

                } else {
                    System.out.println("Invalid option. Please try again.");
                }

            } catch (InputMismatchException e) {
                System.out.println(e);
                System.out.println("Error: Please enter numeric values only.");
                input.nextLine();

            } catch (ArithmeticException e) {
                System.out.println(e);
                System.out.println("Error: Please enter a second number that is not zero.");
            }

            System.out.println();
        }

        input.close();
    }

    public static double add(double num1, double num2) {
        return num1 + num2;
    }

    public static double subtract(double num1, double num2) {
        return num1 - num2;
    }

    public static double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public static double divide(double num1, double num2) {
        return num1 / num2;
    }

    public static void displayList(ArrayList<Integer> values) {
        if (values.size() == 0) {
            System.out.println("No values are stored in memory list.");
        } else {
            System.out.println("Memory list values:");
            for (int i = 0; i < values.size(); i++) {
                System.out.println("Index " + i + ": " + values.get(i));
            }
        }
    }

    public static int getSum(ArrayList<Integer> values) {
        int total = 0;

        for (int value : values) {
            total += value;
        }

        return total;
    }

    public static double getAverage(ArrayList<Integer> values) {
        return (double) getSum(values) / values.size();
    }
}