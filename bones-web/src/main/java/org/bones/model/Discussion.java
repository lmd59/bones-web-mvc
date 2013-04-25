package org.bones.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="discussions")
public class Discussion {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int discussionID;
    private String title;
    private String startdate;
    @OneToMany(mappedBy="discussion")
    private Set<Message> messages;
    
    public Discussion(){
    	this.setTitle("");
    	this.setStartdate("");
    }
    
	public int getDiscussionID() {
		return discussionID;
	}
	public void setDiscussionID(int discussionID) {
		this.discussionID = discussionID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public Set<Message> getMessages() {
		return messages;
	}
	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}
}
