import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Presentation extends JPanel {

	GameB b = new GameB();
	private JTextField tfAcoes;

	public Presentation() {
		setForeground(Color.LIGHT_GRAY);
		setLayout(null);

		JTextArea txtrAperteOBoto = new JTextArea();
		txtrAperteOBoto.setForeground(Color.WHITE);
		txtrAperteOBoto.setText(
				"Aperte o bot\u00E3o START para come\u00E7ar.\r\nDigite info e aperte start para ver os comandos do jogo.");
		txtrAperteOBoto.setBackground(Color.DARK_GRAY);
		txtrAperteOBoto.setBounds(10, 11, 480, 368);
		add(txtrAperteOBoto);

		JButton btnNewButton = new JButton("ACOES");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String test = tfAcoes.getText();
				txtrAperteOBoto.setText(b.acoes(test));
			}
		});
		btnNewButton.setBounds(358, 398, 89, 23);
		add(btnNewButton);

		tfAcoes = new JTextField();
		tfAcoes.setBounds(136, 399, 177, 20);
		add(tfAcoes);
		tfAcoes.setColumns(10);

		JButton btnNewButton_1 = new JButton("START");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nsei = b.info(tfAcoes.getText());
				txtrAperteOBoto.setText(nsei);
			}
		});
		btnNewButton_1.setBounds(190, 430, 89, 23);
		add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("A\u00C7\u00D5ES:");
		lblNewLabel.setBounds(70, 402, 46, 14);
		add(lblNewLabel);

	}
}
