package br.com.caelum.loja.client.exemplo;

import javax.naming.NamingException;

import br.com.caelum.loja.entity.Livro;

public class ClienteFazendoChamadaLocal {
	public static void main(String[] args) throws NamingException {
		
		Livro livro = new Livro();
		
		long inicio = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++){
			livro.getPreco();
		}
		long fim = System.currentTimeMillis();
		System.out.println(fim - inicio);
		
	}
}
