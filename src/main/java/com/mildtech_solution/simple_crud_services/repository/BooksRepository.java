package com.mildtech_solution.simple_crud_services.repository;

import com.mildtech_solution.simple_crud_services.model.BooksEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<BooksEntity, Long> {
}
