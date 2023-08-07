package com.telecom.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.telecom.Entity.User;

@Repository
public interface IUserRepo extends JpaRepository<User, Integer>{

	User findByUserUsernameAndUserPassword(String userUsername, String userPassword);

	@Query("SELECT c.customerId, c.userCust.userId, c.customerName, c.custPinCode, u.userRole "
			+ "FROM Customer c "
			+ "JOIN User u "
			+ "ON c.userCust.userId = u.userId "
			+ "WHERE u.userRole = 'Customer'")
	List<Object[]> getAllCustData();

	
	@Query("SELECT e.engineerId, e.userEng.userId, e.engineerName, e.managerId.managerName, m.pinCode, u.userRole "
			+ "FROM Engineer e "
			+ "JOIN User u "
			+ "ON e.userEng.userId = u.userId "
			+ "JOIN Manager m "
			+ "ON e.managerId.managerId = m.managerId "
			+ "WHERE u.userRole = 'Engineer'")
	List<Object[]> getAllEngData();
	
	
	@Query("SELECT m.managerId, m.userMngr.userId, m.managerName, m.pinCode, u.userRole "
			+ "FROM Manager m "
			+ "JOIN User u "
			+ "ON m.userMngr.userId = u.userId "
			+ "WHERE u.userRole = 'Manager'")
	List<Object[]> getAllMngrData();
	

	User findByUserId(int customerId);

}
