package com.example.todolist.controller;

import com.example.todolist.entity.Note;
import com.example.todolist.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/note")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("notes", noteService.listAll());
        return "note/list";
    }

    @PostMapping("/create")
    public String create(Note note) {
        noteService.add(note);
        return "redirect:/note/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") long id) {
        noteService.deleteById(id);
        return "redirect:/note/list";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") long id, Model model) {
        model.addAttribute("note", noteService.getById(id));
        return "note/edit";
    }

    @PostMapping("/edit")
    public String editSubmit(Note note) {
        noteService.update(note);
        return "redirect:/note/list";
    }
}