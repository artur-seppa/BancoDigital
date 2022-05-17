package Model;

import java.util.Date;

public class ContaPoupanca extends Conta {
	private Cliente cliente;
	private Date dataBonificacao;
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
