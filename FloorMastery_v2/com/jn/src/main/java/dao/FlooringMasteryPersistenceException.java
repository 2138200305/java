package dao;


// import dao.DateValidationException;
// import dao.FlooringMasteryEmptyInputException;
// import dao.FlooringMasteryPersistenceException;
// import dao.DateValidationException;

// import java.util.List;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import controller.FlooringMasteryController;




public class FlooringMasteryPersistenceException extends Exception {
    public static void main(String[] args) throws FlooringMasteryPersistenceException, StateNotServicedException, DateValidationException,
    FlooringMasteryEmptyInputException {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("com.jn.src.");
        appContext.refresh();
        appContext.close(); 
        //https://stackoverflow.com/questions/14184059/spring-applicationcontext-resource-leak-context-is-never-closed

        FlooringMasteryController controller = appContext.getBean("flooringMasteryController", FlooringMasteryController.class);
        controller.run();
    }
 }