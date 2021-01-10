package br.com.spassu.cliente;

import java.util.Scanner;

import br.com.spassu.service.ClienteService;

public class App {
	public static void main(String[] args) {

		System.out.println("Hello World!");

		ClienteService clienteService = new ClienteService();

		Scanner scan = new Scanner(System.in);

		boolean continua = true;
		while (continua) {

			System.out.println("Adicione os dados do cliente");

			String line = scan.nextLine();

			String[] textoSeparado = line.split(";");
			int menu = Integer.parseInt(textoSeparado[0]);

			switch (menu) {
			case 1:
				clienteService.getClientes();
				break;
			case 2:
				clienteService.setClientes(line);
				break;
			case 3:
				clienteService.alteraCliente(line);
				break;
			case 4:
				clienteService.excluirCliente(line);
				break;
			case 5:
				clienteService.consultarCliente(line);
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;
			case 9:
				System.exit(0);
				break;

			default:
				System.out.println("Valor Invalido");
				break;
			}

		}

	}
}
