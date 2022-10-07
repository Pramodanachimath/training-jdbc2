package com.policyapp.service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.policyapp.model.Policy;
import com.policyapp.service.exception.IdNotFoundException;
import com.policyapp.service.exception.PolicyNotFoundException;
import com.policyapp.util.DbConnection;

public class PolicyDAOImpl implements IPolicyDAO {
	@Override
	public void addPolicy(Policy policy) {
		String sql = "insert into policy(policy_name ,premium  ,type ,duration ,coverage ,brand ,category ,sum_assured )  values(?,?,?,?,?,?,?,?) ";
		Connection connection = DbConnection.openConnection();
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, policy.getPolicyName());
			preparedStatement.setDouble(2, policy.getPremium());
			preparedStatement.setString(3, policy.getType());
			preparedStatement.setInt(4, policy.getDuration());
			preparedStatement.setString(5, policy.getCoverage());
			preparedStatement.setString(6, policy.getCategory());
			preparedStatement.setString(7, policy.getBrand());
			preparedStatement.setDouble(8, policy.getSumAssured());
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void deletePolicy(int policyId) {
		PreparedStatement preparedStatement = null;
		String sql = "delete from policy where policy_id=?";
		Connection connection = DbConnection.openConnection();

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, policyId);

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void updatePolicy(int policyId, String coverage) {
//
		String sql = "update policy set coverage=? where policy_id=?";
		PreparedStatement preparedStatement = null;
		Connection connection = DbConnection.openConnection();

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, coverage);
			preparedStatement.setInt(2, policyId);
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Policy> findAll() {
		List<Policy> policyList = new ArrayList<>();

		Connection connection = DbConnection.openConnection();
		ResultSet result = null;
		String sql = "select * from policy";
		PreparedStatement preparedStatement=null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.execute();
			result = preparedStatement.executeQuery();
			Policy policy = new Policy();
			while (result.next()) {
				String name = result.getString("policy_name");
				double premium = result.getDouble("premium");
				String type = result.getString("type");
				Integer duration = result.getInt("duration");

				String coverage = result.getString("coverage");
				String category = result.getString("category");
				String brand = result.getString("brand");
				double sumAssured = result.getDouble("sum_assured");

				policyList.add(policy);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return null;

	}

	@Override
	public List<Policy> findByType(String type) throws PolicyNotFoundException {
		return null;
		
//		List<Policy> policyList = new ArrayList<>();
//
//		Connection connection = DbConnection.openConnection();
//		ResultSet result = null;
//		String sql = "selet * from policy where type=?";
//		PreparedStatement preparedStatement=null;
//		try {
//			preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setString(1, type);
//			preparedStatement.execute();
//			result = preparedStatement.executeQuery();
//			
//			while (result.next()) {
//				String name = result.getString("policyName");
//				double premium = result.getDouble("premium");
//				String type1 = result.getString("type");
//				Integer duration = result.getInt("duration");
//
//				String coverage = result.getString("coverage");
//				String category = result.getString("category");
//				String brand = result.getString("brand");
//				double sumAssured = result.getDouble("SumAssured");
//				int policy_Id=result.getInt("popolicy_Id");
//				Policy policy = new Policy(name, policy_Id, premium, type, duration, coverage, category, brand, sumAssured);
//				policyList.add(policy);
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (preparedStatement != null) {
//					preparedStatement.close();
//				}
//				if (connection != null) {
//					connection.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//
//		return policyList;

	}

	@Override
	public List<Policy> findByCategory(String category) throws PolicyNotFoundException {
		return null;

//		List<Policy> policyList = new ArrayList<>();
//
//		Connection connection = DbConnection.openConnection();
//		ResultSet result = null;
//		String sql = "selet * from policy where category=?";
//		
//		PreparedStatement preparedStatement=null;
//		try {
//			preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setString(1, category);
//			preparedStatement.execute();
//			result = preparedStatement.executeQuery();
//			
//			while (result.next()) {
//				String name = result.getString("policyName");
//				int policy_Id=result.getInt("popolicy_Id");
//				double premium = result.getDouble("premium");
//				String type = result.getString("type");
//				Integer duration = result.getInt("duration");
//				String coverage = result.getString("coverage");
//				String category1 = result.getString("category");
//				String brand = result.getString("brand");
//				double sumAssured = result.getDouble("SumAssured");
//				Policy policy = new Policy(name, policy_Id, premium, type, duration, coverage, category1, brand, sumAssured);
//				policyList.add(policy);
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (preparedStatement != null) {
//					preparedStatement.close();
//				}
//				if (connection != null) {
//					connection.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//
//		return policyList;

	}

	@Override
	public List<Policy> findByHighSumAssured(double sumAssured) throws PolicyNotFoundException {
		return null;

//		List<Policy> policyList = new ArrayList<>();
//
//		Connection connection = DbConnection.openConnection();
//		ResultSet result = null;
//		String sql = "selet * from policy where sumAssured=?";
//		
//		PreparedStatement preparedStatement=null;
//		try {
//			preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setDouble(1, sumAssured);
//			preparedStatement.execute();
//			result = preparedStatement.executeQuery();
//			
//			while (result.next()) {
//				String name = result.getString("policyName");
//				int policy_Id=result.getInt("popolicy_Id");
//				double premium = result.getDouble("premium");
//				String type = result.getString("type");
//				Integer duration = result.getInt("duration");
//				String coverage = result.getString("coverage");
//				String category = result.getString("category");
//				String brand = result.getString("brand");
//				double sumAssured1 = result.getDouble("SumAssured");
//				Policy policy = new Policy(name, policy_Id, premium, type, duration, coverage, category, brand, sumAssured1);
//				policyList.add(policy);
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (preparedStatement != null) {
//					preparedStatement.close();
//				}
//				if (connection != null) {
//					connection.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//
//		return policyList;
	}

	@Override
	public List<Policy> findByCoverage(String coverage) throws PolicyNotFoundException {
		return null;

//		List<Policy> policyList = new ArrayList<>();
//
//		Connection connection = DbConnection.openConnection();
//		ResultSet result = null;
//		String sql = "selet * from policy where sumAssured=?";
//		
//		PreparedStatement preparedStatement=null;
//		try {
//			preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setString(1, coverage);
//			preparedStatement.execute();
//			result = preparedStatement.executeQuery();
//			
//			while (result.next()) {
//				String name = result.getString("policyName");
//				int policy_Id=result.getInt("popolicy_Id");
//				double premium = result.getDouble("premium");
//				String type = result.getString("type");
//				Integer duration = result.getInt("duration");
//				String coverage1 = result.getString("coverage");
//				String category = result.getString("category");
//				String brand = result.getString("brand");
//				double sumAssured = result.getDouble("SumAssured");
//				Policy policy = new Policy(name, policy_Id, premium, type, duration, coverage, category, brand, sumAssured);
//				policyList.add(policy);
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (preparedStatement != null) {
//					preparedStatement.close();
//				}
//				if (connection != null) {
//					connection.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//
//		return policyList;
	}

	@Override
	public List<Policy> findByLessPremium(double premium) throws PolicyNotFoundException {
		return null;

//		List<Policy> policyList = new ArrayList<>();
//
//		Connection connection = DbConnection.openConnection();
//		ResultSet result = null;
//		String sql = "selet * from policy where sumAssured=?";
//		
//		PreparedStatement preparedStatement=null;
//		try {
//			preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setDouble(1, premium);
//			preparedStatement.execute();
//			result = preparedStatement.executeQuery();
//			
//			while (result.next()) {
//				String name = result.getString("policyName");
//				int policy_Id=result.getInt("popolicy_Id");
//				double premium1 = result.getDouble("premium");
//				String type = result.getString("type");
//				Integer duration = result.getInt("duration");
//				String coverage = result.getString("coverage");
//				String category = result.getString("category");
//				String brand = result.getString("brand");
//				double sumAssured = result.getDouble("SumAssured");
//				Policy policy = new Policy(name, policy_Id, premium1, type, duration, coverage, category, brand, sumAssured);
//				policyList.add(policy);
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (preparedStatement != null) {
//					preparedStatement.close();
//				}
//				if (connection != null) {
//					connection.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//
//		return policyList;
	}

	@Override
	public List<Policy> findByBrand(String brand) throws PolicyNotFoundException {
		return null;

//		List<Policy> policyList = new ArrayList<>();
//
//		Connection connection = DbConnection.openConnection();
//		ResultSet result = null;
//		String sql = "selet * from policy where brand=?";
//		
//		PreparedStatement preparedStatement=null;
//		try {
//			preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setString(1, brand);
//			preparedStatement.execute();
//			result = preparedStatement.executeQuery();
//			
//			while (result.next()) {
//				String name = result.getString("policyName");
//				int policy_Id=result.getInt("popolicy_Id");
//				double premium = result.getDouble("premium");
//				String type = result.getString("type");
//				Integer duration = result.getInt("duration");
//				String coverage = result.getString("coverage");
//				String category = result.getString("category");
//				String brand1 = result.getString("brand");
//				double sumAssured = result.getDouble("SumAssured");
//				Policy policy = new Policy(name, policy_Id, premium, type, duration, coverage, category, brand, sumAssured);
//				policyList.add(policy);
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (preparedStatement != null) {
//					preparedStatement.close();
//				}
//				if (connection != null) {
//					connection.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//
//		return policyList;
	}

	@Override
	public Policy findById(int policyId) throws IdNotFoundException {
		return null;

//		Policy policy = null;
//
//		Connection connection = DbConnection.openConnection();
//		ResultSet result = null;
//		String sql = "selet * from policy where policyt_id=?";
//		
//		PreparedStatement preparedStatement=null;
//		try {
//			preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setInt(1, policyId);
//			preparedStatement.execute();
//			result = preparedStatement.executeQuery();
//			
//			while (result.next()) {
//				String name = result.getString("policyName");
//				int policyId1=result.getInt("policy_Id");
//				double premium = result.getDouble("premium");
//				String type = result.getString("type");
//				Integer duration = result.getInt("duration");
//				String coverage = result.getString("coverage");
//				String category = result.getString("category");
//				String brand = result.getString("brand");
//				double sumAssured = result.getDouble("SumAssured");
//				policy = new Policy(name, policyId1, premium, type, duration, coverage, category, brand, sumAssured);
//			
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (preparedStatement != null) {
//					preparedStatement.close();
//				}
//				if (connection != null) {
//					connection.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//
//		return policy;
	}

}
