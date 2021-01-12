package br.com.spassu.service;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import br.com.spassu.modelo.Cliente;
import br.com.spassu.modelo.Compra;
import br.com.spassu.util.FormataCaractereUtil;
import br.com.spassu.util.ListaDeObjetos;

public class CompaService {

	ListaDeObjetos<Compra> listaCompras = new ListaDeObjetos<Compra>(0);
	FormataCaractereUtil formataCaractere = new FormataCaractereUtil();

	Compra umaCompra;
	Cliente umCliente;

	public String setCompra(String valor) throws ParseException {

		String[] textoSeparado = valor.split(";");
		double valorImposto = 0;

		int idClienteCadastrado = Integer.parseInt(textoSeparado[1].replaceAll(" ", ""));
		String dataCompraString = textoSeparado[2];
		String valorCompraString = textoSeparado[3];

		Date data = formataCaractere.formataData(dataCompraString);

		umCliente = ClienteService.listaClientes.recuperar(idClienteCadastrado);

		double valorCompra = formataCaractere.removePontuacao(valorCompraString);

		if (umCliente.getCidade().substring(umCliente.getCidade().length() - 1).equals("a")) {
			valorImposto = (valorCompra * 0.10);
		} else if (umCliente.getCidade().substring(umCliente.getCidade().length() - 1).equals("o")) {
			valorImposto = (valorCompra * 0.20);

		}

		umaCompra = new Compra(umCliente, data, valorCompra, valorImposto);

		listaCompras.adicionar(umaCompra);

		return "Compra para o cliente " + umaCompra.getCliente().getId() + " incluída";

	}

	public void listarCompras() {

		umaCompra = listaCompras.recuperarPrimeiro();

		while (umaCompra != null) {
			System.out.println("| " + umaCompra.getCliente().getId() + " | " + umaCompra.getCliente().getNome() + " | "
					+ formataCaractere.getDataFormatada(umaCompra.getData()) + " | R$ "
					+ NumberFormat.getCurrencyInstance().format(umaCompra.getValor()) + " | R$ "
					+ NumberFormat.getCurrencyInstance().format(umaCompra.getValorImposto()) + " | \n"
					+ "| Total Compras: R$ " + NumberFormat.getCurrencyInstance().format(umaCompra.getValor()) + " |");

			umaCompra = listaCompras.recuperarProximo();

		}

	}

	public void listarClientesEspeciais() {

		umaCompra = listaCompras.recuperarPrimeiro();

		ArrayList<Compra> compras = new ArrayList<Compra>();

		while (umaCompra != null) {
			compras.add(umaCompra);
			umaCompra = listaCompras.recuperarProximo();

		}

		int original[] = new int[compras.size()];
		for (int i = 0; i < compras.size(); i++) {
			original[i] = compras.get(i).getCliente().getId();
		}

		// remover repetidos
		int[] unicos = new int[original.length];
		int qtd = 0;
		for (int i = 0; i < original.length; i++) {
			boolean existe = false;
			for (int j = 0; j < qtd; j++) {
				if (unicos[j] == original[i]) {
					existe = true;
					break;
				}
			}
			if (!existe) {
				unicos[qtd++] = original[i];
			}
		}

		// ajuste do tamanho do vetor resultante
		unicos = Arrays.copyOf(unicos, qtd);

		for (int i = 0; i < unicos.length; i++) {
			double soma = 0;
			for (int j = 0; j < compras.size(); j++) {
				if (compras.get(j).getCliente().getId() == unicos[i]) {
					soma += compras.get(j).getValor();
				}
			}
			if (soma > 1000) {

				umCliente = ClienteService.listaClientes.recuperar(unicos[i]);

				System.out.println("| " + umCliente.getId() + " | " + umCliente.getNome() + " | R$ "
						+ NumberFormat.getCurrencyInstance().format(soma) + " |");

			}

		}

	}

}
