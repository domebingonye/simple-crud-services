package com.mildtech_solution.simple_crud_services;

import com.mildtech_solution.simple_crud_services.domain.BaseResponse;
import com.mildtech_solution.simple_crud_services.model.BooksEntity;
import com.mildtech_solution.simple_crud_services.service.BookService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ObjectUtils;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class BookTest {

    @Autowired
    private BookService bookService;

    @Test
    public void create(){
        BooksEntity booksEntity = new BooksEntity();
        booksEntity.setTitle("Golden heart");
        booksEntity.setDescription("test of life");
        booksEntity.setCompleted(true);
        BooksEntity res = bookService.create(booksEntity);
        Assert.assertTrue(!ObjectUtils.isEmpty(res));
    }

    @Test
    public void update(){
        long id = 10;
        BooksEntity booksEntity = new BooksEntity();
        booksEntity.setTitle("No one knows tomorrow");
        booksEntity.setDescription("test of life");
        booksEntity.setCompleted(true);
        BooksEntity res = bookService.update(id, booksEntity);
        Assert.assertTrue(!ObjectUtils.isEmpty(res));
    }

    @Test
    public void findById(){
        long id = 10;
        BooksEntity res = bookService.getById(id);
        Assert.assertTrue(!ObjectUtils.isEmpty(res));
    }

    @Test
    public void deleteId(){
        long id = 10;
        BaseResponse baseResponse =bookService.deleteById(id);
        Assert.assertTrue(!ObjectUtils.isEmpty(baseResponse));
    }
}
