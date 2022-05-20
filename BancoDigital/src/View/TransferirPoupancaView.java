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

import Controller.ContaPoupancaController;
import Controller.DadosController;

public class TransferirPoupancaView implements ActionListener{

	private static JFrame janela = new JFrame();
	private static JPanel panelTransferir= new JPanel();
	private static JLabel tituloTransferir = new JLabel();
	
	private static JTextField transferirText = new JTextField(20);
	private static JTextField NameText = new JTextField(20);
	
	private static JButton SairButton = new JButton("Voltar");
	private static JButton TransferirButton = new JButton("Sacar");
	
	private static TransferirPoupancaView objCadastro = new TransferirPoupancaView();
	private static DadosController controller = new DadosController();
	private static ContaPoupancaController poupancaController = new ContaPoupancaController();
	private static int IDUsuario;
	
	private static int contErro = 1;
	private static int contErroUser = 1;
	private static int contSucess = 1;

	
	public void imprimirTelaTransferir(DadosController dados, int id,
			ContaPoupancaController poupanca) {
		controller = dados;
		IDUsuario = id;
		poupancaController = poupanca;
		
		janela.setVisible(true);	
		
		janela.setSize(400, 400);
		panelTransferir.setLayout(null);
		janela.add(panelTransferir);
		placeComponents(panelTransferir);	
	}


	private void placeComponents(JPanel panelTransferir) {
		tituloTransferir.setText("Transferir Poupança");
		tituloTransferir.setFont(new Font("Arial", Font.BOLD, 20));
		tituloTransferir.setBounds(20, 10, 250, 30);		
		panelTransferir.add(tituloTransferir);
		
		SairButton.setBounds(290, 10, 80, 30);
		panelTransferir.add(SairButton);
		
		 JLabel text = new JLabel("Insira o valor no qual deseja transferir :");
		 text.setFont(new Font("Arial", Font.BOLD, 15));
		 text.setBounds(40, 75, 500, 30);
		 panelTransferir.add(text);
		 
		 JLabel text1 = new JLabel("R$");
		 text1.setFont(new Font("Arial", Font.BOLD, 15));
		 text1.setBounds(40, 115, 360, 30);
		 panelTransferir.add(text1);
		 
		 transferirText.setText("0.00");
		 transferirText.setBounds(70, 115, 120, 30);
		 panelTransferir.add(transferirText);
		 
		 JLabel text2 = new JLabel("Nome da pessoa que receberá o dinheiro :");
		 text2.setFont(new Font("Arial", Font.BOLD, 15));
		 text2.setBounds(40, 155, 360, 30);
		 panelTransferir.add(text2);
		 
		 NameText.setBounds(40, 195, 180, 30);
		 panelTransferir.add(NameText);
		 
		 TransferirButton.setBounds(145, 250, 100, 30);
		panelTransferir.add(TransferirButton);
		 
		 SairButton.addActionListener(objCadastro);
		 TransferirButton.addActionListener(objCadastro);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		boolean sucesso = false;
		
		if(src == SairButton) {
			janela.setVisible(false);
			
			transferirText.setText("0.00");
			NameText.setText("");
			
			new PoupancaView().imprimirTelaPoupanca(controller, IDUsuario, poupancaController);
		}
		
		if(src == TransferirButton) {
			Double saque =  Double.parseDouble(transferirText.getText());
			
			if( saque >= 0.00d && !NameText.getText().isEmpty() ){
				if(poupancaController.saldoContaPoupanca(IDUsuario) >= saque) {
				    sucesso = poupancaController.transferirContaPoupanca(IDUsuario,
					NameText.getText(), saque);
				
				}
				
				if(sucesso == true) {
					janela.setVisible(false);
					
					transferirText.setText("0.00");
					NameText.setText("");
				}
			}
			
		}
		
	}

}
