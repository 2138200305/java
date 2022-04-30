package com.allyourcode.company;

import java.text.NumberFormat;
import java.util.Locale;

public class PartTimeEmployee extends Employee {
  public double hourlyPay;
  public int hoursWorked;

  static NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);

  public PartTimeEmployee() {
  }

  public PartTimeEmployee(String name, String jobTitle,
                          double hourlyPay, int hoursWorked) {
    this.name = name;
    this.jobTitle = jobTitle;
    this.hourlyPay = hourlyPay;
    this.hoursWorked = hoursWorked;
  }

  public double pay() {
    return hourlyPay * hoursWorked;
  }

  @Override
  public String getPayString() {
    return name + ", " + currency.format(pay()) + "\n";
  }
}
