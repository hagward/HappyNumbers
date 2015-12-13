package se.kth.hagward;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class HappyNumberGeneratorTest {

    private static final int[] HAPPY_NUMBERS = new int[] {
            1, 7, 10, 13, 19, 23, 28, 31, 32, 44, 49, 68, 70, 79, 82, 86, 91, 94, 97, 100, 103, 109, 129, 130, 133, 139,
            167, 176, 188, 190, 192, 193, 203, 208, 219, 226, 230, 236, 239, 262, 263, 280, 291, 293, 301, 302, 310,
            313, 319, 320, 326, 329, 331, 338, 356, 362, 365, 367, 368, 376, 379, 383, 386, 391, 392, 397, 404, 409,
            440, 446, 464, 469, 478, 487, 490, 496, 536, 556, 563, 565, 566, 608, 617, 622, 623, 632, 635, 637, 638,
            644, 649, 653, 655, 656, 665, 671, 673, 680, 683, 694, 700, 709, 716, 736, 739, 748, 761, 763, 784, 790,
            793, 802, 806, 818, 820, 833, 836, 847, 860, 863, 874, 881, 888, 899, 901, 904, 907, 910, 912, 913, 921,
            923, 931, 932, 937, 940, 946, 964, 970, 973, 989, 998, 1000
    };

    @Test
    public void testIsHappy() {
        HappyNumberGenerator generator = new HappyNumberGenerator();

        // Check that the happy numbers are indeed happy.
        for (int happyNumber : HAPPY_NUMBERS) {
            Assert.assertTrue(generator.isHappy(happyNumber));
        }

        // Check that the numbers in-between the happy numbers really are unhappy.
        for (int i = 0; i < HAPPY_NUMBERS.length - 1; i++) {
            for (int unhappyNumber = HAPPY_NUMBERS[i] + 1; unhappyNumber < HAPPY_NUMBERS[i + 1]; unhappyNumber++) {
                Assert.assertFalse(generator.isHappy(unhappyNumber));
            }
        }
    }

    @Test
    public void testGetSquareDigitSum() {
        HappyNumberGenerator generator = new HappyNumberGenerator();

        Assert.assertEquals(0, generator.getSquareDigitSum(0));
        Assert.assertEquals(1, generator.getSquareDigitSum(1));

        Assert.assertEquals(810, generator.getSquareDigitSum(9999999999L));

        long digitSum = 1 + 4 + 9 + 16 + 25 + 36 + 49 + 64 + 81;
        Assert.assertEquals(digitSum, generator.getSquareDigitSum(123456789));
        Assert.assertEquals(digitSum, generator.getSquareDigitSum(1234567890));
        Assert.assertEquals(digitSum, generator.getSquareDigitSum(1234506789));
        Assert.assertEquals(digitSum, generator.getSquareDigitSum(123450678900000L));
        Assert.assertEquals(digitSum, generator.getSquareDigitSum(95873421600000L));
    }

    @Test
    public void testGetHappyNumbers() {
        HappyNumberGenerator generator = new HappyNumberGenerator();

        // Check that we receive all happy numbers between 1 and 1000 (both inclusive).
        List<Long> happyNumbers = new ArrayList<>();
        for (int happyNumber : HAPPY_NUMBERS) {
            happyNumbers.add((long) happyNumber);
        }
        Assert.assertEquals(happyNumbers, generator.getHappyNumbers(1000));
    }

}
