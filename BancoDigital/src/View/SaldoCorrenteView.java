package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.ContaCorrenteController;
import Controller.ContaPoupancaController;
import Controller.DadosController;
import Model.Cliente;

public class SaldoCorrenteView implements ActionListener{

	private static JFrame janela = new JFrame();
	private static JPanel panelSaldo = new JPanel();
	private static JLabel tituloSaldo = new JLabel();
	
	private static JTextField saldoText = new JTextField(20);
	
	private static JButton SairButton = new JButton("Voltar");
	
	private static SaldoCorrenteView objCadastro = new SaldoCorrenteView();
	private static DadosController controller = new DadosController();
	private static ContaCorrenteController correnteController = new ContaCorrenteController();
	private static int IDUsuario;
	
	public void imprimirTelaSaldoCorrente(DadosController dados, int id,  ContaCorrenteController corrente) {
		controller = dados;
		IDUsuario = id;
		correnteController = corrente;
		
		janela.setVisible(true);	
		
		janela.setSize(400, 400);
		panelSaldo.setLayout(null);
		janela.add(panelSaldo);
		placeComponents(panelSaldo);		
	}

	private void placeComponents(JPanel panelSaldo) {
		tituloSaldo.setText("Saldo Conta Corrente");
		tituloSaldo.setFont(new Font("Arial", Font.BOLD, 20));
		tituloSaldo.setBounds(20, 10, 250, 30);		
		panelSaldo.add(tituloSaldo);
		
		SairButton.setBounds(290, 10, 80, 30);
		panelSaldo.add(SairButton);
		
		 JLabel text = new JLabel(" Seu saldo na conta é de :");
		 text.setFont(new Font("Arial", Font.BOLD, 15));
		 text.setBounds(40, 65, 380, 30);
		 panelSaldo.add(text);
		 
		 JLabel text1 = new JLabel(" R$");
		 text1.setFont(new Font("Arial", Font.BOLD, 15));
		 text1.setBounds(40, 105, 360, 30);
		 panelSaldo.add(text1);
		 
		 saldoText.setText(Double.toString(correnteController.saldoContaCorrente(IDUsuario)) );
		 saldoText.setBounds(70, 105, 140, 30);
		 panelSaldo.add(saldoText);
		 
		 SairButton.addActionListener(objCadastro);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == SairButton) {
			janela.setVisible(false);
			
			saldoText.setText(Double.toString(correnteController.saldoContaCorrente(IDUsuario)) );
			
			new CorrenteView().imprimirTelaCorrente(controller, IDUsuario, correnteController);
		}
	}
	
}
