package com.chinasofti.service;

import com.chinasofti.dao.UserDao;
import java.util.List;
import com.chinasofti.dao.UserDao;
import com.chinasofti.entity.Users;

public class UserService {

	public boolean login(String userLogin, String userPwd) // 判断登录

	{

		UserDao userdao = new UserDao();
		Users u = userdao.getUsers(userLogin, userPwd);
		if (u == null) {
			return false;
		} else {
			return true;
		}
	}

	public int addUser(Users u) // 添加用户
	{
		UserDao dao = new UserDao();
		for (Users u1 : dao.getUsers()) {
			if (u1.getUserLogin().equals(u.getUserLogin())) {
				return 0;
			}
		}
		return 1;
	}

	public List<Users> getAllUsers() { // 遍历所有用户
		UserDao dao = new UserDao();
		return dao.getUsers();
	}

	public List<Users> getUsers(String userLogin) { // 得到用户
		UserDao dao = new UserDao();
		List<Users> list = dao.getUsers();
		return list;
	}

	public int updatePwd(String userLogin, String pwd) { // 更换密码
		UserDao dao = new UserDao();
		dao.updatePwd(userLogin, pwd);
		return 1;
	}

	public Users getUserByLogin(String userLogin) { // 登陆调用
		UserDao dao = new UserDao();
		return dao.getUsersByLogin(userLogin);
	}

}
