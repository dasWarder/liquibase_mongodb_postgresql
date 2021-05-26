package com.example.double_db.service;

import com.example.double_db.entity.Issue;
import com.example.double_db.repository.IssueRepository;
import com.example.double_db.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableJpaRepositories(basePackageClasses = { PersonRepository.class })
public class IssueServiceImpl implements IssueService{

    private final IssueRepository issueRepository;

    @Autowired
    public IssueServiceImpl(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    @Override
    public List<Issue> getAll() {
        return issueRepository.findAll();
    }
}
