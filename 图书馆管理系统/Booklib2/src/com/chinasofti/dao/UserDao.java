package com.chinasofti.dao;

import java.util.ArrayList;
import java.util.List;

import com.chinasofti.entity.Users;

public class UserDao {

	public int insertUser(Users u) { // ����û�
		InitData.userList.add(u);
		return 1;
	}

	public int updateUser() {
		return 0;
	}

	public int deleteUser() {
		return 0;
	}

	public List<Users> getUsers() { // ���������û�
		return InitData.userList;

	}

	public Users getUsersByLogin(String userLogin) { // �鿴������Ϣ
		for (Users u : InitData.userList) {
			if (u.getUserLogin().equals(userLogin)) {
				return u;
			}
		}
		return null;
	}

	public Users getUsers(String userLogin, String userPwd) { // ��¼�ж�
		for (Users u : InitData.userList) {
			if (u.getUserLogin().equals(userLogin) && u.getUserPwd().equals(userPwd)) {
				return u;
			}
		}
		return null;
	}

	public int updatePwd(String userLogin, String pwd) { // ��������
		List<Users> userList = InitData.userList;
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getUserLogin().equals(userLogin)) {
				userList.get(i).setUserPwd(pwd);
			}
		}
		return 1;

	}

	public static void main(String[] args) {

		List<Users> userList = InitData.userList;
		for (Users u : userList) {
			System.out.println(u.getUserLogin());
		}
	}
}
