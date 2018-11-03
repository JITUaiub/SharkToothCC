package org.sharktooth.gms.dao;

import java.util.List;

import org.sharktooth.gms.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO {
	public abstract boolean saveUser(User user);
	public User getUserDetailsByEmailAndPassword(String email, String password);
	public List<User> getUserList();
	public abstract void updateUser(User user); 
}
