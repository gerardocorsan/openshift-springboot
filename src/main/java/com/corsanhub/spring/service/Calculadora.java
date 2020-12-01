package com.corsanhub.spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Calculadora {
	private static Logger logger = LoggerFactory.getLogger(Calculadora.class);

	public Long calcula(String marca, Integer modelo) {

		Long result = (long) (marca.length() + modelo);

		logger.info("###### result: " + result);
		return result;

	}

}
