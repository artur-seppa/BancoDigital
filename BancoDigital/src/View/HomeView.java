package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controller.DadosController;

public class HomeView {

	private static JFrame janela = new JFrame("Home");
	private static JPanel panelHome = new JPanel();
	private static JLabel tituloHome = new JLabel("Olá, ");
	
	public void imprimirTelaHome(DadosController controller, int IDCliente) {
		janela.setVisible(true);		
		
		janela.setSize(400, 340);
		janela.add(panelHome);
		placeComponents(panelHome);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private static void placeComponents(JPanel panelHome) {


	}
}
