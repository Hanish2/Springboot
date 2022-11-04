package com.socialmediapage.digipage.service;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;

import com.socialmediapage.digipage.bean.User;

public interface Userservice {

	void insert(HttpServletRequest request) throws ParseException;

	boolean login(HttpServletRequest request, ModelMap modelmap) throws NullPointerException;

	User getDataByName(String name) throws NullPointerException;

	User getDataById(int id) throws NullPointerException;

	void updateUser(HttpServletRequest request) throws ParseException;

	User getDataByEmail(String email) throws NullPointerException;

}
