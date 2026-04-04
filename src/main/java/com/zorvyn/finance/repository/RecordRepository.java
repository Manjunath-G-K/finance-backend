package com.zorvyn.finance.repository;

import com.zorvyn.finance.model.Record;
import com.zorvyn.finance.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecordRepository extends JpaRepository<Record, Long> {

    // filter by type
    List<Record> findByType(Type type);

    // filter by category
    List<Record> findByCategory(String category);

    // filter by both
    List<Record> findByTypeAndCategory(Type type, String category);
}