package com.food.pojo;

public class Food {

	private Integer foodId;
	private String foodName;
	private String foodType;
	private Double foodPrice;
	private Integer foodQuantity;
	private String foodCategory;
	private String foodDescription;
	private Integer foodRating;

	public Food() {

	}

	public Food(Integer foodId, String foodName, String foodType, Double foodPrice, Integer foodQuantity,
			String foodCategory, String foodDescription, Integer foodRating) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.foodType = foodType;
		this.foodPrice = foodPrice;
		this.foodQuantity = foodQuantity;
		this.foodCategory = foodCategory;
		this.foodDescription = foodDescription;
		this.foodRating = foodRating;
	}

	public Food(String foodName, String foodType, Double foodPrice, Integer foodQuantity, String foodCategory,
			String foodDescription, Integer foodRating) {
		super();
		this.foodName = foodName;
		this.foodType = foodType;
		this.foodPrice = foodPrice;
		this.foodQuantity = foodQuantity;
		this.foodCategory = foodCategory;
		this.foodDescription = foodDescription;
		this.foodRating = foodRating;
	}

	public Integer getFoodId() {
		return foodId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public Double getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(Double foodPrice) {
		this.foodPrice = foodPrice;
	}

	public Integer getFoodQuantity() {
		return foodQuantity;
	}

	public void setFoodQuantity(Integer foodQuantity) {
		this.foodQuantity = foodQuantity;
	}

	public String getFoodCategory() {
		return foodCategory;
	}

	public void setFoodCategory(String foodCategory) {
		this.foodCategory = foodCategory;
	}

	public String getFoodDescription() {
		return foodDescription;
	}

	public void setFoodDescription(String foodDescription) {
		this.foodDescription = foodDescription;
	}

	public Integer getFoodRating() {
		return foodRating;
	}

	public void setFoodRating(Integer foodRating) {
		this.foodRating = foodRating;
	}

	@Override
	public String toString() {
		return "\nId : " + foodId + "\nName : " + foodName + "\nType : " + foodType + "\nPrice : " + foodPrice
				+ "\nQuantity : " + foodQuantity + "\nCategory : " + foodCategory + "\nDescription : " + foodDescription
				+ "\nRating : " + foodRating;
	}

}
