package com.ferocia.validator;

public class InputValidator {
    public static boolean isValidPositiveDouble(String s) {
        try {
            double d = Double.parseDouble(s);
            return d > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidPositiveInt(String s) {
        try {
            int i = Integer.parseInt(s);
            return i > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
