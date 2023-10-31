package com.example.gachoncrpytouserservice.user.repository;

import com.example.gachoncrpytouserservice.user.document.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByStudentId(int studentId);
    boolean existsByStudentId(int studentId);
}
