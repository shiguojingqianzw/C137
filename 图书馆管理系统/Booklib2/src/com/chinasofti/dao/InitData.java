package com.chinasofti.dao;

import java.util.ArrayList;
import java.util.List;

import com.chinasofti.entity.Admin;
import com.chinasofti.entity.Book;
import com.chinasofti.entity.Users;

public class InitData {

	public static List<Users> userList = new ArrayList<Users>();
	public static List<Book> bookList = new ArrayList<Book>();
	public static List<Admin> adminList = new ArrayList<Admin>();

	public InitData() {

		userList.add(new Users("xiaojiejie", "123456"));
		userList.add(new Users("dagege", "123456"));
		userList.add(new Users("win", "123456"));

		bookList.add(new Book("java���ŵ������", 10));
		bookList.add(new Book("���ݽṹ�ɻ�ָ��", 5));
		bookList.add(new Book("��ͺͷ�÷���", 30));

		adminList.add(new Admin("admin", "123456"));
	}

}
