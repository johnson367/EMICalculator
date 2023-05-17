package com.brandonang.emicalculator;

import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.errors.YailRuntimeError;
import com.google.appinventor.components.runtime.util.YailList;

public class EMICalculator extends AndroidNonvisibleComponent {

  public EMICalculator(ComponentContainer container) {
    super(container.$form());
  }

  @SimpleFunction(description = "Calculate EMI for a loan")
  public double CalculateEMI(double principal, double interestRate, String timeInYear) {
  if (principal <= 0 || interestRate <= 0) {
    throw new YailRuntimeError("Invalid input. Principal and interest rate must be greater than 0.", "EMI Calculation Error");
  }
  
  double tenure = Double.parseDouble(timeInYear) * 12; // Convert years to months
  
  // Rest of the code remains the same
  double monthlyInterestRate = interestRate / (12 * 100);
  double numerator = principal * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, tenure);
  double denominator = Math.pow(1 + monthlyInterestRate, tenure) - 1;
  double emi = numerator / denominator;
  
  return emi;
  }
}