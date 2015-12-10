package se.kth.hagward;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Class for generating happy numbers (https://en.wikipedia.org/wiki/Happy_number).
 */
public class HappyNumberGenerator {

    public boolean isHappy(long n) {
        Set<Long> viewedNumbers = new HashSet<>();
        long currentNumber = n;
        while (currentNumber != 1 && !viewedNumbers.contains(currentNumber)) {
            viewedNumbers.add(currentNumber);
            currentNumber = getSquareDigitSum(currentNumber);
        }
        return currentNumber == 1;
    }

    public long getSquareDigitSum(long n) {
        long digitSum = 0;
        char[] charDigits = String.valueOf(n).toCharArray();
        for (char charDigit : charDigits) {
            digitSum += Math.pow('0' - charDigit, 2);
        }
        return digitSum;
    }

    public List<Long> getHappyNumbers(long upTo) {
        List<Long> happyNumbers = new ArrayList<>();
        for (long i = 1; i <= upTo; i++) {
            if (isHappy(i)) {
                happyNumbers.add(i);
            }
        }
        return happyNumbers;
    }

}
