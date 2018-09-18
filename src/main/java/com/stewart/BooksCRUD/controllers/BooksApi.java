package com.stewart.BooksCRUD.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stewart.BooksCRUD.models.Book;
import com.stewart.BooksCRUD.services.BookService;

@RestController
public class BooksApi {
	private final BookService bookService;
	public BooksApi(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping("/api/books")
	public List<Book> index() {
		return bookService.allBooks();
	}
	
	@PostMapping("/api/books")
	public Book create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
		Book book = new Book(title, desc, lang, numOfPages);
		return bookService.createBook(book);
	}
	
	@GetMapping("/api/books/{id}")
	public Book show(@PathVariable("id") Long id) {
		Book book = bookService.findBook(id);
		return book;
	}
	
	@PatchMapping("/api/books/update")
	public Book update(@ModelAttribute("book") Book book) {
		Book updateBook = bookService.updateBook(book);
		return updateBook;
	}
	
	@DeleteMapping("/api/books/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
		return "redirect:/api/books";
	}
}
