package com.WannaBe.Project.Service;

import com.WannaBe.Project.DAO.BookDao;
import com.WannaBe.Project.Model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {

    private final BookDao bookDao;

    @Autowired
    public BookService(@Qualifier("postgres") BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public int addBook(Book book){
        return bookDao.addBook(book);
    }

    public List<Book> getBooks(){
        return bookDao.getBooks();
    }

    public Optional<Book> getBook(UUID id){
        return bookDao.getBook(id);
    }

    public int deleteBook(UUID id) {
        return bookDao.deleteBook(id);
    }

    public int updateBook(UUID id, Book book){
        return bookDao.updateBook(id, book);
    }
}
