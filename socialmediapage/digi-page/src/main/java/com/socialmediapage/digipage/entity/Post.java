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
 private String  uname;
@Lob
 private byte[] image_url;
@Column
 private String description;
@Column
 private int likes;
@Column
 private Date timestamp;

private String base64image;
public String getBase64image() {
	return base64image;
}
public void setBase64image(String base64image) {
	this.base64image = base64image;
}
public int getPost_id() {
	return post_id;
}
public void setPost_id(int post_id) {
	this.post_id = post_id;
}
public String getuname() {
	return uname;
}
public void setuname(String uname) {
	this.uname = uname;
		}

public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
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
public Date getTimestamp() {
	return timestamp;
}
public void setTimestamp(Date timestamp) {
	this.timestamp = timestamp;
}
public Post() {
	super();
	// TODO Auto-generated constructor stub
}
public byte[] getImage_url() {
	 
	return image_url;
}
public void setImage_url(byte[] image_url) {
	this.image_url = image_url;
}

public Post(int post_id, String uname, byte[] image_url, String description, int likes, Date timestamp) {
	super();
	this.post_id = post_id;
	this.uname = uname;
	this.image_url = image_url;
	this.description = description;
	this.likes = likes;
	this.timestamp = timestamp;
}
}
