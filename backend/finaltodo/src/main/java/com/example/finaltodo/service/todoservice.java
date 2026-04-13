package com.example.finaltodo.service;

import com.example.finaltodo.dto.tododto;
import java.util.List;

public interface todoservice {

    tododto createtodo(tododto tododto);

    tododto gettodoById(Long todoid);

    List<tododto> getAlltodos();

    // ✅ KEEP ONLY THIS
    tododto updatetodo(Long id, tododto updatedtodo);
    void deletetodo(Long id);
}