package com.chinasofti.dao;

import java.util.List;

import com.chinasofti.entity.Book;

public class BookDao {
	//返回集合
	//List<Book> bookList = InitData.getAllBook();
	
	public List<Book> selectionBook(){
		return InitData.bookList;
	}
	
	
	public int updateBookStock(String bookName){                  //借书
		List<Book> listBook = InitData.bookList;
		for(int i = 0;i<listBook.size();i++){
			if(listBook.get(i).getBookName().equals(bookName)){
				listBook.get(i).setStock(listBook.get(i).getStock()-1);
			}
		}
		return 1;
	}
	
	
	public Book selectBookName(String bookName){                //查看所有图书
		for(Book book: InitData.bookList){
			if(book.getBookName().equals(bookName)){
				return book;
			}
		}
		return null;
	}
	
	
	public int updateReturnBookStock(String bookName){              //归还图书
		List<Book> listBook = InitData.bookList;
		for(int i = 0;i<listBook.size();i++){
			if(listBook.get(i).getBookName().equals(bookName)){
				listBook.get(i).setStock(listBook.get(i).getStock()+1);
			}
		}
		return 1;
	}
	
	
	public void insertBook(Book book){                //添加图书
		InitData.bookList.add(book);
	}
	
	
	public int deleteBook(String BookName){                        //删除指定图书
		for(int i =0;i<InitData.bookList.size();i++){
			if(InitData.bookList.get(i).getBookName().equals(BookName)){
				InitData.bookList.remove(i);
				return 1;
			}
		}
		return 0;
	}
	
	
	public void deleteBook(){              //下架图书
		InitData.bookList.clear();
	}
	
}