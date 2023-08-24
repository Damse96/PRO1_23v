package model;

import java.lang.reflect.Array;
import java.util.Random;
import java.util.UnknownFormatConversionException;

public class YatzyDice {
    // Face values of the 5 dice.
    // 1 <= values[i] <= 6 for i in [0..4]
    private int[] values = new int[5];

    // Number of times the 5 dice have been thrown.
    // 0 <= throwCount <= 3.
    private int throwCount = 0;

    // Random number generator.
    private final Random random = new Random();

    /**
     * Return the 5 face values of the dice.
     */
    public int[] getValues() {
        return values;
    }

    /**
     * Set the 5 face values of the dice.<br/>
     * Pre: 1 <= values[i] <= 6 for i in [0..4].<br/>
     * Note: This method is only to be used in tests.
     */
    void setValues(int[] values) {
        this.values = values;
    }

    /**
     * Return the number of times the 5 dice has been thrown.
     */
    public int getThrowCount() {
        return throwCount;
    }

    /**
     * Reset the throw count.
     */
    public void resetThrowCount() {
        throwCount = 0;
    }

    /**
     * Roll the 5 dice. Only roll dice that are not hold.<br/>
     * Note: holdStatus[index] is true, if die no. index is hold (for index in [0..4]).
     */
    public void throwDice(boolean[] holdStatus) {
        for (int i = 0; i < values.length; i++) {
            if (!holdStatus[i]) {
                values[i] = random.nextInt(1, 6);
            }

        }
        throwCount++;
    }

    // -------------------------------------------------------------------------

    /**
     * Return all results possible with the current face values.<br/>
     * The order of the results is the same as on the score board.<br/>
     * Note: This is an optional method. Comment this method out,<br/>
     * if you don't want use it.
     */
    public int[] getResults() {
        int[] results = new int[15];
        for (int i = 0; i <= 5; i++) {
            results[i] = this.sameValuePoints(i + 1);
        }
        results[6] = this.onePairPoints();
        results[7] = this.twoPairPoints();
        results[8] = this.threeSamePoints();
        results[9] = this.fourSamePoints();
        results[10] = this.fullHousePoints();
        results[11] = this.smallStraightPoints();
        results[12] = this.largeStraightPoints();
        results[13] = this.chancePoints();
        results[14] = this.yatzyPoints();

        return results;
    }

    // -------------------------------------------------------------------------

    // Return an int[7] containing the frequency of face values.
    // Frequency at index v is the number of dice with the face value v, 1 <= v <= 6.
    // Index 0 is not used.
    // Note: This method can be used in several of the following methods.
    private int[] frequency() {
        int[] frequency = new int[7];
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            frequency[value]++;

        }
        return frequency;
    }

    /**
     * Return same-value points for the given face value.<br/>
     * Returns 0, if no dice has the given face value.<br/>
     * Pre: 1 <= value <= 6;
     */
    public int sameValuePoints(int value) {
        int freq[] = frequency();
        int count = freq[value];
        int points = count * value;
        return points;
    }

    /**
     * Return points for one pair (for the face value giving the highest points).<br/>
     * Return 0, if there aren't 2 dice with the same face value.
     */
    public int onePairPoints() {
        int[] freq = frequency();
        int sum = 0;
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] >= 2) {
                sum = i * 2;
            }
        }
        return sum;
    }


    /**
     * Return points for two pairs<br/>
     * (for the 2 face values giving the highest points).<br/>
     * Return 0, if there aren't 2 dice with the same face value<br/>
     * and 2 other dice with the same but different face value.
     */
    public int twoPairPoints() {
        int[] freq = frequency();
        int sum = 0;
        int tempSum = 0;
        int tempPlace = 0;
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] >= 2) {
                tempSum = 2 * i;
                tempPlace = i;
            }
        }
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] >= 2 && tempPlace != i) {
                sum = 2 * i + tempSum;
            }
        }
        return sum;
    }

    /**
     * Return points for 3 of a kind.<br/>
     * Return 0, if there aren't 3 dice with the same face value.
     */
    public int threeSamePoints() {
        int[] freq = frequency();
        int sum = 0;
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] >= 3) {
                sum = i * 3;
            }
        }
        return sum;
    }

    /**
     * Return points for 4 of a kind.<br/>
     * Return 0, if there aren't 4 dice with the same face value.
     */
    public int fourSamePoints() {
        int[] freq = frequency();
        int sum = 0;
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] >= 4) {
                sum = i * 4;
            }
        }
        return sum;
    }


    /**
     * Return points for full house.<br/>
     * Return 0, if there aren't 3 dice with the same face value<br/>
     * and 2 other dice with the same but different face value.
     */
    public int fullHousePoints() {
        int[] freq = frequency();
        int fullHouse1 = 0;
        int fullHouse2 = 0;
        int fullHouse3 = 0;
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] == 3) {
                fullHouse3 = i * 3;
            }
            for (int j = 1; j < freq.length; j++) {
                if (freq[j] == 2)
                    fullHouse2 = j * 2;
            }
            if (fullHouse3 > 0 && fullHouse2 > 0) {
                fullHouse1 = fullHouse3 + fullHouse2;
            }
        }
        return fullHouse1;

    }

    /**
     * Return points for small straight.<br/>
     * Return 0, if the dice aren't showing 1,2,3,4,5.
     */
    public int smallStraightPoints() {
        int[] freq = frequency();
        int smallS = 0;
        int sum = 0;
        for (int i = 1; i < freq.length - 1; i++) {
            if (freq[i] == 1) {
                for (int j = 0; j < values.length; j++) {
                    if (values[j] <= 5) {
                        sum += values[j];
                    }
                }
            }
            if (sum == 15) {
                smallS = 15;
            }
        }
        return smallS;
    }

    /**
     * Return points for large straight.<br/>
     * Return 0, if the dice aren't showing 2,3,4,5,6.
     */
    public int largeStraightPoints() {
        int[] freq = frequency();
        int bigS = 0;
        int sum = 0;
        for (int i = 2; i < freq.length; i++) {
            if (freq[i] == 1) {
                for (int j = 0; j < values.length; j++) {
                    if (values[j] <= 6) {
                        sum += values[j];
                    }
                }
            }
            if (sum == 20) {
                bigS = 20;
            }
        }
        return bigS;
    }

    /**
     * Return points for chance (the sum of face values).
     */
    public int chancePoints() {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum;
    }

    /**
     * Return points for yatzy (50 points).<br/>
     * Return 0, if there aren't 5 dice with the same face value.
     */
    public int yatzyPoints() {
        int[] temp = frequency();
        int sum = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 5) {
                sum = 50;
            }
        }
        return sum;
    }
}
