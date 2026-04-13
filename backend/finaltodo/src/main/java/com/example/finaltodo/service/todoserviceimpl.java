package com.example.finaltodo.service;

import com.example.finaltodo.dto.tododto;
import com.example.finaltodo.entity.todo;
import com.example.finaltodo.exception.ResourceNotFoundException;
import com.example.finaltodo.mapper.todomapper;
import com.example.finaltodo.repository.todorepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class todoserviceimpl implements todoservice {

    private todorepository todorepository;

    @Override
    public tododto createtodo(tododto tododto) {

        // DTO → Entity
        todo todo = todomapper.mapTotodo(tododto);

        // Save to DB
        todo savedtodo = todorepository.save(todo);

        // Entity → DTO
        return todomapper.mapTotododto(savedtodo);
    }

    @Override
    public tododto gettodoById(Long todoid) {

        todo todo = todorepository.findById(todoid)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + todoid));

        return todomapper.mapTotododto(todo);
    }

    @Override
    public List<tododto> getAlltodos() {

        List<todo> todos = todorepository.findAll();

        return todos.stream()
                .map(todomapper::mapTotododto)
                .collect(Collectors.toList());
    }

    // ✅ ONLY THIS UPDATE METHOD (correct one)
    @Override
    public tododto updatetodo(Long id, tododto updatedtodo) {

        // Step 1: Get existing todo
        todo existingtodo = todorepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id));

        // Step 2: Update values
        existingtodo.setTitle(updatedtodo.getTitle());
        existingtodo.setDescription(updatedtodo.getDescription());
        existingtodo.setCompleted(updatedtodo.isCompleted());

        // Step 3: Save
        todo savedtodo = todorepository.save(existingtodo);

        // Step 4: Return DTO
        return todomapper.mapTotododto(savedtodo);
    }
    @Override
    public void deletetodo(Long id) {

        todo existingtodo = todorepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id));

        todorepository.deleteById(id);
    }
}