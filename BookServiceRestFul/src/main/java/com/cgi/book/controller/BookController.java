package com.cgi.book.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cgi.book.model.Book;
import com.cgi.book.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> books = bookService.getAllBooks();
		return new ResponseEntity<>(books, HttpStatus.OK);
	}

	@GetMapping("/{bookid}")
	public ResponseEntity<Book> getBookById(@PathVariable int bookid) {
		Book book = bookService.getBookById(bookid);
		if (book != null) {
			return new ResponseEntity<>(book, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book savedBook = bookService.saveBook(book);
		return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
	}

	@PutMapping("/{bookid}")
	public ResponseEntity<Book> updateBook(@PathVariable int bookid, @RequestBody Book updatedBook) {

		Book updated = bookService.updateBook(bookid, updatedBook);
		if (updated != null) {
			return new ResponseEntity<>(updated, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{bookid}")
	public ResponseEntity<Book> deleteBook(@PathVariable int bookid) {

		Book deletedBlog = bookService.deleteBook(bookid);
		if (deletedBlog != null) {
			return new ResponseEntity<>(deletedBlog, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
