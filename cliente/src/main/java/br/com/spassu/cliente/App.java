package br.com.spassu.cliente;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.spassu.service.ClienteService;
import br.com.spassu.service.CompaService;

public class App {
	public static void main(String[] args) throws ParseException {

//		System.out.println("Hello World!");

		ClienteService clienteService = new ClienteService();
		CompaService compraService = new CompaService();
		List<String> saida = new ArrayList<String>();

		Scanner scan = new Scanner(System.in);

		boolean continua = true;
		while (continua) {

			String line = scan.nextLine();

			String[] textoSeparado = line.split(";");
			int menu = Integer.parseInt(textoSeparado[0].replaceAll(" ", ""));

			switch (menu) {
			case 1:

				saida = clienteService.getClientes();

				for (int i = 0; i < saida.size(); i++) {
					System.out.println(saida.get(i));
				}

				break;
			case 2:
				System.out.println(clienteService.setClientes(line));
				break;
			case 3:
				System.out.println(clienteService.alteraCliente(line));
				break;
			case 4:
				System.out.println(clienteService.excluirCliente(line));
				break;
			case 5:
				System.out.println(clienteService.consultarCliente(line));
				break;
			case 6:
				System.out.println(compraService.setCompra(line));
				break;
			case 7:
				saida = compraService.listarCompras();

				for (int i = 0; i < saida.size(); i++) {
					System.out.println(saida.get(i));
				}

				break;
			case 8:
				saida = compraService.listarClientesEspeciais();

				for (int i = 0; i < saida.size(); i++) {
					System.out.println(saida.get(i));
				}
				
				break;
			case 9:
				System.exit(0);
				break;

			default:
				break;
			}

		}

	}
}
