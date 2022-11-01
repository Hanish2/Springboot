package com.socialmediapage.digipage.friends;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="userfriends")
@Entity
public class Friend {
	 @Column
	    @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
		int id;
	    @Column
	    int sender;
	    @Column
	    int reciever;
	    @Column
	    String status;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getSender() {
			return sender;
		}
		public void setSender(int sender) {
			this.sender = sender;
		}
		public int getReciever() {
			return reciever;
		}
		public void setReciever(int reciever) {
			this.reciever = reciever;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		
		public Friend() {
		
		}
		public Friend(int id, int sender, int reciever, String status) {
		
			this.id = id;
			this.sender = sender;
			this.reciever = reciever;
			this.status = status;
		}
		
}
