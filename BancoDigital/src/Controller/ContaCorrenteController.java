package Controller;

import Model.Cliente;
import Model.ContaCorrente;
import Model.Endereco;
import Controller.DadosController;

public class ContaCorrenteController {
	  
	  private ContaCorrente ContaCorrenteArray[] = new ContaCorrente[100];
	  private static int cont = 0;
	
	  DadosController controller = new DadosController();
	  Cliente clienteArray[] = controller.arrayclientes();
	  int quantidadeClientes = controller.quantidadeClientes();
	  
	  /*Criando ContaCorrente*/
		public boolean criandoContaCorrente(int id, Double saldo) {
			ContaCorrenteArray[cont] = new ContaCorrente();
			ContaCorrenteArray[cont].setAgencia(123);
			ContaCorrenteArray[cont].setNumero(123456);
			ContaCorrenteArray[cont].setSaldo(saldo);
					
			clienteArray[id].adicionarContaCorrente(ContaCorrenteArray[cont]);
			ContaCorrenteArray[cont].setCliente(clienteArray[id]);	
			
			cont++;
			return true;
		}
		
		/*removendo ContaCorrente*/
		public boolean excluindoContaCorrente(int id) {
			clienteArray[id].excluirContaCorrente(clienteArray[id].getContaCorrente());
			
			return true;
		}
		
		/*depositar ContaCorrente*/
		public boolean depositarContaCorrente(int id, Double montante) {
			Double total = clienteArray[id].getContaCorrente().getSaldo();
			total = total + montante;
			
			clienteArray[id].getContaCorrente().setSaldo(total);
			return true;
		}
		
		/*sacar ContaCorrente*/
		public boolean sacarContaCorrente(int id, Double saque) {
			Double saldo = clienteArray[id].getContaCorrente().getSaldo();
			saldo = saldo - saque;
			
			clienteArray[id].getContaCorrente().setSaldo(saldo);
			return true;
		}
		
		/*transferir ContaCorrente*/
		public boolean transferirContaCorrente(int id, String titular, Double transferencia) {
			for(int i=0; i<quantidadeClientes; i++) {
				
				if(clienteArray[i].getNome().equals(titular)) {
					if(clienteArray[i].quantidadeContasCorrente() == 1){
						Double saldo = clienteArray[id].getContaCorrente().getSaldo();
						saldo = saldo - transferencia;
						
						clienteArray[id].getContaCorrente().setSaldo(saldo);
						
						//transfere o valor para o titular
						Double total = clienteArray[i].getContaCorrente().getSaldo();
						clienteArray[i].getContaCorrente().setSaldo(total+transferencia);
						return true;
					}
				}				
			}
			
			return false;
		}
		
		/*quantidade ContaCorrente*/
		public int quantidadeContaCorrente(int id) {
			return clienteArray[id].quantidadeContasCorrente();
		}
		
		/*saldo ContaCorrente*/
		public Double saldoContaCorrente(int id) {
			return clienteArray[id].getContaCorrente().getSaldo();
		}
}
