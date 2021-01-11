package br.com.spassu.service;

import br.com.spassu.modelo.Cliente;

public class ClienteService {
	
	public static ListaDeObjetos<Cliente> listaClientes = new ListaDeObjetos<Cliente>(0);

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
	
	public String setClientes(String valor) {

		String[] textoSeparado = valor.split(";");
		
		int id = Integer.parseInt(textoSeparado[1].replaceAll(" ", ""));
		String nome = textoSeparado[2].replaceAll(" ", "");
		String cidade = textoSeparado[3].trim().replaceAll("\\s{2,}", " ");
	
		umCliente  = new Cliente(id, nome, cidade);
		
	    listaClientes.adicionar(umCliente);

		String resposta = "Cliente " + umCliente.getId() + " incluído";

		return resposta;

	}
	
	public String alteraCliente (String valor) {
			
		String[] textoSeparado = valor.split(";");
				
		int id = (Integer.parseInt((textoSeparado[1]).replaceAll(" ", "")));

		umCliente = listaClientes.recuperar(id);

		if (umCliente != null) {
		    String novoNome = textoSeparado[2].replaceAll(" ", "");
			String novaCidade = textoSeparado[3].trim().replaceAll("\\s{2,}", " ");
			
			umCliente.setNome(novoNome);
			umCliente.setCidade(novaCidade);
			
			String resposta = "Cliente " + umCliente.getId()  + " alterado";
			
			return resposta;
			
		}
		
		return null;
	
		
	}
	
	public String excluirCliente(String valor) {
			
		String[] textoSeparado = valor.split(";");
		
		int id = (Integer.parseInt((textoSeparado[1]).replaceAll(" ", "")));
		
	    listaClientes.remover(id);
	    
	    String resposta = "Cliente " + id + " excluído";
	    
	    return resposta;
		
	}
	
	public String consultarCliente(String valor) {
		
		String[] textoSeparado = valor.split(";");
		
		int id = (Integer.parseInt((textoSeparado[1]).replaceAll(" ", "")));

		umCliente = listaClientes.recuperar(id);
		
		String resposta = umCliente.getId() + " " + umCliente.getNome() + " " + umCliente.getCidade();
		
		return resposta;
	

					
	}
	

}
