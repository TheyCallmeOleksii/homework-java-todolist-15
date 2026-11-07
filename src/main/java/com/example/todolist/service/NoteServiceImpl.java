package com.example.todolist.service;

import com.example.todolist.entity.Note;
import com.example.todolist.exception.NoteNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class NoteServiceImpl implements NoteService {

    private final Map<Long, Note> notes = new HashMap<>();

    private static final Random random = new Random();

    @Override
    public List<Note> listAll() {
        return new ArrayList<>(notes.values());
    }

    @Override
    public Note add(Note note) {
        long id = Math.abs(random.nextLong());
        note.setId(id);
        notes.put(id, note);
        return note;
    }

    @Override
    public void deleteById(long id) {
        if (!notes.containsKey(id)) {
            throw new NoteNotFoundException(id);
        }
        notes.remove(id);
    }

    @Override
    public void update(Note note) {
        if (!notes.containsKey(note.getId())) {
            throw new NoteNotFoundException(note.getId());
        }
        Note existingNote = notes.get(note.getId());
        existingNote.setTitle(note.getTitle());
        existingNote.setContent(note.getContent());
    }

    @Override
    public Note getById(long id) {
        if (!notes.containsKey(id)) {
            throw new NoteNotFoundException(id);
        }
        return notes.get(id);
    }
}