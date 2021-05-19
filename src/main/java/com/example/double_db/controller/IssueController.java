package com.example.double_db.controller;

import com.example.double_db.entity.Issue;
import com.example.double_db.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IssueController {

    private final IssueService issueService;

    @Autowired
    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    @GetMapping(value = "/issues")
    public List<Issue> getAll() {
        return issueService.getAll();
    }
}
