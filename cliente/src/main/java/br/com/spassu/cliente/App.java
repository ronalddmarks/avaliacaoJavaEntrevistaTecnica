package br.com.spassu.cliente;

import br.com.spassu.service.ClienteService;

public class App {
	public static void main(String[] args) {

		System.out.println("Hello World!");

		

		ClienteService clienteService = new ClienteService();
		
	
		
		clienteService.getMenu();
		
		


	}
}
