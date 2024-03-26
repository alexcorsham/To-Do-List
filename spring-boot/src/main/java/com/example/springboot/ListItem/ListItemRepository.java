package com.example.springboot.ListItem;

import java.util.List;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

@RepositoryRestResource(collectionResourceRel = "listItems", path = "listItems")
public interface ListItemRepository extends MongoRepository<ListItem, String> {

    public ListItem findByName(@Param("name") String name);

    public List<ListItem> findByDescription(@Param("description") String description);

}