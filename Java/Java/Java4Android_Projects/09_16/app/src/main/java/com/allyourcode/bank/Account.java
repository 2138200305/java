package com.allyourcode.bank;

public class Account {
  public String customerName;
  private int internalIdNumber;
  String address;
  String phone;
  public int socialSecurityNumber;
  int accountType;
  double balance;

  public static int findById(int internalIdNumber) {
    Account foundAccount = new Account();
    // Code to find the account goes here.
    return foundAccount.internalIdNumber;
  }
}
