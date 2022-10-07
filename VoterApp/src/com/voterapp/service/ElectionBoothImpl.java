package com.voterapp.service;

import com.voterapp.exception.InValidVoterException;
import com.voterapp.exception.LocalityNotFoundException;
import com.voterapp.exception.NoVoterIDException;
import com.voterapp.exception.UnderAgeException;

public class ElectionBoothImpl implements IElectionBooth {

	@Override
	public boolean checkEligibilty(int age, String locality, int vid) throws InValidVoterException {

		
		try {
			checkAge(age);
			checkLocality(locality);
			checkVoterId(vid);
			System.out.println("You are eligible");
		} catch (NoVoterIDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	private boolean checkAge(int age) throws UnderAgeException {
		try {
			if (age < 18) {
				throw new UnderAgeException("Voters with under age 18 are not eligible to vote ");

			}

		} catch (Exception e) {
			System.out.println(e);
			throw e;
		}
		return false;

	}

	
	@SuppressWarnings("unlikely-arg-type")
	private boolean checkLocality(String localoty) throws LocalityNotFoundException {
		String[] streets = { "BasavanaGudi", "RajajiNagar", "Mejastic", "ElectronicCity", "WhiteField",
				"Banashankari" };

		try {
			for (String locality : streets) {
				if (locality.equals(streets)) {
					throw new LocalityNotFoundException("Voters from other locality is not eligible to vote here");
				} 

			}

		} catch (Exception e) {
			System.out.println(e);
			throw e;
		}
		return false;

	}

	private boolean checkVoterId(int vId) throws NoVoterIDException {
		try {
			if (vId < 1000 && vId > 9999) {
				throw new NoVoterIDException("Voter Id is not matching");
			} 
		} catch (Exception e) {
			System.out.println(e);
			throw e;
		}
		return false;
	

	}

}
