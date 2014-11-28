package br.com.caelum.loja.session;

import java.io.StringWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJBAccessException;
import javax.ejb.EJBException;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.interceptor.ExcludeDefaultInterceptors;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import br.com.caelum.loja.entity.Livro;
import br.com.caelum.loja.util.Livros;

@ExcludeDefaultInterceptors
@Stateless
@Local(Mensageiro.class)
public class MensageiroBean implements Mensageiro {

	@Resource(mappedName="java:/ConnectionFactory")
	private ConnectionFactory fabrica;
	
	@Resource(mappedName="java:/queue/loja")
	private Destination destination;
	
	public void enviaMensagem(List<Livro> livros) {
		
		try{
			//criando sessão
			Connection conexao = this.fabrica.createConnection("jms","caelum");
			Session sessao = conexao.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			//criando o wrapper jaxb
			Livros wrapper = new Livros();
			wrapper.adicionaLivros(livros);
			
			//gerando xml
			Marshaller marshaller = JAXBContext.newInstance(Livros.class).createMarshaller();
			StringWriter stringWriter = new StringWriter();
			marshaller.marshal(wrapper, stringWriter);
			
			//criando mensagem jms
			TextMessage textMessage = sessao.createTextMessage(stringWriter.toString());
			
			//criando produtor de mensagens
			MessageProducer produtor = sessao.createProducer(this.destination);
			produtor.send(textMessage);
			
			//fechando conexao
			produtor.close();
			conexao.close();
		} catch (JMSException ex) {
			throw new EJBException(ex);
		} catch (JAXBException ex) {
			throw new EJBException(ex);
		}		 
	}

}
