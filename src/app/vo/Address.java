
package app.aggregate;

import app.vo.*;
import java.util.*;

enum OrderStatus { NEW, CONFIRMED, SHIPPED, DELIVERED }

public class Order {
    private final UUID id = UUID.randomUUID();
    private final List<OrderItemDetails> items = new ArrayList<>();
    private OrderStatus status = OrderStatus.NEW;
    private Address shippingAddress;

    public Order(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public void addItem(OrderItemDetails item) {
        if (status != OrderStatus.NEW) throw new IllegalStateException("Cannot modify order");
        items.add(item);
    }
}

public class Customer {
    private final UUID id = UUID.randomUUID();
    private final String name;
    private Address address;
    private final List<Order> orders = new ArrayList<>();

    public Customer(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }
}

public class Product {
    private final UUID id = UUID.randomUUID();
    private final ProductDetails details;
    private Money price;
    private int stock;

    public Product(ProductDetails details, Money price, int stock) {
        this.details = details;
        this.price = price;
        this.stock = stock;
    }

    public boolean isAvailable(int quantity) {
        return stock >= quantity;
    }
}
