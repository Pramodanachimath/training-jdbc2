package com.voterapp.main;

import java.util.Scanner;

import com.voterapp.exception.InValidVoterException;
import com.voterapp.service.ElectionBoothImpl;
import com.voterapp.service.IElectionBooth;

public class MainClass {

	public static void main(String[] args) {

		IElectionBooth electionBooth=new ElectionBoothImpl();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the age");
		int age=sc.nextInt();
	
		System.out.println("Enter the locality");
		String locality=sc.next();
		
		System.out.println("Enter the voterId");
		int voterId=sc.nextInt();
		
		try {
			if(electionBooth.checkEligibilty(age, locality, voterId)) {
			}
		} catch (InValidVoterException e) {
			e.printStackTrace();
		}
		sc.close();
		
		
		
		
	}

}
