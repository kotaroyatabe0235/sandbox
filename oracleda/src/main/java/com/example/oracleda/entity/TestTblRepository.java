package com.example.oracleda.entity;

import org.springframework.data.repository.CrudRepository;

import com.example.oracleda.model.TestTbl;

public interface TestTblRepository extends CrudRepository<TestTbl, Integer> {
    
}
