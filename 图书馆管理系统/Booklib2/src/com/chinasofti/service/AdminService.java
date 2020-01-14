package com.chinasofti.service;

import java.util.List;
import com.chinasofti.dao.AdminDao;
import com.chinasofti.entity.Admin;
import com.chinasofti.dao.BookDao;
import com.chinasofti.entity.Book;

public class AdminService {

	BookDao bookdao = new BookDao();

	public boolean AdminLogin(String AdminLogin, String AdminPwd) { // 管理员登陆
		AdminDao admindao = new AdminDao();
		AdminDao u = new AdminDao();
		if (u == null) {
			return false;
		} else {
			return true;
		}
	}

	public int AdminUpdatPwd(String Adminlogin, String AdminPwd) { // 设置密码
		AdminDao admindao = new AdminDao();
		admindao.AdminupdatePwd(Adminlogin, AdminPwd);
		return 1;
	}

	public List<Admin> getAllAdminer() { // 遍历所有管理员
		AdminDao admindao = new AdminDao();
		List<Admin> list = admindao.getallUsers();
		return list;
	}

	public int AdminBorrowBook(String bookName) { // 管理员借书
		BookService bookservice = new BookService();
		int x = bookservice.broowBook(bookName);
		return x;
	}

	public int AdminReturnBook(String bookName) { // 管理员换书
		BookService bookservice = new BookService();
		int x = bookservice.ReturnBook(bookName);
		return x;
	}

	public int AdminAddBook(Book book) { // 添加图书
		BookService bookservice = new BookService();
		int x = bookservice.addBook(book);
		return x;
	}

	public int DeleteBook(String bookName) { // 删除图书
		BookService bookservice = new BookService();
		int x = bookservice.deleteBook(bookName);
		return x;
	}

}
