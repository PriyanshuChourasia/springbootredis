package com.redis.springbootredis.repositories.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import com.redis.springbootredis.entities.Note;

public interface INoteRepository extends JpaRepository<Note, String>{

}
