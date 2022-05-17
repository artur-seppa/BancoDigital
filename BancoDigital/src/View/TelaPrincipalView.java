package View;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controller.DadosController;

public class TelaPrincipalView implements ActionListener{
	
	/*
	* 	JFrame == window que abre na tela do usuario
	* 	Jlabel == permite escreve na window(JFrame) em qualquer lugar
	* 	JButton == cria os objetos buttons	
	* 
	* 	Para cada classe swing chamada, instanciamos os seus objetos
	* 	com seus respectivos atributos e metodos das classes. 
	*/
	
	private static JFrame janela = new JFrame("Menu");
	private static JButton cadastroCliente = new JButton("Cadastrar");
	private static JButton loginButton = new JButton("Entrar");
	private static JTextField userText = new JTextField(20);
	private static JPasswordField passwordText = new JPasswordField(20);
	private static JLabel titulo = new JLabel("BSB Bank");
	private static JPanel panel = new JPanel();

	DadosController controller = new DadosController();
	
	public TelaPrincipalView(){		
		janela.setVisible(true);
		
		
		janela.setSize(400, 340);
		janela.add(panel);
		placeComponents(panel);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private static void placeComponents(JPanel panel) {
		
		panel.setLayout(null);
		
//		ImageIcon imagem = new ImageIcon(getClass().getResource("capaPrincipal.jpg"));
//		JLabel img = new JLabel(imagem);
//		panel.add(img);
		
		//Nao permite o usuario redimensionar a tela
		
		/*
		* set o width e height do obj.
		* (loc x, loc y do titulo na window. || width e height do titulo)
		*/
		
		/*impoe a fonte do titulo(fonte, negrito e tamanho em px)*/
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(142, 10, 250, 30);		
		panel.add(titulo);

		JLabel userLabel = new JLabel("Usuario:");
		userLabel.setFont(new Font("Arial", Font.BOLD, 15));
		userLabel.setBounds(130, 50, 140, 30);
		panel.add(userLabel);

        //JTextField userText = new JTextField(20);
		//userText.setFont(new Font("Arial", Font.BOLD, 16));
		userText.setBounds(130, 80, 140, 30);
		panel.add(userText);

		JLabel passwordLabel = new JLabel("Senha:");
		passwordLabel.setFont(new Font("Arial", Font.BOLD, 15));
		passwordLabel.setBounds(130, 120, 140, 30);
		panel.add(passwordLabel);

		//JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(130, 150, 140, 30);
		panel.add(passwordText);

		//JButton loginButton = new JButton("Entrar");
		loginButton.setBounds(50, 210, 140, 30);
		panel.add(loginButton);
		
		//JButton cadastroUsuario = new JButton("register");
		cadastroCliente.setBounds(210, 210, 140, 30);
		panel.add(cadastroCliente);
		
	}
	
	public static void main(String[] args) {
		/*
		 * Na main instanciamos o obj menu da classe TelaPrincipal
		 * e assim o nosso construtor CadastroUsuariopassa a existir na aplicacao
		*/
		TelaPrincipalView menu = new TelaPrincipalView();
		
	/*
	* ActionListener: verifica se o usuario clicou em algum dos
	* buttons criados
	*/
		cadastroCliente.addActionListener(menu);
		loginButton.addActionListener(menu);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == cadastroCliente) {
			new CadastroClienteView().imprimirTelaCadastro(controller);
		}
		
		if(src == loginButton) {
			boolean sucesso;
			
			try {
				
				String password = String.valueOf(passwordText.getPassword());
				sucesso = controller.loginCliente(userText.getText(),  password);
								
				if(sucesso == true) {
					janela.setVisible(false);

					new HomeView().imprimirTelaHome(controller, 
							controller.ImprimeIDCliente(userText.getText(), password) );
				}
			
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null, 
				"Erro: " + ex + "\n", null, 
				JOptionPane.INFORMATION_MESSAGE);
			}
	
	}	
  }
}
