
public class NumberConverter {
    int[] digits;
    int base;

    public boolean isError() {
        return error;
    }

    private boolean error;
    public NumberConverter(int number, int base) {
        String numberAsString = Integer.toString(number);
        digits = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            char digitToChar = numberAsString.charAt(i);
            if (base == 2 && (digitToChar != '1' && digitToChar != '0')) {
                System.out.println("Error Message: Number entered is not of base 2.");
                error = true;
                return;
            }
            if (base == 8 && (digitToChar != '0' && digitToChar != '1' && digitToChar != '2' && digitToChar != '3' && digitToChar != '4' && digitToChar != '5' && digitToChar != '6' && digitToChar != '7')) {
                System.out.println("Error Message: Number entered is not of base 8.");
                error = true;
                return;
            }
            if (base == 10 && !(Character.isDigit(digitToChar))) {
                System.out.println("Error Message: Number entered is not of base 10.");
                error = true;
                return;
            }
            if (base == 16 && (!Character.isDigit(digitToChar)) && (digitToChar < 'A' || digitToChar > 'F')) {
                System.out.println("Error Message: Number entered is not of base 16.");
                error = true;
                return;
            }
            for (int x = 0; x < numberAsString.length(); x++) {
                String single = numberAsString.substring(x, x + 1);
                int d = Integer.parseInt(single);
                digits[x] = d;
            }
        }
        this.base = base;
        error = false;
    }
        public int[] convertToBase1To64(int newBase){
            if (error || newBase < 1 || newBase > 64) {
                System.out.println("Error Message: Please enter correct base.");
                error = true;
            }
            int decimal = convertToDecimal()[0];
            int tempValue = decimal;
            int length = 0;
            while (tempValue > 0) {
                tempValue /= newBase;
                length++;
            }
            int[] newArray = new int[length];
            for (int i = 0; i < length; i++) {
                newArray[i] = decimal % newBase;
                decimal /= newBase;
            }
            error = false;
            return newArray;
        }

        public String displayOriginalNumber () {
            String o = "";
            for (int i = 0; i < digits.length; i++) {
                o = o + digits[i];
            }
            o = o + "\n";
            return o;
        }

        public int[] getDigits () {
            return digits;
        }

        public int[] convertToDecimal () {
            int[] base10Array = new int[1];
            int powerOf = 0;
            int value = 0;
            for (int i = digits.length - 1; i >= 0; i--) {
                value += Math.pow(base, powerOf) * digits[i];
                powerOf++;
            }
            base10Array[0] = value;
            return base10Array;
        }

        public int[] convertToBinary () {
            int decimal = convertToDecimal()[0];
            int tempValue = decimal;
            int length = 0;
            while (tempValue > 0) {
                tempValue /= 2;
                length++;
            }
            int[] base2Array = new int[length];
            for (int i = 0; i < length; i++) {
                if (decimal % 2 == 0) {
                    base2Array[i] = 0;
                } else {
                    base2Array[i] = 1;
                }
                decimal /= 2;
            }
            return base2Array;
        }

        public int[] convertToOctal () {
            int decimal = convertToDecimal()[0];
            int tempValue = decimal;
            int length = 0;
            while (tempValue > 0) {
                tempValue /= 8;
                length++;
            }
            int[] base8Array = new int[length];
            for (int i = 0; i < length; i++) {
                base8Array[i] = decimal % 8;
                decimal /= 8;
            }
            return base8Array;
        }
        public int[] convertToHexadecimal () {
            int decimal = convertToDecimal()[0];
            int tempValue = decimal;
            int length = 0;
            while (tempValue > 0) {
                tempValue /= 16;
                length++;
            }
            int[] base16Array = new int[length];
            for (int i = 0; i < length; i++) {
                base16Array[i] = decimal % 16;
                decimal /= 16;
            }
            return base16Array;
        }
    }


