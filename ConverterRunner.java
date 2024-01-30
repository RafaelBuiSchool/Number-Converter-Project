import java.util.Scanner;
import java.util.Arrays;

class ConverterRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.println("Choose an option: \n1.Convert from a Base 10 number to another base from 1-64 or 2. Convert from base 2,8,10,16 to another base.\nChoose 1 or 2: ");

        Scanner s = new Scanner(System.in);
        int choice = s.nextInt();
        if (choice == 1) {
            System.out.println("Enter a Base 10 number: ");
            int userNumber = s.nextInt();
            System.out.println("Enter a base from 1-64 to convert your number to: ");
            int newBase = s.nextInt();
            NumberConverter nc = new NumberConverter(userNumber, 10);
            int[] newArray = nc.convertToNewBase(newBase);
            System.out.println("Result in new base " + newBase + ": ");
            for (int i = newArray.length - 1; i >= 0; i--) {
                System.out.print(newBaseValues(newArray[i]));
            }
        }
        if (choice == 2) {
            System.out.println("Enter the base of your number (2, 8, 10, or 16): ");
            s.nextLine();
            String secondChoice = s.nextLine();
            int base = Integer.parseInt(secondChoice);
            System.out.print("Enter your number: ");
            String number = s.nextLine();
            int n = Integer.parseInt(number);
            s.close();
            NumberConverter nc = new NumberConverter(n, base);
            int powerOf = 0;
            int value = 0;
            for (int i = nc.digits.length - 1; i >= 0; i--) {
                value += Math.pow(base, powerOf) * nc.digits[i];
                powerOf++;
            }
            String hexadecimal = Integer.toHexString(value).toUpperCase();
            int[] digits = nc.getDigits();
            if (nc.base == 2) {
                System.out.println("\nDecimal Number: " + value);
                System.out.println("Octal Number: " + Integer.toOctalString(value));
                System.out.println("Hexadecimal Number: " + hexadecimal);
            } else if (nc.base == 8) {
                System.out.println("\nDecimal Number: " + value);
                System.out.println("Binary Number: " + Integer.toBinaryString(value));
                System.out.println("Hexadecimal Number: " + hexadecimal);
            } else if (nc.base == 10) {
                System.out.println("\nBinary Number: " + Integer.toBinaryString(value));
                System.out.println("Octal Number: " + Integer.toOctalString(value));
                System.out.println("Hexadecimal Number: " + hexadecimal);
            } else if (nc.base == 16) {
                System.out.println("\nBinary Number: " + Integer.toBinaryString(value));
                System.out.println("Octal Number: " + Integer.toOctalString(value));
                System.out.println("\nDecimal Number: " + value);
            }
        }
    }
    private static char newBaseValues(int value) {
        if (value >= 0 && value <= 9) {
            return (char) ('0' + value);
        } else if (value >= 10 && value <= 35) {
            return (char) ('A' + (value - 10));
        } else if (value >= 36 && value <= 61) {
            return (char) ('a' + (value - 36));
        } else if (value == 62) {
            return '+';
        } else if (value == 63) {
            return '/';
        } else {
            throw new IllegalArgumentException("Error Message: Chosen value does not work.");
        }
    }
}
