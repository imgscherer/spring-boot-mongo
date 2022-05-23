package com.example.springbootwithmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootwithmongo.domain.User;
import com.example.springbootwithmongo.dto.UserDTO;
import com.example.springbootwithmongo.repository.UserRepository;
import com.example.springbootwithmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id){
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Object Not Found. ID: " + id));
	}
	
	public User insert (User user) {
		return repository.insert(user);
	}
	
	public void delete (String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public User fromDTO (UserDTO userDto) {
		return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
	}
	
	

}
