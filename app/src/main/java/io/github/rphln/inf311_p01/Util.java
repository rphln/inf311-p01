package io.github.rphln.inf311_p01;

import java.text.DecimalFormat;

public final class Util {
    public static String formatNumber(Double number) {
        // Removes trailing zeroes. See: <https://stackoverflow.com/a/25308216>
        DecimalFormat format = new DecimalFormat("0");
        format.setMaximumFractionDigits(4);

        return format.format(number);
    }
}
