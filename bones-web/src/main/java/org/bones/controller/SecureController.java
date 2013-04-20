package org.bones.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.bones.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SecureController {
	
	@RequestMapping(value="/secure/user-profile.htm", method = RequestMethod.GET)
	public String getProfile(ModelMap model) {
 
		System.out.println("Getting current user profile");
        
        try{
        	User user = null;
            Session hibSession = getHibernateSession();
            Transaction tx = hibSession.beginTransaction();
            user = (User) hibSession.createCriteria(User.class)
                    .add( Restrictions.eq("username", "alex") ).uniqueResult();
        	tx.commit();
            System.out.println("currUser name: " + user.getUsername());
            model.addAttribute("currUser",user);
        }catch(Exception e){
            System.out.println("Exception: " + e);
        }
		return "secure/user-profile";
 
	}
	
	private Session getHibernateSession(){
        Session hibSession = null;
        try{
            //Hibernate Objects
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure().buildSessionFactory();
            hibSession = sf.openSession();
        }catch(Exception e){
            System.out.println("Exception: " + e);
        }
        return hibSession;
    }
	
}
