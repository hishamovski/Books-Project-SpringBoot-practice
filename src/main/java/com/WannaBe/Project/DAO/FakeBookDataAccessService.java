package com.WannaBe.Project.DAO;

import com.WannaBe.Project.Model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakeBookDataAccessService implements BookDao{

    private static List<Book> DB = new ArrayList<>();

    @Override
    public int insertBook(UUID id, Book book) {
        id = UUID.randomUUID();
        book.setId(id);
        DB.add(book);
        return 0;
    }

    @Override
    public List<Book> getBooks() {
        return DB;
    }

    @Override
    public int deleteBook(UUID id) {
        Optional<Book> book = getBook(id);
        if(book.isEmpty()){
            return 0;
        }
        DB.remove(book.get());
        return 1;
    }

    @Override
    public int updateBook(UUID id, Book book) {
        return getBook(id)
                .map(b -> {
                    int index = DB.indexOf(b);
                    if(index >= 0) {
                        book.setId(b.getId());
                        DB.set(index, book);
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

    @Override
    public Optional<Book> getBook(UUID id) {
        return DB.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();
    }
}
