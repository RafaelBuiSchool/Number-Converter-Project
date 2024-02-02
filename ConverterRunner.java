import java.util.Scanner;
import java.util.Arrays;

class ConverterRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.println("Choose an option: \n1.Convert from a Base 10 number to another base between 1-64 or 2. Convert from base 2,8,10,16 to another base.\nChoose 1 or 2: ");

        Scanner s = new Scanner(System.in);
        int choice = s.nextInt();
        NumberConverter nc = null;
        if (choice == 1) {
            System.out.println("Enter your base 10 number: ");
            int number = s.nextInt();
            System.out.println("Enter a base from 1-64 that you want to convert your number to: ");
            int newBase = s.nextInt();
            nc = new NumberConverter(number, 10);
            if (nc != null || !nc.isError()) {
                int[] newArray = nc.convertToBase1To64(newBase);
                System.out.println("Result in new base " + newBase + ": ");
                for (int i = newArray.length - 1; i >= 0; i--) {
                    System.out.print(newBaseValues(newArray[i]));
                }
            }
        }
        if (choice == 2) {
            System.out.println("Enter the base of your number (2, 8, 10, or 16): ");
            s.nextLine();
            String secondChoice = s.nextLine();
            int base = Integer.parseInt(secondChoice);
            System.out.print("Enter your number: ");
            String number = s.nextLine();
            number = number.toLowerCase();
            if(!number.contains("0") || !number.contains("1") ||!number.contains("2") ||!number.contains("3") ||!number.contains("4") ||!number.contains("5") ||!number.contains("6") ||!number.contains("7") ||!number.contains("8") ||!number.contains("9")){
                if(base == 2){
                    System.out.println("Error Message: Number entered is not of base 2.");
                }
                if(base == 8){
                    System.out.println("Error Message: Number entered is not of base 8.");
                }
                if(base == 10){
                    System.out.println("Error Message: Number entered is not of base 10.");
                }
                else if(base==16 && (!number.contains("a") || !number.contains("b") ||!number.contains("c") ||!number.contains("d") ||!number.contains("e") ||!number.contains("f"))){
                    System.out.println("Error Message: Number entered is not of base 16.");
                }
            }
            else{
                int n = Integer.parseInt(number);
                s.close();
                nc = new NumberConverter(n, base);
                if (nc != null && !nc.isError()) {
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

        }
    }
    private static String newBaseValues(int value) {
         String[] lowerAlphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

         String[] upperAlphabet={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        if (value >= 0 && value <= 9) {
            return (String) (value + "");
        } else if (value >= 10 && value <= 35) {
            int i = value-10;
            return (lowerAlphabet[i] + "");
        } else if (value >= 36 && value <= 61) {
            int i = value-36;
            return (upperAlphabet[i] + "");
        } else if (value == 62) {
            return "+";
        } else if (value == 63) {
            return "/";
        } else {
            System.out.println("Error Message: Chosen value does not work.");
            return null;
        }
    }
}
