package br.com.alura.forum.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class CourseService {
	
	private RestTemplate restTemṕlate;
	
	@Value( "${services.url.courses}" )
	private String uri;

	@Autowired
	public CourseService(RestTemplate restTemṕlate) {
		this.restTemṕlate = restTemṕlate;
	}
	
	
	@HystrixCommand(fallbackMethod="getByIdFallback")
	public Course getById(UUID id) {
		
		return restTemṕlate.getForObject("http://" + uri + "/courses/"+id, Course.class);
		
	}
	
	public Course getByIdFallback(UUID id) {
		Course c = new Course();
		c.setId(id);
		c.setName("Nome padrao");
		return c;
	}

}
