package View;

import java.util.ArrayList;
import java.util.Iterator;

import Model.*;
import Controller.*;

public class MainView {

	public static void main(String[] args) {
		
		DadosController controller = new DadosController();
		ContaPoupancaController poupanca = new ContaPoupancaController();
		
		String[] clienteName = controller.listandoNomesClientes();
		
		for(int i=0; i<controller.quantidadeClientes(); i++) {
			System.out.println(clienteName[i]);
		}
		
		System.out.println("Adicionando");
		
		controller.criandoCliente("mamae", "333", 123456, 50);
		controller.criandoCliente("papai", "44", 123456, 60);
		
		String[] clienteNameAtualizada = controller.listandoNomesClientes();
		for(int i=0; i<controller.quantidadeClientes(); i++) {
			System.out.println(clienteNameAtualizada[i]);
		}
		
		System.out.println("Removendo");
		
//		controller.removerCliente(1);
//		controller.removerCliente(3);
		String[] clienteNameAtualizada2 = controller.listandoNomesClientes();
		for(int i=0; i<controller.quantidadeClientes(); i++) {
			System.out.println(clienteNameAtualizada2[i]);
		}
		
		System.out.println("Add conta");
		
//		Cliente clienteArray[] = controller.clientes();
//		System.out.println(clienteArray[0].getNome());
		
		poupanca.criandoContaPoupanca(0, 1234d);
		System.out.println(poupanca.saldoContaPoupanca(0));
		System.out.println(poupanca.quantidadeContaPoupanca(0));
		
		System.out.println("removendo conta");
		poupanca.excluindoContaPoupanca(0);
		System.out.println(poupanca.quantidadeContaPoupanca(0));
		
		System.out.println("add conta2");
		poupanca.criandoContaPoupanca(0, 1555d);
		System.out.println(poupanca.saldoContaPoupanca(0));
		System.out.println(poupanca.quantidadeContaPoupanca(0));
		
		System.out.println("Add conta de outro user");
		poupanca.criandoContaPoupanca(3, 2300d);
		System.out.println(poupanca.saldoContaPoupanca(3));
		System.out.println(poupanca.quantidadeContaPoupanca(3));
		
		System.out.println("transeferencia");
		System.out.println("conta1 "+poupanca.saldoContaPoupanca(0));
		poupanca.transferirContaPoupanca(0, "Ana", 200d);
		System.out.println("conta1 "+poupanca.saldoContaPoupanca(0));
		System.out.println("conta2 "+poupanca.saldoContaPoupanca(3));
		
		
//		Cliente clienteArray[] = new Cliente[100]; 
//		
//		System.out.println("Bem vindo ao bank");
//		System.out.println("Criando conta");
//		
//		ArrayList<Cliente> cliente = new ArrayList<Cliente>();
//		
//		clienteArray[0] = new Cliente();
//		clienteArray[0].setNome("Artur");
//		clienteArray[0].setCpf(12345678);
//		
//		clienteArray[1] = new Cliente();
//		clienteArray[1].setNome("seppa");
//		clienteArray[1].setCpf(12345678);
//		
//		clienteArray[2] = new Cliente();
//		clienteArray[2].setNome("reiman");
//		clienteArray[2].setCpf(12345678);
//		
//		clienteArray[3] = new Cliente();
//		clienteArray[3].setNome("raul");
//		clienteArray[3].setCpf(12345678);
//		
//		cliente.add(clienteArray[0]);
//		cliente.add(clienteArray[1]);
//		cliente.add(clienteArray[2]);
//		cliente.add(clienteArray[3]);
//		
//		for(int i=0; i<cliente.size(); i++) {	
//			System.out.println(cliente.get(i).getNome());
//			System.out.println(cliente.get(i).quantidadeContasCorrente());
//		}
//		
//		System.out.println("removendo conta");
//		cliente.remove(clienteArray[2]);
//		
//		for(int i=0; i<cliente.size(); i++) {	
//			System.out.println(cliente.get(i).getNome());
//		}
//		
//		System.out.println("Endereco");
//		
//		Endereco endereco = new Endereco();
//		endereco.setCliente(clienteArray[0]);
//		System.out.println(endereco.getCliente().getNome());
//		
//		System.out.println("Conta poupanca");
//		
//		ContaPoupanca contaPoupanca = new ContaPoupanca();
//		contaPoupanca.setAgencia(123);
//		contaPoupanca.setCliente(clienteArray[0]);
//		clienteArray[0].adicionarContaPoupanca(contaPoupanca);
//		clienteArray[0].excluirContaPoupanca(contaPoupanca);
//		System.out.println(clienteArray[0].quantidadeContasPoupanca());
//		System.out.println(contaPoupanca.getAgencia()+"\n"+ contaPoupanca.getCliente().getNome());
//		
//		System.out.println("Conta poupanca2");
//		ContaPoupanca contaPoupanca1 = new ContaPoupanca();
//		contaPoupanca1.setAgencia(123);
//		contaPoupanca1.setCliente(clienteArray[0]);
//		clienteArray[0].adicionarContaPoupanca(contaPoupanca1);
//		System.out.println(clienteArray[0].quantidadeContasPoupanca());
//		System.out.println(contaPoupanca1.getAgencia()+"\n"+ contaPoupanca1.getCliente().getNome());
//		
//		ContaPoupanca contaPoupanca2 = new ContaPoupanca();
//		contaPoupanca2.setAgencia(123);
//		contaPoupanca2.setCliente(clienteArray[3]);
//		clienteArray[3].adicionarContaPoupanca(contaPoupanca2);
//		System.out.println(contaPoupanca2.getAgencia()+"\n"+ contaPoupanca2.getCliente().getNome());
//		
//		System.out.println("Contas");
//		for(int i=0; i<cliente.size(); i++) {	
//			System.out.println(cliente.get(i).getNome());
//			System.out.println(cliente.get(i).quantidadeContasPoupanca());
//		}
	}

}
