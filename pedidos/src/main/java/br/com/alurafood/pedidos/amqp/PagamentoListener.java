package br.com.alurafood.pedidos.amqp;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import br.com.alurafood.pedidos.dto.PagamentoDto;

@Component
public class PagamentoListener {

	@RabbitListener(queues = "pagamentos.detalhes-pedido")
	public void recebeMensagem(PagamentoDto pagamento) {
		StringBuilder message = new StringBuilder();
		message.append("Dados pagamento: ").append(pagamento.getId()).append(" / ");
		message.append("Número pedido: ").append(pagamento.getPedidoId()).append(" / ");
		message.append("Valor R$: ").append(pagamento.getValor()).append(" / ");
		message.append("Status: ").append(pagamento.getStatus().toString());
		
		System.out.println("Recebi a mensagem: " + message.toString());
	}
}
