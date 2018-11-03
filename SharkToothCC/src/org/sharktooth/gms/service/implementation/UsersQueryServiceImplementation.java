package org.sharktooth.gms.service.implementation;

import java.util.List;

import org.sharktooth.gms.dao.UsersQueryDAO;
import org.sharktooth.gms.model.UsersQuery;
import org.sharktooth.gms.service.UsersQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
