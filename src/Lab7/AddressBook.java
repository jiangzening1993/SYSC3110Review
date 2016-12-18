package Lab7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddressBook {
	private List<BuddyInfo> buddyInfo;

	public AddressBook() {
		buddyInfo = new ArrayList<BuddyInfo>();
	}

	public void addBuddy(BuddyInfo bi) {
		if (bi != null) {
			buddyInfo.add(bi);
		}
	}

	public void removeBuddy(int index) {
		if (index >= 0 && index < buddyInfo.size()) {
			buddyInfo.remove(index);
		}
	}

	public List<BuddyInfo> getBuddy() {
		return buddyInfo;
	}
	
	public int size(){
		return buddyInfo.size();
	}

	public void clear(){
		buddyInfo.clear();
	}
	
	public void export() {
		String str = "";
		for(BuddyInfo b : buddyInfo){
			str += b.toString() + System.lineSeparator();
		}
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("output.txt"));
			out.write(str);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void importFile() {
		try {
			BufferedReader in = new BufferedReader(new FileReader("output.txt"));
			String line;
			BuddyInfo bi = new BuddyInfo();
			while((line = in.readLine()) != null){
				bi = bi.factory(line);
				this.addBuddy(bi);
			}
			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		BuddyInfo buddy = new BuddyInfo("Tom", "Carleton", "613");
		AddressBook addressBook = new AddressBook();
		addressBook.addBuddy(buddy);
		addressBook.export();
		addressBook.importFile();
		System.out.println(addressBook.getBuddy().get(1).toString());
	}

}
