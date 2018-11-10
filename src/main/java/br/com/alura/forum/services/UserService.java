package br.com.alura.forum.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
	
	private RestTemplate restTemṕlate;

	@Autowired
	public UserService(RestTemplate restTemṕlate) {
		this.restTemṕlate = restTemṕlate;		
	}
	
	public ResponseEntity<User> getUserById(UUID id) {
		
		return restTemṕlate.getForEntity("http://192.168.0.241/api/users/", User.class);
		
	}

}
