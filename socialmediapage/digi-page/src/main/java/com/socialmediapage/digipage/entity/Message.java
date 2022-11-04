package com.socialmediapage.digipage.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="message")
public class Message {
@Id
@Column
@GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;
@Column
 private String name;
 @Column
 private String content;
 @Column
 private Date timeStamp;
 
 public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public Date getTimestamp() {
	return timeStamp;
}
public void setTimestamp(Date timeStamp) {
	this.timeStamp = timeStamp;
}

 

}
