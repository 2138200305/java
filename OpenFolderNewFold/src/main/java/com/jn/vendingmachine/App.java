package com.jn.vendingmachine;

import com.jn.vendingmachine.controller.VendingMachineController;
import com.jn.vendingmachine.dao.*;
import com.jn.vendingmachine.service.*;
import com.jn.vendingmachine.ui.UserIO;
import com.jn.vendingmachine.ui.UserIOConsoleImpl;
import com.jn.vendingmachine.ui.VendingMachineView;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
    public static void main(String[] args) {

        ApplicationContext appContext
                = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        VendingMachineController controller = appContext.getBean("controller", VendingMachineController.class);
        controller.run();
    }
}