package ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FlooringMasteryView {

    private UserIO io;

    @Autowired
    public FlooringMasteryView(UserIO io) {
        this.io = io;
    }

    public void displayMenuBanner() {
        io.print("<<Flooring Program>>");
    }

    public int printMenuAndGetSelection() {
        io.print("1. Display Orders");
        io.print("2. Add an Order");
        io.print("3. Edit an Order");
        io.print("4. Remove an Order");
        io.print("5. Export All Data");
        io.print("6. Quit");

        return io.readInt("Please select from the list above", 1, 3);
    }

    public void unknownCmd() {
        io.print("Unknown Comand!");
    }

}