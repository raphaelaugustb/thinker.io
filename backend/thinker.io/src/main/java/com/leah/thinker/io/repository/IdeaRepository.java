package com.leah.thinker.io.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.leah.thinker.io.entity.Idea;

import java.util.List;
import java.util.UUID;

@Repository
public interface IdeaRepository extends JpaRepository<Idea,Long> {
    List<Idea> findByTitle(String title, UUID idUser);
}
