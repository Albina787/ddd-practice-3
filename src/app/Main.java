package app;


import app.aggregate.*;
import app.vo.*;


public class Main {
public static void main(String[] args) {
Address address = new Address("Ukraine", "Lviv", "Shevchenka 1", "79000");
Customer customer = new Customer("Albina Hasan", address);


Order order = new Order(address);
customer.addOrder(order);


System.out.println("Order created successfully");
}
}
