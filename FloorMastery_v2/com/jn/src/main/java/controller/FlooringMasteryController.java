package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dao.DateValidationException;
import dao.FlooringMasteryEmptyInputException;
import dao.StateNotServicedException;
import dao.FlooringMasteryPersistenceException;
import service.FlooringMasteryServiceLayer;
import ui.FlooringMasteryView;


import java.math.BigDecimal;
import java.math.RoundingMode;



@Component
public class FlooringMasteryController {
    private FlooringMasteryView view;
    private FlooringMasteryServiceLayer service;

    @Autowired
    public FlooringMasteryController(FlooringMasteryView view, FlooringMasteryServiceLayer service) {
        this.view = view;
        this.service = service;
    }

    public void run() throws FlooringMasteryPersistenceException, StateNotServicedException, DateValidationException, FlooringMasteryEmptyInputException
    {
        Boolean keepGoing =true;
        int menuSelection = 0;
        try {
            while (keepGoing) {
                menuSelection = getMenuSelection();
                switch (menuSelection) {
                    case 1:
                        notCompleted();
                        break;

                    case 2:
                        notCompleted();
                        break;

                    case 3:
                        notCompleted();
                        break;

                    case 4:
                        notCompleted();
                        break;

                    case 5:
                        notCompleted();
                        break;

                    case 6:
                        notCompleted();
                        break;

                    default:
                        unknownCmd();
                }
            }
            exitMsg();
        } catch (DateValidationException | FlooringMasteryEmptyInputException | FlooringMasteryPersistenceException
                | StateNotServicedException e)
        {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void exitMsg() {
        view.displayMenuBanner();
    }

    private int getMenuSelection() {
        return 0;
    }

    public void unknownCmd() {
        view.unknownCmd();
    }

    public void notCompleted() throws DateValidationException, FlooringMasteryEmptyInputException, FlooringMasteryPersistenceException, StateNotServicedException {
        System.out.println("Not completed");
    }

}