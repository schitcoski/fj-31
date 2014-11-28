package br.com.caelum.loja.session;

import java.util.List;

import br.com.caelum.loja.entity.Autor;
import br.com.caelum.loja.entity.Livro;

public interface GerenciadorLoja {
	Livro procura(String isbn);
	Livro procura(Long id);
	List<Livro> buscaLivroPeloNomeDoAutor(String nome);
	List<Autor> buscaAutorPeloNomeDolivro(String nome);
	void salva(Livro livro);
	Autor salva(Autor autor);
	List<Livro> listaLivros();
}
