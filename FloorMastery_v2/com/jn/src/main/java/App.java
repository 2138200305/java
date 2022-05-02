import controller.FlooringMasteryController;
import dao.StateNotServicedException;
import dao.FlooringMasteryPersistenceException;
import dao.FlooringMasteryEmptyInputException;
import dao.DateValidationException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App {
    public static void main(String[] args) throws FlooringMasteryPersistenceException,
            DateValidationException, FlooringMasteryEmptyInputException,StateNotServicedException {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("com.jn.src");
        appContext.refresh();

        FlooringMasteryController controller = appContext.getBean("flooringMasteryController",
                FlooringMasteryController.class);
        controller.run();
    }
}