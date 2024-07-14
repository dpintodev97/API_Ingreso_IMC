package com.practica.API_Ingreso_IMC.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/*
 * Controller API; respuesta cáculo a partir de Ingreso de IMC
 * METODOS PRIVADOS PARA EL CÁLCULO EN SÍ; ENCAPSULACIÓN
 */
@RestController
public class RespuestaImc {
	/**
	 * Calcular IMC según x parametros de entrada en solictud GET
	 * @return: Estado del peso de la persona
	 */
	@GetMapping("/calculo")
	private static double calcularIMC(@RequestParam double peso, @RequestParam double estaturaMetros) {
		
		
		return 0;
	}
	
		//METODOS PRIVADOS, ENCAPSULADOS:
		
		private double calcularIMCValue(double peso, double estaturaMetros) {
			if (estaturaMetros <= 0) {
				throw new IllegalArgumentException("La altura no puede ser igual o menos que 0 !");
			}else {
				return peso / (estaturaMetros * estaturaMetros);
			}
		}
		
		/**
		 * CLASIFICAR EL IMC
		 */
		private String clasificarIMC(double imc) {
	        if (imc < 18.5) {
	            return "Peso insuficiente";
	        } else if (imc >= 18.6 && imc < 24.9) {
	            return "Peso normal";
	        } else if (imc >= 25.0 && imc < 29.9) {
	            return "Sobrepeso";
	        } else {
	            return "Obesidad";
	        }
	    
	}

}
