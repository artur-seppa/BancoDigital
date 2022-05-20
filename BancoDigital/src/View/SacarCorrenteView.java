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

public class SacarCorrenteView implements ActionListener{

			private static JFrame janela = new JFrame();
			private static JPanel panelSacar= new JPanel();
			private static JLabel tituloSacar = new JLabel();
			private static JLabel text2 = new JLabel("sacar da sua conta :");
			private static JLabel text = new JLabel("Insira o valor no qual deseja ");
			private static JLabel text1 = new JLabel(" R$");
			
			private static JTextField sacarText = new JTextField(20);
			
			private static JButton SairButton = new JButton("Voltar");
			private static JButton SacarButton = new JButton("Sacar");
			
			private static SacarCorrenteView objCadastro = new SacarCorrenteView();
			private static DadosController controller = new DadosController();
			private static ContaCorrenteController correnteController = new ContaCorrenteController();
			private static int IDUsuario;
			
			private static int contErro = 1;
			private static int contSucess = 1;
	
	public void imprimirTelaSacarCorrente(DadosController dados, int id,
			ContaCorrenteController corrente) {
		
		controller = dados;
		IDUsuario = id;
		correnteController = corrente;
		
		janela.setVisible(true);	
		
		janela.setSize(400, 400);
		panelSacar.setLayout(null);
		janela.add(panelSacar);
		placeComponents(panelSacar);	
		
	}

	private void placeComponents(JPanel panelSacar) {
		tituloSacar.setText("Sacar Conta Corrente");
		tituloSacar.setFont(new Font("Arial", Font.BOLD, 20));
		tituloSacar.setBounds(20, 10, 250, 30);		
		panelSacar.add(tituloSacar);
		
		SairButton.setBounds(290, 10, 80, 30);
		panelSacar.add(SairButton);
		
		 text.setFont(new Font("Arial", Font.BOLD, 15));
		 text.setBounds(80, 65, 500, 30);
		 panelSacar.add(text);
		 
		 text2.setFont(new Font("Arial", Font.BOLD, 15));
		 text2.setBounds(80, 85, 500, 30);
		 panelSacar.add(text2);
		 
		 text1.setFont(new Font("Arial", Font.BOLD, 15));
		 text1.setBounds(90, 135, 360, 30);
		 panelSacar.add(text1);
		 
		 sacarText.setText("0.00");
		 sacarText.setBounds(120, 135, 140, 30);
		 panelSacar.add(sacarText);
		 
		SacarButton.setBounds(137, 190, 100, 30);
		panelSacar.add(SacarButton);
		
		sacarText.setVisible(true);
		text.setVisible(true);
		text2.setVisible(true);
		text1.setVisible(true);
		
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
			
			sacarText.setVisible(false);
			text.setVisible(false);
			text2.setVisible(false);
			text1.setVisible(false);
			
			new CorrenteView().imprimirTelaCorrente(controller, IDUsuario, correnteController);
		}
		
		if(src == SacarButton) {
			
			Double saque =  Double.parseDouble(sacarText.getText());
			
			if(saque >= 0.00d){
				if(correnteController.saldoContaCorrente(IDUsuario) >= saque) {
					sucesso = correnteController.sacarContaCorrente(IDUsuario, saque);
					
					sacarText.setVisible(false);
					text.setVisible(false);
					text2.setVisible(false);
					text1.setVisible(false);
					
					janela.setVisible(false);
						
				}
			}
			
		}
	}

}
