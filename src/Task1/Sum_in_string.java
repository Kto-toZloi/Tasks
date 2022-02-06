package Task1;

import java.util.Scanner;

public class Sum_in_string {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        long sum = 0;
        char c;
        for (int i = 0; i < input.length(); i++) {
            c = input.charAt(i);
            if (Character.isDigit(c)){
                sum += Integer.parseInt(String.valueOf(c));
            }
        }
        System.out.println("Сумма введенных в строке чисел равна = " + sum);
    }
}
