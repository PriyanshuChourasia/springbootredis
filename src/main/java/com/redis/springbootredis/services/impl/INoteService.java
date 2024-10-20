package com.redis.springbootredis.services.impl;

import java.util.List;

import com.redis.springbootredis.entities.Note;


public interface INoteService {
    Note create(Note note);
    List<Note> getAll();
    Note update(String noteId,Note note);
    Note getNoteById(String noteId);
    void delete(String noteId);
}
