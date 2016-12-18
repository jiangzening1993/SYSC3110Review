package Lab5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;

public class GUI implements ActionListener {
	private JTextArea displayArea;
	private AddressBook addressBook;
	private DefaultListModel<String> listModel;
	private JList<String> nameList;

	public GUI() {
		JFrame frame = new JFrame();
		JMenuBar menuBar;
		JMenu addressBookMenu;
		JMenu buddyInfoMenu;
		JMenuItem create;
		JMenuItem save;
		JMenuItem display;
		JMenuItem add;
		JMenuItem remove;
		JMenuItem edit;
		

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
		
		remove = new JMenuItem("Remove");
		buddyInfoMenu.add(remove);
		remove.addActionListener(this);
		
		edit = new JMenuItem("Edit");
		buddyInfoMenu.add(edit);
		edit.addActionListener(this);

		/*displayArea = new JTextArea();
		displayArea.setEditable(false);
		frame.add(displayArea);*/
		
		listModel = new DefaultListModel<>();
		nameList = new JList<>(listModel);
		frame.add(nameList);

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
				str += b.toString() + System.lineSeparator();
			}
			try {
				BufferedWriter out = new BufferedWriter(new FileWriter("myFile.txt"));
				out.write(str);
				out.close();
			} catch (Exception e1) {
				System.out.println("error");
			}
		} else if (e.getActionCommand().equals("Display")) {
			/*String str = "";
			for (BuddyInfo b : addressBook.getBuddy()) {
				str += b.toString();
				str += "\n";
			}
			displayArea.setText(str);*/
		} else if (e.getActionCommand().equals("Add")) {
			String name = (String)JOptionPane.showInputDialog(null, "Name: ");
			String address = (String)JOptionPane.showInputDialog(null, "Address: ");
			String phoneNumber = (String)JOptionPane.showInputDialog(null, "Phone Number: ");
			BuddyInfo buddy = new BuddyInfo(name, address, phoneNumber);
			addressBook.addBuddy(buddy);
			listModel.addElement(buddy.getName());
		} else if(e.getActionCommand().equals("Remove")) {
			int index = nameList.getSelectedIndex();
			listModel.remove(index);
		} else if(e.getActionCommand().equals("Edit")) {
			int index = nameList.getSelectedIndex();
			String name = (String)JOptionPane.showInputDialog(null, "Name: ");
			String address = (String)JOptionPane.showInputDialog(null, "Address: ");
			String phoneNumber = (String)JOptionPane.showInputDialog(null, "Phone Number: ");
			addressBook.getBuddy().get(index).setName(name);
			addressBook.getBuddy().get(index).setAddress(address);
			addressBook.getBuddy().get(index).setPhoneNumber(phoneNumber);
			listModel.setElementAt(name, index);
		}

	}

	public static void main(String[] args) {
		new GUI();
	}
}
