package app.aggregate;

import app.vo.Address;
import app.vo.OrderItemDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {

    private final UUID id;
    private final List<OrderItemDetails> items;
    private Address shippingAddress;
    private OrderStatus status;

    public Order(Address shippingAddress) {
        this.id = UUID.randomUUID();
        this.items = new ArrayList<>();
        this.shippingAddress = shippingAddress;
        this.status = OrderStatus.NEW;
    }

    public void addItem(OrderItemDetails item) {
        if (status != OrderStatus.NEW) {
            throw new IllegalStateException("Cannot modify order in current status");
        }
        items.add(item);
    }

    public void changeStatus(OrderStatus newStatus) {
        this.status = newStatus;
    }

    public UUID getId() {
        return id;
    }
}
