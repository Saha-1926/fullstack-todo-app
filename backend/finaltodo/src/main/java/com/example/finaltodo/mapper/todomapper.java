package com.example.finaltodo.mapper;

import com.example.finaltodo.dto.tododto;
import com.example.finaltodo.entity.todo;

public class todomapper {

    // Entity → DTO
    public static tododto mapTotododto(todo todo) {
        return new tododto(
                todo.getId(),
                todo.getTitle(),
                todo.getDescription(),
                todo.isCompleted(),
                todo.getCreatedAt()
        );
    }

    // DTO → Entity
    public static todo mapTotodo(tododto tododto) {
        return new todo(
                tododto.getId(),
                tododto.getTitle(),
                tododto.getDescription(),
                tododto.isCompleted(),
                tododto.getCreatedAt()
        );
    }
}