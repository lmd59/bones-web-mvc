package org.bones.dao;

import org.bones.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

public class UserDAO {
    
    private SessionFactory sessionFactory;
         
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
     
    @Transactional(readOnly=false)
    public void addUser(User p) {
        Session session = sessionFactory.openSession();
        session.save(p);
        session.close();       
    }
}
