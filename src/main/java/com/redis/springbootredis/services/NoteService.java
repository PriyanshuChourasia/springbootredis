package com.redis.springbootredis.services;

import java.util.List;
import java.util.UUID;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.redis.springbootredis.entities.Note;
import com.redis.springbootredis.repositories.impl.INoteRepository;
import com.redis.springbootredis.services.impl.INoteService;

@Service
public class NoteService implements INoteService {

    private  INoteRepository iNoteRepository;

    public NoteService(INoteRepository iNoteRepository){
        this.iNoteRepository = iNoteRepository;
    }

    /**
     * save function to save note in database
     * @param note
     * @return Note
     */
    @Override
    @CachePut(value="notes",key="#note.id")
    public Note create(Note note){
        note.setId(UUID.randomUUID().toString());
        return iNoteRepository.save(note);
    }


    /**
     * Get all the saved notes from the database
     * @return []
     */
    @Override
    public List<Note> getAll(){
        return iNoteRepository.findAll();
    }

    /**
     * Get Note by Id
     * @param noteId
     * @return Note
     */
    @Override
    @Cacheable(value = "notes",key="#noteId")
    public Note getNoteById(String noteId){
        return iNoteRepository.findById(noteId).orElseThrow(()-> new RuntimeException("Note with the given id not available"));
    }


    /**
     * Get Note data by id and then update it according to id
     * @param noteId
     * @param note
     * @return
     */
    @Override
    public Note update(String noteId, Note note){
        Note note1 = iNoteRepository.findById(noteId).orElseThrow(()-> new RuntimeException("Note with the given id is not in database"));
        note1.setTitle(note.getTitle());
        note1.setContent(note.getContent());
        note1.setLive(note.isLive());
        return iNoteRepository.save(note1);
    }

    /**
     * 
     * Delete the note data by getting id of it
     */
    @Override
    @CacheEvict(value="notes",key="#noteId")
    public void delete(String noteId){
        Note note1 = iNoteRepository.findById(noteId).orElseThrow(()-> new RuntimeException("Note with the given id is not found"));
        iNoteRepository.delete(note1);
    }

   


}
