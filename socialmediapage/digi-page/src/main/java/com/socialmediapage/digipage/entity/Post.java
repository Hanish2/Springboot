package com.socialmediapage.digipage.entity;

import java.io.File;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="post")
public class Post {
@Id
@Column
@GeneratedValue(strategy = GenerationType.IDENTITY)
 private int post_id; 
@Column
 private String  userName;
@Lob
 private byte[] image_url;
@Column
 private String description;
@Column
 private int likes;
@Column
 private Date timeStamp;

private String base64image;

public int getPost_id() {
	return post_id;
}

public void setPost_id(int post_id) {
	this.post_id = post_id;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public byte[] getImage_url() {
	return image_url;
}

public void setImage_url(byte[] image_url) {
	this.image_url = image_url;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public int getLikes() {
	return likes;
}

public void setLikes(int likes) {
	this.likes = likes;
}

public Date getTimeStamp() {
	return timeStamp;
}

public void setTimeStamp(Date timeStamp) {
	this.timeStamp = timeStamp;
}

public String getBase64image() {
	return base64image;
}

public void setBase64image(String base64image) {
	this.base64image = base64image;
}

public Post() {
	
}

public Post(int post_id, String userName, byte[] image_url, String description, int likes, Date timeStamp) {
	super();
	this.post_id = post_id;
	this.userName = userName;
	this.image_url = image_url;
	this.description = description;
	this.likes = likes;
	this.timeStamp = timeStamp;
}

}
