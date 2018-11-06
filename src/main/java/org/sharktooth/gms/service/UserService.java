package main.java.org.sharktooth.gms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import main.java.org.sharktooth.gms.model.User;

@Service
public interface UserService {
	public abstract User validateUserCredential(String email, String password);
	public abstract boolean registerUser(User user);
	public List<User> getUserList();
	public abstract void updateUser(User user);
}
