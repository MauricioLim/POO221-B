package moduleB;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import moduleB.Console;
import moduleB.Game;
import moduleB.Player;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.ListSelectionModel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/* 
 * Universidade Regional de Blumenau - FURB
 * Departamento de Sistemas e Computa��o
 * Cursos de Ci�ncia da Computa��o e de Sistemas de Informa��o
 * Disciplina de Programa��o Orientada a Objetos
 * 
 * 2022/1 - Noturno
 */
public class ParaTestar {

	private JFrame frame;
	private Console console;
	private JComboBox<String> jCBGames;
	private JTextArea jTAPlayers;
	private JPanel jPPrincipal;
	private Player p = new Player("Testador oficial", "TheTester");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParaTestar window = new ParaTestar();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ParaTestar() {
		initialize();
		loadConsole();
	}

	private void loadConsole() {
		console = Console.getInstance();
		console.addPlayer(p);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("PARA TESTAR SUPERGAMES - POO 2022-1 Noturno");
		frame.setBounds(50, 50, 1000, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 233, 154, 377);
		frame.getContentPane().add(scrollPane);

		jTAPlayers = new JTextArea();
		jTAPlayers.setEditable(false);
		jTAPlayers.setText(
				"S� PARA APRESENTAR\r\n11509 - DeepBlue\r\n11121 - ArthurClarke\r\n9832 - MeuMalvadoFavorito\r\n9276 - Unicorn\r\n8722 - PraFrenteBrasil\r\n8712 - JonasAltair\r\n8623 - BillGates\r\n7925 - EuMesmo");
		scrollPane.setViewportView(jTAPlayers);

		JLabel lblNewLabel = new JLabel("Ranking dos");
		lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 14));
		lblNewLabel.setBounds(20, 177, 132, 26);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblJogadores = new JLabel("JOGADORES");
		lblJogadores.setFont(new Font("Stencil", Font.ITALIC, 16));
		lblJogadores.setBounds(20, 200, 132, 26);
		frame.getContentPane().add(lblJogadores);

		jCBGames = new JComboBox<>();
		jCBGames.setModel(new DefaultComboBoxModel(
				new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "P" }));

		jCBGames.setBounds(10, 59, 160, 22);
		frame.getContentPane().add(jCBGames);

		JLabel lblNewLabel_1 = new JLabel("Letra de sua equipe:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 30, 160, 14);
		frame.getContentPane().add(lblNewLabel_1);

		jPPrincipal = new JPanel();
		jPPrincipal.setBorder(new TitledBorder(null, "Jogo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		jPPrincipal.setBounds(186, 43, 550, 500);
		frame.getContentPane().add(jPPrincipal);
		jPPrincipal.setLayout(new BorderLayout(0, 0));

		JButton btnJogar = new JButton("Jogar");
		btnJogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String gameName = (String) jCBGames.getSelectedItem();
				Game g = console.loadGame(gameName);
				String s = "Carregando: " + g.getName() + "\nativado " + g.getActivations() + " vezes e"
						+ "\ncuja descri��o � \n" + g.getDescription();

				JPanel jPGame = g.getPanel();
				jPGame.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				jPGame.setSize(500, 480);
				if (jPPrincipal.getComponentCount() > 0) {
					jPPrincipal.remove(0); // para tirar o painel do jogo anterior
				}
				jPPrincipal.add(jPGame);
				jPPrincipal.setBorder(new TitledBorder(null, g.getName(), TitledBorder.LEADING, TitledBorder.TOP, null, null));
				jPGame.requestFocus();
				frame.validate();
				g.start(p);
			}
		});
		btnJogar.setBounds(43, 107, 89, 23);
		frame.getContentPane().add(btnJogar);
	}
}
