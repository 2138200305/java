package service;

import java.math.BigDecimal;
import java.util.List;

import dao.DateValidationException;
import dao.FlooringMasteryEmptyInputException;
import dto.Order;

public interface FlooringMasteryServiceLayer {

    public List<Order> getAllOrders() throws FlooringMasteryPersistenceException;
    public BigDecimal placeOrder(String name, BigDecimal inputCash) throws FlooringMasteryPersistenceException, StateNotServicedException, DateValidationException, FlooringMasteryEmptyInputException;
    public int[] giveChange(BigDecimal outputCash);
}