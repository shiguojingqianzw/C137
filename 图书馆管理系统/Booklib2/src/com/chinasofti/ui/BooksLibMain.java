package com.chinasofti.ui;

import java.util.List;
import com.chinasofti.dao.AdminDao;
import com.chinasofti.service.AdminService;
import com.chinasofti.entity.Admin;
import java.util.Scanner;
import com.chinasofti.service.BookService;
import com.chinasofti.service.UserService;
import com.chinasofti.dao.InitData;
import com.chinasofti.dao.UserDao;
import com.chinasofti.entity.Book;
import com.chinasofti.entity.Users;
import com.chinasofti.entity.Admin;
import com.chinasofti.dao.BookDao;

public class BooksLibMain {

	static Scanner scanner = new Scanner(System.in);
	static UserService userservice = new UserService();
	static BookService bookservice = new BookService();
	static AdminService adminservice = new AdminService();
	static UserDao dao = new UserDao();

	public static int systemMenuShow() {
		System.out.println("欢迎光临图书馆管理系统");
		System.out.println("1.会员登录");
		System.out.println("2.管理员登录");
		System.out.println("3.注册会员");
		System.out.println("4.退出系统");
		System.out.println("请选择您的身份");

		return scanner.nextInt();
	}

	public static int userMenuShow() {
		System.out.println("欢迎进入用户主菜单");
		System.out.println("1.查看所有图书");
		System.out.println("2.借书");
		System.out.println("3.还书");
		System.out.println("4.查看个人信息");
		System.out.println("5.修改密码");
		System.out.println("6.退出");
		System.out.println("请选择");

		return scanner.nextInt();
	}

	public static int AdminMenuShow() {
		System.out.println("欢迎进入管理员主菜单");
		System.out.println("1.添加图书");
		System.out.println("2.图书下架");
		System.out.println("3.编辑图书");
		System.out.println("4.查看所有图书");
		System.out.println("5.查看所有的用户");
		System.out.println("6.修改密码");
		System.out.println("7.管理员退出登录:");
		System.out.println("请选择");

		return scanner.nextInt();
	}

	public static void main(String[] argv) {

		new InitData(); // 初始化
		boolean isExit = false;
		do {
			int Chose = systemMenuShow();

			switch (Chose) {
			case 1:
				System.out.println("请输入用户名");
				String userName = scanner.next();
				System.out.println("请输入密码");
				String userPwd = scanner.next();
				if (userservice.login(userName, userPwd)) {
					boolean isUserExit = false;
					do {
						int userChose = userMenuShow();

						switch (userChose) {
						case 1:
							System.out.println("图书名称:  库存量");
							for (Book book : bookservice.getAllBook()) {
								System.out.println(book.getBookName() + " " + book.getStock());
							}
							break;

						case 2:
							System.out.println("请输入借书的书名:");
							String bookName = scanner.next();
							int b = bookservice.broowBook(bookName);
							if (b == 0) {
								System.out.println("没有该图书:");
							} else if (b == 1) {
								System.out.println("库存量为空:");
							} else {
								System.out.println("借书成功:");
							}
							break;

						case 3:
							System.out.println("输入还书的书名:");
							String bookNewName = scanner.next();
							int r = bookservice.ReturnBook(bookNewName);
							if (r == 0) {
								System.out.println("没有该图书:");
							} else {
								System.out.println("还书成功:");
							}
							break;

						case 4:
							System.out.println("用户名    密码");
							Users user = userservice.getUserByLogin(userName);
							System.out.println(user.getUserLogin() + " " + user.getUserPwd());
							break;

						case 5:
							System.out.println("输入新密码:");
							String pwd = scanner.next();
							userservice.updatePwd(userName, pwd);
							System.out.println("密码修改成功:");
							break;

						case 6:
							isExit = true;
							break;

						default:
							break;
						}
					} while (!isUserExit);

				}

				else {
					System.out.println("登录失败:");
				}
				break;

			case 2:
				System.out.println("输入管理员的用户名");
				String AdminName = scanner.next();
				System.out.println("输入管理员的密码");
				String AdminPwd = scanner.next();
				if (adminservice.AdminLogin(AdminName, AdminPwd)) {
					boolean isAdminExit = false;
					do {
						int AdminChose = AdminMenuShow();

						switch (AdminChose) {
						case 1:
							System.out.println("添加图书的名称:   添加图书的容量");
							String BookNewName = scanner.next();
							int BookNewStock = scanner.nextInt();
							Book book = new Book(BookNewName, BookNewStock);
							int x = bookservice.addBook(book);
							if (x == 0) {
								System.out.println("添加失败:");
							} else {
								System.out.println("添加成功:");
							}
							break;

						case 2:
							System.out.println("输入要下架的书");
							String bookBadName = scanner.next();
							int q = bookservice.deleteBook(bookBadName);
							if (q == 0) {
								System.out.println("无此书:");
							} else {
								System.out.println("下架成功:");
							}
							break;

						case 3:
							System.out.println("输入要修改的书目:");
							String ReviseBookName = scanner.next();
							BookDao bookdao = new BookDao();
							int a = bookdao.updateBookStock(ReviseBookName);
							if (a == 1) {
								System.out.println("修改库存成功");
							} else {
								System.out.println("修改库存失败:");
							}
							break;

						case 4:
							System.out.println("图书名称  库存量");
							for (Book book1 : bookservice.getAllBook()) {
								System.out.println(book1.getBookName() + " " + book1.getStock());
							}
							break;

						case 5:
							System.out.println("会员用户名    会员密码");
							for (Users u : userservice.getAllUsers()) {
								System.out.println(u.getUserLogin() + " " + u.getUserPwd());
							}
							break;

						case 6:
							System.out.println("输入管理员新密码:");
							String AdminNewPwd = scanner.next();
							int b = adminservice.AdminUpdatPwd(AdminName, AdminNewPwd);
							if (b == 1) {
								System.out.println("修改密码成功:");
							} else {
								System.out.println("修改密码失败:");
							}
							break;

						case 7:
							isAdminExit = true;
							break;
						}

					} while (!isAdminExit);
				} else {
					System.out.println("管理员登陆失败:");
				}
				break;

			case 3:
				System.out.println("输入添加的会员用户:");
				String NewUserName = scanner.next();
				System.out.println("输入添加会员的密码:");
				String NewUserPwd = scanner.next();
				Users u = new Users(NewUserName, NewUserPwd);
				int d = userservice.addUser(u);
				if (d == 0) {
					System.out.println("用户已存在:");
				} else {
					System.out.println("会员添加成功:");
					dao.insertUser(u);
				}
				break;

			case 4:
				isExit = true;
				break;
			}
		} while (!isExit);
	}
}
