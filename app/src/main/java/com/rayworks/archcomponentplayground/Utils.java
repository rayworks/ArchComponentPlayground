package com.rayworks.archcomponentplayground;

import java.util.Locale;
import java.util.Random;

/**
 * Created by Sean on 1/30/18.
 */

public final class Utils {
    private static Random random = new Random();

    public static boolean isRandomOdd() {
        return random.nextInt() % 2 == 0;
    }

    public static String getFormatScoreInfo(int scoreA, int scoreB) {
        return String.format(Locale.ENGLISH, "TeamA: %d | TeamB: %d",
                scoreA, scoreB);
    }
}
