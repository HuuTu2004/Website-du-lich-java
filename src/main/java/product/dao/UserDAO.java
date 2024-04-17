package product.dao;


import java.util.List;

import product.entites.Role;
import product.entites.User;
import product.entites.User_Role;


public interface UserDAO {
	public User findByUserName(String username);
	public boolean InsertUser(User u);
	List<User> findUsersWithoutRole();
	List<User> findUsersWithoutNoRole();
	List<Role> ListUserRole();
	boolean InsertUserRole(User_Role u);
}