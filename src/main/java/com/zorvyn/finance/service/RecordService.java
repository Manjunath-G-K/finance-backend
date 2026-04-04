package com.zorvyn.finance.service;

import com.zorvyn.finance.model.Record;
import com.zorvyn.finance.model.Type;
import com.zorvyn.finance.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService {

    @Autowired
    private RecordRepository recordRepository;

    // Create record
    public Record createRecord(Record record) {
        return recordRepository.save(record);
    }

    // Get all records
    public List<Record> getAllRecords() {
        return recordRepository.findAll();
    }

    // Delete record
    public void deleteRecord(Long id) {
        recordRepository.deleteById(id);
    }

    // Filter by type
    public List<Record> getByType(String type) {
        return recordRepository.findByType(Type.valueOf(type));
    }

    // Filter by category
    public List<Record> getByCategory(String category) {
        return recordRepository.findByCategory(category);
    }

    // Filter by both
    public List<Record> getByTypeAndCategory(String type, String category) {
        return recordRepository.findByTypeAndCategory(Type.valueOf(type), category);
    }
}