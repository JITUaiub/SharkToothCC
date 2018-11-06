package main.java.org.sharktooth.gms.service;

import java.util.List;

import main.java.org.sharktooth.gms.model.UsersQuery;

public interface UsersQueryService {
	public abstract boolean saveUsersQuery(UsersQuery usersQuery);
	public abstract void updateUsersQuery(UsersQuery usersQuery);
	public List<UsersQuery> getUsersQuery();
}
