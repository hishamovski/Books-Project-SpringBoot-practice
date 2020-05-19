package com.WannaBe.Project.DAO;

import com.WannaBe.Project.Model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class BookDataAccessService implements BookDao{
    @Override
    public int insertBook(UUID id, Book book) {
        return 0;
    }

    @Override
    public List<Book> getBooks() {
        List<Book> DB = new ArrayList<>();
       Book b =  new Book(UUID.randomUUID(),"title", "2134356","Owner");
       DB.add(b);
       return DB;
    }

    @Override
    public int deleteBook(UUID id) {
        return 0;
    }

    @Override
    public int updateBook(UUID id, Book book) {
        return 0;
    }

    @Override
    public Optional<Book> getBook(UUID id) {
        return Optional.empty();
    }
}
