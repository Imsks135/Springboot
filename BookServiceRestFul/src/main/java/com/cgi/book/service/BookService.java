package com.cgi.book.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cgi.book.model.Book;
import com.cgi.book.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	public Book getBookById(int bookid) {
		return bookRepository.findById(bookid).orElse(null);
	}

	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}

	public Book deleteBook(int bookid) {
		Book book = bookRepository.findById(bookid).orElse(null);
		if (book != null) {
			bookRepository.delete(book);
		}
		return book;
	}

	public Book updateBook(int bookid, Book updatedBook) {
		// TODO Auto-generated method stub
		Book book = bookRepository.findById(bookid).orElse(null);
		if (book != null) {

			book.setTitle(updatedBook.getTitle());
			book.setAuthor(updatedBook.getAuthor());
			return bookRepository.save(book);
		}
		return null;
	}

}
