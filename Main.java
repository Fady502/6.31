import java.util.Scanner;
// Fady Zaki SDEV200 1/20/24
public class Main {

    public static void Main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a credit card number as a long integer: ");
        long creditCardNumber = input.nextLong();

        if (isValid(creditCardNumber)) {
            System.out.println(creditCardNumber + " is valid");
        } else {
            System.out.println(creditCardNumber + " is invalid");
        }
    }

    public static boolean isValid(long number) {
        return (getSize(number) >= 13 && getSize(number) <= 16) &&
                (prefixMatched(number, 4) || prefixMatched(number, 5) ||
                        prefixMatched(number, 37) || prefixMatched(number, 6)) &&
                ((sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0);
    }

    public static int sumOfDoubleEvenPlace(long number) {
        int sum = 0;
        String numStr = Long.toString(number);

        for (int i = numStr.length() - 2; i >= 0; i -= 2) {
            sum += getDigit(Integer.parseInt(String.valueOf(numStr.charAt(i))) * 2);
        }

        return sum;
    }

    public static int getDigit(int number) {
        if (number < 10) {
            return number;
        } else {
            return number / 10 + number % 10;
        }
    }

    public static int sumOfOddPlace(long number) {
        int sum = 0;
        String numStr = Long.toString(number);

        for (int i = numStr.length() - 1; i >= 0; i -= 2) {
            sum += Integer.parseInt(String.valueOf(numStr.charAt(i)));
        }

        return sum;
    }

    public static boolean prefixMatched(long number, int d) {
        return getPrefix(number, getSize(d)) == d;
    }

    public static int getSize(long d) {
        return Long.toString(d).length();
    }

    public static long getPrefix(long number, int k) {
        String numStr = Long.toString(number);
        return Long.parseLong(numStr.substring(0, Math.min(k, numStr.length())));
    }
}
