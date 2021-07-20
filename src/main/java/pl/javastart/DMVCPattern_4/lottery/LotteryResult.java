package pl.javastart.DMVCPattern_4.lottery;

import java.util.List;

public class LotteryResult {
    private List<Integer> lotteryNumbers;
    private List<Integer> playerNumbers;
    private List<Integer> hitNumbers;

    public LotteryResult(List<Integer> lotteryNumbers, List<Integer> playerNumbers, List<Integer> hitNumbers) {
        this.lotteryNumbers = lotteryNumbers;
        this.playerNumbers = playerNumbers;
        this.hitNumbers = hitNumbers;
    }

    public List<Integer> getLotteryNumbers() {
        return lotteryNumbers;
    }

    public List<Integer> getPlayerNumbers() {
        return playerNumbers;
    }

    public List<Integer> getHitNumbers() {
        return hitNumbers;
    }
}
