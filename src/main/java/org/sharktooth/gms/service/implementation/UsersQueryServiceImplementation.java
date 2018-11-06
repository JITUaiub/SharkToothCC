package main.java.org.sharktooth.gms.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.org.sharktooth.gms.dao.UsersQueryDAO;
import main.java.org.sharktooth.gms.model.UsersQuery;
import main.java.org.sharktooth.gms.service.UsersQueryService;

@Service()
public class UsersQueryServiceImplementation implements UsersQueryService{
	
	@Autowired
	private UsersQueryDAO usersQueryDAO;

	public UsersQueryDAO getUsersQueryDAO() {
		return usersQueryDAO;
	}

	public void setUsersQueryDAO(UsersQueryDAO usersQueryDAO) {
		this.usersQueryDAO = usersQueryDAO;
	}

	@Override
	public boolean saveUsersQuery(UsersQuery usersQuery) {
		return getUsersQueryDAO().saveUsersQuery(usersQuery);
	}

	@Override
	public void updateUsersQuery(UsersQuery usersQuery) {
		getUsersQueryDAO().updateUsersQuery(usersQuery);
	}

	@Override
	public List<UsersQuery> getUsersQuery() {
		return getUsersQueryDAO().getUsersQuery();
	}

}
