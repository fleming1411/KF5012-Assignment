
public class StaffArray {
	private int id;
	private String position, surname, forename, dob, address, strength, weakness, notes;
	
	public StaffArray(int id, String position, String surname, String forename, String dob, String address,
			String strength, String weakness, String notes) {
		this.id=id;
		this.position=position;
		this.surname=surname;
		this.forename=forename;
		this.dob=dob;
		this.address=address;
		this.strength=strength;
		this.weakness=weakness;
		this.notes=notes;
	}
	
	public int getID() {
		return id;
	}
	
	public String getPosition() {
		return position;
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
	
	public String getNotes() {
		return notes;
	}
}
