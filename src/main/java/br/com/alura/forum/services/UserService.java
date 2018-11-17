package br.com.alura.forum.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class UserService {
	
	private RestTemplate restTemṕlate;
	
	@Value( "${services.url.users}" )
	private String uri;

	@Autowired
	public UserService(RestTemplate restTemṕlate) {
		this.restTemṕlate = restTemṕlate;		
	}
	
	@HystrixCommand(fallbackMethod="getUserByIdFallback")
	public UserVO getUserById(UUID id) {
		
		return restTemṕlate.getForObject("http://" + uri + "/api/users/"+id, UserVO.class);
		
	}

	public UserVO getUserByIdFallback(UUID id) {
		UserVO userVO = new UserVO();
		userVO.setNome("Nome padrao");
		return userVO;
		
	}
}
