package dao;


// import dao.DateValidationException;
// import dao.FlooringMasteryEmptyInputException;
// import dao.FlooringMasteryPersistenceException;
// import dao.DateValidationException;

// import java.util.List;

// import org.springframework.context.annotation.AnnotationConfigApplicationContext;
// import controller.FlooringMasteryController;





public class FlooringMasteryPersistenceException extends Exception {

    public FlooringMasteryPersistenceException(String message){
        super(message);
    }
    public FlooringMasteryPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

}