package br.com.spassu.service;

import br.com.spassu.modelo.Cliente;
import br.com.spassu.util.FormataDadosUtil;
import br.com.spassu.util.ListaDeObjetos;

public class ClienteService {
	
	public static ListaDeObjetos<Cliente> listaClientes = new ListaDeObjetos<Cliente>(0);
	FormataDadosUtil formataDados = new FormataDadosUtil();

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
		
		int id = formataDados.convertStringToInt(textoSeparado[1]);
		String nome = formataDados.removeEspacoString(textoSeparado[2]);
		String cidade = formataDados.removerEspacoExtremidadeString(textoSeparado[3]);
	
		umCliente  = new Cliente(id, nome, cidade);
		
	    listaClientes.adicionar(umCliente);

		String resposta = "Cliente " + umCliente.getId() + " incluído";

		return resposta;

	}
	
	public String alteraCliente (String valor) {
			
		String[] textoSeparado = valor.split(";");
				
		int id = formataDados.convertStringToInt(textoSeparado[1]);

		umCliente = listaClientes.recuperar(id);

		if (umCliente != null) {
		    String novoNome = formataDados.removeEspacoString(textoSeparado[2]);
			String novaCidade = formataDados.removerEspacoExtremidadeString(textoSeparado[3]);
			
			umCliente.setNome(novoNome);
			umCliente.setCidade(novaCidade);
			
			String resposta = "Cliente " + umCliente.getId()  + " alterado";
			
			return resposta;
			
		}
		
		return null;
	
		
	}
	
	public String excluirCliente(String valor) {
			
		String[] textoSeparado = valor.split(";");
		
		int id = formataDados.convertStringToInt(textoSeparado[1]);
		
	    listaClientes.remover(id);
	    
	    String resposta = "Cliente " + id + " excluído";
	    
	    return resposta;
		
	}
	
	public String consultarCliente(String valor) {
		
		String[] textoSeparado = valor.split(";");
		
		int id = formataDados.convertStringToInt(textoSeparado[1]);

		umCliente = listaClientes.recuperar(id);
		
		String resposta = umCliente.getId() + " " + umCliente.getNome() + " " + umCliente.getCidade();
		
		return resposta;
						
	}
	

}
