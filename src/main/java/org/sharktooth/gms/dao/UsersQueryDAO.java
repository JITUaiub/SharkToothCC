package main.java.org.sharktooth.gms.dao;

import java.util.List;

import main.java.org.sharktooth.gms.model.UsersQuery;

public interface UsersQueryDAO {
	public abstract boolean saveUsersQuery(UsersQuery usersQuery);
	public abstract void updateUsersQuery(UsersQuery usersQuery);
	public List<UsersQuery> getUsersQuery();
}
