package dao;


import dto.VendingMachineItem;

import java.util.List;

public interface VendingMachineDao {
    List<VendingMachineItem> getVendingMachineInventory() throws VendingMachinePersistenceException;

    VendingMachineItem getVendingMachineItem(String name) throws VendingMachinePersistenceException;

    void updateVendingMachineItem(String name, VendingMachineItem item) throws VendingMachinePersistenceException;

}


