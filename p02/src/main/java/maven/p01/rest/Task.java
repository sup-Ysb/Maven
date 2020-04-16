package maven.p01.rest;

public class Task {
	private int id;
	private String discription;
	public Task(int id2, String string) {
		this.discription=string;
		this.id=id2;
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
}
