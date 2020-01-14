package com.chinasofti.service;

import java.util.List;
import com.chinasofti.dao.BookDao;
import com.chinasofti.entity.Book;

public class BookService {

	BookDao dao = new BookDao();

	public List<Book> getAllBook() { // 遍历所有图书
		return dao.selectionBook();
	}

	public int broowBook(String bookName) { // 借书
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

	public int ReturnBook(String bookName) { // 换书
		Book book = dao.selectBookName(bookName);
		if (book == null) {
			return 0;
		} else {
			dao.updateReturnBookStock(bookName);
			return 1;
		}
	}

	public int addBook(Book book) { // 添加图书
		BookDao bookdao = new BookDao();
		Book b = dao.selectBookName(book.getBookName());
		if (b != null) {
			return 0;
		} else {
			dao.insertBook(book);
			return 1;
		}
	}

	public int deleteBook(String BookName) { // 删除指定图书
		BookDao bookdao = new BookDao();
		if (dao.selectBookName(BookName) == null) {
			return 0;
		} else {
			dao.deleteBook(BookName);
			return 1;
		}
	}

	public void deleteBook() { // 下架图书
		BookDao dao = new BookDao();
		dao.deleteBook();
	}
}