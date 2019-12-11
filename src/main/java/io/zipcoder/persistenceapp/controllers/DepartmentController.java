package io.zipcoder.persistenceapp.controllers;

import io.zipcoder.persistenceapp.models.Department;
import io.zipcoder.persistenceapp.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @PostMapping("/departments")
    public ResponseEntity<Department> create(@RequestBody Department department){
        return new ResponseEntity<>(service.create(department), HttpStatus.CREATED);
    }

    @PutMapping("/departments/{id}")
    public ResponseEntity<Department> update(@PathVariable Long id, @Valid @RequestBody Department department){
        return new ResponseEntity<>(service.update(id, department), HttpStatus.OK);
    }

    @GetMapping("/departments/{id}")
    public ResponseEntity<Department> findOne(@PathVariable Long id){
        return new ResponseEntity<>(service.findOne(id), HttpStatus.OK);
    }

    @GetMapping("/departments")
    public ResponseEntity<Iterable<Department>> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PutMapping("/departments/{id}/{managerId}")
    public ResponseEntity<Department> setManager (@PathVariable Long id, @PathVariable Long managerId) {
        Department response = service.setManager(id, managerId);
        if (response != null) {
            return new ResponseEntity<Department>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<Department>(HttpStatus.BAD_REQUEST);
        }

    }
}
