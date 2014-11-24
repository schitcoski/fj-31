package br.com.caelum.livraria.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateful;

import br.com.caelum.livraria.modelo.Livro;

@Stateful
@Remote
public class CarrinhoBean implements Carrinho {

	private List<Livro> livros = new ArrayList<>();
	private double total;
	
	public void addLivro(Livro livro) {
		
		System.out.println("Adicionando o livro " + livro.getNome() + " ao carrinho");
		this.livros.add(livro);
		this.total += livro.getPreco();
		
	}
	
	public List<Livro> getLivros() {
		
		System.out.println("Carrinho devolvendo a lista de livros: ");
		return this.livros;
	}

	public double getTotal() {
		
		System.out.println("Carrinho devolvendo o total: " + total);
		return this.total;
		
	}

	public void finalizacompra() {
		
		System.out.println("Finalizando a compra de: ");
		for (Livro livro : this.livros){
			System.out.println(livro.getPreco() + " - " + livro.getNome());
		}
		
	}

}
