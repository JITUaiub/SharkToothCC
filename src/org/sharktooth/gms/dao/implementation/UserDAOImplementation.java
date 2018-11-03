package org.sharktooth.gms.dao.implementation;

import java.util.List;

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
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public boolean saveUser(User user) {
		int id = (Integer) hibernateTemplate.save(user);
		if (id > 0) {
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User getUserDetailsByEmailAndPassword(String email, String password) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class);
		detachedCriteria.add(Restrictions.eq("email", email));
		detachedCriteria.add(Restrictions.eq("password", password));
		List<User> findByCriteria = (List<User>) hibernateTemplate.findByCriteria(detachedCriteria);
		if (findByCriteria != null && findByCriteria.size() > 0) {
			return findByCriteria.get(0);
		}else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUserList() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class);
		return (List<User>) hibernateTemplate.findByCriteria(detachedCriteria);
	}

	@Override
	public void updateUser(User user) {
		hibernateTemplate.save(user);
	}

}
