package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controller.ContaCorrenteController;
import Controller.ContaPoupancaController;
import Controller.DadosController;

public class HomeView implements ActionListener{

	private static JFrame janela = new JFrame();
	private static JPanel panelHome = new JPanel();
	private static JLabel tituloHome = new JLabel();
	
	private static JButton perfilButton = new JButton("Perfil");
	private static JButton poupancaButton = new JButton("Conta Poupança");
	private static JButton correnteButton = new JButton("Conta Corrente");
	private static JButton sairButton = new JButton("Sair");
	
	private static HomeView objCadastro = new HomeView();
	private static DadosController controller = new DadosController();
	private static ContaPoupancaController poupancaController = new ContaPoupancaController();
	private static ContaCorrenteController correnteController = new ContaCorrenteController();
	private static int IDUsuario;
	
	public void imprimirTelaHome(DadosController dados, int IDCliente) {
		controller = dados;
		IDUsuario = IDCliente;
		
		janela.setVisible(true);	
		
		janela.setSize(400, 380);
		panelHome.setLayout(null);
		janela.add(panelHome);
		placeComponents(panelHome);
	}
	
	private static void placeComponents(JPanel panelHome) {
		//instancia o objeto relacionado a classe de data e hora
		Date dataHoraAtual = new Date();
		String hora = new SimpleDateFormat("HH").format(dataHoraAtual);
		String Text = null;
		
		if(hora.equals("01") || hora.equals("02") ||  hora.equals("03") ||  hora.equals("04") ||  
				hora.equals("05") || hora.equals("06") || hora.equals("07") ||  hora.equals("08") ||  
				hora.equals("09") || hora.equals("10") || 
				hora.equals("11") || hora.equals("12")) {
				Text = "Bom dia";
			}
		
		if(hora.equals("13") || hora.equals("14")  || hora.equals("15") ||  hora.equals("16") ||  
				hora.equals("17")|| hora.equals("18")) {
				Text = "Boa tarde";
			}
		
		if(hora.equals("19") || hora.equals("20")  || hora.equals("21") ||  hora.equals("22") ||  
				hora.equals("23")|| hora.equals("00")) {
				Text = "Boa noite";
			}
		
		tituloHome.setText(Text + ", " + 	controller.cliente(IDUsuario).getNome());
		tituloHome.setFont(new Font("Arial", Font.BOLD, 20));
		tituloHome.setBounds(110, 10, 250, 30);		
		panelHome.add(tituloHome);

		perfilButton.setBounds(100, 60, 200, 40);
		panelHome.add(perfilButton);
		
		poupancaButton.setBounds(100, 130, 200, 40);
		panelHome.add(poupancaButton);
		
		correnteButton.setBounds(100, 200, 200, 40);
		panelHome.add(correnteButton);
		
		sairButton.setBounds(100, 270, 200, 40);
		panelHome.add(sairButton);
		
		perfilButton.addActionListener(objCadastro);
		poupancaButton.addActionListener(objCadastro);
		correnteButton.addActionListener(objCadastro);
		sairButton.addActionListener(objCadastro);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		boolean sucesso = false;
		
		if(src == perfilButton) {
			new PerfilView().imprimirTelaPerfil(controller, IDUsuario);
		}
		
		if(src == poupancaButton) {
			new PoupancaView().imprimirTelaPoupanca(controller, IDUsuario, poupancaController);
		}
		
		if(src == correnteButton) {
			new CorrenteView().imprimirTelaCorrente(controller, IDUsuario, correnteController);
		}
		
		if(src == sairButton) {
			janela.setVisible(false);
			new TelaPrincipalView().VoltaTelaPrincipalView(controller);
		}
		
	}
		
}
