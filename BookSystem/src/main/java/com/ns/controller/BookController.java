package com.ns.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ns.model.Book;
import com.ns.service.BookService;

@RestController
@RequestMapping(value="/")
public class BookController {
	
	@Autowired
	BookService bservice;
	
	@RequestMapping(value="/insert",method = RequestMethod.POST)
	public String insertBook(@ModelAttribute Book book) {
		boolean b=bservice.insertBook(book);
		if(b)
		return "success";
		else
			return "error";
	}
	@RequestMapping(value="/seeall")
	public List<Book> seeAllBooks(){
		List<Book> blist=bservice.seeAllBooks();
		return blist;
		
	}

}
