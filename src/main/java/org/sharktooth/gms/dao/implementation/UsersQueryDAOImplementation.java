package org.sharktooth.gms.dao.implementation;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.sharktooth.gms.dao.UsersQueryDAO;
import org.sharktooth.gms.model.UsersQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository()
public class UsersQueryDAOImplementation implements UsersQueryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean saveUsersQuery(UsersQuery usersQuery) {
		int id = (Integer) sessionFactory.openSession().save(usersQuery);
		if (id > 0) {
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UsersQuery> getUsersQuery() {
		Criteria detachedCriteria = sessionFactory.openSession().createCriteria(UsersQuery.class);
		
		return detachedCriteria.list();
	}

	@Override
	public void updateUsersQuery(UsersQuery usersQuery) {
		sessionFactory.openSession().update(usersQuery);
	}

}
