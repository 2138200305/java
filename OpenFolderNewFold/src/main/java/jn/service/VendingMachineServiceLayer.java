package jn.service;

import jn.dao.VendingMachinePersistenceException;
import jn.dao.VendingMachinePersistenceException;
import jn.dto.VendingMachineItem;

import java.math.BigDecimal;
import java.util.List;

public interface VendingMachineServiceLayer {

    public List<VendingMachineItem> getAvailableItems() throws VendingMachinePersistenceException;
    public BigDecimal buyItem(String name, BigDecimal inputCash) throws VendingMachinePersistenceException, InsufficientFundsException, NoItemInventoryException;
    public int[] giveChange(BigDecimal outputCash);
}