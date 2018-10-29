package com.epam.engx.cleancode.comments.task1;

import com.epam.engx.cleancode.comments.task1.thirdpartyjar.InvalidInputException;

public class MortgageInstallmentCalculator {

    public static double calculateMonthlyPayment(
            int principalAmount, int termOfMortgageInYears, double rateOfInterest) {


        if (principalAmount < 0 || termOfMortgageInYears <= 0 ||  rateOfInterest < 0) {
            throw new InvalidInputException("Negative values are not allowed");
        }


        rateOfInterest /= 100.0;


        double termInMonths= termOfMortgageInYears * 12;


        if(rateOfInterest==0)
            return  principalAmount/termInMonths;


        double monthlyRate = rateOfInterest / 12.0;


        // The Math.pow() method is used calculate values raised to a power
        double monthlyPayment = (principalAmount * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -termInMonths));

        return monthlyPayment;
    }
}
