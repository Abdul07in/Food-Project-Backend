package com.food.pojo;

public class Cart {

    private Food f;
    private Integer cartId;
    private Integer foodId;
    private Integer foodQuantity;
    private Double price;
    private Double subtotal;
    private String customerEmail;

    public Cart() {
        super();
    }

    public Cart(Food f, Integer cartId, Integer foodId, Integer foodQuantity, Double price, Double subtotal,
            String customerEmail) {
        this.f = f;
        this.cartId = cartId;
        this.foodId = foodId;
        this.foodQuantity = foodQuantity;
        this.price = price;
        this.subtotal = subtotal;
        this.customerEmail = customerEmail;
    }

    public Food getF() {
        return f;
    }

    public void setF(Food f) {
        this.f = f;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public Integer getFoodQuantity() {
        return foodQuantity;
    }

    public void setFoodQuantity(Integer foodQuantity) {
        this.foodQuantity = foodQuantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    @Override
    public String toString() {
        return "Cart [f=" + f + ", cartId=" + cartId + ", foodId=" + foodId + ", foodQuantity=" + foodQuantity
                + ", price=" + price + ", subtotal=" + subtotal + ", customerEmail=" + customerEmail + "]";
    }

}