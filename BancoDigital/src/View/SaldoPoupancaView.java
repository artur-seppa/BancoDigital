package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.ContaPoupancaController;
import Controller.DadosController;
import Model.Cliente;

public class SaldoPoupancaView implements ActionListener{

	private static JFrame janela = new JFrame();
	private static JPanel panelSaldo = new JPanel();
	private static JLabel tituloSaldo = new JLabel();
	private static JLabel text = new JLabel(" Seu saldo na conta é de :");
	private static JLabel text1 = new JLabel(" R$");
	
	private static JTextField saldoText = new JTextField(20);
	
	private static JButton SairButton = new JButton("Voltar");
	
	private static SaldoPoupancaView objCadastro = new SaldoPoupancaView();
	private static DadosController controller = new DadosController();
	private static ContaPoupancaController poupancaController = new ContaPoupancaController();
	private static int IDUsuario;
	
	public void imprimirTelaSaldo(DadosController dados, int id,  ContaPoupancaController poupanca) {
		controller = dados;
		IDUsuario = id;
		poupancaController = poupanca;
		
		janela.setVisible(true);	
		
		janela.setSize(400, 400);
		panelSaldo.setLayout(null);
		janela.add(panelSaldo);
		placeComponents(panelSaldo);		
	}

	private void placeComponents(JPanel panelSaldo) {
		tituloSaldo.setText("Saldo Poupança");
		tituloSaldo.setFont(new Font("Arial", Font.BOLD, 20));
		tituloSaldo.setBounds(20, 10, 250, 30);		
		panelSaldo.add(tituloSaldo);
		
		SairButton.setBounds(290, 10, 80, 30);
		panelSaldo.add(SairButton);
		
		 text.setFont(new Font("Arial", Font.BOLD, 15));
		 text.setBounds(40, 65, 380, 30);
		 panelSaldo.add(text);
		 
		 text1.setFont(new Font("Arial", Font.BOLD, 15));
		 text1.setBounds(40, 105, 360, 30);
		 panelSaldo.add(text1);
		 
		 saldoText.setText(Double.toString(poupancaController.saldoContaPoupanca(IDUsuario)) );
		 saldoText.setBounds(70, 105, 140, 30);
		 panelSaldo.add(saldoText);
		 
		 saldoText.setVisible(true);
		 text.setVisible(true);
		 text1.setVisible(true);
		 
		 SairButton.addActionListener(objCadastro);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == SairButton) {
			janela.setVisible(false);
			
			saldoText.setVisible(false);
			text.setVisible(false);
			text1.setVisible(false);
						
			new PoupancaView().imprimirTelaPoupanca(controller, IDUsuario, poupancaController);
		}
	}
	
}
