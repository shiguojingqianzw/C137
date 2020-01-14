package com.chinasofti.entity;

public class Book {
	
	private String bookName;
	private int stock;	
	
	public Book(String bookName,int stock){
		this.bookName=bookName;
		this.stock=stock;
	}

	public String getBookName() {
		return bookName;
	}
	
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public int getStock() {
		return stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}

}
