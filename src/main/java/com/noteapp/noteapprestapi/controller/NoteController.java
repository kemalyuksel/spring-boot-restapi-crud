package com.noteapp.noteapprestapi.controller;

import com.noteapp.noteapprestapi.model.Note;
import com.noteapp.noteapprestapi.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;


    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Note> getAll(){
        return noteService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Note getById(@PathVariable Long id){
        return noteService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addNote(@RequestBody Note note)
    {
        noteService.addNote(note);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateNote(@PathVariable Long id,@RequestBody Note note){
        noteService.updateNote(note,id);
    }


    @DeleteMapping("/deleteById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id){
        noteService.deleteById(id);
    }

}
