package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping("/")
    public ModelAndView showList(){
        return new ModelAndView("home","bookList", bookService.findAll());
    }

    @GetMapping("/book/{id}/borrow")
    public String borrow(@PathVariable int id, Model model, RedirectAttributes redirect){
        Book book = bookService.findById(id);
        if (book.getQuantity() > 0){
            book.setQuantity(book.getQuantity() - 1);
            bookService.save(book);
            redirect.addFlashAttribute("success", "successfully borrowed ");
        } else {
            redirect.addFlashAttribute("success", "No Book Anymore");
        }
        model.addAttribute("bookList", bookService.findAll());
        return "redirect:/";
    }


    @PostMapping("/book/borrow")
    public String giveBack(@RequestParam String bookCode, Model model){
        Book book = bookService.findByCode(bookCode);
        if (book == null){
            model.addAttribute("message", "Not found");
            return "borrow";
        } else {
            book.setQuantity(book.getQuantity() + 1);
            bookService.save(book);
            model.addAttribute("message","successfully");
        }
        return "borrow";
    }
}
