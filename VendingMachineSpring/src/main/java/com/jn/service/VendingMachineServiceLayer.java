package service;

import dao.VendingMachinePersistenceException;
import dto.VendingMachineItem;

import java.math.BigDecimal;
import java.util.List;

public interface VendingMachineServiceLayer {

    public List<VendingMachineItem> getAvailableItems() throws VendingMachinePersistenceException;
    public BigDecimal buyItem(String name, BigDecimal inputCash) throws VendingMachinePersistenceException, InsufficientFundsException, NoItemInventoryException;
    public int[] giveChange(BigDecimal outputCash);
}