package com.allyourcode.company;

import java.text.NumberFormat;
import java.util.Locale;

public class FullTimeEmployee extends Employee {
  public double salary;

  static NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);

  public FullTimeEmployee() {
  }

  public FullTimeEmployee(String name, String jobTitle, double salary) {
    this.name = name;
    this.jobTitle = jobTitle;
    this.salary = salary;
  }

  public double pay() {
    return salary;
  }

  @Override
  public String getPayString() {
    return name + ", " + currency.format(pay()) + "\n";
  }
}

