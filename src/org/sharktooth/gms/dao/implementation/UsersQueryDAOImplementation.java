package org.sharktooth.gms.dao.implementation;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.sharktooth.gms.dao.UsersQueryDAO;
import org.sharktooth.gms.model.UsersQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository()
public class UsersQueryDAOImplementation implements UsersQueryDAO {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public boolean saveUsersQuery(UsersQuery usersQuery) {
		int id = (Integer) hibernateTemplate.save(usersQuery);
		if (id > 0) {
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UsersQuery> getUsersQuery() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(UsersQuery.class);
		
		return (List<UsersQuery>) hibernateTemplate.findByCriteria(detachedCriteria);
	}

	@Override
	public void updateUsersQuery(UsersQuery usersQuery) {
		hibernateTemplate.update(usersQuery);
	}

}
