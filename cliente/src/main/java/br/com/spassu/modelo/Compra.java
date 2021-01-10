package br.com.spassu.modelo;

import java.util.Date;

public class Compra {

	private Cliente cliente;
	private Date data;
	private String valor;
	private String valorImposto;
	

	// construtor 
	public Compra(Cliente cliente, Date data, String valor, String valorImposto) {
		this.cliente = cliente;
		this.data = data;
		this.valor = valor;
		this.valorImposto = valorImposto;
	}


	// gets
	
	public Cliente getCliente() {
		return cliente;
	}


	public Date getData() {
		return data;
	}


	public String getValor() {
		return valor;
	}


	public String getValorImposto() {
		return valorImposto;
	}

	
	// sets
	

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public void setData(Date data) {
		this.data = data;
	}


	public void setValor(String valor) {
		this.valor = valor;
	}


	public void setValorImposto(String valorImposto) {
		this.valorImposto = valorImposto;
	}
	
		

}
