package com.montojo.postservice.repository;

import com.montojo.postservice.model.PostEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEnt, Long> {
}
