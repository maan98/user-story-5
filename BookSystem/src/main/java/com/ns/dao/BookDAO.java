package com.ns.dao;

import java.util.List;

import com.ns.model.Book;

public interface BookDAO {
	
	public abstract boolean insertBook(Book book);
	public abstract List<Book> seeAllBooks();

}
