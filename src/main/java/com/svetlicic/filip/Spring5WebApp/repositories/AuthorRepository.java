package com.svetlicic.filip.Spring5WebApp.repositories;

import com.svetlicic.filip.Spring5WebApp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
