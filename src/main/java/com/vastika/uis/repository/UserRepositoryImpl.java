package com.vastika.uis.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.vastika.uis.model.User;
import com.vastika.uis.util.HibernateUtil;


@Repository
public class UserRepositoryImpl implements UserRepository{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveUserInfo(User user) {
		Session session = HibernateUtil.getSession(sessionFactory);
		session.save(user);
		//session.getTransaction().commit();
	}

	@Override
	public void updateUserInfo(User user) {
		Session session = HibernateUtil.getSession(sessionFactory);
		session.update(user);
		//session.getTransaction().commit();
		session.flush();
	}
	
	@Override
	public void deleteUserInfo(int id) {
		User user=  getUserById(id);
		
		if(user!= null) {
			Session session = HibernateUtil.getSession(sessionFactory);
			session.delete(user);
			//session.getTransaction().commit();
		}
	}

	@Override
	public User getUserById(int id) {
		Session session = HibernateUtil.getSession(sessionFactory);
		User user = (User)session.get(User.class, id);
		//session.getTransaction().commit();
		return user;
	}

	@Override
	public List<User> getAllUserInfo() {
		Session session = HibernateUtil.getSession(sessionFactory);
		Criteria criteria = session.createCriteria(User.class);
		 return criteria.list();
	}

	@Override
	public User getUserInfoByUsername(String username) {
		Session session = HibernateUtil.getSession(sessionFactory);
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));  
		 return (User) criteria.uniqueResult();
	}

	@Override
	public User getUserInfoByEmail(String email) {
		Session session = HibernateUtil.getSession(sessionFactory);
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("email", email));  
		 return (User) criteria.uniqueResult();
	}
	
	

}
