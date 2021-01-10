package br.com.spassu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.spassu.modelo.Cliente;

public class ClienteService {

	private List<Cliente> listaClientes;

	public void getMenu() {

		Scanner scan = new Scanner(System.in);

		System.out.println("Adicione os dados do cliente");
		String line = scan.nextLine();

		String[] textoSeparado = line.split(";");
		int menu = Integer.parseInt(textoSeparado[0]);

		switch (menu) {
		case 0:
			break;
		case 1:
			getClientes();
			break;
		case 2:
			setClientes(line);
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		case 8:
			break;
		case 9:
			break;

		default:
			break;
		}

	}

	public String setClientes(String valor) {

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

		getMenu();

		return null;
	}

	public void getClientes() {

		System.out.println("entrou!!!!!!!");

		for (int i = 0; i < listaClientes.size(); i++) {
			System.out.println("teste");
			System.out.println("| " + listaClientes.get(i).getId() + " |" + listaClientes.get(i).getNome() + " |"
					+ listaClientes.get(i).getCidade() + " | ");

		}
		
		getMenu();

	}
	
	

}
