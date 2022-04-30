package com.allyourcode.bank;

public class UseAccount {

  Account account = new Account();

  {
    account.customerName = "William of Occam";
    String nameBackup = account.customerName;
    account.address = "Ockham, Borough of Guildford, Surrey, England.";
    account.internalIdNumber = 716010;  // ERROR !!!!



  }

}



