package Lab6;

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
	
	public static void main(String[] args) {
		BuddyInfo buddy = new BuddyInfo("Tom", "Carleton", "613");
		AddressBook addressBook = new AddressBook();
		addressBook.addBuddy(buddy);
		addressBook.removeBuddy(0);
	}

}
