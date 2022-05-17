package Model;

import java.util.ArrayList;

public class Cliente {
	private String nome;
	private String senha; 
	private long cpf;
	private int idade;
	private int id;
	
	// Associacao de Endereco com Cliente
	private Endereco endereco;
	
	//Agregacao de contas (Poupança // contaCorrente // Credito) com o Cliente
	private ArrayList<ContaCorrente> contaCorrente;
	private ArrayList<ContaPoupanca> contaPoupanca;
	
	/*
	 * o construtor inicia o array list 
	 */
	public Cliente() {
		contaCorrente = new ArrayList<ContaCorrente>();
		contaPoupanca = new ArrayList<ContaPoupanca>();
	}

	/*
	 * permite adicionar produtos associados a pessoa
	 */
	public void adicionarContaCorrente(ContaCorrente conta) {
		contaCorrente.add(conta);
	}
	
	public void adicionarContaPoupanca(ContaPoupanca conta) {
		contaPoupanca.add(conta);
	}
	
	/*
	 * retorna a quantidade de produtos dessa pessoa
	 */
	public int quantidadeContasCorrente() {
		return contaCorrente.size();
	}
	
	public int quantidadeContasPoupanca() {
		return contaPoupanca.size();
	}
	
	/*
	 * exclui o produto associado a pessoa
	 */
	public void excluirContaCorrente(ContaCorrente conta) {
		contaCorrente.remove(conta);
	}
	
	public void excluirContaPoupanca(ContaPoupanca conta) {
		contaPoupanca.remove(conta);
		conta.setNumero(0);
		conta.setAgencia(0);
		conta.setSaldo(0d);
	}
	
	/*
	 * pega a posiçao de onde o produto se encontra
	 */
	public ContaPoupanca getContaPoupanca() {
		return contaPoupanca.get(0);
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	} 
	
}
