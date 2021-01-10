package br.com.spassu.service;

import java.sql.Date;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import br.com.spassu.modelo.Cliente;
import br.com.spassu.modelo.Compra;

public class CompaService {

   public void incluirCompra(String valor) throws ParseException {
	   
		String[] textoSeparado = valor.split(";");
		
		int id = (Integer.parseInt((textoSeparado[1]).replaceAll(" ", "")));
	   
	   Compra compra = new Compra();
	   Cliente cliente = new Cliente();
	   
	   SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
	   Date data = (Date) formato.parse(textoSeparado[2]);
	   
	   compra.setData(data);
	   
	   compra.setValor(NumberFormat.getCurrencyInstance().format(textoSeparado[3]));
	   
	   
	//   compra.setCliente(cliente.getId(Integer.parseInt(textoSeparado[1])));
	   
	   
	   
   }

}
