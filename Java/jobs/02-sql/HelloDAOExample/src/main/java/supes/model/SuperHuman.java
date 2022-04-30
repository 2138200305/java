package supes.model;

public class SuperHuman {
	private int shuman_id;
	private String name;
	private int bounty;
	
	public SuperHuman() {
	}

	public SuperHuman(int shuman_id, String name, int bounty) {
		super();
		this.shuman_id = shuman_id;
		this.name = name;
		this.bounty = bounty;
	}

	public int getShuman_id() {
		return shuman_id;
	}

	public void setShuman_id(int shuman_id) {
		this.shuman_id = shuman_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBounty() {
		return bounty;
	}

	public void setBounty(int bounty) {
		this.bounty = bounty;
	}

	@Override
	public String toString() {
		return "SuperHuman [shuman_id=" + shuman_id + ", name=" + name + ", bounty=" + bounty + "]";
	}
	
}
