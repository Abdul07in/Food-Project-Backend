package com.food.test;

import java.util.List;
import java.util.Scanner;

import com.food.dao.FoodDaoImpl;
import com.food.pojo.Food;

public class FoodTest {

	static {
		System.out.println("--------------------------------");
		System.out.println("----------FOOD SHOP-------------");
		System.out.println("--------------------------------");
	}

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			Food f = null;
			FoodDaoImpl fimpl = new FoodDaoImpl();
			List<Food> flist = null;

			Integer foodId;
			String foodName;
			String foodType;
			Double foodPrice;
			Integer foodQuantity;
			String foodCategory;
			String foodDescription;
			Integer foodRating;
			String[] type = { "Veg", "No-Veg" };
			int t;

			while (true) {

				System.out.println("\t\tMENU");

				System.out.println("1. Add new food item.");
				System.out.println("2. Show food item.");
				System.out.println("3. Search Food By Id.");
				System.out.println("4. Delete Food by Id.");
				System.out.println("9. Exit");

				System.out.print("=>\t");
				int option = sc.nextInt();
				sc.nextLine();

				switch (option) {
					case 1:
						System.out.println("ADD FOOD ITEMS");
						System.out.print("\nEnter Name of the Item : ");
						foodName = sc.nextLine();

						System.out.print("Enter Type of the Item : ");
						System.out.println("\n\t1.Veg\t2.No-Veg");
						System.out.print("=>");
						t = sc.nextInt();
						if (t == 1)
							foodType = type[0];
						else
							foodType = type[1];

						System.out.print("Enter Price of the Item : ");
						foodPrice = sc.nextDouble();
						sc.nextLine();

						System.out.print("Enter Quantity of the Item : ");
						foodQuantity = sc.nextInt();
						sc.nextLine();

						System.out.print("Enter Category of the Item : ");
						foodCategory = sc.nextLine();

						System.out.print("Enter Description of the Item : ");
						foodDescription = sc.nextLine();

						System.out.print("Enter Rating of the Item : ");
						foodRating = sc.nextInt();
						sc.nextLine();

						f = new Food(foodName, foodType, foodPrice, foodQuantity, foodCategory, foodDescription,
								foodRating);

						if (fimpl.addFood(f))
							System.out.println("Food Added Successfully");
						else
							System.out.println("Error while Adding");

						break;

					case 2:
						System.out.println("SHOW ALL FOOD ITEM");

						flist = fimpl.fetchAllFood();

						if (flist != null && flist.isEmpty() != true)
							flist.forEach(
									s -> System.out.println("\n------------------------------------------------" + s));
						else
							System.out.println("List is Empty");
						break;

					case 3:
						System.out.println("SEARCH FOOD BY ID");
						System.out.print("\nEnter Id of Food Item : ");
						foodId = sc.nextInt();

						f = fimpl.searchFoodById(foodId);

						if (f != null) {
							System.out.println("-------------Your Search Result--------------");
							System.out.println(f);
							boolean b = false;
							do {
								System.out.print("Do you want to update this Food Item. [Yes/No] : ");
								String choice = sc.next();
								if (choice.equalsIgnoreCase("yes")) {
									b = true;
									fimpl.updateFoodMenu();
									b = false;
								} else
									b = false;
							} while (b);

						} else
							System.out.println("No Food Id Found , Please Enter a Valid FoodId.");

						break;
					case 4:
						System.out.println("DELETE FOOD BY ID");
						System.out.print("\nEnter Id of Food Item : ");
						foodId = sc.nextInt();

						f = fimpl.searchFoodById(foodId);

						if (f != null) {
							System.out.println("-------------Your Search Result--------------");
							System.out.println(f);
							boolean b = false;
							do {
								System.out.print("Do you want to delete this Food Item. [Yes/No] : ");
								String choice = sc.next();
								if (choice.equalsIgnoreCase("yes")) {
									b = true;
									if (fimpl.deleteFood(foodId))
										System.out.println("Item Deleted Successfully");
									else
										System.out.println("Error");
									b = false;
								} else
									b = false;
							} while (b);

						} else
							System.out.println("No Food Id Found , Please Enter a Valid FoodId.");

						break;

					case 9:
						System.exit(0);
					default:
						System.out.println("Please Select Vaild Option.");
				}

			}
		}

	}
}
