package com.voterapp.service;

import com.voterapp.exception.InValidVoterException;

public interface IElectionBooth {
 
	boolean checkEligibilty(int age,String locality,int vid) throws InValidVoterException;
	
}
