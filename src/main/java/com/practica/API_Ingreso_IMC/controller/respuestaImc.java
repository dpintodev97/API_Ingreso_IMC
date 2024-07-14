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
	 * Calcular IMC según x parametros de entrada en solictud GET.
	 * 1.INVOCA METODO PRIVADO PARA CALCULAR EL IMC SEGÚN LOS PARAMETROS DE ENTRADA EN EL GET HTTP
	 * 2.INVOCA METODO PARA CALCULAR EL ESTADO DE LA PERSONA, SI ES OBESA....
	 * @return: Estado del peso de la persona con String.format -> PARA ESPECIFICAR EL FORMATO; Número de 2 decimales + String
	 */
	@GetMapping("/calculo")
	public  String calcularIMC(@RequestParam double peso, @RequestParam double estaturaMetros) {
		double imc = calcularIMCValue(peso, estaturaMetros); 
		String estadoCorporal = clasificarIMC(imc);
		
		return String.format("Tu IMC es de: %.2f. Tu estado actual es: %s.",imc,estadoCorporal);
	}
	
		//METODOS PRIVADOS, ENCAPSULADOS:
		/**
		 * 
		 * @param peso
		 * @param estaturaMetros
		 * @return valor del IMC de la persona
		 */
		private double calcularIMCValue(double peso, double estaturaMetros) {
			if (estaturaMetros <= 0) {
				throw new IllegalArgumentException("La altura no puede ser igual o menos que 0 !");
			}else {
				return peso / (estaturaMetros * estaturaMetros);
			}
		}
		
		/**
		 * 
		 * @param imc
		 * @return Estado de la persona, si está en pesos insuficiente, normal. . . 
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
