package controller;

import java.math.BigDecimal;
import java.math.RoundingMode;

import dao.VendingMachinePersistenceException;
import service.InsufficientFundsException;
import service.NoItemInventoryException;
import service.VendingMachineServiceLayer;
import ui.UserIO;
import ui.UserIOConsoleImpl;
import ui.VendingMachineView;
/**
 *
 * @author User
 */
public class VendingMachineController {
    private VendingMachineView view;
    private VendingMachineServiceLayer service;

    public VendingMachineController(VendingMachineView view, VendingMachineServiceLayer service) {
        this.view = view;
        this.service = service;
    }

    public void run() throws NoItemInventoryException, VendingMachinePersistenceException, InsufficientFundsException {
        BigDecimal currentMoney=new BigDecimal(0);
        boolean keepGoing = true;
        int menuSelection = 0;
        try{
            while(keepGoing){
                showMenu(currentMoney);
                menuSelection=getMenuSelection();
                switch (menuSelection){
                    case 1:
                        currentMoney = buyProduct(currentMoney);
                        break;
                    case 2:
                        currentMoney = userMoney(currentMoney);
                        break;
                    case 3:
                        requestToExit(currentMoney);
                        keepGoing=false;
                        break;
                    default:
                        unknownCmd();
                }
            }
            exitMsg();
        }catch (NoItemInventoryException  | VendingMachinePersistenceException | InsufficientFundsException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    public BigDecimal userMoney(BigDecimal money){
        money=money.add(view.getUserMoney().setScale(2, RoundingMode.HALF_UP));
        return money;
    }

    public void showMenu(BigDecimal currentMoney) throws VendingMachinePersistenceException {
        view.displayMenuBanner();
        view.displayItemsList(service.getAvailableItems());
        view.displayCurrentMoney(currentMoney);
    }

    public int getMenuSelection() {
        int selection = view.printMenuAndGetSelection();
        return selection;
    }

    public BigDecimal buyProduct(BigDecimal currentMoney) throws NoItemInventoryException, VendingMachinePersistenceException, InsufficientFundsException {
        view.displayPurchaseBanner();
        try {
            String productChoice = view.buyAproduct();
            currentMoney = service.buyItem(productChoice, currentMoney);
            view.thankYou(productChoice);
        }catch(NoItemInventoryException| VendingMachinePersistenceException|InsufficientFundsException e)
        {
            view.displayErrorMessage(e.getMessage());
        }
        return currentMoney;

    }
    public void requestToExit(BigDecimal currentmoney){
        int[] changeInCoinsArr = service.giveChange(currentmoney);
        view.displayReturnedMoney(changeInCoinsArr);
    }
    public void unknownCmd(){
        view.unknownCommand();
    }
    public void exitMsg(){
        view.displayExitBanner();
    }
}
