package com.example.springboot.ListItem;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ListItemRepository extends MongoRepository<ListItem, String> {

    public ListItem findByName(String name);

    public List<ListItem> findByDescription(String description);

}