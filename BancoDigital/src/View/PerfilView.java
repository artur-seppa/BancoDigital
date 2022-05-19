package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.DadosController;
import Model.Cliente;
import Model.Endereco;

public class PerfilView implements ActionListener{

	private static JFrame janela = new JFrame();
	private static JPanel panelPerfil = new JPanel();
	private static JLabel tituloPerfil = new JLabel();
	
	private static JButton SairButton = new JButton("Sair");
	private static JButton salvarButton = new JButton("Salvar");
	
	private static JTextField nomeText = new JTextField(120);
	private static JTextField senhaText = new JTextField(120);
	private static JTextField IdadeText = new JTextField(3);
	
	private static JTextField estadoText = new JTextField(120);
	private static JTextField cidadeText = new JTextField(120);
	private static JTextField enderecoText = new JTextField(120);
	
	private static PerfilView objCadastro = new PerfilView();
	private static DadosController controller = new DadosController();
	private static int IDUsuario;
	private static Cliente cliente = new Cliente();
	
	public void imprimirTelaPerfil(DadosController dados, int idCliente) {
		controller = dados;
		IDUsuario = idCliente;
		
		janela.setVisible(true);	
		
		janela.setSize(400, 450);
		panelPerfil.setLayout(null);
		janela.add(panelPerfil);
		placeComponents(panelPerfil);
	}

	private void placeComponents(JPanel panelHome) {
		
		cliente = controller.cliente(IDUsuario);
		
		tituloPerfil.setText("Perfil de Usuario");
		tituloPerfil.setFont(new Font("Arial", Font.BOLD, 20));
		tituloPerfil.setBounds(20, 10, 250, 30);		
		panelPerfil.add(tituloPerfil);
		
		SairButton.setBounds(290, 10, 80, 30);
		panelPerfil.add(SairButton);
		
		/*=============PESSOA==============*/
		JLabel nome = new JLabel("Nome :");
		nome.setFont(new Font("Arial", Font.BOLD, 15));
		nome.setBounds(20, 65, 120, 30);
		panelPerfil.add(nome);
	
		nomeText.setText(cliente.getNome());
		nomeText.setBounds(20, 95, 140, 30);
		panelPerfil.add(nomeText);
		
		JLabel senha = new JLabel("Senha :");
		senha.setFont(new Font("Arial", Font.BOLD, 15));
		senha.setBounds(20, 135, 120, 30);
		panelPerfil.add(senha);
	
		senhaText.setText(cliente.getSenha());
		senhaText.setBounds(20, 165, 140, 30);
		panelPerfil.add(senhaText);
		
		JLabel idade = new JLabel("Idade :");
		idade.setFont(new Font("Arial", Font.BOLD, 15));
		idade.setBounds(20, 205, 120, 30);
		panelPerfil.add(idade);
	
		IdadeText.setText(Integer.toString(cliente.getIdade()));
		IdadeText.setBounds(20, 235, 140, 30);
		panelPerfil.add(IdadeText);
		
		/*=============ENDERECO==============*/
		
		JLabel estado = new JLabel("Estado :");
		estado.setFont(new Font("Arial", Font.BOLD, 15));
		estado.setBounds(200, 65, 120, 30);
		panelPerfil.add(estado);
	
		estadoText.setText(cliente.getEndereco().getEstado());
		estadoText.setBounds(200, 95, 140, 30);
		panelPerfil.add(estadoText);
		
		JLabel cidade = new JLabel("Cidade :");
		cidade.setFont(new Font("Arial", Font.BOLD, 15));
		cidade.setBounds(200, 135, 120, 30);
		panelPerfil.add(cidade);
	
		cidadeText.setText(cliente.getEndereco().getCidade());
		cidadeText.setBounds(200, 165, 140, 30);
		panelPerfil.add(cidadeText);
		
		JLabel endereco = new JLabel("Endereco :");
		endereco.setFont(new Font("Arial", Font.BOLD, 15));
		endereco.setBounds(200, 205, 120, 30);
		panelPerfil.add(endereco);
	
		enderecoText.setText(cliente.getEndereco().getEndereco());
		enderecoText.setBounds(200, 235, 140, 30);
		panelPerfil.add(enderecoText);
		
		salvarButton.setBounds(130, 295, 120, 35);
		panelHome.add(salvarButton);
		
		salvarButton.addActionListener(objCadastro);
		SairButton.addActionListener(objCadastro);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == salvarButton) {
			
			int idade = Integer.parseInt(IdadeText.getText());
			Endereco adress = controller.cliente(IDUsuario).getEndereco();
			
			controller.cliente(IDUsuario).setNome(nomeText.getText());
			controller.cliente(IDUsuario).setSenha(senhaText.getText());
			controller.cliente(IDUsuario).setIdade(idade);
			
			adress.setCidade(cidadeText.getText());
			adress.setEstado(estadoText.getText());
			adress.setEndereco(enderecoText.getText());
			controller.cliente(IDUsuario).setEndereco(adress);
			
			janela.setVisible(false);

			/*
			 * passa o novo valor salvo para os inputs ao finalizar a operacao
			 */
			nomeText.setText(controller.cliente(IDUsuario).getNome());
			senhaText.setText(controller.cliente(IDUsuario).getSenha());
			IdadeText.setText(Integer.toString(controller.cliente(IDUsuario).getIdade()));

			estadoText.setText(controller.cliente(IDUsuario).getEndereco().getEstado());
			cidadeText.setText(controller.cliente(IDUsuario).getEndereco().getCidade());
			enderecoText.setText(controller.cliente(IDUsuario).getEndereco().getEndereco());
			
		}
		
		if(src == SairButton) {
			janela.setVisible(false);
			new HomeView().imprimirTelaHome(controller, 
					controller.ImprimeIDCliente(cliente.getNome(), cliente.getSenha()) );
		}
		
	}

}
