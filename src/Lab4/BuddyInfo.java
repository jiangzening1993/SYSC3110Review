package Lab4;

public class BuddyInfo {
	private String name;
	private String address;
	private String phoneNumber;

	public BuddyInfo(String name, String address, String phoneNumber) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String toString() {
		String str = "";
		str += name + " " + address + " " + phoneNumber;
		return str;
	}

	public boolean equals(BuddyInfo bi) {
		if (bi.getName().equals(name) && bi.getAddress().equals(address) && bi.getPhoneNumber().equals(phoneNumber))
			return true;
		return false;
	}

}
