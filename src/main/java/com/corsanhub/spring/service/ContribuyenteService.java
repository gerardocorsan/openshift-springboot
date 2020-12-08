package com.corsanhub.spring.service;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ContribuyenteService {
	private static Logger logger = LoggerFactory.getLogger(ContribuyenteService.class);

	@Autowired
	private Calculadora calculadora;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	public ContribuyenteService(Calculadora calculadora) {
		this.calculadora = calculadora;
	}

	public BigDecimal calcula(String marca, Integer modelo) {
		logger.info("Calculating ...");
		BigDecimal value = calculadora.calcula(marca, modelo);

		return value;
	}

	public String callMongo() {
		logger.info("Calling mongo service ...");

		String mongodbServiceEndpoint = "http://localhost:8081/api/dbTest";
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(mongodbServiceEndpoint, String.class);
		String response = responseEntity.getBody();
		logger.info("mongo response:" + response);

		return response;
	}

}
