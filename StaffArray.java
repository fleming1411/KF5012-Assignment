
public class StaffArray {
	private int id;
	private String surname, forename, dob, address, strength, weakness;
	
	public StaffArray(int id, String surname, String forename, String dob, String address,
			String strength, String weakness) {
		this.id=id;
		this.surname=surname;
		this.forename=forename;
		this.dob=dob;
		this.address=address;
		this.strength=strength;
		this.weakness=weakness;
	}
	
	public int getID() {
		return id;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public String getForename() {
		return forename;
	}
	
	public String getDob() {
		return dob;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getStrength() {
		return strength;
	}
	
	public String getWeakness() {
		return weakness;
	}
}
