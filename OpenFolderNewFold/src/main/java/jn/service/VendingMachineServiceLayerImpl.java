package jn.service;

import jn.dao.VendingMachineAuditDao;
import jn.dao.VendingMachineDao;
import jn.dao.VendingMachinePersistenceException;
import jn.dto.VendingMachineItem;
import jn.dao.VendingMachineDao;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer  {
    VendingMachineDao dao;
    VendingMachineAuditDao auditDao;
    Coins coins;

    public VendingMachineServiceLayerImpl(VendingMachineDao dao, VendingMachineAuditDao auditDao, Coins coins) {
        this.dao = dao;
        this.auditDao = auditDao;
        this.coins=coins;
    }

    @Override
    public List<VendingMachineItem> getAvailableItems() throws VendingMachinePersistenceException {
        return dao.getVendingMachineInventory();
    }

    @Override
    public BigDecimal buyItem(String name, BigDecimal inputCash) throws VendingMachinePersistenceException, InsufficientFundsException, NoItemInventoryException {
        if(dao.getVendingMachineItem(name)==null){
            throw new VendingMachinePersistenceException("Item not found");
        }else if(dao.getVendingMachineItem(name).getAmount()==0){
            throw new NoItemInventoryException("There is no "+ name+" inventory left");
        }
        else if(dao.getVendingMachineItem(name).getCost().compareTo(inputCash) > 0) {
            throw new InsufficientFundsException("You didn't enough insert enough");
        }
        VendingMachineItem boughtItem = dao.getVendingMachineItem(name);
        boughtItem.setAmount(boughtItem.getAmount() -1);
        dao.updateVendingMachineItem(name,boughtItem);
        BigDecimal outputCash = inputCash.subtract(boughtItem.getCost()).setScale(2, RoundingMode.HALF_UP);
        auditDao.writeAuditEntry("1 item sold. Stock updated for " +boughtItem.getName());
        return outputCash;
    }

    @Override
    public int[] giveChange(BigDecimal outputCash) {
        int outputCashInPennies = outputCash.multiply(BigDecimal.valueOf(100)).intValueExact();
        return coins.calculateCoins(outputCashInPennies);
    }
}