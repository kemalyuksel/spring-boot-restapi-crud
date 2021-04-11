package com.noteapp.noteapprestapi.service;

import com.noteapp.noteapprestapi.model.Note;
import com.noteapp.noteapprestapi.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    NoteRepository noteRepository;

    public List<Note> getAll(){
        return noteRepository.findAll();
    }

    public Note getById(Long id){
        return noteRepository.findById(id).get();
    }

    public void addNote(Note note){
        noteRepository.save(note);
    }

    public void updateNote(Note note,Long id){
        Note updatedNote = noteRepository.getOne(id);

        updatedNote.setName(note.getName());
        updatedNote.setDescription(note.getDescription());

        noteRepository.save(updatedNote);
    }

    public void deleteById(Long id){
        noteRepository.deleteById(id);
    }

}
