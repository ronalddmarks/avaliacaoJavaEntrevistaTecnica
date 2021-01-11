package br.com.spassu.cliente;
import java.text.ParseException;
import java.util.Scanner;

import br.com.spassu.service.ClienteService;
import br.com.spassu.service.CompaService;

public class App {
	public static void main(String[] args) throws ParseException {

//		System.out.println("Hello World!");

		ClienteService clienteService = new ClienteService();
		CompaService compraService = new CompaService();

		Scanner scan = new Scanner(System.in);

		boolean continua = true;
		while (continua) {
	
			String line = scan.nextLine();

			String[] textoSeparado = line.split(";");
			int menu = Integer.parseInt(textoSeparado[0].replaceAll(" ", ""));

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
				compraService.setCompra(line);
				break;
			case 7:
				compraService.listarCompras();
				break;
			case 8:
				compraService.listarClientesEspeciais();
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
