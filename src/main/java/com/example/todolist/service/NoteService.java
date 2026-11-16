package com.example.todolist.service;

import com.example.todolist.entity.Note;
import java.util.List;

public interface NoteService {
    List<Note> listAll();
    Note add(Note note);
    void deleteById(Long id);
    void update(Note note);
    Note getById(Long id);
}