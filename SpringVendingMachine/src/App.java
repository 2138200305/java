import controller.VendingMachineController;
import dao.*;
import service.*;
import ui.UserIO;
import ui.UserIOConsoleImpl;
import ui.VendingMachineView;

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
        //SpringVendingMachine
    }
}