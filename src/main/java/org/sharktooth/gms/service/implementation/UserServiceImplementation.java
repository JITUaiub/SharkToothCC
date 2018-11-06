package main.java.org.sharktooth.gms.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.org.sharktooth.gms.dao.UserDAO;
import main.java.org.sharktooth.gms.model.User;
import main.java.org.sharktooth.gms.service.UserService;

@Service()
public class UserServiceImplementation implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public User validateUserCredential(String email, String password) {
		User user = getUserDAO().getUserDetailsByEmailAndPassword(email, password);
		return user;
	}

	@Override
	public boolean registerUser(User user) {
		boolean isRegister = false;
		boolean saveUser = getUserDAO().saveUser(user);
		if (saveUser) {
			isRegister = true;
		}

		return isRegister;
	}

	@Override
	public List<User> getUserList() {
		return getUserDAO().getUserList();
	}

	@Override
	public void updateUser(User user) {
		getUserDAO().updateUser(user);
	}

}
