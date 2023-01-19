package com.food.pojo;

public class Cart {

    private Integer cartId;
    private Integer foodId;
    private Food f;
    private Integer foodQuantity;
    private Double subtotal;
    private String customerEmail;

    public Cart() {
        super();
    }

    public Cart(Integer cartId, Integer foodId, Food f, Integer foodQuantity, Double subtotal, String customerEmail) {
        this.cartId = cartId;
        this.foodId = foodId;
        this.f = f;
        this.foodQuantity = foodQuantity;
        this.subtotal = subtotal;
        this.customerEmail = customerEmail;
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

    public Food getF() {
        return f;
    }

    public void setF(Food f) {
        this.f = f;
    }

    public Integer getFoodQuantity() {
        return foodQuantity;
    }

    public void setFoodQuantity(Integer foodQuantity) {
        this.foodQuantity = foodQuantity;
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
        return "Cart [cartId=" + cartId + ", foodId=" + foodId + ", f=" + f + ", foodQuantity=" + foodQuantity
                + ", subtotal=" + subtotal + ", customerEmail=" + customerEmail + "]";
    }

}