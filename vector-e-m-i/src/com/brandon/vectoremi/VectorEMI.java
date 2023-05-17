package com.brandon.vectoremi;

import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.errors.YailRuntimeError;
import com.google.appinventor.components.runtime.EventDispatcher;

public class VectorEMI extends AndroidNonvisibleComponent {
  private int vectorCount = 0;

  public VectorEMI(ComponentContainer container) {
    super(container.$form());
  }

    @SimpleFunction(description = "Adds two vectors together.")
    public double AddVectors(double x1, double y1, double x2, double y2) {
        return x1 + x2 + y1 + y2;
    }

    @SimpleFunction(description = "Subtracts one vector from another.")
    public double SubtractVectors(double x1, double y1, double x2, double y2) {
        return x1 - x2 + y1 - y2;
    }

    @SimpleFunction(description = "Calculates the dot product of two vectors.")
    public double DotProduct(double x1, double y1, double x2, double y2) {
        return x1 * x2 + y1 * y2;
    }

    @SimpleFunction(description = "Calculates the magnitude of a vector.")
    public double VectorMagnitude(double x, double y) {
        return Math.sqrt(x * x + y * y);
    }

    @SimpleEvent(description = "Fires when a vector calculation is completed.")
    public void VectorCalculationComplete(double result) {
        EventDispatcher.dispatchEvent(this, "VectorCalculationComplete", result);
    }

    @SimpleEvent(description = "Fires when an error occurs during a vector calculation.")
    public void VectorCalculationError(String errorMessage) {
        EventDispatcher.dispatchEvent(this, "VectorCalculationError", errorMessage);
    }

    @SimpleProperty(description = "Gets or sets the number of vectors used in calculations.")
    public int VectorCount() {
        return vectorCount;
    }

    @SimpleProperty(description = "Gets or sets the number of vectors used in calculations.")
    public void VectorCount(int count) {
        vectorCount = count;
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