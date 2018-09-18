package com.stewart.BooksCRUD.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.stewart.BooksCRUD.models.Book;
import com.stewart.BooksCRUD.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public List<Book> allBooks(){
		return bookRepository.findAll();
	}
	
	public Book createBook(Book b) {
		return bookRepository.save(b);
	}
	
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	
	public Book updateBook(Book book) {
		
		bookRepository.save(book);
		return book;
	}
	
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
}
