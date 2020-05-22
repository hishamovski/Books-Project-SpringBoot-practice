package com.WannaBe.Project.DAO;

import com.WannaBe.Project.Model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class BookDataAccessService implements BookDao{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertBook(UUID id, Book book) {
        return 0;
    }

    @Override
    public List<Book> getBooks() {
        final String sql = "SELECT * FROM book";
        List <Book> books = jdbcTemplate.query(sql, ((resultSet, i) -> {
            return new Book(UUID.fromString(resultSet.getString("id")),
                    resultSet.getString("title"),
                    resultSet.getString("isbn"),
                    resultSet.getString("owner")
                    );
        }));
        return books;
    }

    @Override
    public int deleteBook(UUID id) {
        return 0;
    }

    @Override
    public int updateBook(UUID id, Book book) {
        final String sql = "SELECT * FROM book where id = ?" ;
        return 0;
    }

    @Override
    public Optional<Book> getBook(UUID id) {
        final String sql = "SELECT * FROM book where id = ?" ;
        Book book = jdbcTemplate.queryForObject(sql, new Object []{id}, (resultSet, i) -> {
           UUID bookId = UUID.fromString(resultSet.getString("id"));
           String title = resultSet.getString("title");
           String isbn = resultSet.getString("isbn");
           String owner = resultSet.getString("owner");
          return new Book(bookId,title,isbn,owner);

        });
        return Optional.ofNullable(book);
    }
}
