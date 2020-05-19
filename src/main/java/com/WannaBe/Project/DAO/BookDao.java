package com.WannaBe.Project.DAO;

import com.WannaBe.Project.Model.Book;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookDao {

    int insertBook(UUID id, Book book);
    default int addBook(Book book) {
        UUID id = UUID.randomUUID();
        return insertBook(id, book);
    }

    List<Book> getBooks();

    int deleteBook(UUID id);
    int updateBook(UUID id, Book book);

    Optional<Book> getBook(UUID id);
}
