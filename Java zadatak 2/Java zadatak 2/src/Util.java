import java.util.Scanner;

public class Util {
    private static final Scanner scanner = new Scanner(System.in);

    public static boolean readGender(String message) {
        while (true) {
            System.out.println(message);
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("m")) {
                return true;
            } else if (input.equals("f")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter 'M' for male or 'F' for female.");
            }
        }
    }

    public static int readInt(String message, String error, int min, int max) {
        while (true) {
            System.out.println(message);
            try {
                int number = Integer.parseInt(scanner.nextLine());
                if (number < min || number > max) {
                    System.out.println(error);
                    continue;
                }
                return number;
            } catch (NumberFormatException e) {
                System.out.println(error);
            }
        }
    }

    public static boolean readYesOrNo(String message, String error) {
        while (true) {
            System.out.println(message);
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("yes")) {
                return true;
            } else if (input.equals("no")) {
                return false;
            } else {
                System.out.println(error);
            }
        }
    }

    public static String readString(String message, String error) {
        while (true) {
            System.out.println(message);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            } else {
                System.out.println(error);
            }
        }
    }
}
