package jn;

import jn.controller.VendingMachineController;
import jn.dao.*;
import jn.ui.UserIO;
import jn.service.*;
import jn.ui.UserIO;
import jn.ui.UserIOConsoleImpl;
import jn.ui.VendingMachineView;

public class App {
    public static void main(String[] args) throws NoItemInventoryException, VendingMachinePersistenceException, InsufficientFundsException {
        UserIO io = new UserIOConsoleImpl();
        Coins coins = new Coins();

        VendingMachineAuditDao auditDao = new VendingMachineAuditDaoFileImpl();
        VendingMachineDao dao = new VendingMachineDaoFileImpl();
        VendingMachineServiceLayer service = new VendingMachineServiceLayerImpl(dao,auditDao, coins);
        VendingMachineView view = new VendingMachineView(io);


        VendingMachineController controller = new VendingMachineController(view,service);
        controller.run();
    }
}