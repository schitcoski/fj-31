package br.com.caelum.loja.testes;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.loja.serializacao.Livro;

public class TestaEscritaDeObjetos {

	public static void main(String[] args) throws IOException {

		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
				"livros.txt"));
		
		Livro l1 = new Livro();
		l1.setNome("O Senhor dos Anéis");
		l1.setPreco(50);
		
		Livro l2 = new Livro();
		l2.setNome("O Hobbit");
		l2.setPreco(35);
		
		List<Livro> livros = new ArrayList<>();
		livros.add(l1);
		livros.add(l2);
		
		oos.writeObject(livros);
		oos.close();

	}

}
