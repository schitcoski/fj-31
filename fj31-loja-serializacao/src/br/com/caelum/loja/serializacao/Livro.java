package br.com.caelum.loja.serializacao;

import java.io.Serializable;

public class Livro implements Serializable{
	
	private static final long serialVersionUID = 7339860952191476196L;
	
	private String nome;
	private double preco;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}

}
