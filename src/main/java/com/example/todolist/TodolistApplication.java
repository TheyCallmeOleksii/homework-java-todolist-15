package com.example.todolist;

import com.example.todolist.entity.Note;
import com.example.todolist.service.NoteService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TodolistApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(TodolistApplication.class, args);

		NoteService noteService = context.getBean(NoteService.class);

		System.out.println("\n--- ТЕСТУВАННЯ CRUD ОПЕРАЦІЙ ---");

		Note note = new Note();
		note.setTitle("Купити молоко");
		note.setContent("2 пакети 2,5%");
		Note createdNote = noteService.add(note);
		System.out.println("1. Створено нотатку з ID: " + createdNote.getId());

		System.out.println("2. Всього нотаток у списку: " + noteService.listAll().size());

		createdNote.setContent("3 пакети безлактозного");
		noteService.update(createdNote);
		Note updatedNote = noteService.getById(createdNote.getId());
		System.out.println("3. Оновлений контент нотатки: " + updatedNote.getContent());

		noteService.deleteById(createdNote.getId());
		System.out.println("4. Всього нотаток після видалення: " + noteService.listAll().size());

		System.out.println("--- ТЕСТУВАННЯ УСПІШНЕ ---\n");
	}
}