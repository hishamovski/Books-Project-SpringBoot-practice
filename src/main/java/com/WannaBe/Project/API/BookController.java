package com.WannaBe.Project.API;

import com.WannaBe.Project.Model.Book;
import com.WannaBe.Project.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/books")
@RestController
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public void addBook(@NonNull @RequestBody Book book) {
        bookService.addBook(book);
    }

    @GetMapping
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    @GetMapping(path = "/{id}")
    public Book getBook(@PathVariable("id") UUID id){
        return bookService.getBook(id)
                .orElse( null);
    }
    @DeleteMapping(path = "/{id}")
    public void deleteBook(@PathVariable("id") UUID id) {
        bookService.deleteBook(id);
    }

    @PutMapping(path = "/{id}")
    public void updateBook(@PathVariable("id") UUID id, @NonNull @RequestBody Book book){
        bookService.updateBook(id, book);
    }
}
