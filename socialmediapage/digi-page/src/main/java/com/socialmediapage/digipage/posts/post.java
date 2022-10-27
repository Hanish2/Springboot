package com.socialmediapage.digipage.posts;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="post")
public class post {
@Id
@Column
@GeneratedValue(strategy = GenerationType.IDENTITY)
 private int post_id; 
@Column
 private String  uname;
@Column
 private String image_url;
@Column
 private String description;
@Column
 private int likes;
@Column
 private Date timestamp;
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
public String getImage_url() {
	return image_url;
}
public void setImage_url(String image_url) {
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
public Date getTimestamp() {
	return timestamp;
}
public void setTimestamp(Date timestamp) {
	this.timestamp = timestamp;
}
public post() {
	super();
	// TODO Auto-generated constructor stub
}
public post(int post_id, String uname, String image_url, String description, int likes, Date timestamp) {
	super();
	this.post_id = post_id;
	this.uname	 = uname;
	this.image_url = image_url;
	this.description = description;
	this.likes = likes;
	this.timestamp = timestamp;
}


}
