package br.com.caelum.loja.session;

import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.Schedule;
import javax.ejb.ScheduleExpression;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;

@Stateless
@Remote(Agendador.class)
public class AgendadorBean implements Agendador {

	@Resource
	private TimerService ts;
	
	public void agenda(String expressaoMinutos, String expressaoSegundos) {
		
		ScheduleExpression expression = new ScheduleExpression();
		expression.hour("*");
		expression.minute(expressaoMinutos);
		expression.second(expressaoSegundos);
		
		TimerConfig config = new TimerConfig();
		config.setInfo(expression.toString());
		config.setPersistent(false);
		
		this.ts.createCalendarTimer(expression,config);
		
	}
	
	@Timeout
	public void realizaTransacaoBancaria(Timer timer){
		
		System.out.println(timer.getInfo());
		
	}
	
	@Schedule(hour="*", minute="*/1", second="0", persistent=false)
	public void enviaEmail(){
		System.out.println("Enviando e-mail a cada minuto");
	}
	

}
