package com.chinasofti.service;

import com.chinasofti.dao.UserDao;
import java.util.List;
import com.chinasofti.dao.UserDao;
import com.chinasofti.entity.Users;

public class UserService {

	public boolean login(String userLogin, String userPwd) // �жϵ�¼

	{

		UserDao userdao = new UserDao();
		Users u = userdao.getUsers(userLogin, userPwd);
		if (u == null) {
			return false;
		} else {
			return true;
		}
	}

	public int addUser(Users u) // ����û�
	{
		UserDao dao = new UserDao();
		for (Users u1 : dao.getUsers()) {
			if (u1.getUserLogin().equals(u.getUserLogin())) {
				return 0;
			}
		}
		return 1;
	}

	public List<Users> getAllUsers() { // ���������û�
		UserDao dao = new UserDao();
		return dao.getUsers();
	}

	public List<Users> getUsers(String userLogin) { // �õ��û�
		UserDao dao = new UserDao();
		List<Users> list = dao.getUsers();
		return list;
	}

	public int updatePwd(String userLogin, String pwd) { // ��������
		UserDao dao = new UserDao();
		dao.updatePwd(userLogin, pwd);
		return 1;
	}

	public Users getUserByLogin(String userLogin) { // ��½����
		UserDao dao = new UserDao();
		return dao.getUsersByLogin(userLogin);
	}

}
