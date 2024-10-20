package com.redis.springbootredis.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.redis.springbootredis.entities.Note;
import com.redis.springbootredis.services.impl.INoteService;


@RestController
@RequestMapping("/api/v1/notes")
public class NoteController {

    private INoteService iNoteService;

    public NoteController(INoteService iNoteService){
        this.iNoteService = iNoteService;
    }

    /**
     * Create a note
     * @param note
     * @return
     */
    @PostMapping
    public ResponseEntity<Note> create(@RequestBody Note note){
        return ResponseEntity.status(HttpStatus.CREATED).body(iNoteService.create(note));
    }

    
    /**
     * Get All data of notes
     * @return
     */
    @GetMapping
    public ResponseEntity<List<Note>> getAll(){
        return ResponseEntity.ok(iNoteService.getAll());
    }


    /**
     * Get Note by Id
     * @param noteId
     * @return
     */
    @GetMapping("/{noteId}")
    public ResponseEntity<Note> getSingle(@PathVariable String noteId){
        return ResponseEntity.ok(iNoteService.getNoteById(noteId));
    }

    @DeleteMapping("/{noteId}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String noteId){
        iNoteService.delete(noteId);
    }
    
    
}
