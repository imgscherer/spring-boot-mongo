package com.example.springbootwithmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.springbootwithmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
	//Query do MongoDB
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> findByTitle(String text);

	//Query do Spring Boot
	List<Post> findByTitleContainingIgnoreCase(String text);
}