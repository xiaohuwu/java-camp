package com.ktb;

import com.ktb.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("name")
public class TodoController {

    @Autowired
    private TodoService service;

    @RequestMapping(value = "/list-todos", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model, HttpSession httpSession) {
        Object name = httpSession.getAttribute("name");
        model.addAttribute("todos", service.retrieveTodos("in28Minutes"));
        return "list_todos";
    }


    @RequestMapping(value = "/book",method = RequestMethod.POST)
    @ResponseBody
    public Book addBook(@RequestBody Book book) {
        System.out.println("book = " + book);
        return book;
    }


}
