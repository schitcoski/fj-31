package br.com.caelum.webservices;

import javax.xml.ws.Endpoint;

public class Publicador {

	public static void main(String[] args) {
		
		Endpoint.publish("http://localhost:10000/calculadorDeParcela", new CalculadorDeParcela());
		
	}
	
}
