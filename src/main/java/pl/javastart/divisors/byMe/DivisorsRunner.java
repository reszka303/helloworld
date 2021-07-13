package pl.javastart.divisors.byMe;

import java.util.Arrays;

public class DivisorsRunner {
    public static void main(String[] args) {
        DivisorFinder divisor = new DivisorFinder();
        int number = -10;
        if (number == 0) {
            System.out.println("Libcza 0 ma nieskończenie wiele dzielników");
        }
        int[] array = divisor.getDivisor(number);
        System.out.println(Arrays.toString(array));
    }
}
