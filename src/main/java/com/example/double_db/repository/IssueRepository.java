package com.example.double_db.repository;

import com.example.double_db.entity.Issue;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IssueRepository extends MongoRepository<Issue, String> {
}
