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
		System.out.println("��ӭ����ͼ��ݹ���ϵͳ");
		System.out.println("1.��Ա��¼");
		System.out.println("2.����Ա��¼");
		System.out.println("3.ע���Ա");
		System.out.println("4.�˳�ϵͳ");
		System.out.println("��ѡ���������");

		return scanner.nextInt();
	}

	public static int userMenuShow() {
		System.out.println("��ӭ�����û����˵�");
		System.out.println("1.�鿴����ͼ��");
		System.out.println("2.����");
		System.out.println("3.����");
		System.out.println("4.�鿴������Ϣ");
		System.out.println("5.�޸�����");
		System.out.println("6.�˳�");
		System.out.println("��ѡ��");

		return scanner.nextInt();
	}

	public static int AdminMenuShow() {
		System.out.println("��ӭ�������Ա���˵�");
		System.out.println("1.���ͼ��");
		System.out.println("2.ͼ���¼�");
		System.out.println("3.�༭ͼ��");
		System.out.println("4.�鿴����ͼ��");
		System.out.println("5.�鿴���е��û�");
		System.out.println("6.�޸�����");
		System.out.println("7.����Ա�˳���¼:");
		System.out.println("��ѡ��");

		return scanner.nextInt();
	}

	public static void main(String[] argv) {

		new InitData(); // ��ʼ��
		boolean isExit = false;
		do {
			int Chose = systemMenuShow();

			switch (Chose) {
			case 1:
				System.out.println("�������û���");
				String userName = scanner.next();
				System.out.println("����������");
				String userPwd = scanner.next();
				if (userservice.login(userName, userPwd)) {
					boolean isUserExit = false;
					do {
						int userChose = userMenuShow();

						switch (userChose) {
						case 1:
							System.out.println("ͼ������:  �����");
							for (Book book : bookservice.getAllBook()) {
								System.out.println(book.getBookName() + " " + book.getStock());
							}
							break;

						case 2:
							System.out.println("��������������:");
							String bookName = scanner.next();
							int b = bookservice.broowBook(bookName);
							if (b == 0) {
								System.out.println("û�и�ͼ��:");
							} else if (b == 1) {
								System.out.println("�����Ϊ��:");
							} else {
								System.out.println("����ɹ�:");
							}
							break;

						case 3:
							System.out.println("���뻹�������:");
							String bookNewName = scanner.next();
							int r = bookservice.ReturnBook(bookNewName);
							if (r == 0) {
								System.out.println("û�и�ͼ��:");
							} else {
								System.out.println("����ɹ�:");
							}
							break;

						case 4:
							System.out.println("�û���    ����");
							Users user = userservice.getUserByLogin(userName);
							System.out.println(user.getUserLogin() + " " + user.getUserPwd());
							break;

						case 5:
							System.out.println("����������:");
							String pwd = scanner.next();
							userservice.updatePwd(userName, pwd);
							System.out.println("�����޸ĳɹ�:");
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
					System.out.println("��¼ʧ��:");
				}
				break;

			case 2:
				System.out.println("�������Ա���û���");
				String AdminName = scanner.next();
				System.out.println("�������Ա������");
				String AdminPwd = scanner.next();
				if (adminservice.AdminLogin(AdminName, AdminPwd)) {
					boolean isAdminExit = false;
					do {
						int AdminChose = AdminMenuShow();

						switch (AdminChose) {
						case 1:
							System.out.println("���ͼ�������:   ���ͼ�������");
							String BookNewName = scanner.next();
							int BookNewStock = scanner.nextInt();
							Book book = new Book(BookNewName, BookNewStock);
							int x = bookservice.addBook(book);
							if (x == 0) {
								System.out.println("���ʧ��:");
							} else {
								System.out.println("��ӳɹ�:");
							}
							break;

						case 2:
							System.out.println("����Ҫ�¼ܵ���");
							String bookBadName = scanner.next();
							int q = bookservice.deleteBook(bookBadName);
							if (q == 0) {
								System.out.println("�޴���:");
							} else {
								System.out.println("�¼ܳɹ�:");
							}
							break;

						case 3:
							System.out.println("����Ҫ�޸ĵ���Ŀ:");
							String ReviseBookName = scanner.next();
							BookDao bookdao = new BookDao();
							int a = bookdao.updateBookStock(ReviseBookName);
							if (a == 1) {
								System.out.println("�޸Ŀ��ɹ�");
							} else {
								System.out.println("�޸Ŀ��ʧ��:");
							}
							break;

						case 4:
							System.out.println("ͼ������  �����");
							for (Book book1 : bookservice.getAllBook()) {
								System.out.println(book1.getBookName() + " " + book1.getStock());
							}
							break;

						case 5:
							System.out.println("��Ա�û���    ��Ա����");
							for (Users u : userservice.getAllUsers()) {
								System.out.println(u.getUserLogin() + " " + u.getUserPwd());
							}
							break;

						case 6:
							System.out.println("�������Ա������:");
							String AdminNewPwd = scanner.next();
							int b = adminservice.AdminUpdatPwd(AdminName, AdminNewPwd);
							if (b == 1) {
								System.out.println("�޸�����ɹ�:");
							} else {
								System.out.println("�޸�����ʧ��:");
							}
							break;

						case 7:
							isAdminExit = true;
							break;
						}

					} while (!isAdminExit);
				} else {
					System.out.println("����Ա��½ʧ��:");
				}
				break;

			case 3:
				System.out.println("������ӵĻ�Ա�û�:");
				String NewUserName = scanner.next();
				System.out.println("������ӻ�Ա������:");
				String NewUserPwd = scanner.next();
				Users u = new Users(NewUserName, NewUserPwd);
				int d = userservice.addUser(u);
				if (d == 0) {
					System.out.println("�û��Ѵ���:");
				} else {
					System.out.println("��Ա��ӳɹ�:");
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
