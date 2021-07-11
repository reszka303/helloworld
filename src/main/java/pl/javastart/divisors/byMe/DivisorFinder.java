package pl.javastart.divisors.byMe;

public class DivisorFinder {
    protected int[] getDivisor(int number) {
        if (number < 0) {
            return addDivisorsByNegativeNumber(number);
        } else {
            return addDivisorsByPositiveNumber(number);
        }
    }

    protected int[] addDivisorsByNegativeNumber(int number) {
        int capacityArray = countArrayLengthByNegativeNumber(number);
        int[] array = new int[capacityArray];
        for (int i = number, k = 0; i < capacityArray; i++) {
            if (i == 0) {
                continue;
            }
            if (number % i == 0) {
                array[k++] = i;
            }
        }
        int counter = countArrayLengthWithoutZero(capacityArray, array);
        return deleteAllZeroValueInArray(capacityArray, array, counter);
    }

    private int[] deleteAllZeroValueInArray(int capacityArray, int[] arrayInt, int counter) {
        int[] copyArray = new int[counter];
        for (int i = 0; i < capacityArray; i++) {
            if (arrayInt[i] != 0) {
                copyArray[i] = arrayInt[i];
            }
        }
        return copyArray;
    }

    private int countArrayLengthWithoutZero(int capacityArray, int[] arrayInt) {
        int counter = 0;
        for (int i = 0; i < capacityArray; i++) {
            if (arrayInt[i] != 0) {
                counter++;
            }
        }
        return counter;
    }

    int countArrayLengthByNegativeNumber(int number) {
        int capacityArray = 0;
        for (int i = number; i < 0; i++) {
            capacityArray++;
        }
        int finalCapacityArray = 0;
        for (int i = number; i <= capacityArray; i++) {
            finalCapacityArray++;
        }
        return finalCapacityArray;
    }

    private int[] addDivisorsByPositiveNumber(int number) {
        int capacityArray = arrayLengthByPositiveNumber(number);
        int[] arrayInt = new int[capacityArray];
        for (int i = 1, k = 0; i < number + 1; i++) {
            if (number % i == 0) {
                arrayInt[k++] = i;
            }
        }
        return arrayInt;
    }

    private int arrayLengthByPositiveNumber(int number) {
        int capacityArray = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                capacityArray++;
            }
        }
        return capacityArray;
    }
}
