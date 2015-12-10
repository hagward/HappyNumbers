package se.kth.hagward;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Class for generating happy numbers (https://en.wikipedia.org/wiki/Happy_number).
 */
public class HappyNumberGenerator {

    /**
     * Checks if a number is happy.
     * @param n the number to check for happiness
     * @return <code>true</code> if <code>n</code> is happy; <code>false</code> otherwise
     */
    public boolean isHappy(long n) {
        Set<Long> viewedNumbers = new HashSet<>();
        long currentNumber = n;
        while (currentNumber != 1 && !viewedNumbers.contains(currentNumber)) {
            viewedNumbers.add(currentNumber);
            currentNumber = getSquareDigitSum(currentNumber);
        }
        return currentNumber == 1;
    }

    /**
     * Calculates and returns the sum of the squared digits of a number.
     * @param n the number to calculate the sum for
     * @return the sum of the squared digits of <code>n</code>
     */
    public long getSquareDigitSum(long n) {
        long digitSum = 0;
        char[] charDigits = String.valueOf(n).toCharArray();
        for (char charDigit : charDigits) {
            digitSum += Math.pow('0' - charDigit, 2);
        }
        return digitSum;
    }

    /**
     * Returns a list of all the happy numbers from 1 to <code>upTo</code> (inclusive).
     * @param upTo the number to find happy numbers up to (inclusive)
     * @return a list of all the happy numbers from 1 to <code>upTo</code> (inclusive)
     */
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
