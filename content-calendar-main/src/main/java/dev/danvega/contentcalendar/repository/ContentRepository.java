package dev.danvega.contentcalendar.repository;

import dev.danvega.contentcalendar.model.content.Content;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

/**
 This interface extends ListCrudRepository<Content,Integer>.
 <Content,Integer> -> Content is a class that is mapped to a DB Table
                      Integer indicates that the PK of the table is an int.

 Spring creates a concrete implementation of this interface at runtime and provides methods to interact with Content
 I used ListCrudRespository because it returns Lists while CrudRepository returns iterables, and I want to work with Lists.
 */
public interface ContentRepository extends ListCrudRepository<Content,Integer> {

    List<Content> findAllByContentType(String type);
}
