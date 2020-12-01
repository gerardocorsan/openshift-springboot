package com.corsanhub.spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContribuyenteService {
	private static Logger logger = LoggerFactory.getLogger(ContribuyenteService.class);

	@Autowired
	private Calculadora calculadora;

	@Autowired
	public ContribuyenteService(Calculadora calculadora) {
		this.calculadora = calculadora;
	}

	public Long calcula(String marca, Integer modelo) {
		logger.info("Calculating ...");
		Long value = calculadora.calcula(marca, modelo);

		return value;

	}

	public Long calcula2(String marca, Integer modelo) {
		Long value = calculadora.calcula(marca, modelo);

		return value;

	}

}
