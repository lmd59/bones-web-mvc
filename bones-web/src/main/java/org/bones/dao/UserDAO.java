package org.bones.dao;

import java.util.List;

import org.bones.model.User;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

//TODO: use hibernate4 orm import??
public class UserDAO extends HibernateDaoSupport{
	 
	public void save(User user){
		getHibernateTemplate().save(user);
	}
 
	public void update(User user){
		getHibernateTemplate().update(user);
	}
 
	public void delete(User user){
		getHibernateTemplate().delete(user);
	}
 
	public User findUserByID(String id){
		List list = getHibernateTemplate().find(
                      "from User where userID=?",id
                );
		return (User)list.get(0);
	}
 
}