package com.mycompany.services;

import org.springframework.stereotype.Service;
import com.mycompany.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.mycompany.entities.Book;

@Service
public class MainService {

    private BookRepository repository;

    @Autowired
    public MainService(BookRepository repository){
        this.repository = repository;
    }
    
    public List<Book> getAllBooks(){
        return repository.findAll();
    }

    public void createNewBook(Book book){
        if (book.getName().isBlank()){
            book.setName("UNKNOWN");
        }
        repository.save(book);
    }

    public void updateBook(long id, Book book){
        if (book.getName().isBlank()){
            book.setName("UNKNOWN");
        }
        book.setId(id);
        repository.save(book);
    }

    public void deleteById(long id){
        repository.deleteById(id);
    }
}
