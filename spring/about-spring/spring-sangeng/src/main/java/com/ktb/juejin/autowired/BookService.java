package com.ktb.juejin.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {


    BookDao bookDao;

    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public BookDao getBookDao() {
        return bookDao;
    }

}
