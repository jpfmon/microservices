package com.montojo.userservice.repository;

import com.montojo.userservice.model.UserEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEnt, Long> {
}
