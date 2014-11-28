package br.com.caelum.loja.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import br.com.caelum.loja.entity.Livro;
import br.com.caelum.loja.session.GerenciadorLoja;

@Path("/loja")
public class LojaResource {
	
	@EJB
	GerenciadorLoja gerenciador;
	
	@GET @Path("/livros")
	@Produces({"application/xml","application/json"})
	public List<Livro> getLivrosXml(){
		List<Livro> livros = gerenciador.listaLivros();
		return livros;
	}
	
	@GET @Path("/livro/{id}")
	@Produces({"application/xml","application/json"})
	public Livro getLivro(@PathParam("id") Long id){
		
		Livro livro = gerenciador.procura(id);
		if(livro == null ){
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		System.out.println(livro.getNome());
		return livro;
	}
	
}
