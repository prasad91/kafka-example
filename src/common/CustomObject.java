package common;

public class CustomObject {
	private String name;
	private int number;

	public CustomObject(String name, int number) {
		this.name = name;
		this.number = number;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}
}
