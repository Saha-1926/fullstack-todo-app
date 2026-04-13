package com.example.finaltodo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class tododto {

    private Long id;

    private String title;

    private String description;

    private boolean completed;

    private LocalDateTime createdAt;
}