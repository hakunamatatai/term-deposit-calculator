package com.ferocia.service;

import com.ferocia.model.TermDepositInput;
import com.ferocia.Enum.InterestPaymentType;

/**
 * @description: term deposit calculator
 * @date: 07/31/2025
 * @author: evie chen
 */
public class TermDepositCalculator {

    public double calculateDepositBalance(TermDepositInput input) {
        double p = input.getStartDepositAmount();
        double r = input.getInterestRate();
        int t = input.getInvestmentTerm();

        InterestPaymentType paymentType = input.getInterestPaymentType();
        if (paymentType == null) {
            throw new IllegalArgumentException("Interest payment type must not be null.");
        }

        switch (input.getInterestPaymentType()) {
            case MONTHLY:
                int month = InterestPaymentType.MONTHLY.getTimeCount();
                return round(calPeriodicInterest(p, r, t, month));
            case QUARTERLY:
                int quarter = InterestPaymentType.QUARTERLY.getTimeCount();
                return round(calPeriodicInterest(p, r, t, quarter));
            case ANNUALLY:
                int year = InterestPaymentType.ANNUALLY.getTimeCount();
                return round(calPeriodicInterest(p, r, t, year));
            case AT_MATURITY:
                return round(calMaturityInterest(p, r, t));
            default:
                throw new IllegalArgumentException("Unsupported payment frequency.");
        }
    }

    /**
     * equation for monthly/quarterly/annually: A = P × (1 + r / n) ^ nt
     */
    private double calPeriodicInterest(double p, double r, int t, int time) {
        return p * Math.pow(1 + r / time, time * t);
    }

    /**
     * equation for maturity: A = P × (1 + r * t)
     */
    private double calMaturityInterest(double p, double r, int t) {
        return p * (1 + r * t);
    }

    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

}
