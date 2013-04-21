package org.bones.dao;

import java.util.ArrayList;
import java.util.List;

import org.bones.model.User;
import org.bones.model.UserRole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

public class UserDAO {
    
    private SessionFactory sessionFactory;
         
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
        session.close();       
        return userList;
    }
    
    //TODO: probably don't need to retrieve the entire list
    public List<User> getPendingUsers(){
    	Session session = sessionFactory.openSession();
        List<User> userList = session.createCriteria(User.class).list();
        List<User> pendingUsers = new ArrayList<User>();
    	for(User user: userList){
    		if(user.getRoles().isEmpty()){
    			pendingUsers.add(user);
    		}
    	}
        session.close();
    	
    	return pendingUsers;
    }
    
    public User getUserByID(int userID){
    	Session session = sessionFactory.openSession();
        
        User user = (User)session.createCriteria(User.class)
                .add( Restrictions.eq("userID", userID) ).uniqueResult();
        session.close();       
        return user;
    }
}
