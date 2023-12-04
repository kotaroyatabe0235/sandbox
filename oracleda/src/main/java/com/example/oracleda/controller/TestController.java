package com.example.oracleda.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.oracleda.entity.TestTblRepository;
import com.example.oracleda.model.TestTbl;

import io.micrometer.common.util.StringUtils;

@RestController
public class TestController {

    private TestTblRepository testTblRepository;

    @PostMapping
    public String registerName(@RequestParam("name") String name) {
        String retStr = "SUCCESS";
        Iterable<TestTbl> resultList = testTblRepository.findAll();
        // id の降順になるはず
        // resultList.sort((a,b) -> b.id - a.id);
        
        TestTbl newEntity = new TestTbl(resultList.get(resultList.size()-1).id + 1, name);
        testTblRepository.save(newEntity);
        
        return retStr;
    }

    @GetMapping("/name")
    public String getName(@RequestParam("id") int id) {
        String name = null;
        TestTbl result = testTblRepository.findById(id).orElseThrow();
        if (result != null && !StringUtils.isEmpty(result.name)) {
            name = result.name;
        }
        return name;
    }
    
}
