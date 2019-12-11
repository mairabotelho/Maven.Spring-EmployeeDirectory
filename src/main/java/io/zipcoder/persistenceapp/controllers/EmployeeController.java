package io.zipcoder.persistenceapp.controllers;

import io.zipcoder.persistenceapp.models.Employee;
import io.zipcoder.persistenceapp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/employees")
    public ResponseEntity<Employee> create(@RequestBody Employee employee){
        return new ResponseEntity<>(service.create(employee), HttpStatus.CREATED);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> update(@PathVariable Long id, @Valid @RequestBody Employee employee){
        return new ResponseEntity<>(service.update(id, employee), HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> findOne(@PathVariable Long id){
        return new ResponseEntity<>(service.findOne(id), HttpStatus.OK);
    }

    @GetMapping("/employees")
    public ResponseEntity<Iterable<Employee>> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
}