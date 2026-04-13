package com.example.finaltodo.controller;

import com.example.finaltodo.dto.tododto;
import com.example.finaltodo.service.todoservice;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
@RestController
@RequestMapping("/api/todos")
public class todocontroller {

    private todoservice todoservice;

    // CREATE
    @PostMapping
    public ResponseEntity<tododto> createtodo(@RequestBody tododto tododto) {
        tododto savedtodo = todoservice.createtodo(tododto);
        return new ResponseEntity<>(savedtodo, HttpStatus.CREATED);
    }

    // GET BY ID
    @GetMapping("{id}")
    public ResponseEntity<tododto> gettodoByid(@PathVariable("id") Long todoid) {
        tododto tododto = todoservice.gettodoById(todoid);
        return new ResponseEntity<>(tododto, HttpStatus.OK);
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<List<tododto>> getAlltodos() {
        List<tododto> todos = todoservice.getAlltodos();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    // UPDATE ✅
    @PutMapping("{id}")
    public ResponseEntity<tododto> updatetodo(@PathVariable("id") Long todoid,
                                              @RequestBody tododto updatedtodo) {

        tododto todo = todoservice.updatetodo(todoid, updatedtodo);
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletetodo(@PathVariable("id") Long todoid) {

        todoservice.deletetodo(todoid);

        return new ResponseEntity<>("Todo deleted successfully", HttpStatus.OK);
    }
}