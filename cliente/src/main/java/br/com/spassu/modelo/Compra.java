package br.com.spassu.modelo;

import java.util.Date;

public class Compra {

	private Cliente cliente;
	private Date data;
	private double valor;
	private double valorImposto;
	

	// construtor 
	
	public Compra() {
	}
	
		
	public Compra(Cliente cliente, Date data, double valor, double valorImposto) {
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

	public double getValor() {
		return valor;
	}


	public double getValorImposto() {
		return valorImposto;
	}

	
	// sets
	

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public void setData(Date data) {
		this.data = data;
	}


	public void setValor(double valor) {
		this.valor = valor;
	}


	public void setValorImposto(double valorImposto) {
		this.valorImposto = valorImposto;
	}

	
	
		

}
