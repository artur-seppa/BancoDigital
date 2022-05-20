package Controller;

import Model.Cliente;
import Model.ContaPoupanca;
import Model.Endereco;
import Controller.DadosController;

public class ContaPoupancaController {
	  
	  private ContaPoupanca ContaPoupancaArray[] = new ContaPoupanca[100];
	  private static int cont = 0;
	
	  private static DadosController controller = new DadosController();
	  private static Cliente clienteArray[] = controller.arrayclientes();
	  private static int quantidadeClientes = controller.quantidadeClientes();
	  
	  public void obtemController (DadosController dados) {
		  controller = dados;
		  clienteArray = controller.arrayclientes();
		  quantidadeClientes = controller.quantidadeClientes();
		  System.out.println("quantidade cliente = "+quantidadeClientes);
	  }
	  
	  /*Criando ContaPoupanca*/
		public boolean criandoContaPoupanca(int id, Double saldo) {
			ContaPoupancaArray[cont] = new ContaPoupanca();
			ContaPoupancaArray[cont].setAgencia(123);
			ContaPoupancaArray[cont].setNumero(123456);
			ContaPoupancaArray[cont].setSaldo(saldo);
					
			clienteArray[id].adicionarContaPoupanca(ContaPoupancaArray[cont]);
			ContaPoupancaArray[cont].setCliente(clienteArray[id]);	
			
			cont++;
			return true;
		}
		
		/*removendo ContaPoupanca*/
		public boolean excluindoContaPoupanca(int id) {
			if(cont == 0){
				clienteArray[id].excluirContaPoupanca(clienteArray[id].getContaPoupanca());
				
				return true;
			}
			
			return false;
		}
		
		/*depositar ContaPoupanca*/
		public boolean depositarContaPoupanca(int id, Double montante) {
			Double total = clienteArray[id].getContaPoupanca().getSaldo();
			total = total + montante;
			
			clienteArray[id].getContaPoupanca().setSaldo(total);
			return true;
		}
		
		/*sacar ContaPoupanca*/
		public boolean sacarContaPoupanca(int id, Double saque) {
			Double saldo = clienteArray[id].getContaPoupanca().getSaldo();
			saldo = saldo - saque;
			
			clienteArray[id].getContaPoupanca().setSaldo(saldo);
			return true;
		}
		
		/*transferir ContaPoupanca*/
		public boolean transferirContaPoupanca(int id, String titular, Double transferencia) {
			for(int i=0; i<quantidadeClientes; i++) {
				
				if(clienteArray[i].getNome().equals(titular)) {
					System.out.println("quantidade de contas na transferencia "+ clienteArray[i].quantidadeContasPoupanca());
					if(clienteArray[i].quantidadeContasPoupanca() == 1){
						Double saldo = clienteArray[id].getContaPoupanca().getSaldo();
						saldo = saldo - transferencia;
						
						clienteArray[id].getContaPoupanca().setSaldo(saldo);
						
						//transfere o valor para o titular
						Double total = clienteArray[i].getContaPoupanca().getSaldo();
						clienteArray[i].getContaPoupanca().setSaldo(total+transferencia);
						return true;
					}
				}				
			}
			
			return false;
		}
		
		/*quantidade ContaPoupanca*/
		public int quantidadeContaPoupanca(int id) {
			return clienteArray[id].quantidadeContasPoupanca();
		}
		
		/*saldo ContaPoupanca*/
		public Double saldoContaPoupanca(int id) {
			return clienteArray[id].getContaPoupanca().getSaldo();
		}
}
