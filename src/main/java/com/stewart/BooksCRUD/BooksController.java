package com.stewart.BooksCRUD;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stewart.BooksCRUD.models.Book;
import com.stewart.BooksCRUD.services.BookService;

@Controller
@RequestMapping("/books")
public class BooksController {
	private final BookService bookService;
	public BooksController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping("")
	public String index(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "/index.jsp";
	}
	
	@GetMapping("/new")
	public String newBook(@ModelAttribute("book") Book book) {
		return "/new.jsp";
	}
	
	@PostMapping("")
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "/new.jsp";
		} else {
			bookService.createBook(book);
			return "redirect:/books";
		}
	}
	
	@GetMapping("/m/show/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Book book = bookService.findBook(id);
		model.addAttribute(book);
		return "/show.jsp";
	}
	
	@GetMapping("/m/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Book book = bookService.findBook(id);
		model.addAttribute(book);
		return "/edit.jsp";
	}
	
	@PutMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/edit.jsp";
        } else {
            bookService.updateBook(book);
            return "redirect:/books";
        }
    }
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		System.out.println("delete");
		bookService.deleteBook(id);
		return "redirect:/books";
	}
	
	
	
	
}
