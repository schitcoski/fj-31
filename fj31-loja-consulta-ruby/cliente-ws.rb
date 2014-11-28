require "savon"

nome_do_livro = ARGV[0]

client = Savon.client({ :wsdl => "http://localhost:8080/fj31-loja-ejb3/ConsultaDeLivrosBean?wsdl"})
 
response = client.call(:busca_livro, 
				{ :message => 
					{ :nome => nome_do_livro } } )
 
livros = response.body[:busca_livro_response][:return]
 
if(livros.nil?)
	puts "Nenhum livro encontrado!"
else
	puts "Encontrados: #{livros}"
end
