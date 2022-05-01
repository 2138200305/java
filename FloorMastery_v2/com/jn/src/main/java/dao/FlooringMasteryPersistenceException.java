package dao;


import dao.DateValidationException;
import dao.FlooringMasteryEmptyInputException;
import dao.FlooringMasteryPersistenceException;
import dao.

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import controller.FlooringMasteryController;




public class FlooringMasteryPersistenceException {
    public static void main(String[] args) throws FlooringMasteryPersistenceException, FlooringMasteryEmptyInputException {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("com.jn.src.");
        appContext.refresh();

        FlooringMasteryController controller = appContext.getBean("flooringMasteryController", FlooringMasteryController.class);
        controller.run();
    }
 }