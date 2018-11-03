package org.sharktooth.gms.service;

import java.util.List;

import org.sharktooth.gms.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
	public abstract User validateUserCredential(String email, String password);
	public abstract boolean registerUser(User user);
	public List<User> getUserList();
	public abstract void updateUser(User user);
}
