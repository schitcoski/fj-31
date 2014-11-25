package br.com.caelum.loja.session;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.com.caelum.loja.entity.Livro;

@Stateless
@Remote( GerenciadorLoja.class)
public class GerenciadorLojaBean implements GerenciadorLoja {

	private Map<String, Livro> repositorio;
	
	
	public GerenciadorLojaBean(){
		
		this.repositorio = new HashMap<String, Livro>();
		
		Livro l1 = new Livro();
		l1.setNome("Senhor dos Aneis");
		l1.setPreco(40);
		
		Livro l2 = new Livro();
		l2.setNome("O Hobbit");
		l2.setPreco(25);
		
		this.repositorio.put("1111", l1);
		this.repositorio.put("2222", l2);
	}
	
	public Livro procura(String isbn) {
			
		return this.repositorio.get(isbn);
		
	}

}
