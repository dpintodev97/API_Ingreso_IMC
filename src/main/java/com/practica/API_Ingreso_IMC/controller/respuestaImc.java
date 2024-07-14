package com.practica.API_Ingreso_IMC.controller;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/*
 * Controller API; respuesta cáculo a partir de Ingreso de IMC
 */
@RestController
public class respuestaImc {
	/**
	 * Calcular IMC según x parametros de entrada en solictud GET
	 * @return: Estado del peso de la persona
	 */
	public String calcularIMC(@RequestParam double peso, @RequestParam double estaturaMetros) {
		return null;
		
	}

}
