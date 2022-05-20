package Controller;

import java.util.ArrayList;

import Model.*;

public class DadosController {
   private Cliente clienteArray[] = new Cliente[100]; 
   private Endereco enderecoArray[] = new Endereco[100]; 
   
   private ContaPoupanca ContaPoupancaArray[] = new ContaPoupanca[100];
   
   private static int cont = 4;
	
   ArrayList<Cliente> cliente = new ArrayList<Cliente>();
	
	public DadosController() {
		for (int i = 0; i < 4; i++) {
			clienteArray[0] = new Cliente();
			clienteArray[0].setNome("Artur");
			clienteArray[0].setSenha("123");
			clienteArray[0].setCpf(123);
			clienteArray[0].setIdade(19);
			clienteArray[0].setId(0);
			
			clienteArray[1] = new Cliente();
			clienteArray[1].setNome("Tiago");
			clienteArray[1].setSenha("1234");
			clienteArray[1].setCpf(1234);
			clienteArray[1].setIdade(20);
			clienteArray[1].setId(1);

			clienteArray[2] = new Cliente();
			clienteArray[2].setNome("Maria");
			clienteArray[2].setSenha("12345");
			clienteArray[2].setCpf(12345);
			clienteArray[2].setIdade(21);
			clienteArray[2].setId(2);

			clienteArray[3] = new Cliente();
			clienteArray[3].setNome("Ana");
			clienteArray[3].setSenha("123456");
			clienteArray[3].setCpf(123456);
			clienteArray[3].setIdade(22);
			clienteArray[3].setId(3);
			
			/*==========Enderecos===========*/
			
			enderecoArray[0] = new Endereco();
			enderecoArray[0].setEstado("DF");
			enderecoArray[0].setCidade("Brasília");
			enderecoArray[0].setEndereco("rua df");
			
			enderecoArray[1] = new Endereco();
			enderecoArray[1].setEstado("SP");
			enderecoArray[1].setCidade("Sao Paulo");
			enderecoArray[1].setEndereco("rua sp");
			
			enderecoArray[2] = new Endereco();
			enderecoArray[2].setEstado("Rj");
			enderecoArray[2].setCidade("Rio de Janeiro");
			enderecoArray[2].setEndereco("rua rj");
			
			enderecoArray[3] = new Endereco();
			enderecoArray[3].setEstado("MG");
			enderecoArray[3].setCidade("BH");
			enderecoArray[3].setEndereco("rua bh");
			
			/*ASSOCIA O CLIENTE AO ENDERECO*/
			
			enderecoArray[0].setCliente(clienteArray[0]);
			enderecoArray[1].setCliente(clienteArray[1]);
			enderecoArray[2].setCliente(clienteArray[2]);
			enderecoArray[3].setCliente(clienteArray[3]);
			
			/*ASSOCIA O ENDERECO AO CLIENTE*/
			
			clienteArray[0].setEndereco(enderecoArray[0]);
			clienteArray[1].setEndereco(enderecoArray[1]);
			clienteArray[2].setEndereco(enderecoArray[2]);
			clienteArray[3].setEndereco(enderecoArray[3]);
		}

		cliente.add(clienteArray[0]);
		cliente.add(clienteArray[1]);
		cliente.add(clienteArray[2]);
		cliente.add(clienteArray[3]);

	}
	
	/*Criando Cliente*/
	public boolean criandoCliente(String nome, String senha, long cpf, int idade, 
			String endereco, String estado, String cidade) {
		
		clienteArray[cont] = new Cliente();
		
		clienteArray[cont].setNome(nome);
		clienteArray[cont].setSenha(senha);
		clienteArray[cont].setCpf(cpf);
		clienteArray[cont].setIdade(idade);
		clienteArray[cont].setId(cont);
				
		enderecoArray[cont] = new Endereco();
		enderecoArray[cont].setCidade(cidade);
		enderecoArray[cont].setEstado(estado);
		enderecoArray[cont].setEndereco(endereco);
		
		//ASSOCIA O CLIENTE AO ENDERECO
		enderecoArray[cont].setCliente(clienteArray[cont]);
		
		//ASSOCIA O ENDERECO AO CLIENTE
		clienteArray[cont].setEndereco(enderecoArray[cont]);
		
		cliente.add(clienteArray[cont]);
		
		cont++;
		return true;
	}
	
	/*Deletando Cliente*/
	public boolean removerCliente(int id) {
		cliente.remove(clienteArray[id]);
		return true;
	}
	
	/*Quantidade de Clientes*/
	public int quantidadeClientes() {
		return cliente.size();
	}
	
	/*Mostrando todos os Cliente*/
	public String[] listandoNomesClientes() {
		String[] clientesNames = new String[cliente.size()];
		
		for(int i=0; i<cliente.size(); i++) {	
			clientesNames[i] = cliente.get(i).getNome();
		}
		
		return clientesNames;
	}
	
	/*Detem o Cliente com o seu id*/
	public Cliente imprimeCliente(int id) {
		return clienteArray[id];
	}
	
	/*Login de cliente no sistema*/
	public boolean loginCliente(String nome, String senha) {
		for(int i=0; i<cliente.size(); i++) {	
			if(nome.equals(cliente.get(i).getNome())) {
				if(senha.equals(cliente.get(i).getSenha())){
					return true;
				}
			}
		}		
		return false;		
	}
	
	/*Obtem ID de cliente no sistema*/
	public int ImprimeIDCliente(String nome, String senha) {
	for(int i=0; i<cliente.size(); i++) {	
		if(nome.equals(cliente.get(i).getNome())) {
			if(senha.equals(cliente.get(i).getSenha())){
				return cliente.get(i).getId();
			}
		}
	}
	return -1;
	
  }
	
	/*Obtem Cliente pelo ID*/
	public Cliente cliente(int id) {
		return cliente.get(id);
	}
	
	/*Obtem Array de clientes*/
	public Cliente[] arrayclientes() {
		return clienteArray;
	}
}
