package com.jn.vendingmachine.ui;

import com.jn.vendingmachine.dto.VendingMachineItem;

import java.math.BigDecimal;
import java.util.List;

public class VendingMachineView {

    private UserIO io;

    public VendingMachineView (UserIO io){
        this.io = io;
    }

    public BigDecimal  getUserMoney(){
        BigDecimal userMoney= null;
        userMoney = io.readBigDecimal("Please enter your cash amount");
        return userMoney;
    }

    public void thankYou(String name){
        io.print("Thank you for purchasing " + name);
    }

    public void displayCurrentMoney(BigDecimal currentMoney){
        io.print("You currently have $" +currentMoney+ " available");
    }

    public void displayMenuBanner() {
        io.print("=== Menu ===");
    }
    public void displayPurchaseBanner() {
        io.print("=== Buy a product ===");
    }

    public String buyAproduct(){
        return io.readString("Select a product from the menu");
    }

    public void displayReturnedMoney(int[] changeAsCoins){
        io.print("Here is your change");
        io.print("Quarters returned: "+ changeAsCoins[0]);
        io.print("Dimes returned: " + changeAsCoins[1]);
        io.print("Nickels returned: " + changeAsCoins[2]);
        io.print("Pennies returned: " + changeAsCoins[3]);
    }

    public int printMenuAndGetSelection(){
        io.print("1  Buy a Product");
        io.print("2  Insert Money");
        io.print("3  Get Change and Exit");

        return io.readInt("Please select from the list above", 1, 3);
    }

    public void displayItemsList(List<VendingMachineItem> itemList){
        io.print("Here is the list of items available");
        itemList.stream().forEach((currentItem)-> {
            if(currentItem.getAmount()!= 0){
                String itemDetails = String.format("Name: %s Price: %s Stock: %s",
                        currentItem.getName(),
                        currentItem.getCost(),
                        currentItem.getAmount());
                io.print(itemDetails);
            }
            else{
                io.print("Not in stock");
            }
        });
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void welcomeMessage() {
        io.print("Welcome");
    }

    public void displayErrorMessage (String errorMsg) {
        io.print("=== Error ===");
        io.print(errorMsg);
    }

    public void unknownCommand() {
        io.print("Unknown Command!!!");
    }

}