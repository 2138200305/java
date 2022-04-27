package jn.service;

public class Coins {
    public enum coins{
        QUARTERS(25),
        DIMES(10),
        NICKELS(5),
        PENNIES(1);


        private final int value;
        private coins(int value){
            this.value = value;
        }
    }
    public int[] calculateCoins(int pennies){
        int[] changeInCoins= new int[4];
        changeInCoins[0] = pennies/coins.QUARTERS.value;
        pennies = pennies - (changeInCoins[0]* coins.QUARTERS.value);
        changeInCoins[1] = pennies/coins.DIMES.value;
        pennies =pennies - (changeInCoins[1]*coins.DIMES.value);
        changeInCoins[2]= pennies/coins.NICKELS.value;
        pennies=pennies -(changeInCoins[2] *coins.NICKELS.value);
        changeInCoins[3]= pennies;
        return changeInCoins;
    }


}