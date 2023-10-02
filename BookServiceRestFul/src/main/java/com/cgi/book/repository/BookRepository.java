package com.cgi.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cgi.book.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

}
