package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.ContaPoupancaController;
import Controller.DadosController;
import Model.Cliente;

public class PoupancaView implements ActionListener{

	private static JFrame janela = new JFrame();
	private static JPanel panelPoupanca = new JPanel();
	private static JLabel tituloPoupanca = new JLabel();
	
	private static JLabel text = new JLabel("Você não possui nenhuma conta poupança,");
	private static JLabel text1 = new JLabel("deseja criar uma conta agora ? ");
	
	private static JButton SairButton = new JButton("Sair");
	private static JButton CriarContaButton = new JButton("Criar");
	
	private static JButton SaldoButton = new JButton("Saldo");
	private static JButton SacarButton = new JButton("Sacar");
	private static JButton transferirButton = new JButton("Transferir");
	private static JButton depositarButton = new JButton("Depositar");
	
	private static PoupancaView objCadastro = new PoupancaView();
	private static DadosController controller = new DadosController();
	private static ContaPoupancaController poupancaController = new ContaPoupancaController();
	private static Cliente cliente = new Cliente();
	private static int IDUsuario;
	
	public void imprimirTelaPoupanca(DadosController dados, int id, ContaPoupancaController poupanca) {
		controller = dados;
		IDUsuario = id;
		poupancaController = poupanca;
		
		janela.setVisible(true);	
		
		janela.setSize(400, 450);
		panelPoupanca.setLayout(null);
		janela.add(panelPoupanca);
		placeComponents(panelPoupanca);
		
		cliente = controller.cliente(IDUsuario);
	}

	private void placeComponents(JPanel panelPoupanca) {
		if(poupancaController.quantidadeContaPoupanca(IDUsuario) == 0) {
			
			tituloPoupanca.setText("Conta Poupanca");
			tituloPoupanca.setFont(new Font("Arial", Font.BOLD, 20));
			tituloPoupanca.setBounds(20, 10, 250, 30);		
			panelPoupanca.add(tituloPoupanca);
			
			SairButton.setBounds(290, 10, 80, 30);
			panelPoupanca.add(SairButton);
			
			text.setFont(new Font("Arial", Font.BOLD, 15));
			text.setBounds(20, 65, 380, 30);
			panelPoupanca.add(text);
			
			text1.setFont(new Font("Arial", Font.BOLD, 15));
			text1.setBounds(20, 85, 360, 30);
			panelPoupanca.add(text1);
			
			CriarContaButton.setBounds(130, 125, 120, 30);
			panelPoupanca.add(CriarContaButton);
			
			SairButton.addActionListener(objCadastro);
			CriarContaButton.addActionListener(objCadastro);
			
		} if(poupancaController.quantidadeContaPoupanca(IDUsuario) != 0){
			tituloPoupanca.setText("Conta Poupanca");
			tituloPoupanca.setFont(new Font("Arial", Font.BOLD, 20));
			tituloPoupanca.setBounds(20, 10, 250, 30);		
			panelPoupanca.add(tituloPoupanca);
			
			SairButton.setBounds(290, 10, 80, 30);
			panelPoupanca.add(SairButton);
			
			SaldoButton.setBounds(100, 80, 200, 40);
			panelPoupanca.add(SaldoButton);
			
			SacarButton.setBounds(100, 150, 200, 40);
			panelPoupanca.add(SacarButton);
			
			transferirButton.setBounds(100, 220, 200, 40);
			panelPoupanca.add(transferirButton);
			
			depositarButton.setBounds(100, 290, 200, 40);
			panelPoupanca.add(depositarButton);
			
			SairButton.addActionListener(objCadastro);
			SaldoButton.addActionListener(objCadastro);
			SacarButton.addActionListener(objCadastro);
			transferirButton.addActionListener(objCadastro);
			depositarButton.addActionListener(objCadastro);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == CriarContaButton) {
			janela.setVisible(false);
			
			poupancaController.criandoContaPoupanca(IDUsuario, 0d);
			
			text.setVisible(false);
			text1.setVisible(false);
			CriarContaButton.setVisible(false);
			
			new HomeView().imprimirTelaHome(controller, 
					controller.ImprimeIDCliente(cliente.getNome(), cliente.getSenha()) );
		}
		
		if(src == SairButton) {
			janela.setVisible(false);
			new HomeView().imprimirTelaHome(controller, 
					controller.ImprimeIDCliente(cliente.getNome(), cliente.getSenha()) );
		}
		
		if(src == SaldoButton) {
			new SaldoPoupancaView().imprimirTelaSaldo(controller, IDUsuario, poupancaController);
		}
		
		if (src == SacarButton) {
			new SacarPoupancaView().imprimirTelaSacar(controller, IDUsuario, poupancaController);
		}

		if (src == transferirButton) {
			new TransferirPoupancaView().imprimirTelaTransferir(controller, IDUsuario, poupancaController);
		}

		if (src == depositarButton) {
			new DepositarPoupancaView().imprimirTelaDepositar(controller, IDUsuario, poupancaController);
		}
		
	}

}
