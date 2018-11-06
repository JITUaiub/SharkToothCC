package main.java.org.sharktooth.gms.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.org.sharktooth.gms.dao.UserDAO;
import main.java.org.sharktooth.gms.model.User;
import main.java.org.sharktooth.gms.service.GuildInfoService;

@Service
public class GuildInfoServiceImplementation implements GuildInfoService{
	
	@Autowired
	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public List<User> getUserList() {
		return getUserDAO().getUserList();
	}
	
	
}
