package pl.javastart.divisors.byMe;

import java.util.Arrays;

public class DivisorsRunner {
    public static void main(String[] args) {
        Divisor divisor = new Divisor();
        int number = 10;
        int[] array = divisor.getDivisor(number);
        System.out.println(Arrays.toString(array));
    }
}
