package com.mildtech_solution.simple_crud_services.service;

import com.mildtech_solution.simple_crud_services.domain.BaseResponse;
import com.mildtech_solution.simple_crud_services.model.BooksEntity;
import com.mildtech_solution.simple_crud_services.repository.BooksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BooksRepository repository;

    public BooksEntity create(BooksEntity booksEntity){
        return repository.save(booksEntity);
    }

    public BooksEntity update(Long id, BooksEntity booksEntity){
        boolean check = existsById(id);
        if(ObjectUtils.isEmpty(booksEntity)) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No record found for Books");
        booksEntity.setId(id);
        return repository.save(booksEntity);
    }

    public boolean existsById(Long id ){
        return repository.existsById(id);
    }

    public BaseResponse deleteById(Long id){
        boolean check = existsById(id);
        if(!check) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No record found for Books");
        repository.deleteById(id);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage("Successful");
        baseResponse.setStatus("SUCCESS");
        return baseResponse;
    }

    public BooksEntity getById(Long id){
        return repository.findById(id).orElse(null);
    }
}
