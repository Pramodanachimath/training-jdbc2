package com.policyapp.client;

import com.policyapp.model.Policy;
import com.policyapp.service.IPolicyService;
import com.policyapp.service.PolicyServiceImpl;
import com.policyapp.service.exception.PolicyNotFoundException;

public class UserClass {

	public static void main(String[] args) {
	IPolicyService policyService = new PolicyServiceImpl();
Policy  policy=new Policy();
//	Policy policy = new Policy("JeevanSathi", 1, 2000, "life", 5, "Family", "Health", "Star", 5000);
//	Policy policy1 = new Policy("JeevanAnand", 2, 3000, "term", 5, "Family", "Retirement", "Voya", 1000);
//	Policy policy2 = new Policy("JeevanRaksha", 3, 2000, "life", 5, "Family", "Vehicle", "Acko", 2000);
//	Policy policy3 = new Policy("JeevanSathi", 4, 5000, "life", 5, "Family", "Endowment", "LIC", 3000);
//	policyService.addPolicy(policy);
//	policyService.addPolicy(policy1);
//	policyService.addPolicy(policy2);
//	policyService.addPolicy(policy3);

	System.out.println("get All");
	policyService.getAll().forEach(System.out::println);
	
//		System.out.println("get By Type");
//
//		try {
//			policyService.getByType("term").forEach(System.out::println);
//		} catch (PolicyNotFoundException e) {
//			e.printStackTrace();
//		}
//		System.out.println();
//
//		System.out.println("get By category");
//		try {
//			policyService.getByCategory("life").forEach(System.out::println);
//			System.out.println();
//		} catch (PolicyNotFoundException e) {
//			e.printStackTrace();
//		}
//
//		System.out.println("get By Coverage");
//		try {
//			policyService.getByCoverage("life").forEach(System.out::println);
//			System.out.println();
//		} catch (PolicyNotFoundException e) {
//			e.printStackTrace();
//		}
//
//		System.out.println("get By HighSumAssured");
//		try {
//			policyService.getByHighSumAssured(2000).forEach(System.out::println);
//			System.out.println();
//		} catch (PolicyNotFoundException e) {
//			e.printStackTrace();
//		}
//
//		System.out.println("get By LessPremium");
//
//		try {
//			policyService.getByLessPremium(2000).forEach(System.out::println);
//			System.out.println();
//		} catch (PolicyNotFoundException e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println("get By Brand");
//		
//		try {
//			policyService.getByBrand("star").forEach(System.out::println);
//		} catch (PolicyNotFoundException e1) {
//			e1.printStackTrace();
//		}
//		
//		System.out.println("get By Id");
//		try {
//			policyService.getById(1001);
//		} catch (IdNotFoundException e) {
//			e.printStackTrace();
//		}
	}

}
