package com.leah.thinker.io.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.leah.thinker.io.entity.Idea;
@Repository
public interface IdeiaRepository extends JpaRepository<Idea,Long> {
}
