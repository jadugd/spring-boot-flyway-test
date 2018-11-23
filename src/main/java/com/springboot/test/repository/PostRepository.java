package com.springboot.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.test.model.PostModel;

@Repository
public interface PostRepository extends JpaRepository<PostModel, Long> {

}
