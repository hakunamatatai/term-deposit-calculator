package com.ferocia.service;

import com.ferocia.Enum.InterestPaymentType;
import com.ferocia.model.TermDepositInput;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TermDepositCalculatorTest {

    @Test
    void testZeroTerm() {
        TermDepositInput input = new TermDepositInput(
                10000,
                0.011,
                0,
                InterestPaymentType.ANNUALLY
        );
        double result = new TermDepositCalculator().calculateDepositBalance(input);
        assertEquals(10000.00, result, 0.01);
    }

    @Test
    void testMonthlyInterest() {
        TermDepositInput input = new TermDepositInput(
                10000,
                0.011,
                3,
                InterestPaymentType.MONTHLY
        );
        double result = new TermDepositCalculator().calculateDepositBalance(input);
        assertEquals(10335.35, result, 0.01);
    }

    @Test
    void testQuarterlyInterest() {
        TermDepositInput input = new TermDepositInput(
                10000,
                0.011,
                3,
                InterestPaymentType.QUARTERLY
        );
        double result = new TermDepositCalculator().calculateDepositBalance(input);
        assertEquals(10335.04, result, 0.01);
    }

    @Test
    void testAnnuallyInterest() {
        TermDepositInput input = new TermDepositInput(
                10000,
                0.011,
                3,
                InterestPaymentType.ANNUALLY
        );
        double result = new TermDepositCalculator().calculateDepositBalance(input);
        assertEquals(10333.64, result, 0.01);
    }

    @Test
    void testAtMaturityInterest() {
        TermDepositInput input = new TermDepositInput(
                10000,
                0.011,
                3,
                InterestPaymentType.AT_MATURITY
        );
        double result = new TermDepositCalculator().calculateDepositBalance(input);
        assertEquals(10330.00, result, 0.01);
    }

    @Test
    void testIllegalPaymentType() {
        TermDepositInput input = new TermDepositInput(
                10_000,
                0.011,
                3,
                null
        );
        assertThrows(IllegalArgumentException.class, () ->
                new TermDepositCalculator().calculateDepositBalance(input)
        );
    }

}
