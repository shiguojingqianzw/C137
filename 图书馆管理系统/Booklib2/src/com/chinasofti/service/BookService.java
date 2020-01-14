package com.chinasofti.service;

import java.util.List;
import com.chinasofti.dao.BookDao;
import com.chinasofti.entity.Book;

public class BookService {

	BookDao dao = new BookDao();

	public List<Book> getAllBook() { // ��������ͼ��
		return dao.selectionBook();
	}

	public int broowBook(String bookName) { // ����
		Book book = dao.selectBookName(bookName);
		if (book == null) {
			return 0;
		} else if (book.getStock() == 0) {
			return 1;
		} else {
			dao.updateBookStock(bookName);
			return 2;
		}
	}

	public int ReturnBook(String bookName) { // ����
		Book book = dao.selectBookName(bookName);
		if (book == null) {
			return 0;
		} else {
			dao.updateReturnBookStock(bookName);
			return 1;
		}
	}

	public int addBook(Book book) { // ���ͼ��
		BookDao bookdao = new BookDao();
		Book b = dao.selectBookName(book.getBookName());
		if (b != null) {
			return 0;
		} else {
			dao.insertBook(book);
			return 1;
		}
	}

	public int deleteBook(String BookName) { // ɾ��ָ��ͼ��
		BookDao bookdao = new BookDao();
		if (dao.selectBookName(BookName) == null) {
			return 0;
		} else {
			dao.deleteBook(BookName);
			return 1;
		}
	}

	public void deleteBook() { // �¼�ͼ��
		BookDao dao = new BookDao();
		dao.deleteBook();
	}
}