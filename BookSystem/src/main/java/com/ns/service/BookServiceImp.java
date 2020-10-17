package com.ns.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ns.dao.BookDAO;
import com.ns.model.Book;

@Service
public class BookServiceImp implements BookService {
	
	@Autowired
	BookDAO bdao;

	@Override
	public boolean insertBook(Book book) {
		// TODO Auto-generated method stub
		boolean b=bdao.insertBook(book);
		return b;
	}

	@Override
	public List<Book> seeAllBooks() {
		// TODO Auto-generated method stub
		List<Book> blist=bdao.seeAllBooks();
		return blist;
	}

}
