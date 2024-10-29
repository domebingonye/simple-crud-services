package com.mildtech_solution.simple_crud_services.controller;

import com.mildtech_solution.simple_crud_services.domain.BaseResponse;
import com.mildtech_solution.simple_crud_services.model.BooksEntity;
import com.mildtech_solution.simple_crud_services.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping
    public ResponseEntity<BooksEntity> create(@RequestBody BooksEntity booksEntity){
        return ResponseEntity.ok(bookService.create(booksEntity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BooksEntity> create(@PathVariable final Long id, @RequestBody BooksEntity booksEntity){
        return ResponseEntity.ok(bookService.update(id, booksEntity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BooksEntity> getById(@PathVariable final Long id){
        return ResponseEntity.ok(bookService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> deleteById(@PathVariable final Long id){
        return ResponseEntity.ok(bookService.deleteById(id));
    }
}
