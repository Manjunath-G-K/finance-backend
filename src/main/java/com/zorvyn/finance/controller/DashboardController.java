package com.zorvyn.finance.controller;

import com.zorvyn.finance.model.Record;
import com.zorvyn.finance.model.Type;
import com.zorvyn.finance.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private RecordRepository recordRepository;

    @GetMapping("/summary")
    public Map<String, Object> getSummary() {

        List<Record> records = recordRepository.findAll();

        double income = records.stream()
                .filter(r -> r.getType() == Type.INCOME)
                .mapToDouble(Record::getAmount)
                .sum();

        double expense = records.stream()
                .filter(r -> r.getType() == Type.EXPENSE)
                .mapToDouble(Record::getAmount)
                .sum();

        Map<String, Object> result = new HashMap<>();
        result.put("totalIncome", income);
        result.put("totalExpense", expense);
        result.put("netBalance", income - expense);

        return result;
    }
}