package com.policyapp.service;

import java.util.List;
import java.util.stream.Collectors;

import com.policyapp.model.Policy;
import com.policyapp.service.dao.IPolicyDAO;
import com.policyapp.service.dao.PolicyDAOImpl;
import com.policyapp.service.exception.IdNotFoundException;
import com.policyapp.service.exception.PolicyNotFoundException;

public class PolicyServiceImpl implements IPolicyService {
	IPolicyDAO policyDAO = new PolicyDAOImpl();

	@Override
	public void addPolicy(Policy policy) {
		policyDAO.addPolicy(policy);
	}

	@Override
	public void deletePolicy(int policyId) {
		policyDAO.deletePolicy(policyId);

	}

	@Override
	public void updatePolicy(int policyId, String coverage) {
		policyDAO.updatePolicy(policyId, coverage);

	}

	IPolicyDAO policydao = null;

	@Override
	public List<Policy> getAll() {
		return null;
//		List<Policy> policies = new PolicyDAOImpl().findAll();
//		return policies;
	}

	@Override
	public List<Policy> getByType(String policy) throws PolicyNotFoundException {
		return null;

//		List<Policy> policies = new PolicyDAOImpl().findAll();
//		return policies.stream().filter((type->type.getType().contains("e"))).sorted((p1,p2)->p1.getPolicyName().compareTo(p2.getPolicyName())).collect(Collectors.toList());
	}

	@Override
	public List<Policy> getByCategory(String category) throws PolicyNotFoundException {

		List<Policy> policies = new PolicyDAOImpl().findAll();
		return policies.stream().filter((type->type.getCategory().endsWith("t"))).sorted((p1,p2)->p1.getPolicyName().compareTo(p2.getPolicyName())).collect(Collectors.toList());
	}

	@Override
	public List<Policy> getByHighSumAssured(double sumAssured) throws PolicyNotFoundException {

		List<Policy> policies = new PolicyDAOImpl().findAll();
		return policies.stream().filter((type->type.getSumAssured()>1000)).sorted((p1,p2)->p1.getPolicyName().compareTo(p2.getPolicyName())).collect(Collectors.toList());
	}

	@Override
	public List<Policy> getByCoverage(String coverage) throws PolicyNotFoundException {

		List<Policy> policies = new PolicyDAOImpl().findAll();
		return policies.stream().filter((type->type.getCoverage().startsWith("F"))).sorted((p1,p2)->p1.getPolicyName().compareTo(p2.getPolicyName())).collect(Collectors.toList());
	}

	@Override
	public List<Policy> getByBrand(String brand) throws PolicyNotFoundException {

		List<Policy> policies = new PolicyDAOImpl().findAll();
		return policies.stream().filter((type->type.getBrand().contains("s"))).sorted((p1,p2)->p1.getPolicyName().compareTo(p2.getPolicyName())).collect(Collectors.toList());
	}

	@Override
	public List<Policy> getByLessPremium(double premium) throws PolicyNotFoundException {

		List<Policy> policies = new PolicyDAOImpl().findAll();
		return policies.stream().filter((type->type.getPremium()<3000)).sorted((p1,p2)->p1.getPolicyName().compareTo(p2.getPolicyName())).collect(Collectors.toList());
	}

	@Override
	public Policy getById(int policyId) throws IdNotFoundException {
	
		
		return policyDAO.findById(policyId);
	}

}
