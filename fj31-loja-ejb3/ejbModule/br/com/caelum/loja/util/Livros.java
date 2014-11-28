package br.com.caelum.loja.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.caelum.loja.entity.Livro;

@XmlRootElement
public class Livros {

	private List<Livro> livros = new ArrayList<Livro>();
	
	@XmlElement(name="livro")
	public List<Livro> getLivros(){
		return this.getLivros();
	}
	
	public void adicionaLivros(List<Livro> livros){
		this.livros.addAll(livros);
	}
	
}
