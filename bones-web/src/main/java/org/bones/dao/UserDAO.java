package org.bones.dao;

import java.util.ArrayList;
import java.util.List;

import org.bones.model.User;
import org.bones.model.UserRole;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

public class UserDAO {
    
    private SessionFactory sessionFactory;
    private Session session;
         
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
     
    @Transactional(readOnly=false)
    public void addUser(User u) {
        Session session = sessionFactory.openSession();
        session.save(u);
        session.close();       
    }
    
    @Transactional(readOnly=false)
    public void addUserRole(UserRole ur) {
        Session session = sessionFactory.openSession();
        session.save(ur);
        session.close();       
    }
    
    @Transactional(readOnly=false)
    public List<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        List<User> userList = session.createCriteria(User.class).list();
//        List<User> userList = hibSession.createCriteria(User.class)
//                .add( Restrictions.eq("country", country) ).list();
        for(User user: userList){
        	Hibernate.initialize(user.getRoles());
        }
        
        session.close();       
        return userList;
    }
    
    public List<User> getPendingUsers(){
    	Session session = sessionFactory.openSession();
        List<User> userList = session.createCriteria(User.class).add( 
        		Restrictions.isEmpty("roles") ).list();
        session.close();
    	
    	return userList;//pendingUsers;
    }
    
    public List<User> getConfirmedUsers(){
    	Session session = sessionFactory.openSession();
        List<UserRole> userRoleList = session.createCriteria(UserRole.class).add( 
        		Restrictions.eq("authority", UserRole.ROLE_USER)).list();
        List<User> confirmedUsers = new ArrayList<User>();
        for(UserRole role:userRoleList){
        	User user = role.getUser();
        	confirmedUsers.add(user);
        }
        session.close();
    	
    	return confirmedUsers;
    }
    
    public User getUserByID(int userID){
    	Session session = sessionFactory.openSession();
        
        User user = (User)session.createCriteria(User.class)
                .add( Restrictions.eq("userID", userID) ).uniqueResult();
        //session.close();       
        return user;
    }
}
