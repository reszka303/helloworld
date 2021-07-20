package pl.javastart.DMVCPattern_4.lottery.byMe;

import java.util.*;
import java.util.stream.Collectors;

public class LotteryManager {
    static List<Integer> lottery() {
        List<Integer> lotteryNumbers =  new Random().ints(6,1,50)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(lotteryNumbers);
        return lotteryNumbers;
    }

    static List<Integer> checkIfVoucherContainsTheSameNumbers(Collection<Integer> lotteryResult, Collection<Integer> playerVoucher) {
        return lotteryResult.stream()
                .filter(playerVoucher::contains)
                .collect(Collectors.toList());
    }

    static boolean checkEqualElements(String[] numbers) {
        int capacity = numbers.length;
        for (int i = 0; i < capacity; i++) {
            for (int j = i + 1; j < capacity; j++) {
                if (numbers[i].equals(numbers[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    static List<Integer> convertToListInteger(String [] numbers) {
        return Arrays.stream(numbers)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}
