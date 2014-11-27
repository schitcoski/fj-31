package br.com.caelum.loja.session;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

import br.com.caelum.loja.entity.Autor;
import br.com.caelum.loja.entity.Livro;
import br.com.caelum.loja.exception.SalvaLivroException;
import br.com.caelum.loja.interceptor.AuditoriaInterceptor;

//@TransactionManagement(TransactionManagementType.BEAN)
@Interceptors(AuditoriaInterceptor.class)
@Stateless
@Remote(GerenciadorLoja.class)
public class GerenciadorLojaBean implements GerenciadorLoja {

	private Map<String, Livro> repositorio;

	@PersistenceContext
	private EntityManager manager;

	@Resource
	private UserTransaction ut;

	public GerenciadorLojaBean() {

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

	public void salva(Livro livro) {
//		try {
//			this.ut.begin();
//		} catch (Exception e) {
//			throw new EJBException(e);
//		}

		this.manager.persist(livro);
		System.out.println("Livro salvo! ID: " + livro.getId());
		throw new SalvaLivroException();

//		try {
//			this.ut.commit();
//		} catch (Exception e) {
//			try {
//				this.ut.rollback();
//			} catch (Exception e1) {
//				throw new EJBException(e1);
//			}
//			throw new EJBException(e);
//		}
	}

	public Autor salva(Autor autor) {
		this.manager.persist(autor);
		System.out.println("Autor salvo! ID: " + autor.getId());
		return autor;
	}

	public Livro procura(Long id) {
		return this.manager.find(Livro.class, id);
	}

	public List<Livro> buscaLivroPeloNomeDoAutor(String nome) {
		System.out.println("Buscando livros pelo autor: " + nome);
		String jpql = "select livro from Livro as livro join fetch livro.autores as autor"
				+ " where autor.nome like :busca";
		Query query = this.manager.createQuery(jpql);
		query.setParameter("busca", "%" + nome + "%");
		return query.getResultList();
	}

	public List<Autor> buscaAutorPeloNomeDolivro(String nome) {
		System.out.println("Buscando autores pelo livro: " + nome);
		String jpql = "select livro.autores from Livro as livro"
				+ " where livro.nome like :busca order by livro.nome";
		Query query = this.manager.createQuery(jpql);
		query.setParameter("busca", "%" + nome + "%");
		return query.getResultList();
	}

}
