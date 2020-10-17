package com.ns.service;

import java.util.List;

import com.ns.model.Book;

public interface BookService {
	
	public abstract boolean insertBook(Book book);
	public abstract List<Book> seeAllBooks();

}
