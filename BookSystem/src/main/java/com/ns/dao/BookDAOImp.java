package com.ns.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ns.model.Book;

@Repository
public class BookDAOImp implements BookDAO{
	
	static Connection con;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated constructor stub
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/schemaone","root","M@@n98n@v");
		return con;
	}
	

	@Override
	public boolean insertBook(Book book) {
		try {
			con=BookDAOImp.getConnection();
			PreparedStatement pst1=con.prepareStatement("insert into book values(?,?,?,?)");
			pst1.setInt(1, book.getId());
			pst1.setString(2, book.getTitle());
			pst1.setString(3, book.getAuthor());
			pst1.setInt(4, book.getPrice());
			boolean b=pst1.execute();
			if(b)
				return true;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Book> seeAllBooks() {
		try {
			con=BookDAOImp.getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from book");
			List<Book> blist=new ArrayList<Book>();
			while(rs.next()) {
				Book b=new Book();
				b.setId(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getInt(4));
				blist.add(b);
			}
			return blist;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
