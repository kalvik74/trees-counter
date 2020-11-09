package com.holidu.interview.assignment.rest;

import com.holidu.interview.assignment.integration.soda2.Soda2IntegrationAdapter;
import com.holidu.interview.assignment.service.TreeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class TreeCounterResource {
    private static final Logger logger = LoggerFactory.getLogger(TreeCounterResource.class);
    private final TreeService treeService;

    public TreeCounterResource(TreeService treeService) {
        this.treeService = treeService;
    }

    @GetMapping("/tree")
    Map<String, Integer> trees(@RequestParam Double x, @RequestParam Double y, @RequestParam Long radius) {
        long start = System.currentTimeMillis();
        Map<String, Integer> trees = treeService.getGroupedTrees(x, y, radius);
        logger.info("PROCESS TIME: " + (System.currentTimeMillis() - start) + " ms");
        return trees;
    }
}
