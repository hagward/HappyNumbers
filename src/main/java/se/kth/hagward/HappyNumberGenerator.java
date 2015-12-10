package se.kth.hagward;

import java.util.HashSet;
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

}
