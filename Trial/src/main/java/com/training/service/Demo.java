package com.training.service;

import java.util.Scanner;

public class Demo {
 
	public static void main(String[] args) {
		Delivery deliveryFood=new Delivery();
		
		String msg=deliveryFood.greetMessage("Pramod");
		System.out.println(msg);
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the type of food");
		String type=sc.next();
		System.out.println(deliveryFood.showFood(type));
		
		sc.close();
	}
}
