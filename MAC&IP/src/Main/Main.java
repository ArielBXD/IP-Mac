package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.net.SocketException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {
	static JFrame mainFrame;
	static JPanel panel;
	static JLabel ipLabel, macLabel;
	static final int width = 300, height = 50;
	static String ip, mac;

	public static void main(String[] args) {
		createNDisplay();
	}

	private static void init() {
		ip = setAddresses.getIP();
		try {
			mac = setAddresses.getMac();
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	private static void createNDisplay() {
		init();

		ipLabel = new JLabel("This computer IP is: " + ip);
		macLabel = new JLabel("This computer Mac is: " + mac);

		panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));
		panel.setBackground(Color.cyan);
		panel.add(ipLabel);
		panel.add(macLabel);

		mainFrame = new JFrame("Mac and IP");
		mainFrame.setSize(width, height);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.add(panel);
		mainFrame.pack();
		mainFrame.setVisible(true);

	}
}
