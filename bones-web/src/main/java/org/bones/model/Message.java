package org.bones.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="messages")
public class Message implements Comparable<Message>{
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int messageID;
	@ManyToOne
    @JoinColumn(name="USERID")
	private User user;
	@ManyToOne
    @JoinColumn(name="DISCUSSIONID")
	private Discussion discussion;
	private String title;
	private String content;
	private String createdate;
	
	public Message(){
		this.setTitle("");
		this.setContent("");
		this.setCreatedate("");
	}

	public int getMessageID() {
		return messageID;
	}

	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Discussion getDiscussion() {
		return discussion;
	}

	public void setDiscussion(Discussion discussion) {
		this.discussion = discussion;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	@Override
	public int compareTo(Message o) {
//		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		return this.getCreatedate().compareTo(o.getCreatedate());
	}
	
	
	

}
