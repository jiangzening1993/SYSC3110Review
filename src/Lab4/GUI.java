package Lab4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;

import javax.swing.*;

public class GUI implements ActionListener {
	private JTextArea displayArea;
	private AddressBook addressBook;

	public GUI() {
		JFrame frame = new JFrame();
		JMenuBar menuBar;
		JMenu addressBookMenu;
		JMenu buddyInfoMenu;
		JMenuItem create;
		JMenuItem save;
		JMenuItem display;
		JMenuItem add;

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 250);
		frame.setTitle("Address Book");

		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		addressBookMenu = new JMenu("AddressBook");
		menuBar.add(addressBookMenu);
		buddyInfoMenu = new JMenu("BuddyInfo");
		menuBar.add(buddyInfoMenu);

		create = new JMenuItem("Create");
		addressBookMenu.add(create);
		create.addActionListener(this);

		save = new JMenuItem("Save");
		addressBookMenu.add(save);
		save.addActionListener(this);

		display = new JMenuItem("Display");
		addressBookMenu.add(display);
		display.addActionListener(this);

		add = new JMenuItem("Add");
		buddyInfoMenu.add(add);
		add.addActionListener(this);

		displayArea = new JTextArea();
		displayArea.setEditable(false);
		frame.add(displayArea);

		//frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Create")) {
			if (addressBook == null) {
				addressBook = new AddressBook();
				JOptionPane.showMessageDialog(null, "Created Sucess");
			} else {
				JOptionPane.showMessageDialog(null, "Already Created");
			}
		} else if (e.getActionCommand().equals("Save")) {
			String str = "";
			for (BuddyInfo b : addressBook.getBuddy()) {
				str += b.toString();
				str += "\n";
			}
			try {
				BufferedWriter out = new BufferedWriter(new FileWriter("myFile.txt"));
				out.write(str);
				out.close();
			} catch (Exception e1) {
				System.out.println("error");
			}
		} else if (e.getActionCommand().equals("Display")) {
			String str = "";
			for (BuddyInfo b : addressBook.getBuddy()) {
				str += b.toString() + System.lineSeparator();
			}
			displayArea.setText(str);
		} else if (e.getActionCommand().equals("Add")) {
			String name = (String)JOptionPane.showInputDialog(null, "Name: ");
			String address = (String)JOptionPane.showInputDialog(null, "Address: ");
			String phoneNumber = (String)JOptionPane.showInputDialog(null, "Phone Number: ");
			addressBook.addBuddy(new BuddyInfo(name, address, phoneNumber));
		}

	}

	public static void main(String[] args) {
		new GUI();
	}
}
