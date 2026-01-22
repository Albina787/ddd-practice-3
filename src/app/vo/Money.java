
package app.vo;

import java.util.UUID;

public final class Money {
    private final String currency;
    private final double amount;

    public Money(String currency, double amount) {
        if (currency == null || currency.isEmpty()) throw new IllegalArgumentException("Currency required");
        this.currency = currency;
        this.amount = amount;
    }

    public Money add(Money other) {
        if (!currency.equals(other.currency)) throw new IllegalArgumentException("Different currencies");
        return new Money(currency, amount + other.amount);
    }

    public double getAmount() { return amount; }

    public String getCurrency() { return currency; }

    @Override
    public String toString() {
        return currency + " " + String.format("%.2f", amount);
    }
}

public final class Address {
    private final String country, city, street, postalCode;

    public Address(String country, String city, String street, String postalCode) {
        if (postalCode == null || postalCode.isEmpty()) throw new IllegalArgumentException("Invalid postal code");
        this.country = country;
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return country + ", " + city + ", " + street + ", " + postalCode;
    }
}

public final class Dimensions {
    private final double length, width, height;

    public Dimensions(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double volume() {
        return length * width * height;
    }
}

public final class ProductDetails {
    private final String name;
    private final String description;
    private final Dimensions dimensions;

    public ProductDetails(String name, String description, Dimensions dimensions) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Name required");
        this.name = name;
        this.description = description;
        this.dimensions = dimensions;
    }
}

public final class OrderItemDetails {
    private final UUID productId;
    private final int quantity;
    private final Money price;

    public OrderItemDetails(UUID productId, int quantity, Money price) {
        if (quantity < 1) throw new IllegalArgumentException("Quantity >= 1");
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    public Money totalPrice() {
        return new Money(price.getCurrency(), price.getAmount() * quantity);
    }
}
