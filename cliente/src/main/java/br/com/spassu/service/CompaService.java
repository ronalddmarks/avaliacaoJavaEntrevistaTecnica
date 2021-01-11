package br.com.spassu.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.spassu.modelo.Cliente;
import br.com.spassu.modelo.Compra;

public class CompaService {

	ListaDeObjetos<Cliente> listaClientes = new ListaDeObjetos<Cliente>(0);
	ListaDeObjetos<Compra> listaCompras = new ListaDeObjetos<Compra>(0);

	Compra umaCompra;
	Cliente umCliente;

	public void setCompra(String valor) throws ParseException {
	   
		String[] textoSeparado = valor.split(";");
	   
		int idClienteCadastrado = Integer.parseInt(textoSeparado[1].replaceAll(" ", ""));
		String dataCompra = textoSeparado[2].replaceAll(" ", "");
		String valorCompra = textoSeparado[3].replaceAll(" ", "");
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
        Date data = (Date) formato.parse(dataCompra);
                
        umCliente = listaClientes.recuperar(idClienteCadastrado);
        
        umaCompra = new Compra(umCliente, data, valorCompra);
        
        listaCompras.adicionar(umaCompra);

        System.out.println("Compra para o cliente " + idClienteCadastrado + " incluída");
	   
   }
	
	public void listarCompras(String valor) {
		
		umaCompra = listaCompras.recuperarPrimeiro();
		
		while (umaCompra != null)  
		{	
				System.out.println (//"| " + umaCompra.getCliente().getId() + 
			                    //    " | " + umaCompra.getCliente().getNome() + 
			                        " | R$ " + umaCompra.getValor() + 
			                        " |");
				
		umaCompra = listaCompras.recuperarProximo();
		
		}
		
	}

}
