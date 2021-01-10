package br.com.spassu.service;

import java.util.ArrayList;
import java.util.List;

import br.com.spassu.modelo.Cliente;

public class ClienteService {

	private List<Cliente> listaClientes;

	
	
	public void getClientes() {

		System.out.println("entrou!!!!!!!");

		for (int i = 0; i < listaClientes.size(); i++) {
			System.out.println("teste");
			System.out.println("| " + listaClientes.get(i).getId() + " |" + listaClientes.get(i).getNome() + " |"
					+ listaClientes.get(i).getCidade() + " | ");
		}
		
	}
	
	
	public void setClientes(String valor) {

		String[] textoSeparado = valor.split(";");

//		 System.out.println(Arrays.toString(textoSeparado));

		Cliente cliente = new Cliente();
		cliente.setId(Integer.parseInt((textoSeparado[1]).replaceAll(" ", "")));
		cliente.setNome(textoSeparado[2]);
		cliente.setCidade(textoSeparado[3]);

		List<Cliente> listaClientes = new ArrayList<Cliente>();
		listaClientes.add(cliente);

		String resposta = "Cliente " + textoSeparado[1] + " incluído";

		System.out.println(resposta);

	}


	
	public void alteraCliente (String valor) {
		
			
		String[] textoSeparado = valor.split(";");
				
		int id = (Integer.parseInt((textoSeparado[1]).replaceAll(" ", "")));
			
		for (int i = 0; i < listaClientes.size(); i++) {
		
    	if (listaClientes.get(i).getId() == id) {
	    	    listaClientes.get(i).setNome(textoSeparado[2]);
	    		listaClientes.get(i).setCidade(textoSeparado[3]);
	    		System.out.println("Cliente " + id + " alterado");
			}
		
		}
		
	}
	
	public void excluirCliente(String valor) {
		
			
		String[] textoSeparado = valor.split(";");
		
		int id = (Integer.parseInt((textoSeparado[1]).replaceAll(" ", "")));
			
		for (int i = 0; i < listaClientes.size(); i++) {
		
    	if (listaClientes.get(i).getId() == id) {
	    	    listaClientes.remove(i);
	    		System.out.println("Cliente " + id + " excluído");
			}
		
		}
		
		
		
	}
	
	public void consultarCliente(String valor) {

		
		String[] textoSeparado = valor.split(";");
		
		int id = (Integer.parseInt((textoSeparado[1]).replaceAll(" ", "")));
			
		for (int i = 0; i < listaClientes.size(); i++) {
		
    	if (listaClientes.get(i).getId() == id) {
	    	   System.out.println(listaClientes.get(i).getId() + " " + listaClientes.get(i).getNome() + " " + listaClientes.get(i).getCidade());
			}
		
		}
					
	}
	

}
