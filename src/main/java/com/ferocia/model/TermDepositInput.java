package com.ferocia.model;

import com.ferocia.Enum.InterestPaymentType;

public class TermDepositInput {

    private double startDepositAmount;

    private double interestRate;

    private int investmentTerm;

    private InterestPaymentType interestPaymentType;


    public TermDepositInput(double startDepositAmount, double interestRate, int investmentTerm,
                            InterestPaymentType interestPaymentType) {
        this.startDepositAmount = startDepositAmount;
        this.interestRate = interestRate;
        this.investmentTerm = investmentTerm;
        this.interestPaymentType = interestPaymentType;
    }

    public double getStartDepositAmount() {
        return startDepositAmount;
    }

    public void setStartDepositAmount(double startDepositAmount) {
        this.startDepositAmount = startDepositAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getInvestmentTerm() {
        return investmentTerm;
    }

    public void setInvestmentTerm(int investmentTerm) {
        this.investmentTerm = investmentTerm;
    }

    public InterestPaymentType getInterestPaymentType() {
        return interestPaymentType;
    }

    public void setInterestPaymentType(InterestPaymentType interestPaymentType) {
        this.interestPaymentType = interestPaymentType;
    }
}
