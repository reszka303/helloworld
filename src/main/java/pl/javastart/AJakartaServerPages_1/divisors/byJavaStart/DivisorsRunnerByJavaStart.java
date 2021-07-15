package pl.javastart.AJakartaServerPages_1.divisors.byJavaStart;

import java.util.List;

public class DivisorsRunnerByJavaStart {
    public static void main(String[] args) {
        int number = -10;
        List<Integer> divisors = DivisorsFinder.getDivisors(number);
        System.out.println(divisors);
    }
}
