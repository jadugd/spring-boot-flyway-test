package com.springboot.test.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.test.exception.ResourceNotFoundException;
import com.springboot.test.model.PostModel;
import com.springboot.test.repository.PostRepository;

@RestController
public class PostController {
	
	@Autowired
	PostRepository postRepository;
	
	@GetMapping("/posts")
	public Page<PostModel> getAllPosts(Pageable pageable) {
		return postRepository.findAll(pageable);
	}
	
	@PostMapping("/posts")
	public PostModel createPost(@Valid @RequestBody PostModel post) {
		return postRepository.save(post);
	}
	
	@PutMapping("/posts/{postId}")
	public PostModel updatePost(@PathVariable Long postId, @Valid @RequestBody PostModel postRequest) {
		return postRepository.findById(postId).map(post -> {
			post.setTitle(postRequest.getTitle());
			post.setDescription(postRequest.getDescription());
			post.setContent(postRequest.getContent());
			return postRepository.save(post);
		}).orElseThrow(() -> new ResourceNotFoundException("PostId"+ postId +"not found"));
	}
	
	@DeleteMapping("/posts/{postId}")
	public ResponseEntity<?> deletePost(@PathVariable Long postId) {
		return postRepository.findById(postId).map(post -> {
			postRepository.delete(post);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("PostId"+ postId +"not found"));
	}
	
}
