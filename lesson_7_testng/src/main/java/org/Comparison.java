package org;

public class Comparison {
    public static String comparison(int a, int b) {
        if (a > b) {
            return "a > b";
        } else if (a < b) {
            return "a < b";
        } else {
            return "a == b";
        }
    }
}