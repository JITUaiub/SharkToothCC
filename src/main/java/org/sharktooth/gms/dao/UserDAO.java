package main.java.org.sharktooth.gms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import main.java.org.sharktooth.gms.model.User;

@Repository
public interface UserDAO {
	public abstract boolean saveUser(User user);
	public User getUserDetailsByEmailAndPassword(String email, String password);
	public List<User> getUserList();
	public abstract void updateUser(User user); 
}
