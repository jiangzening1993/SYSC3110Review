package Lab7;

public class BuddyInfo {
	private String name;
	private String address;
	private String phoneNumber;
	private int age;

	public BuddyInfo(String name, String address, String phoneNumber) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	
	public BuddyInfo(BuddyInfo bi){
		this.name = bi.getName();
		this.address = bi.getAddress();
		this.phoneNumber = bi.getPhoneNumber();
	}

	public BuddyInfo() {
		
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
		str += name + "$" + address + "$" + phoneNumber;
		return str;
	}

	public boolean equals(BuddyInfo bi) {
		if (bi.getName().equals(name) && bi.getAddress().equals(address) && bi.getPhoneNumber().equals(phoneNumber))
			return true;
		return false;
	}
	
	public String greet(){
		String str = "";
		str += "Hello " + name;
		return str;
	}
	
	public int getAge(){
		return age;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	
	public boolean isOver18(){
		if(age >= 18) return true;
		else return false;
	}
	
	public BuddyInfo factory(String s) {
		String[] result = s.split("\\$");
		return new BuddyInfo(result[0], result[1], result[2]);
	}

}
