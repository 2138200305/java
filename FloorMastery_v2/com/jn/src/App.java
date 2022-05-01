package com.jn.src;

import dao.StateNotServicedException;
import dao.FlooringMasteryPersistenceException;
import dao.FlooringMasteryEmptyInputException;
import dao.DateValidationException;
import java.util.List;

public class App {
    public static void main(String[] args) throws FlooringMasteryPersistenceException,
            FlooringMasteryEmptyInputException, DateValidationException, FlooringMasteryEmptyInputException {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("com.jn.src");
        appContext.refresh();

        FlooringMasteryController controller = appContext.getBean("flooringMasteryController",
                FlooringMasteryController.class);
        controller.run();
    }
}