public class hex{

    // Recursive method to convert decimal to hexadecimal
    public static String toHex(int decimal) {
        if (decimal == 0) {
            return "";  // base case: nothing left to convert
        }

        int remainder = decimal % 16;
        String hexDigits = "0123456789ABCDEF";

        // Recursive call for the quotient
        String result = toHex(decimal / 16);

        // Append the hex digit for the remainder
        return result + hexDigits.charAt(remainder);
    }

    public static void main(String[] args) {
        int decimalNumber = 2545;  // example decimal number

        if (decimalNumber == 0) {
            System.out.println("0");
        } else {
            String hex = toHex(decimalNumber);
            System.out.println("Hexadecimal: " + hex);
        }
    }
}


