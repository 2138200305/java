package com.allmycode.bank;

import com.allyourcode.bank.Account;

public class UseAccountFromOutside {

  Account account = new Account();

  {
    account.customerName = "William of Occam";
    String nameBackup = account.customerName;
    account.address = "Ockham, Borough of Guildford, Surrey, England."; // ERROR!!!




    account.internalIdNumber = 716010; // ERROR !!!!
  }

}


