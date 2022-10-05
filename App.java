import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        boolean keepGoing = true;

        while (keepGoing == true) {

            Double num1 = getDouble("Give your first number.");
            Double num2 = getDouble("Give your second number.");

            String options = makeList();
            System.out.println(options);

            keyboard.nextLine();
            String userOperation = keyboard.nextLine();

            operations(userOperation, calculator, num1, num2);

            keepGoing = userContinue();

        }
    }

    private static void operations(String userOperation, Calculator calculator, Double num1, Double num2) {
        if (userOperation.equalsIgnoreCase("add")) {

            Double result = calculator.add(num1, num2);
            System.out.println();
            System.out.println("Added: " + result);
        } else if (userOperation.equalsIgnoreCase("subtract")) {

            Double result = calculator.subtract(num1, num2);
            System.out.println();
            System.out.println("Subtracted: " + result);
        } else if (userOperation.equalsIgnoreCase("multiply")) {

            Double result = calculator.multiply(num1, num2);
            System.out.println();
            System.out.println("Multiplied: " + result);
        } else if (userOperation.equalsIgnoreCase("divide")) {

            Double result = calculator.divide(num1, num2);
            System.out.println();
            System.out.println("Divided: " + result);
        }
    }

    private static String getString(String prompt) {
        System.out.println();
        System.out.println(prompt);
        String userInput = keyboard.nextLine();
        return userInput;
    }

    private static Double getDouble(String prompt) {
        System.out.println();
        System.out.println(prompt);
        Double number = keyboard.nextDouble();
        return number;
    }

    private static String makeList() {
        List<String> options = new ArrayList<String>() {
            {
            add("Add");
            add("Subtract");
            add("Multiply");
            add("Divide");
            }
        };

        System.out.println();
        System.out.println("Choose an operation:");
        System.out.println();
        String joined = String.join("---", options);

        return joined;
    }

    private static boolean userContinue() {
        String userContinue = getString("Would you like to continue? (Y/N)");
        if (userContinue.equalsIgnoreCase("y")) {
            return true;
        } else {
            System.out.println();
            System.out.println("Goodbye");
            System.out.println();
            return false;
        }
    }

}