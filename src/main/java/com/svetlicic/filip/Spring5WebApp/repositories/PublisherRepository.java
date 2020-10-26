package com.svetlicic.filip.Spring5WebApp.repositories;

import com.svetlicic.filip.Spring5WebApp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
