package br.com.alura.forum;

import org.springframework.stereotype.Service;

@Service
public class ServiceCircuitBraker {
	
	public void request() {
		System.out.println("deu bommm!");
	}

}
