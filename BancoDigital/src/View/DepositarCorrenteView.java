package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.ContaCorrenteController;
import Controller.ContaPoupancaController;
import Controller.DadosController;

public class DepositarCorrenteView  implements ActionListener{

	private static JFrame janela = new JFrame();
	private static JPanel panelDepositar= new JPanel();
	private static JLabel tituloDepositar = new JLabel();
	
	private static JTextField DepositarText = new JTextField(20);
	
	private static JButton SairButton = new JButton("Voltar");
	private static JButton DepositarButton = new JButton("Depositar");
	
	private static DepositarCorrenteView objCadastro = new DepositarCorrenteView();
	private static DadosController controller = new DadosController();
	private static ContaCorrenteController correnteController = new ContaCorrenteController();
	private static int IDUsuario;
	
	private static int contErro = 1;
	private static int contErroUser = 1;
	private static int contSucess = 1;
	
	public void imprimirTelaDepositarCorrente(DadosController dados, int id,
			ContaCorrenteController corrente) {
		
		controller = dados;
		IDUsuario = id;
		correnteController = corrente;
		
		janela.setVisible(true);	
		
		janela.setSize(400, 400);
		panelDepositar.setLayout(null);
		janela.add(panelDepositar);
		placeComponents(panelDepositar);	
		
	}
	
	private void placeComponents(JPanel panelDepositar) {
		tituloDepositar.setText("Depositar Conta Corrente");
		tituloDepositar.setFont(new Font("Arial", Font.BOLD, 20));
		tituloDepositar.setBounds(20, 10, 250, 30);		
		panelDepositar.add(tituloDepositar);
		
		SairButton.setBounds(290, 10, 80, 30);
		panelDepositar.add(SairButton);
		
		 JLabel text = new JLabel("Insira o valor no qual deseja depositar");
		 text.setFont(new Font("Arial", Font.BOLD, 15));
		 text.setBounds(40, 65, 380, 30);
		 panelDepositar.add(text);
		 
		 JLabel text2 = new JLabel("na sua conta :");
		 text2.setFont(new Font("Arial", Font.BOLD, 15));
		 text2.setBounds(40, 85, 380, 30);
		 panelDepositar.add(text2);
		 
		 JLabel text1 = new JLabel(" R$");
		 text1.setFont(new Font("Arial", Font.BOLD, 15));
		 text1.setBounds(40, 125, 360, 30);
		 panelDepositar.add(text1);
		 
		 DepositarText.setText("0.00");
		 DepositarText.setBounds(70, 125, 140, 30);
		 panelDepositar.add(DepositarText);
		 
		 DepositarButton.setBounds(110, 190, 160, 30);
		 panelDepositar.add(DepositarButton);
		 
		 SairButton.addActionListener(objCadastro);
		 DepositarButton.addActionListener(objCadastro);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		boolean sucesso = false;
		
		if(src == SairButton) {
			janela.setVisible(false);
			
			DepositarText.setText("0.00");
			
			new CorrenteView().imprimirTelaCorrente(controller, IDUsuario, correnteController);
		}
		
		if(src == DepositarButton) {
			Double saque =  Double.parseDouble(DepositarText.getText());
			
			if( saque >= 0.00d){
				sucesso = correnteController.depositarContaCorrente(IDUsuario, saque);
				janela.setVisible(false);
				
				DepositarText.setText("0.00");
			}
			
		}
		
	}
	
	
}
