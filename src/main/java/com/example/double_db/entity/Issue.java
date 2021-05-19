package com.example.double_db.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "id")
@Document(collection = "issue")
public class Issue {

    @Id
    private String id;

    @Field(value = "author")
    private String author;

    @Field(value = "description")
    private String description;

    public Issue(String author, String description) {
        this.author = author;
        this.description = description;
    }
}
