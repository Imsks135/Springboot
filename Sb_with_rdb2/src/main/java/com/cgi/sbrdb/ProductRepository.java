package com.cgi.sbrdb;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductDAO, Long> {

  List<ProductDAO> findByName(String name);

  ProductDAO findById(long id);
}

