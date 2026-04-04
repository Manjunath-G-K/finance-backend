package com.zorvyn.finance.controller;

import com.zorvyn.finance.model.Record;
import com.zorvyn.finance.service.RecordService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/records")
public class RecordController {

    @Autowired
    private RecordService recordService;

    // Create record
    @PostMapping
    public Record createRecord(@RequestBody Record record) {

        if (record.getUser() != null) {
            if (!record.getUser().getRole().name().equals("ADMIN")) {
                throw new RuntimeException("Only admin can create records");
            }
        }

        return recordService.createRecord(record);
    }

    // Get all records OR filter
    @GetMapping
    public List<Record> getRecords(
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String category
    ) {
        if (type != null && category != null) {
            return recordService.getByTypeAndCategory(type, category);
        } else if (type != null) {
            return recordService.getByType(type);
        } else if (category != null) {
            return recordService.getByCategory(category);
        } else {
            return recordService.getAllRecords();
        }
    }

    // Delete record
    @DeleteMapping("/{id}")
    public void deleteRecord(@PathVariable Long id) {
        recordService.deleteRecord(id);
    }
}