package com.mycompany.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.mycompany.entities.Book;
import com.mycompany.services.MainService;

@Controller
public class MainController{
    
    private MainService service;

    @Autowired
    public MainController(MainService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String getAllBooks(Model model){
        List<Book> books = service.getAllBooks();
        System.out.println("BOOKS COUNT IS: "+ books.size());
        model.addAttribute("books",books);
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String getEditPage(@PathVariable("id") long id, Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("id", id);
        return "edit";
    }

    @GetMapping("/create")
    public String getEditPage(Model model){
        model.addAttribute("book", new Book());
        return "create";
    }

    //Don't want to use any javascript, but <a> tags support only GET requests
    //So, when you click on the "delete" link - the entry is removed
    @GetMapping("/delete/{id}")
    public String deleteBookById(@PathVariable("id") long id){
        service.deleteById(id);
        return "redirect:/";
    }   

    @PostMapping("/create/submit")
    public String createNewBook(@ModelAttribute("book") Book book){
        System.out.printf("%d %s %d %s%n",book.getId(),book.getName(),book.getStock(),book.getSection());
        service.createNewBook(book);
        return "redirect:/";
    }

    //Don't want to use javascript for simplicity
    //<form> tags natively support only GET and POST requests
    //so we use post request here to edit an entry
    @PostMapping("/edit/{id}/submit")
    public String updateBookById(@PathVariable("id") long id,
                                @ModelAttribute("book") Book book){
        service.updateBook(id,book);
        return "redirect:/";
    }

}
