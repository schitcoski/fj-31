package br.com.caelum.loja.consulta.cliente;

import java.util.List;

import br.com.caelum.loja.consulta.ws.ConsultaDeLivrosBean;
import br.com.caelum.loja.consulta.ws.ConsultaDeLivrosBeanService;
import br.com.caelum.loja.consulta.ws.Livro;

public class ClienteConsultaWS {

	public static void main(String[] args) {
		ConsultaDeLivrosBean consulta = new ConsultaDeLivrosBeanService().getConsultaDeLivrosBeanPort();
		List<Livro> livros = consulta.buscaLivro("Hob");
		for (Livro livro : livros) {
			System.out.println(livro.getNome());
		}
	}
	
}
