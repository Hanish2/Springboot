package com.socialmediapage.digipage.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.socialmediapage.digipage.bean.Friend;

public interface Friendservice {

	void saveFriend(int id1, int id2) throws SQLException;

	List<Friend> getList(int id);

}
