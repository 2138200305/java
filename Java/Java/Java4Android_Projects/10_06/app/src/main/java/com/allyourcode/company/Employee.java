package com.allyourcode.company;

public class Employee {
  public String name;
  public String jobTitle;

  public Employee() {
  }

  public Employee(String name, String jobTitle) {
    this.name = name;
    this.jobTitle = jobTitle;
  }

  public String getPayString() {
    return name + ", Pay not known\n";
  }
}
