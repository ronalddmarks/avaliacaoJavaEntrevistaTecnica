package br.com.spassu.service;

import java.util.ArrayList;
import java.util.List;

import br.com.spassu.modelo.Cliente;

public class ClienteService {
	
	ListaDeObjetos<Cliente> listaClientes = new ListaDeObjetos<Cliente>(0);

	Cliente umCliente;
	
	
	public void getClientes() {
		
		
		umCliente = listaClientes.recuperarPrimeiro();
		
		while (umCliente != null)  
		{	
				System.out.println ("| " + umCliente.getId() + 
			                        " | " + umCliente.getNome() + 
			                        " | " + umCliente.getCidade() + 
			                        " |");
				
		umCliente = listaClientes.recuperarProximo();
		
		}
	
	}
	
	public void setClientes(String valor) {

		String[] textoSeparado = valor.split(";");
		
		int id = Integer.parseInt(textoSeparado[1].replaceAll(" ", ""));
		String nome = textoSeparado[2].replaceAll(" ", "");
		String cidade = textoSeparado[3].replaceAll(" ", "");
	
		umCliente  = new Cliente(id, nome, cidade);
		
	    listaClientes.adicionar(umCliente);

		String resposta = "Cliente " + umCliente.getId() + " incluído";

		System.out.println(resposta);

	}
	
	public void alteraCliente (String valor) {
			
		String[] textoSeparado = valor.split(";");
				
		int id = (Integer.parseInt((textoSeparado[1]).replaceAll(" ", "")));

		umCliente = listaClientes.recuperar(id);

		if (umCliente != null) {
			System.out.println("entrou!");
			String novoNome = textoSeparado[2].replaceAll(" ", "");
			String novaCidade = textoSeparado[3].replaceAll(" ", "");
			
			umCliente.setNome(novoNome);
			umCliente.setCidade(novaCidade);
			
		}
	
		
	}
	
	public void excluirCliente(String valor) {
			
		String[] textoSeparado = valor.split(";");
		
		int id = (Integer.parseInt((textoSeparado[1]).replaceAll(" ", "")));
		
	    listaClientes.remover(id);
	    
	    System.out.println("Cliente " + id + " excluído");
		
	}
	
	public void consultarCliente(String valor) {
		
		String[] textoSeparado = valor.split(";");
		
		int id = (Integer.parseInt((textoSeparado[1]).replaceAll(" ", "")));

		umCliente = listaClientes.recuperar(id);
		
		System.out.println(umCliente.getId() + " " + umCliente.getNome() + " " + umCliente.getCidade());
	

					
	}
	

}
