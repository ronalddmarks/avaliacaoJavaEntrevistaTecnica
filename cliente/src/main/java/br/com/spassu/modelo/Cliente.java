package br.com.spassu.modelo;

public class Cliente {

	private Integer id;
	private String nome;
	private String cidade;

	// construtor


	public Cliente(Integer id, String nome, String cidade) {
		this.id = id;
		this.nome = nome;
		this.cidade = cidade;
	}

	
	public Cliente() {

	}


	// gets

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCidade() {
		return cidade;
	}

	// sets

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	
	public boolean equals (Object num)
	{		
		Integer n = new Integer(id);
		return n.equals(num);
		
	}


	
	

}
