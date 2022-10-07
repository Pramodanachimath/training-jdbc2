package com.training.service;

import java.util.Arrays;
import java.util.List;

public class Delivery {

	List<String> showFood(String type) {

		if (type.equals("chineesFood")) {
			System.out.println("chineesFood");
			return Arrays.asList("Gobi", "FrenchFries", "SandWitch");
		}

		if (type.equals("southIndian")) {
			System.out.println("southIndian");
			return Arrays.asList("Roti", "chapati", "Parota");
		}

		if (type.equals("northIndian")) {
			System.out.println("northIndian");
			return Arrays.asList("Tandoori", "Chicken", "Paneer");
		}

		else
			return null;

	}

	public String greetMessage(String name) {
		return "great Day " + name;
	}
}
