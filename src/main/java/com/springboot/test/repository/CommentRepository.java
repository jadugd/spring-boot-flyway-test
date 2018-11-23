package com.springboot.test.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.test.model.CommentModel;

@Repository
public interface CommentRepository extends JpaRepository<CommentModel, Long> {
	
	Page<CommentModel> findByPostId(Long postId, Pageable page);
}
