package com.example.todolist.exception;

public class NoteNotFoundException extends RuntimeException {
    public NoteNotFoundException(long id) {
        super("Нотатку з ID " + id + " не знайдено");
    }
}