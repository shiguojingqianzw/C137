package com.chinasofti.dao;

import java.util.List;

import com.chinasofti.entity.Admin;

public class AdminDao {

	public Admin getAdmin(String login, String AdminPwd) { // 判断
		for (Admin u : InitData.adminList) {
			if (u.getLogin().equals(login) && u.getPwd().equals(AdminPwd)) {
				return u;
			}
		}
		return null;
	}

	public int AdminupdatePwd(String userLogin, String pwd) { // 设置密码
		List<Admin> adminList = InitData.adminList;
		for (int i = 0; i < InitData.adminList.size(); i++) {
			if (adminList.get(i).getLogin().equals(userLogin)) {
				adminList.get(i).setPwd(pwd);
			}
		}
		return 1;
	}

	public List<Admin> getallUsers() { // 遍历所有管理员
		return InitData.adminList;
	}

}
