package br.com.spassu.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.spassu.modelo.Cliente;
import br.com.spassu.modelo.Compra;

public class CompaService {

	ListaDeObjetos<Cliente> listaClientes = new ListaDeObjetos<Cliente>(0);
	ListaDeObjetos<Compra> listaComprass = new ListaDeObjetos<Compra>(0);

	Compra umaCompra;
	Cliente umCliente;

	public void setCompra(String valor) throws ParseException {
	   
		 //  6; 0; 12/12/2020; 1.310,00
		String[] textoSeparado = valor.split(";");
	   
		int idClienteCadastrado = Integer.parseInt(textoSeparado[1].replaceAll(" ", ""));
		String dataCompra = textoSeparado[2].replaceAll(" ", "");
		String valorCompra = textoSeparado[3].replaceAll(" ", "");
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
        Date data = (Date) formato.parse(dataCompra);
                
        umCliente = listaClientes.recuperar(idClienteCadastrado);
        
        umaCompra = new Compra(umCliente, data, valorCompra);
  
	   
   }

}
