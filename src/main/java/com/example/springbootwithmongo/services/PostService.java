package com.example.springbootwithmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootwithmongo.domain.Post;
import com.example.springbootwithmongo.repository.PostRepository;
import com.example.springbootwithmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	public Post findById(String id){
		Optional<Post> post = repository.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Object Not Found. ID: " + id));
	}
	
	
	

}