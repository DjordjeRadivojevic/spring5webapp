package com.springFramework.spring5webapp.repositories;

import com.springFramework.spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository  extends CrudRepository<Author,Long> {
}
