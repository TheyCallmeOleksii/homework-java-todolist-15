package com.example.todolist.service;

import com.example.todolist.entity.Note;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class NoteService {

    private final Map<Long, Note> notes = new HashMap<>();
    private final Random random = new Random();

    public List<Note> listAll() {
        return new ArrayList<>(notes.values());
    }

    public Note add(Note note) {
        long id = Math.abs(random.nextLong());
        note.setId(id);
        notes.put(id, note);
        return note;
    }

    public void deleteById(long id) {
        if (!notes.containsKey(id)) {
            throw new IllegalArgumentException("Нотатку з ID " + id + " не знайдено");
        }
        notes.remove(id);
    }

    public void update(Note note) {
        if (!notes.containsKey(note.getId())) {
            throw new IllegalArgumentException("Нотатку з ID " + note.getId() + " не знайдено");
        }
        Note existingNote = notes.get(note.getId());
        existingNote.setTitle(note.getTitle());
        existingNote.setContent(note.getContent());
    }

    public Note getById(long id) {
        if (!notes.containsKey(id)) {
            throw new IllegalArgumentException("Нотатку з ID " + id + " не знайдено");
        }
        return notes.get(id);
    }
}