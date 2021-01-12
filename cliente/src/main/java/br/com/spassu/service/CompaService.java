package br.com.spassu.service;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import br.com.spassu.modelo.Cliente;
import br.com.spassu.modelo.Compra;
import br.com.spassu.util.FormataDadosUtil;
import br.com.spassu.util.ListaDeObjetos;

public class CompaService {

	ListaDeObjetos<Compra> listaCompras = new ListaDeObjetos<Compra>(0);
	FormataDadosUtil formataDados = new FormataDadosUtil();

	Compra umaCompra;
	Cliente umCliente;

	public String setCompra(String valor) throws ParseException {

		String[] textoSeparado = valor.split(";");
		double valorImposto = 0;

		int idClienteCadastrado = Integer.parseInt(textoSeparado[1].replaceAll(" ", ""));
		String dataCompraString = textoSeparado[2];
		String valorCompraString = textoSeparado[3];

		Date data = formataDados.formataData(dataCompraString);

		umCliente = ClienteService.listaClientes.recuperar(idClienteCadastrado);

		double valorCompra = formataDados.removePontuacao(valorCompraString);

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
					+ formataDados.getDataFormatada(umaCompra.getData()) + " | R$ "
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

		int vetIdUsuariosCompraOriginal[] = new int[compras.size()];
		for (int i = 0; i < compras.size(); i++) {
			vetIdUsuariosCompraOriginal[i] = compras.get(i).getCliente().getId();
		}

		int vetIdUsuariosCompra[] = formataDados.removeValorDuplicadoVet(vetIdUsuariosCompraOriginal);

		for (int i = 0; i < vetIdUsuariosCompra.length; i++) {
			double somaValorCompras = 0;
			for (int j = 0; j < compras.size(); j++) {
				if (compras.get(j).getCliente().getId() == vetIdUsuariosCompra[i]) {
					somaValorCompras += compras.get(j).getValor();
				}
			}
			if (somaValorCompras > 1000) {

				umCliente = ClienteService.listaClientes.recuperar(vetIdUsuariosCompra[i]);

				System.out.println("| " + umCliente.getId() + " | " + umCliente.getNome() + " | R$ "
						+ NumberFormat.getCurrencyInstance().format(somaValorCompras) + " |");

			}

		}

	}

}
