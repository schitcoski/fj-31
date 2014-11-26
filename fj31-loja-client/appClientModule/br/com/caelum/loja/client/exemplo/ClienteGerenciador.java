package br.com.caelum.loja.client.exemplo;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.caelum.loja.entity.Livro;
import br.com.caelum.loja.session.GerenciadorLoja;

public class ClienteGerenciador {

	public static void main(String[] args) throws NamingException {

		InitialContext ic = new InitialContext();

		GerenciadorLoja gerenciador = (GerenciadorLoja) ic
				.lookup("ejb:fj31-loja-ear/fj31-loja-ejb3/GerenciadorLoja!br.com.caelum.loja.session.GerenciadorLoja");

		Livro livro = new Livro();
		livro.setNome("Senhor dos Aneis");
		livro.setPreco(25);
		gerenciador.salva(livro);

	}

}
