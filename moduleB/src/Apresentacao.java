import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Apresentacao {

	private JFrame frame;
	private JTextField tfAcoes;
	private String test;
	JTextArea txtrAperteOBoto = new JTextArea();
	private JButton btnNewButton;
	GameB b = new GameB();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Apresentacao window = new Apresentacao();
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
	public Apresentacao() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tfAcoes = new JTextField();
		tfAcoes.setBounds(99, 356, 194, 20);
		frame.getContentPane().add(tfAcoes);
		tfAcoes.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("A\u00E7\u00F5es");
		lblNewLabel.setBounds(54, 359, 40, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Fazer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				test = tfAcoes.getText();
				txtrAperteOBoto.setText(b.acoes(test));
				b.save();
			}
		});
		btnNewButton_1.setBounds(303, 355, 108, 23);
		frame.getContentPane().add(btnNewButton_1);
		txtrAperteOBoto.setText("Aperte o bot\u00E3o start para iniciar. \r\nDigite info e aperte start para ver os comandos do jogo");
		txtrAperteOBoto.setForeground(Color.WHITE);
		
		
		txtrAperteOBoto.setBackground(Color.DARK_GRAY);
		txtrAperteOBoto.setBounds(10, 11, 464, 300);
		frame.getContentPane().add(txtrAperteOBoto);
		
		btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nsei = b.info(tfAcoes.getText());
				txtrAperteOBoto.setText(nsei);				
			}
		});
		btnNewButton.setBounds(153, 387, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}