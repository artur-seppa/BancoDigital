package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controller.DadosController;
import Exceptions.NumberException;
import Exceptions.*;

public class CadastroClienteView implements ActionListener{
	
	private static JFrame janela = new JFrame("Cadastrar");
	private static JPanel panel = new JPanel();
	private static JLabel titulo = new JLabel("Cadastro de usuario");
	
	private static JButton cadastroUsuario = new JButton("Cadastrar");
	
	private static JTextField nomeText = new JTextField(20);
	private static JPasswordField passwordText = new JPasswordField(20);
	private static JTextField cpfText = new JTextField(11);
	private static JTextField idadeText = new JTextField(3);
	
	private static JTextField enderecoText = new JTextField(50);
	private static JTextField cidadeText = new JTextField(20);
	private static JTextField estadoText = new JTextField(20);
	
	DadosController controller = new DadosController();
	private static CadastroClienteView objCadastro = new CadastroClienteView();
	
	public void imprimirTelaCadastro(DadosController dados) {

		/*
		 * Obtem o "BD" criado na tela anterior, com seus users ja pre fabricados, e
		 * passa essa configuracao ao obj usuario de mesmo tipo ControleUsuario
		 */
		controller = dados;

		janela.setVisible(true);

		janela.setSize(400, 710);
		janela.add(panel);
		placeComponents(panel);

	}
	
	private static void placeComponents(JPanel panel) {

		panel.setLayout(null);
		janela.setResizable(false);
		
		/*
		* set o width e height do obj.
		* (loc x, loc y do titulo na window. || width e height do titulo)
		*/
		
		/*
		 * impoe a fonte do titulo(fonte, negrito e tamanho em px)*/
		titulo.setFont(new Font("Arial", Font.BOLD, 17));
		titulo.setBounds(100, 10, 250, 30);		
		panel.add(titulo);

		/*=========Nome==========*/
		JLabel userLabel = new JLabel("Digite o seu nome :");
		userLabel.setFont(new Font("Arial", Font.BOLD, 15));
		userLabel.setBounds(20, 50, 160, 30);
		panel.add(userLabel);

		nomeText.setBounds(20, 80, 160, 30);
		panel.add(nomeText);

		/*=========Senha==========*/
		JLabel passwordLabel = new JLabel("digite a senha :");
		passwordLabel.setFont(new Font("Arial", Font.BOLD, 15));
		passwordLabel.setBounds(20, 120, 160, 30);
		panel.add(passwordLabel);

		passwordText.setBounds(20, 150, 160, 30);
		panel.add(passwordText);
		
		/*=========CPF==========*/
		JLabel cpfLabel = new JLabel("digite o seu CPF :");
		cpfLabel.setFont(new Font("Arial", Font.BOLD, 15));
		cpfLabel.setBounds(20, 190, 160, 30);
		panel.add(cpfLabel);

		cpfText.setBounds(20, 220, 160, 30);
		panel.add(cpfText);
		
		/*=========idade==========*/
		JLabel idadelabel = new JLabel("Idade :");
		idadelabel.setFont(new Font("Arial", Font.BOLD, 15));
		idadelabel.setBounds(20, 260, 140, 30);
		panel.add(idadelabel);

		idadeText.setBounds(20, 290, 140, 30);
		panel.add(idadeText);
		
		/*=========cidade==========*/
		JLabel cidadelabel = new JLabel("Cidade :");
		cidadelabel.setFont(new Font("Arial", Font.BOLD, 15));
		cidadelabel.setBounds(20, 330, 140, 30);
		panel.add(cidadelabel);

		cidadeText.setBounds(20, 360, 140, 30);
		panel.add(cidadeText);
		
		/*=========estado==========*/
		JLabel estadolabel = new JLabel("Estado :");
		estadolabel.setFont(new Font("Arial", Font.BOLD, 15));
		estadolabel.setBounds(20, 400, 140, 30);
		panel.add(estadolabel);

		estadoText.setBounds(20, 430, 140, 30);
		panel.add(estadoText);
		
		/*=========endereco==========*/
		JLabel enderecolabel = new JLabel("Endereco :");
		enderecolabel.setFont(new Font("Arial", Font.BOLD, 15));
		enderecolabel.setBounds(20, 470, 140, 30);
		panel.add(enderecolabel);

		enderecoText.setBounds(20, 500, 140, 30);
		panel.add(enderecoText);
		
		/*--------------Button--------------*/
		cadastroUsuario.setBounds(20, 560, 140, 30);
		panel.add(cadastroUsuario);
		
		/*
		* ActionListener: verifica se o usuario clicou em algum dos
		* buttons criados
		*/
		cadastroUsuario.addActionListener(objCadastro);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		boolean sucesso = false;
		
		if(src == cadastroUsuario) {
			
			try {
				String password = String.valueOf(passwordText.getPassword());
				long cpf =  Long.parseLong(cpfText.getText());
				int idade = Integer.parseInt(idadeText.getText());
				
				/*
				 * Condicao da Exception CUSTOMIZADA para ser lançada
				 */
				if(idade < 18) {
					throw new NumberException();
				}
				
				if(cpfText.getText().length() < 11) {
					throw new CpfException();
				}
				
				sucesso = controller.criandoCliente(nomeText.getText(), password, cpf, idade, 
						estadoText.getText(), cidadeText.getText(), enderecoText.getText());
				
				if(sucesso == true) {
					JOptionPane.showMessageDialog(null, 
					"Usuario cadastrado com sucesso\n", null, 
					JOptionPane.INFORMATION_MESSAGE);
					
					String[] clienteNameAtualizada = controller.listandoNomesClientes();
					for(int i=0; i<controller.quantidadeClientes(); i++) {
						System.out.println(clienteNameAtualizada[i]);
					}
					
					System.out.println("quantidade = " + controller.quantidadeClientes());
					
					/*
					 * fecha a janela quando cadastrar o usuario
					 */
					janela.setVisible(false);
					new TelaPrincipalView().VoltaTelaPrincipalView(controller);
					
					/*
					 * passa o valor null para os inputs ao finalizar a operacao
					 */
					nomeText.setText(null);
					passwordText.setText(null);
					estadoText.setText(null);
					cidadeText.setText(null);
					enderecoText.setText(null);
					
				}else{
					JOptionPane.showMessageDialog(null, 
					"Os campos nao foram preenchidos corretamente\n", null, 
					JOptionPane.INFORMATION_MESSAGE);
				}
			}catch(NumberException ex){
				JOptionPane.showMessageDialog(null, 
				"Erro: " + ex.getMessage() + "\n", null, 
				JOptionPane.INFORMATION_MESSAGE);
			}
			catch(CpfException ex){
				JOptionPane.showMessageDialog(null, 
				"Erro: " + ex.getMessage() + "\n", null, 
				JOptionPane.INFORMATION_MESSAGE);
			}			
			catch(Exception ex){
				JOptionPane.showMessageDialog(null, 
				"Erro: " + ex.getMessage() + "\n", null, 
				JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
	}
}
