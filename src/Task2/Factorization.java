package Task2;

import java.util.*;

public class Factorization {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long a;
        try {
            if (s.hasNextLong()) {
                a = Math.abs(s.nextLong());
                if (a >= 2) {
                    for (Object num : Factorization.factor(a)) {
                        System.out.print(num + " ");
                    }
                } else throw new ArithmeticException("Число меньше двух");
            } else throw new ArithmeticException("Введенное значение не целое число");
        }
        catch (ArithmeticException e) {
            System.out.println(e.getClass().getSimpleName() + " " + e.getMessage());
        }
    }

    static List<Object> factor(long num){
        ArrayList<Object> primes = new ArrayList<>();
        long b = num;
        //42.5 36,1
        int i = 2;
        while (true) {
            if (b % i == 0){
                primes.add(i);
                b /= i;
            }
            else {
                i++;
                if (i > b) return primes;
            }
        }
    }



}
