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

public class SacarPoupancaView implements ActionListener{

			private static JFrame janela = new JFrame();
			private static JPanel panelSacar= new JPanel();
			private static JLabel tituloSacar = new JLabel();
			
			private static JTextField sacarText = new JTextField(20);
			
			private static JButton SairButton = new JButton("Voltar");
			private static JButton SacarButton = new JButton("Sacar");
			
			private static SacarPoupancaView objCadastro = new SacarPoupancaView();
			private static DadosController controller = new DadosController();
			private static ContaPoupancaController poupancaController = new ContaPoupancaController();
			private static int IDUsuario;
			
			private static int contErro = 1;
			private static int contSucess = 1;
	
	public void imprimirTelaSacar(DadosController dados, int id,
			ContaPoupancaController poupanca) {
		
		controller = dados;
		IDUsuario = id;
		poupancaController = poupanca;
		
		janela.setVisible(true);	
		
		janela.setSize(400, 400);
		panelSacar.setLayout(null);
		janela.add(panelSacar);
		placeComponents(panelSacar);	
		
	}

	private void placeComponents(JPanel panelSacar) {
		tituloSacar.setText("Sacar Poupança");
		tituloSacar.setFont(new Font("Arial", Font.BOLD, 20));
		tituloSacar.setBounds(20, 10, 250, 30);		
		panelSacar.add(tituloSacar);
		
		SairButton.setBounds(290, 10, 80, 30);
		panelSacar.add(SairButton);
		
		 JLabel text = new JLabel("Insira o valor no qual deseja ");
		 text.setFont(new Font("Arial", Font.BOLD, 15));
		 text.setBounds(80, 65, 500, 30);
		 panelSacar.add(text);
		 
		 JLabel text2 = new JLabel("sacar da sua conta :");
		 text2.setFont(new Font("Arial", Font.BOLD, 15));
		 text2.setBounds(80, 85, 500, 30);
		 panelSacar.add(text2);
		 
		 JLabel text1 = new JLabel(" R$");
		 text1.setFont(new Font("Arial", Font.BOLD, 15));
		 text1.setBounds(90, 135, 360, 30);
		 panelSacar.add(text1);
		 
		 sacarText.setText("0.00");
		 sacarText.setBounds(120, 135, 140, 30);
		 panelSacar.add(sacarText);
		 
		SacarButton.setBounds(137, 190, 100, 30);
		panelSacar.add(SacarButton);
		 
		 SairButton.addActionListener(objCadastro);
		 SacarButton.addActionListener(objCadastro);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		boolean sucesso = false;
		
		if(src == SairButton) {
			janela.setVisible(false);
			
			sacarText.setText("0.00");
			
			new PoupancaView().imprimirTelaPoupanca(controller, IDUsuario, poupancaController);
		}
		
		if(src == SacarButton) {
			
			Double saque =  Double.parseDouble(sacarText.getText());
			
			if(saque >= 0.00d){
				if(poupancaController.saldoContaPoupanca(IDUsuario) >= saque) {
					sucesso = poupancaController.sacarContaPoupanca(IDUsuario, saque);
					sacarText.setText("0.00");
					
					if(sucesso == true) {
						janela.setVisible(false);
						
						sacarText.setText("0.00");
					}
				}
			}
			
		}
	}

}
