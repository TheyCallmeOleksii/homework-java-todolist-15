package com.example.todolist.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Note {
    private long id;
    private String title;
    private String content;
}