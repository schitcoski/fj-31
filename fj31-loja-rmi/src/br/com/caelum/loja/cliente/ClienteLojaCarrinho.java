package br.com.caelum.loja.cliente;

import java.rmi.Naming;

import br.com.caelum.loja.rmi.Carrinho;
import br.com.caelum.loja.rmi.CarrinhoFactory;
import br.com.caelum.loja.rmi.Livro;

public class ClienteLojaCarrinho {

	public static void main(String[] args) throws Exception {

		CarrinhoFactory carrinhoFactory = (CarrinhoFactory) Naming
				.lookup("rmi://localhost:1099/loja/carrinhos");
		
		Carrinho carrinho = carrinhoFactory.create();
		
		Livro l1 = new Livro();
		l1.setNome("Senhor dos Anéis");
		l1.setPreco(50);
		
		Livro l2 = new Livro();
		l2.setNome("O Hobbit");
		l2.setPreco(35);
		
		carrinho.addLivro(l1);
		carrinho.addLivro(l2);
		
		System.out.println(carrinho.getTotal());
		
		System.out.println(carrinho.getClass().toString());
		

	}

}
