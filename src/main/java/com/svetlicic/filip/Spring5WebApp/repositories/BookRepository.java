package com.svetlicic.filip.Spring5WebApp.repositories;

import com.svetlicic.filip.Spring5WebApp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
