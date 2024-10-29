package com.mildtech_solution.simple_crud_services.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;

@Data
@Entity
@Table(name = "BOOKS")
public class BooksEntity implements Serializable {
    private static final Long seriaLVersionUID = 1L;
    @Id
    @Column(name = "ID", nullable = false, updatable = false, insertable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "active")
    @SequenceGenerator(name = "active", sequenceName = "active", allocationSize = 1)
    private Long id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "COMPLETED")
    private Boolean completed;
}
