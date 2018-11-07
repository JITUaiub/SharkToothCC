package org.sharktooth.gms.dao.implementation;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.sharktooth.gms.dao.UserDAO;
import org.sharktooth.gms.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository()
public class UserDAOImplementation implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean saveUser(User user) {
		int id = (Integer) sessionFactory.openSession().save(user);
		if (id > 0) {
			return true;
		}
		return false;
	}

	@Override
	public User getUserDetailsByEmailAndPassword(String email, String password) {
		User user = null;
		Criteria detachedCriteria = sessionFactory.openSession().createCriteria(User.class);
		detachedCriteria.add(Restrictions.eq("email", email));
		detachedCriteria.add(Restrictions.eq("password", password));
		List entityList = detachedCriteria.list();
		
		if (!entityList.isEmpty()) {
			user = (User) entityList.get(0);
		}
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUserList() {
		Criteria detachedCriteria = sessionFactory.openSession().createCriteria(User.class);
		return detachedCriteria.list();
	}

	@Override
	public void updateUser(User user) {
		sessionFactory.openSession().save(user);
	}

}
