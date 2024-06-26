package com.example.springboot.ListItem;

import org.springframework.data.annotation.Id;

public class ListItem {
    @Id
    public String id;

    public String name;
    public String description;

    public ListItem() {
    }

    public ListItem(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format(
                "ListItem[id=%s, name='%s', description='%s']",
                id, name, description);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}