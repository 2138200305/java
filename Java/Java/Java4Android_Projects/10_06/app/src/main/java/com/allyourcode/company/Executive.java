package com.allyourcode.company;

public class Executive extends FullTimeEmployee {
  public double bonus;

  public Executive() {
  }

  public Executive(String name, String jobTitle, double salary, double bonus) {
    this.name = name;
    this.jobTitle = jobTitle;
    this.salary = salary;
    this.bonus = bonus;
  }

  @Override
  public double pay() {
    return salary + bonus;
  }
}
