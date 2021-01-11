package br.com.spassu.service;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.spassu.modelo.Cliente;
import br.com.spassu.modelo.Compra;

public class CompaService {

	ListaDeObjetos<Compra> listaCompras = new ListaDeObjetos<Compra>(0);

	Compra umaCompra;
	Cliente umCliente;

	public void setCompra(String valor) throws ParseException {

		String[] textoSeparado = valor.split(";");
		double valorImposto = 0;

		int idClienteCadastrado = Integer.parseInt(textoSeparado[1].replaceAll(" ", ""));
		String dataCompra = textoSeparado[2].replaceAll(" ", "");
		String valorCompraString = (textoSeparado[3]);

		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date data = (Date) formato.parse(dataCompra);

		umCliente = ClienteService.listaClientes.recuperar(idClienteCadastrado);

		valorCompraString = valorCompraString.replaceAll(" ", "");
		valorCompraString = valorCompraString.replace(".", "");
		valorCompraString = valorCompraString.replaceAll(",", ".");

		double valorCompra = Double.parseDouble(valorCompraString);
		
		if (umCliente.getCidade().substring(umCliente.getCidade().length() - 1).equals("a")) {
			valorImposto = (valorCompra * 0.10);
		} else if (umCliente.getCidade().substring(umCliente.getCidade().length() - 1).equals("o")) {
			valorImposto = (valorCompra * 0.20);

		}

		umCliente.getCidade().substring(umCliente.getCidade().length() - 1);

		umaCompra = new Compra(umCliente, data, valorCompra, valorImposto);

		listaCompras.adicionar(umaCompra);

		System.out.println("Compra para o cliente " + umaCompra.getCliente().getId() + " incluída");

	}

	public void listarCompras() {

		umaCompra = listaCompras.recuperarPrimeiro();
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");   

		while (umaCompra != null) {
			System.out.println("| " + umaCompra.getCliente().getId() +
			                  " | " + umaCompra.getCliente().getNome() +
					   	      " | " + fmt.format(umaCompra.getData()) +
						      " | R$ " + NumberFormat.getCurrencyInstance().format(umaCompra.getValor()) +
						      " | R$ " + NumberFormat.getCurrencyInstance().format(umaCompra.getValorImposto()) +
					          " |");
			
			System.out.println("| " + 
							   "Total Compras: R$ " + NumberFormat.getCurrencyInstance().format(umaCompra.getValor()) +
			                   " |");

			umaCompra = listaCompras.recuperarProximo();

		}

	}
	
	public void listarClientesEspeciais() {
		
		umaCompra = listaCompras.recuperarPrimeiro();
		
		if (umaCompra != null && umaCompra.getValor() > 1000) {
			
			System.out.println("| " + umaCompra.getCliente().getId() +
	                  " | " + umaCompra.getCliente().getNome() +
			   	      " | R$ " + umaCompra.getValor() +
				      " |");
			
		
		}
		
		umaCompra = listaCompras.recuperarProximo();
		

	}

}
