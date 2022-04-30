package supes.model;

public class SuperPower {
	private int spower_id;
	private String name;
	
	public SuperPower() {
	}

	public SuperPower(int spower_id, String name) {
		super();
		this.spower_id = spower_id;
		this.name = name;
	}

	public int getSpower_id() {
		return spower_id;
	}

	public void setSpower_id(int spower_id) {
		this.spower_id = spower_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "SuperPower [spower_id=" + spower_id + ", name=" + name + "]";
	}
	
}
