package br.com.caelum.loja.client.exemplo;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.caelum.loja.entity.Autor;
import br.com.caelum.loja.entity.Livro;
import br.com.caelum.loja.session.GerenciadorLoja;

public class ClienteGerenciadorPesquisa {
	public static void main(String[] args) throws NamingException {
		InitialContext ic = new InitialContext();
		GerenciadorLoja gerenciador = (GerenciadorLoja) ic
				.lookup("ejb:fj31-loja-ear/fj31-loja-ejb3/GerenciadorLojaBean!br.com.caelum.loja.session.GerenciadorLoja");

		List<Livro> livros = gerenciador.buscaLivroPeloNomeDoAutor("TolkieN");
		for (Livro livro : livros) {
			System.out.println(livro.getNome());
		}
		
		List<Autor> autores = gerenciador.buscaAutorPeloNomeDolivro("espada");
		for (Autor autor : autores) {
			System.out.println(autor.getNome());
		}

	}
}
