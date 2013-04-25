package org.bones.dao;

import java.util.ArrayList;
import java.util.List;

import org.bones.model.Discussion;
import org.bones.model.Message;
import org.bones.model.User;
import org.bones.model.UserRole;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

public class BonesDAO {
    
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
    
    public List<Message> getMessagesForUser(User user){
    	Session session = sessionFactory.openSession();
        List<Message> messageList = session.createCriteria(Message.class).add( 
        		Restrictions.eq("user", user)).list();
        
        session.close();
    	
    	return messageList;
    }
    
    public List<Message> getMessagesForDiscussion(Discussion discussion){
    	Session session = sessionFactory.openSession();
        List<Message> messageList = session.createCriteria(Message.class).add( 
        		Restrictions.eq("discussion", discussion)).list();
        
        session.close();
    	
    	return messageList;
    }
    
    public User getUserByName(String name){
    	Session session = sessionFactory.openSession();
        
        User user = (User)session.createCriteria(User.class)
                .add( Restrictions.eq("username", name) ).uniqueResult();
        session.close();       
        return user;
    }
    
    @Transactional(readOnly=false)
    public List<Discussion> getAllDiscussions() {
        Session session = sessionFactory.openSession();
        List<Discussion> discussionList = session.createCriteria(Discussion.class).list();
//        for(User user: userList){
//        	Hibernate.initialize(user.getRoles());
//        }
        
        session.close();       
        return discussionList;
    }
    
    public Discussion getDiscussionByID(int discussionID){
    	Session session = sessionFactory.openSession();
        
        Discussion discussion = (Discussion)session.createCriteria(Discussion.class)
                .add( Restrictions.eq("discussionID", discussionID) ).uniqueResult();
        session.close();       
        return discussion;
    }
    
    @Transactional(readOnly=false)
    public void addMessage(Message message) {
        Session session = sessionFactory.openSession();
        session.save(message);
        session.close();       
    }
    
    @Transactional(readOnly=false)
    public void addDiscussion(Discussion discussion) {
        Session session = sessionFactory.openSession();
        session.save(discussion);
        session.close();       
    }
}
