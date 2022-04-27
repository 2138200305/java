package com.jn.vendingmachine.service;

import com.jn.vendingmachine.dao.VendingMachinePersistenceException;
import com.jn.vendingmachine.dto.VendingMachineItem;

import java.math.BigDecimal;
import java.util.List;

public interface VendingMachineServiceLayer {

    public List<VendingMachineItem> getAvailableItems() throws VendingMachinePersistenceException;
    public BigDecimal buyItem(String name, BigDecimal inputCash) throws VendingMachinePersistenceException, InsufficientFundsException, NoItemInventoryException;
    public int[] giveChange(BigDecimal outputCash);
}